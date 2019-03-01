meta viewport原理

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


