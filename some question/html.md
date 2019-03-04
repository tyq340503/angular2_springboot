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


6.一步一步实现JS拖拽插件

http://www.cnblogs.com/lrzw32/p/4696655.html

常见的拖拽操作是什么样的呢？整过过程大概有下面几个步骤：

　　1、用鼠标点击被拖拽的元素

　　2、按住鼠标不放，移动鼠标

　　3、拖拽元素到一定位置，放开鼠标

这里的过程涉及到三个dom事件：onmousedown,onmousemove,onmouseup。所以拖拽的基本思路就是：

　　1、用鼠标点击被拖拽的元素触发onmousedown

　　　　（1）设置当前元素的可拖拽为true，表示可以拖拽

　　　　（2）记录当前鼠标的坐标x,y

　　　　（3）记录当前元素的坐标x,y

　　2、移动鼠标触发onmousemove

　　　　（1）判断元素是否可拖拽，如果是则进入步骤2，否则直接返回

　　　　（2）如果元素可拖拽，则设置元素的坐标

　　　　　　元素的x坐标 = 鼠标移动的横向距离+元素本来的x坐标 = 鼠标现在的x坐标 - 鼠标之前的x坐标 + 元素本来的x坐标

　　　　　　元素的y坐标 = 鼠标移动的横向距离+元素本来的y坐标 = 鼠标现在的y坐标 - 鼠标之前的y坐标 + 元素本来的y坐标

　　3、放开鼠标触发onmouseup

　　　　（1）将鼠标的可拖拽状态设置成false

二、根据原理实现的最基本效果
在实现基本的效果之前，有几点需要说明的：

　　1、元素想要被拖动，它的postion属性一定要是relative或absolute

　　2、通过event.clientX和event.clientY获取鼠标的坐标

　　3、onmousemove是绑定在document元素上而不是拖拽元素本身，这样能解决快速拖动造成的延迟或停止移动的问题

 1 var dragObj = document.getElementById("test");
 2         dragObj.style.left = "0px";
 3         dragObj.style.top = "0px";
 4 
 5         var mouseX, mouseY, objX, objY;
 6         var dragging = false;
 7 
 8         dragObj.onmousedown = function (event) {
 9             event = event || window.event;
10 
11             dragging = true;
12             dragObj.style.position = "relative";
13 
14 
15             mouseX = event.clientX;
16             mouseY = event.clientY;
17             objX = parseInt(dragObj.style.left);
18             objY = parseInt(dragObj.style.top);
19         }
20 
21         document.onmousemove = function (event) {
22             event = event || window.event;
23             if (dragging) {
24 
25                 dragObj.style.left = parseInt(event.clientX - mouseX + objX) + "px";
26                 dragObj.style.top = parseInt(event.clientY - mouseY + objY) + "px";
27             }
28 
29         }
30 
31         document.onmouseup = function () {
32             dragging = false;
33         }

7.HTTP 中 GET 与 POST 的区别

GET在浏览器回退时是无害的，而POST会再次提交请求。

GET产生的URL地址可以被Bookmark，而POST不可以。

GET请求会被浏览器主动cache，而POST不会，除非手动设置。

GET请求只能进行url编码，而POST支持多种编码方式。

GET请求参数会被完整保留在浏览器历史记录里，而POST中的参数不会被保留。

GET请求在URL中传送的参数是有长度限制的，而POST么有。

对参数的数据类型，GET只接受ASCII字符，而POST没有限制。

GET比POST更不安全，因为参数直接暴露在URL上，所以不能用来传递敏感信息。

GET参数通过URL传递，POST放在Request body中。

（本标准答案参考自w3schools）
HTTP的底层是TCP/IP。所以GET和POST的底层也是TCP/IP，也就是说，GET/POST都是TCP链接。GET和POST能做的事情是一样一样的。你要给GET加上request body，给POST带上url参数，技术上是完全行的通的。 
GET和POST还有一个重大区别，简单的说：

GET产生一个TCP数据包；POST产生两个TCP数据包。

长的说：

对于GET方式的请求，浏览器会把http header和data一并发送出去，服务器响应200（返回数据）；

而对于POST，浏览器先发送header，服务器响应100 continue，浏览器再发送data，服务器响应200 ok（返回数据）。
也就是说，GET只需要汽车跑一趟就把货送到了，而POST得跑两趟，第一趟，先去和服务器打个招呼“嗨，我等下要送一批货来，你们打开门迎接我”，然后再回头把货送过去。

因为POST需要两步，时间上消耗的要多一点，看起来GET比POST更有效。因此Yahoo团队有推荐用GET替换POST来优化网站性能。但这是一个坑！跳入需谨慎。为什么？


8.怎样用通俗的语言解释REST，以及RESTful？

看Url就知道要什么
看http method就知道干什么
看http status code就知道结果如何

9. WebSocket协议跨域

10. Angular2-自定义指令@Directive

11. JS事件模型
https://segmentfault.com/a/1190000006934031
观察者模式
观察者模式又叫做发布订阅者模式(Publish/Subscribe)，它可以让多个观察者对象同时监听某一个主题对象，这个主题对象的状态变化时会通知所有的订阅者，使得它们能够做出反应。

var events = (function() {
  var topics = {};

  return {
    publish: function(topic, info) {
      console.log('publish a topic:' + topic);
      if (topics.hasOwnProperty(topic)) {
        topics[topic].forEach(function(handler) {
          handler(info ? info : {});
        })
      }
    },
    subscribe: function(topic, handler) {
      console.log('subscribe an topic:' + topic);
      if (!topics.hasOwnProperty(topic)) {
        topics[topic] = [];
      }

      topics[topic].push(handler);
    },
    remove: function(topic, handler) {
      if (!topics.hasOwnProperty(topic)) {
        return;
      }

      var handlerIndex = -1;
      topics[topic].forEach(function(element, index) {
        if (element === handler) {
          handlerIndex = index;
        }
      });

      if (handlerIndex >= 0) {
        topics[topic].splice(handlerIndex, 1);
      }
    },
    removeAll: function(topic) {
      console.log('remove all the handler on the topic:' + topic);
      if (topics.hasOwnProperty(topic)) {
        topics[topic].length = 0;
      }
    }
  }
})();

使用事例:

//主题监听函数
var handler = function(info) {
    console.log(info);
}
//订阅hello主题
events.subscribe('hello', handler);

//发布hello主题
events.publish('hello', 'hello world');


事件是与浏览器或文档交互的瞬间，如点击按钮，填写表格等，它是JS与HTML之间交互的桥梁。
DOM是树形结构，如果同时给父子节点都绑定事件时，当触发子节点的时候，这两个事件的发生顺序如何决定?这就涉及到事件流的概念，它描述的是页面中接受事件的顺序。

事件流有两种:

事件冒泡(Event Bubbling): 是一种从下往上的传播方式。事件最开始由最具体的元素(文档中嵌套层次最深的那个节点接受, 也就是DOM最低层的子节点), 然后逐渐向上传播到最不具体的那个节点，也就是DOM中最高层的父节点。

事件捕获(Event Capturing): 与事件冒泡相反。事件最开始由不太具体的节点最早接受事件, 而最具体的节点最后接受事件。

事件在冒泡过程中会上传到父节点，因此可以把子节点的监听函数定义在父节点上，由父节点的监听函数统一处理多个子元素的事件，这种方式称为事件代理(Event delegation)。

我们有一个div元素，它包含三个按钮:

<div id="box">
    <input type="button" value="按钮" id="btn">
    <input type="button" value="按钮2" id="btn2">
    <input type="button" value="按钮3" id="btn3">
</div>
我们可以在父节点上一次性的为所有子节点注册监听函数:

var box = document.getElementById('box');

box.addEventListener('click', function(event) {
  if (event.target.tagName.toLowerCase() === 'input') {
    // some code
  }
});


自定义事件
JS中已经内置了很多事件，如click, mouseover等等，但是内置事件毕竟有限，有时候我们想自己定义一些事件，例如三连击，threeclick。如何实现自定义事件呢？

首先要创建一个事件。可以使用以下方式:

var event = new Event('threeclick', {"bubbles":true, "cancelable":false});
然后我们需要为事件注册监听函数:

target.addEventListener('threeclick', hello, false);
最后我们要在合适的时机触发该事件，我们可以使用dispatchEvent函数。该方法在当前节点触发指定事件，从而触发监听函数执行。该方法返回一个布尔值，只要有一个监听函数调用了Event.preventDefault(), 则返回false, 否则返回true。

target.dispatchEvent(event);


12. accept是什么，怎么用

https://blog.csdn.net/tennysonsky/article/details/45621341


13. 记阿里面试的一道nodejs中http同步处理请求问题


14. 