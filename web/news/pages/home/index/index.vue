<template>
	<view class="container">
		<view class="uni-list">
			<uni-section title="圆头像且不显示分割线" type="line"></uni-section>
			<uni-list :border="false">
				<uni-list-chat v-for="item in listData" :avatar-circle="true" :key="item.id" :title="item.memberUserName" :avatar="item.memberUserAvatar" :note="item.content" :time="item.create_time" :clickable="true" @click="toChatPage"></uni-list-chat>
			</uni-list>
		 </view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				listData:[],
				socketTask: "",
				is_open_socket: false
			}
		},
		onLoad:function(){
			this.loadChatList();
		},
		onTabItemTap:function(){
			this.loadChatList();
		},
		onUnload:function(){
		},
		methods: {
			openInfo(e) {
				console.log(e)
				uni.navigateTo({
					url: '../info/info',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			toChatPage(e) {
				uni.navigateTo({
					url: '../index/chat',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			loadChatList() {
				uni.showLoading({})
				uni.request({
					// url: 'https://unidemo.dcloud.net.cn/api/news',
					url: 'http://localhost:8080/chatContentInfo/selectPage',
					method: 'POST',
					data: {
						primaryUserId:1,
						pageNum: 1,
						pageSize:4
					},
					success: res => {
						console.log(res);
						
						let result = res.data;
						if (result.code == 0){
							this.listData = result.result.list;
							console.log(this.listData);
						}
					},
					fail: () => {},
					complete: () => {
						uni.hideLoading();	
					}
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
					this.is_open_socket = true;
					// 注：只有连接正常打开中 ，才能正常成功发送消息
					this.socketTask.send({
						data: "uni-app发送一条消息",
						async success() {
							console.log("消息发送成功");
						},
					});
					// 注：只有连接正常打开中 ，才能正常收到消息
					this.socketTask.onMessage((res) => {
						console.log("收到服务器内容：" + res.data);
					});
				})
				// 这里仅是事件监听【如果socket关闭了会执行】
				uni.onSocketClose((res) => {
				  console.log('WebSocket 已关闭！');
				});
				uni.onSocketError(function (res) {
				  console.log('WebSocket连接打开失败，请检查！');
				});
			},
			// 关闭websocket【离开这个页面的时候执行关闭】
			// closeSocket() {
			// 	this.socketTask.close({
			// 		success(res) {
			// 			this.is_open_socket = false;
			// 			console.log("关闭成功", res)
			// 		},
			// 		fail(err) {
			// 			console.log("关闭失败", err)
			// 		}
			// 	})
			// },
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
	.container {
		padding: 20px;
		font-size: 14px;
		line-height: 24px;
	}
	.uni-media-list-body {
		height: auto;
	}
	.uni-media-list-text-top{
		line-height: 1.6em;
	}
</style>
