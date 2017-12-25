LinearLayout

1、android:orientation="horizontal"
注意： Android 的线性布局不会换行，当组件一个挨着一个的排列到头之后，剩下的组件将不会被显示出来
1）fill_parent

设置一个构件的布局为fill_parent将强制性地使构件扩展，以填充布局单元内尽可能多的空间。这跟Windows控件的dockstyle属性大体一致。设置一个顶部布局或控件为fill_parent将强制性让它布满整个屏幕。

2） wrap_content

设置一个视图的尺寸为wrap_content将强制性地使视图扩展以显示全部内容。以TextView和ImageView控件为例，设置为wrap_content将完整显示其内部的文本和图像。布局元素将根据内容更改大小。设置一个视图的尺寸为wrap_content大体等同于设置Windows控件的Autosize属性为True。

3）match_parent
   Android2.2中match_parent和fill_parent是一个意思 .两个参数意思一样，match_parent更贴切，于是从2.2开始两个词都可以用。那么如果考虑低版本的使用情况你就需要用fill_parent了
2、android：gravity
属性值：top（顶部对齐） 、bottom（底部对齐） 、left（左对齐） 、right（右对齐） 、center_vertical（垂直方向居中） 、 fill_vertical（垂直方向填充） 、 center_horizontal（水平方向居中） 、 fill_horizontal（水平方向填充） 、center（垂直与水平方向都居中） 、 fill （填充）、  clip_vertical（垂直方向裁剪） 、  clip_horizontal（水平方向裁剪） 。可同时指定多种对其方式的组合，中间用“|”连接，如下方代码设置对齐方式为 left|center_vertical 表示出现在屏幕左边且垂直居中。
android:gravity="left|center_vertical"


除以上两个常用属性外，LinearLayout 的属性还有以下几个：
　　android：baselineAligned　　　　　　　　　　　　该属性设为 false ，将会阻止该布局管理器与它的子元素的基线对齐。

　　android：divider　　　　　　　　　　　　　　　　设置垂直布局时两个按钮直接的分隔条。

　　android：measureWithLargestChild　　　　　　该属性设为 true 时，所有带权重的子元素都会具有最大子元素的最小尺寸。

最后介绍一下 LinearLayout 子元素支持的常用属性：

　　android：layout_gravity　　　　指定该子元素在 LinearLayout 中的对其方式

　　android：layout_weight　　　　指定该子元素在 LinearLayout 中所占的权重
