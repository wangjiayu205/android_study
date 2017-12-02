####imageButton和imageView的区别
[原文传送](http://blog.csdn.net/qq_27376951/article/details/51810829)
* 继承不同：
java.lang.Object ↳ android.view.View ↳android.widget.ImageView ↳ android.widget.ImageButton 
java.lang.Object ↳ android.view.View ↳ android.widget.TextView ↳android.widget.Button
因而ImageButton 不支持setText﻿，而Button支持。反之，ImageButton 支持setImageURI﻿，而Button不支持。Button和ImageButton有Button的状态，但是ImageView没有。

* 显示差异：
imageView 加上可点击的属性同样实现button的点击功能，这样看来没啥区别，可是可是，最近我做的listView，一个imagebutton，一个imageView 显示圆角图片的时候，imageBotton 居然显示不出来。
ImageButton 拥有默认背景：

* 问题：
项目中使用ImageButton,但是给图片设置具体尺寸(width,height)之后,发现还是原来的大小,为了保持图片的原始像素,并没有给ImageButton设置ScaleType,后来将ImageButton换成ImageView之后就ok了

* 差异
1. 不设置具体宽高
两者没有差别
2. 设置了具体宽高
ImageView会根据设置的具体宽高尺寸变化,但是ImageButton只会显示图片的原始像素大小。当然,给ImageButton设置scaletype属性是可以完成ImageView的效果,但是那样会是图片失真。
