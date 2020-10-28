<template>
	<view class="container">
		<view class="uni-list">
			我的
		 </view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				news:[]
			}
		},
		onLoad:function(){
			uni.showLoading({
				
			})
			uni.request({
				url: 'https://unidemo.dcloud.net.cn/api/news',
				method: 'GET',
				data: {},
				success: res => {
					console.log(res);
					uni.hideLoading();
					this.news = res.data;
				},
				fail: () => {},
				complete: () => {}
			});
		},
		methods: {
			openInfo(e) {
				console.log(e)
				var newsId = e.currentTarget.dataset.newsid;
				uni.navigateTo({
					url: '../info/info?newsId='+newsId,
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			}
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
