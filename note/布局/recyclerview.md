在 main module的gradle.build里面的
dependencies{
    implementation 'com.android.support:appcompat-v7:26.1.0'
    compile 'com.android.support:recyclerview-v7:26.1.0'
}
两个版本一致就可以了。

http://blog.csdn.net/sinat_35762047/article/details/53728803
完整的例子

http://blog.csdn.net/u013091087/article/details/51331133
使用的简单例子介绍(详解)


recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
LinearLayoutManager的实例需要三个参数，第一个contex；第二个布局是垂直还是水平；第三个

http://blog.csdn.net/lmj623565791/article/details/45059587
RecyclerView使用完全解析

注意事项：
context是activity的基类  初始化context只用指定该activity就可以了  使用this
显示使用visible
