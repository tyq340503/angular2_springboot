1.meta viewportԭ��

HTML�У�


<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
1

��meta��ǩ���������õ�ǰviewport�Ŀ�ȵ����豸�Ŀ�ȣ�ͬʱ�������û��ֶ����š���Ȼmaximum-scale=1.0, user-scalable=0���Ǳ���ģ��Ƿ������û��ֶ����Ÿ�����վ����������������width��Ϊwidth-device�����Ǳ���ģ������ܱ�֤������ֺ����������

����	ֵ

width	����layout viewport �Ŀ�ȣ�Ϊһ�������������ַ�����width-device��

initial-scale	����ҳ��ĳ�ʼ����ֵ��Ϊһ�����֣����Դ�С��

minimum-scale	�����û�����С����ֵ��Ϊһ�����֣����Դ�С��

maximum-scale	�����û����������ֵ��Ϊһ�����֣����Դ�С��

height	����layout viewport �ĸ߶ȣ�������Բ�����Ҫ������ʹ��

user-scalable	�Ƿ������û��������ţ�ֵΪ��no����yes��, no ��������yes��������

�������д��������ǲ���ÿ�ζ��ð���������Զ�д���أ��𰸿϶��Ƿ񶨵ģ����磺����������user-scalable=no ��ô��minimum-scale=1, maximum-scale=1���������Ծ�û��Ҫ׷���ˡ���Ϊ�㶼�Ѿ���ֹ���û�����ҳ���ˣ���������ŷ�ΧҲ�Ͳ������ˡ�

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=yes">
1
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">


2.HTML �Ż�
https://juejin.im/post/59ff2dbe5188254dd935c8ab
http://web.jobbole.com/89512/

3.jsonp��ԭ����ʵ��

https://github.com/qianlongo/zepto-analysis/issues/4

����������script��ǩ��src������ʵ�ֿ���

ͨ����ǰ�˷�����Ϊ�������ݵ��������ˣ�Ȼ���ɷ�������ע�����֮���ٷ��أ�ʵ�ַ���������ͻ���ͨ�š�

����ʹ��script��ǩ��src���ԣ����ֻ֧��get����

һ���򵥵�jsonpʵ�֣���ʵ����ƴ��url��Ȼ�󽫶�̬���һ��scriptԪ�ص�ͷ����

function jsonp(req){
    var script = document.createElement('script');
    var url = req.url + '?callback=' + req.callback.name;
    script.src = url;
    document.getElementsByTagName('head')[0].appendChild(script); 
}

ǰ��jsʾ��

function hello(res){
    alert('hello ' + res.data);
}
jsonp({
    url : '',
    callback : hello 
});


4.�հ�������
https://zhuanlan.zhihu.com/p/22486908?refer=study-fe

�հ�������������ӷ���һ�������������仰˵��������һ����������
������������һ����Ϸ����д���й��ڡ���ʣ���������Ĵ��롣

������ñհ��������ֱ����һ��ȫ�ֱ�����

window.lives = 30 // ������ʮ����
�����������ܲ��ס���һ��С�İ����ֵ�ĳ� -1 ����ô�졣�������ǲ����ñ��ˡ�ֱ�ӷ��ʡ������������ô���أ�

�þֲ�������

�����þֲ����������ַ��ʲ�������ô���أ�

��¶һ�������������������ñ��˿��ԡ���ӷ��ʡ���

�������£�

!function(){

  var lives = 50

  window.����һ���� = function(){
    lives += 1
  }

  window.��һ���� = function(){
    lives -= 1
  }

}()


5.����������

1�� ͨ��jsonp����
2�� document.domain + iframe����
3�� location.hash + iframe
4�� window.name + iframe����
5�� postMessage����
6�� ������Դ����CORS��
7�� nginx�������
8�� nodejs�м���������


6.һ��һ��ʵ��JS��ק���

http://www.cnblogs.com/lrzw32/p/4696655.html

��������ק������ʲô�����أ��������̴�������漸�����裺

����1�������������ק��Ԫ��

����2����ס��겻�ţ��ƶ����

����3����קԪ�ص�һ��λ�ã��ſ����

����Ĺ����漰������dom�¼���onmousedown,onmousemove,onmouseup��������ק�Ļ���˼·���ǣ�

����1�������������ק��Ԫ�ش���onmousedown

����������1�����õ�ǰԪ�صĿ���קΪtrue����ʾ������ק

����������2����¼��ǰ��������x,y

����������3����¼��ǰԪ�ص�����x,y

����2���ƶ���괥��onmousemove

����������1���ж�Ԫ���Ƿ����ק�����������벽��2������ֱ�ӷ���

����������2�����Ԫ�ؿ���ק��������Ԫ�ص�����

������������Ԫ�ص�x���� = ����ƶ��ĺ������+Ԫ�ر�����x���� = ������ڵ�x���� - ���֮ǰ��x���� + Ԫ�ر�����x����

������������Ԫ�ص�y���� = ����ƶ��ĺ������+Ԫ�ر�����y���� = ������ڵ�y���� - ���֮ǰ��y���� + Ԫ�ر�����y����

����3���ſ���괥��onmouseup

����������1�������Ŀ���ק״̬���ó�false

��������ԭ��ʵ�ֵ������Ч��
��ʵ�ֻ�����Ч��֮ǰ���м�����Ҫ˵���ģ�

����1��Ԫ����Ҫ���϶�������postion����һ��Ҫ��relative��absolute

����2��ͨ��event.clientX��event.clientY��ȡ��������

����3��onmousemove�ǰ���documentԪ���϶�������קԪ�ر��������ܽ�������϶���ɵ��ӳٻ�ֹͣ�ƶ�������

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

7.HTTP �� GET �� POST ������

GET�����������ʱ���޺��ģ���POST���ٴ��ύ����

GET������URL��ַ���Ա�Bookmark����POST�����ԡ�

GET����ᱻ���������cache����POST���ᣬ�����ֶ����á�

GET����ֻ�ܽ���url���룬��POST֧�ֶ��ֱ��뷽ʽ��

GET��������ᱻ�����������������ʷ��¼���POST�еĲ������ᱻ������

GET������URL�д��͵Ĳ������г������Ƶģ���POSTô�С�

�Բ������������ͣ�GETֻ����ASCII�ַ�����POSTû�����ơ�

GET��POST������ȫ����Ϊ����ֱ�ӱ�¶��URL�ϣ����Բ�����������������Ϣ��

GET����ͨ��URL���ݣ�POST����Request body�С�

������׼�𰸲ο���w3schools��
HTTP�ĵײ���TCP/IP������GET��POST�ĵײ�Ҳ��TCP/IP��Ҳ����˵��GET/POST����TCP���ӡ�GET��POST������������һ��һ���ġ���Ҫ��GET����request body����POST����url����������������ȫ�е�ͨ�ġ� 
GET��POST����һ���ش����𣬼򵥵�˵��

GET����һ��TCP���ݰ���POST��������TCP���ݰ���

����˵��

����GET��ʽ��������������http header��dataһ�����ͳ�ȥ����������Ӧ200���������ݣ���

������POST��������ȷ���header����������Ӧ100 continue��������ٷ���data����������Ӧ200 ok���������ݣ���
Ҳ����˵��GETֻ��Ҫ������һ�˾Ͱѻ��͵��ˣ���POST�������ˣ���һ�ˣ���ȥ�ͷ���������к����ˣ��ҵ���Ҫ��һ�����������Ǵ���ӭ���ҡ���Ȼ���ٻ�ͷ�ѻ��͹�ȥ��

��ΪPOST��Ҫ������ʱ�������ĵ�Ҫ��һ�㣬������GET��POST����Ч�����Yahoo�Ŷ����Ƽ���GET�滻POST���Ż���վ���ܡ�������һ���ӣ������������Ϊʲô��


8.������ͨ�׵����Խ���REST���Լ�RESTful��

��Url��֪��Ҫʲô
��http method��֪����ʲô
��http status code��֪��������

9. WebSocketЭ�����

10. Angular2-�Զ���ָ��@Directive

11. JS�¼�ģ��
https://segmentfault.com/a/1190000006934031
�۲���ģʽ
�۲���ģʽ�ֽ�������������ģʽ(Publish/Subscribe)���������ö���۲��߶���ͬʱ����ĳһ��������������������״̬�仯ʱ��֪ͨ���еĶ����ߣ�ʹ�������ܹ�������Ӧ��

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

ʹ������:

//�����������
var handler = function(info) {
    console.log(info);
}
//����hello����
events.subscribe('hello', handler);

//����hello����
events.publish('hello', 'hello world');


�¼�������������ĵ�������˲�䣬������ť����д���ȣ�����JS��HTML֮�佻����������
DOM�����νṹ�����ͬʱ�����ӽڵ㶼���¼�ʱ���������ӽڵ��ʱ���������¼��ķ���˳����ξ���?����漰���¼����ĸ������������ҳ���н����¼���˳��

�¼���������:

�¼�ð��(Event Bubbling): ��һ�ִ������ϵĴ�����ʽ���¼��ʼ��������Ԫ��(�ĵ���Ƕ�ײ��������Ǹ��ڵ����, Ҳ����DOM��Ͳ���ӽڵ�), Ȼ�������ϴ������������Ǹ��ڵ㣬Ҳ����DOM����߲�ĸ��ڵ㡣

�¼�����(Event Capturing): ���¼�ð���෴���¼��ʼ�ɲ�̫����Ľڵ���������¼�, �������Ľڵ��������¼���

�¼���ð�ݹ����л��ϴ������ڵ㣬��˿��԰��ӽڵ�ļ������������ڸ��ڵ��ϣ��ɸ��ڵ�ļ�������ͳһ��������Ԫ�ص��¼������ַ�ʽ��Ϊ�¼�����(Event delegation)��

������һ��divԪ�أ�������������ť:

<div id="box">
    <input type="button" value="��ť" id="btn">
    <input type="button" value="��ť2" id="btn2">
    <input type="button" value="��ť3" id="btn3">
</div>
���ǿ����ڸ��ڵ���һ���Ե�Ϊ�����ӽڵ�ע���������:

var box = document.getElementById('box');

box.addEventListener('click', function(event) {
  if (event.target.tagName.toLowerCase() === 'input') {
    // some code
  }
});


�Զ����¼�
JS���Ѿ������˺ܶ��¼�����click, mouseover�ȵȣ����������¼��Ͼ����ޣ���ʱ���������Լ�����һЩ�¼���������������threeclick�����ʵ���Զ����¼��أ�

����Ҫ����һ���¼�������ʹ�����·�ʽ:

var event = new Event('threeclick', {"bubbles":true, "cancelable":false});
Ȼ��������ҪΪ�¼�ע���������:

target.addEventListener('threeclick', hello, false);
�������Ҫ�ں��ʵ�ʱ���������¼������ǿ���ʹ��dispatchEvent�������÷����ڵ�ǰ�ڵ㴥��ָ���¼����Ӷ�������������ִ�С��÷�������һ������ֵ��ֻҪ��һ����������������Event.preventDefault(), �򷵻�false, ���򷵻�true��

target.dispatchEvent(event);


12. accept��ʲô����ô��

https://blog.csdn.net/tennysonsky/article/details/45621341


13. �ǰ������Ե�һ��nodejs��httpͬ��������������


14. 