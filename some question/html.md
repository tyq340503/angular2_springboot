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
9�� WebSocketЭ�����