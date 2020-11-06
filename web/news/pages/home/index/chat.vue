<template>
	<view class="uni-column">
		<view class="content" id="content" :style="{height:style.contentViewHeight+'px'}">
			<scroll-view id="scrollview"   scroll-y="true" :style="{height:style.contentViewHeight+'px'}" :scroll-with-animation="true"
			    :scroll-top="scrollTop">
				<message-show v-for="(message,index) in messages" :key="index" v-bind:message="message" :id="index"></message-show>
				<view id="bottom"></view>
			</scroll-view>
		</view>
		<view class="foot">
			<chat-input @send-message="getInputMessage" ></chat-input>
		</view>
	</view>
</template>

<script>
	import chatInput from 'components/third/chatinput.vue';
	import messageShow from 'components/third/messageshow.vue';

	export default {
		data() {
			return {
				style: {
					pageHeight: 0,
					contentViewHeight: 0,
					footViewHeight: 90,
					mitemHeight: 0,
				},
				scrollTop: 0,
				messages: [{
					user: 'home',
					type: 'head', //input,content 
					content: '你好!'
				}],
				socketTask: "",
				//websocket是否已连接:默认未连接
				isOpenSocket: false
			}
		},
		components: {
			chatInput,
			messageShow
		},
		created: function () { 
			const res = uni.getSystemInfoSync();
			this.style.pageHeight = res.windowHeight;
			this.style.contentViewHeight = res.windowHeight - uni.getSystemInfoSync().screenWidth / 750 * (100); //像素
			this.connectSocketInit();
		},
		onload: function () {
			this.connectSocketInit();
		},
		onUnload:function(){
			this.closeSocket()
		},
		methods: {
			getInputMessage: function (message) { //获取子组件的输入数据
				// console.log(message);
				let sendMessage = {
					primaryUserId:1,
					memberUserId: 111,
					memberUserName: 111,
					memberUserAvatar: 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoYiaToG6rPM3EibuEbbIlCfG14EiakYB300eznKzpIDaicsiacoEic2kloJaGLJGFUftQz3kjIfkyX5w3A/132',
					content: message.content
				};
				this.toSendWebsocketMessage(sendMessage);
			},
			addMessage: function (user, content, hasSub, subcontent) {
				var that = this;
				that.messages.push({
					memberUserId: 111,
					memberUserName: 111,
					memberUserAvatar: 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoYiaToG6rPM3EibuEbbIlCfG14EiakYB300eznKzpIDaicsiacoEic2kloJaGLJGFUftQz3kjIfkyX5w3A/132',
					hasSub: hasSub,
					content: content
				});
			},
			scrollToBottom: function () {
				var that = this;
				var query = uni.createSelectorQuery();
				query.selectAll('.m-item').boundingClientRect();
				query.select('#scrollview').boundingClientRect();

				query.exec(function (res) {
					that.style.mitemHeight = 0;
					res[0].forEach(function (rect) {
						// console.info(rect.height);
						that.style.mitemHeight = that.style.mitemHeight + rect.height + 20;
					});

					if (that.style.mitemHeight > that.style.contentViewHeight) {
						that.scrollTop = that.style.mitemHeight - that.style.contentViewHeight;
					}
				});
			},
			toSendWebsocketMessage: function (info) {
				// this.addMessage('home', info, false);
				this.socketTask.send({
					data: JSON.stringify(info),
					async success() {
						console.log("消息发送成功");
					},
				});
			},
			// 进入这个页面的时候创建websocket连接【整个页面随时使用】
			connectSocketInit() {
				// 创建一个this.socketTask对象【发送、接收、关闭socket都由这个对象操作】
				this.socketTask = uni.connectSocket({
				    url: 'ws://192.168.40.102:10012/websocket/12', //仅为示例，并非真实接口地址。
				    success: (data) => {
						console.log("websocket连接成功");
					},
					fail: (e) => {
						console.log("websocket连接失败");
						console.log(e);
					},
					complete: ()=> {}
				});
			 
				// 消息的发送和接收必须在正常连接打开中,才能发送或接收【否则会失败】
				uni.onSocketOpen((res) => {
					console.log("WebSocket连接正常打开中...！");
					this.isOpenSocket = true;
				})
				// 这里仅是事件监听【如果socket关闭了会执行】
				uni.onSocketClose((res) => {
				  console.log('WebSocket 已关闭！');
				});
				uni.onSocketError(function (res) {
				  console.log('WebSocket连接打开失败，请检查！');
				});
				uni.onSocketMessage((res) => {
				  console.log("收到服务器内容：" + res.data);
				  let message = res.data;
				  if (message) {
				  	this.messages.push(JSON.parse(message));
				  }
				});
			},
			// 关闭websocket【离开这个页面的时候执行关闭】
			closeSocket() {
				this.socketTask.close({
					success(res) {
						this.is_open_socket = false;
						console.log("关闭成功", res)
					},
					fail(err) {
						console.log("关闭失败", err)
					}
				})
			},
			// clickRequest() {
			// 	if (this.is_open_socket) {
			// 		// websocket的服务器的原理是:发送一次消息,同时返回一组数据【否则服务器会进去死循环崩溃】
			// 		this.socketTask.send({
			// 			data: "请求一次发送一次message",
			// 			async success() {
			// 				console.log("消息发送成功");
			// 			},
			// 		});
			// 	}
			// },
			// // 检测心跳reset
			// reset () {
			// 	clearInterval(this.timeoutObj);
			// 	this.start(); // 启动心跳
			// },
			// // 启动心跳 start 
			// start () {
			// 	let self = this;
			// 	this.timeoutObj = setInterval(function(){
			// 		uni.sendSocketMessage({
			// 			data: 'ping',
			// 			 success: (res) => {
			// 				console.log('连接中....');
			// 			},
			// 			fail: (err) => {
			// 				console.log('连接失败重新连接....');
			// 				self.openConnection();
			// 			}
			// 		});
			// 	}, this.timeout);
			// }
		}
	}
</script>


<style>
	.uni-column {
		display: flex;
		flex-direction: column;
	}
	.content {

		display: flex;
		flex: 1;
		margin-bottom: 100px;
		 
	}
	.foot {
		position: fixed;
		width: 100%;
		height: 90px;
		min-height: 90px;
		left: 0px;
		bottom: 0px;
		overflow: hidden;
	}
</style>
