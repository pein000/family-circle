(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/home/index/index"],{"0f7f":function(n,t,e){"use strict";var o;e.d(t,"b",(function(){return u})),e.d(t,"c",(function(){return a})),e.d(t,"a",(function(){return o}));var u=function(){var n=this,t=n.$createElement;n._self._c},a=[]},"374a":function(n,t,e){"use strict";e.r(t);var o=e("4096"),u=e.n(o);for(var a in o)"default"!==a&&function(n){e.d(t,n,(function(){return o[n]}))}(a);t["default"]=u.a},4096:function(n,t,e){"use strict";(function(n){Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var e={data:function(){return{news:[]}},onLoad:function(){var t=this;n.showLoading({}),n.request({url:"https://unidemo.dcloud.net.cn/api/news",method:"GET",data:{},success:function(e){console.log(e),n.hideLoading(),t.news=e.data},fail:function(){},complete:function(){}})},methods:{openInfo:function(t){console.log(t);var e=t.currentTarget.dataset.newsid;n.navigateTo({url:"../info/info?newsId="+e,success:function(n){},fail:function(){},complete:function(){}})}}};t.default=e}).call(this,e("543d")["default"])},"4a2f":function(n,t,e){"use strict";var o=e("dddb"),u=e.n(o);u.a},bde5:function(n,t,e){"use strict";e.r(t);var o=e("0f7f"),u=e("374a");for(var a in u)"default"!==a&&function(n){e.d(t,n,(function(){return u[n]}))}(a);e("4a2f");var c,f=e("f0c5"),i=Object(f["a"])(u["default"],o["b"],o["c"],!1,null,null,null,!1,o["a"],c);t["default"]=i.exports},dddb:function(n,t,e){},ef08:function(n,t,e){"use strict";(function(n){e("6a0d");o(e("66fd"));var t=o(e("bde5"));function o(n){return n&&n.__esModule?n:{default:n}}n(t.default)}).call(this,e("543d")["createPage"])}},[["ef08","common/runtime","common/vendor"]]]);