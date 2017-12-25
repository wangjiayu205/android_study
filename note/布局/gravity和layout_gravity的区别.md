**首先来看看android:layout_gravity和android:gravity的使用区别。
android:gravity：**
这个是针对控件里的元素来说的，用来控制元素在该控件里的显示位置。例如，在一个Button按钮控件中设置如下两个属性，
android:gravity="left"和android:text="提交"，这时Button上的文字“提交”将会位于Button的左部。

android:layout_gravity：
这个是针对控件本身而言，用来控制该控件在包含该控件的父控件中的位置。同样，当我们在Button按钮控件中设置android:layout_gravity="left"属性时，表示该Button按钮将位于界面的左部。

2.**属性值：**
这两个属性可选的值有：top、bottom、left、right、center_vertical、fill_vertical、center_horizontal、fill_horizontal、center、fill、clip_vertical。
clip_vertical   ：
附加选项，用于按照容器的边来剪切对象的顶部和/或底部的内容. 剪切基于其纵向对齐设置：顶部对齐时，剪切底部；底部对齐时剪切顶部；除此之外剪切顶部和底部.
垂直方向裁剪
clip_horizontal   ：
附加选项，用于按照容器的边来剪切对象的左侧和/或右侧的内容. 剪切基于其横向对齐设置：左侧对齐时，剪切右侧；右侧对齐时剪切左侧；除此之外剪切左侧和右侧.
水平方向裁剪
