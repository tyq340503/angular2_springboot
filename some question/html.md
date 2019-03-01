1.meta viewport原理

HTML中：


<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
1

该meta标签的作用是让当前viewport的宽度等于设备的宽度，同时不允许用户手动缩放。当然maximum-scale=1.0, user-scalable=0不是必需的，是否允许用户手动播放根据网站的需求来定，但把width设为width-device基本是必须的，这样能保证不会出现横向滚动条。

属性	值

width	设置layout viewport 的宽度，为一个正整数，或字符串”width-device”

initial-scale	设置页面的初始缩放值，为一个数字，可以带小数

minimum-scale	允许用户的最小缩放值，为一个数字，可以带小数

maximum-scale	允许用户的最大缩放值，为一个数字，可以带小数

height	设置layout viewport 的高度，这个属性并不重要，很少使用

user-scalable	是否允许用户进行缩放，值为”no”或”yes”, no 代表不允许，yes代表允许

对于这行代码我们是不是每次都得把这五个属性都写上呢？答案肯定是否定的，例如：如果你添加了user-scalable=no 那么，minimum-scale=1, maximum-scale=1这两个属性就没必要追加了。因为你都已经禁止了用户缩放页面了，允许的缩放范围也就不存在了。

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=yes">
1
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">


2.HTML 优化
https://juejin.im/post/59ff2dbe5188254dd935c8ab
http://web.jobbole.com/89512/

3.jsonp的原理与实现

https://github.com/qianlongo/zepto-analysis/issues/4

首先是利用script标签的src属性来实现跨域。

通过将前端方法作为参数传递到服务器端，然后由服务器端注入参数之后再返回，实现服务器端向客户端通信。

由于使用script标签的src属性，因此只支持get方法

一个简单的jsonp实现，其实就是拼接url，然后将动态添加一个script元素到头部。

function jsonp(req){
    var script = document.createElement('script');
    var url = req.url + '?callback=' + req.callback.name;
    script.src = url;
    document.getElementsByTagName('head')[0].appendChild(script); 
}

前端js示例

function hello(res){
    alert('hello ' + res.data);
}
jsonp({
    url : '',
    callback : hello 
});


4.闭包的作用
https://zhuanlan.zhihu.com/p/22486908?refer=study-fe

闭包常常用来「间接访问一个变量」。换句话说，「隐藏一个变量」。
假设我们在做一个游戏，在写其中关于「还剩几条命」的代码。

如果不用闭包，你可以直接用一个全局变量：

window.lives = 30 // 还有三十条命
这样看起来很不妥。万一不小心把这个值改成 -1 了怎么办。所以我们不能让别人「直接访问」这个变量。怎么办呢？

用局部变量。

但是用局部变量别人又访问不到，怎么办呢？

暴露一个访问器（函数），让别人可以「间接访问」。

代码如下：

!function(){

  var lives = 50

  window.奖励一条命 = function(){
    lives += 1
  }

  window.死一条命 = function(){
    lives -= 1
  }

}()


5.跨域解决方案

1、 通过jsonp跨域
2、 document.domain + iframe跨域
3、 location.hash + iframe
4、 window.name + iframe跨域
5、 postMessage跨域
6、 跨域资源共享（CORS）
7、 nginx代理跨域
8、 nodejs中间件代理跨域
9、 WebSocket协议跨域