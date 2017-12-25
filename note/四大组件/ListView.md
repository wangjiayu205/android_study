[工作原理全解析](http://blog.csdn.net/guolin_blog/article/details/44996879)
[特别详细版](http://l62s.iteye.com/blog/1675509)
[BaseAdapter的基本用法以及ViewHolder模式](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1021/1815.html)
[完整例子](http://www.cnblogs.com/topcoderliu/archive/2011/05/07/2039862.html)
listview的点击监听器：
lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            publicvoid onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                    //点击后在标题上显示点击了第几行                     setTitle("你点击了第"+arg2+"行");
            }
        });

OnClickListener和OnItemClickListener的区别：
拿ListView举例来说OnClickListener是监听ListView本身的点击事件OnItemClickListener 是监听ListView中子条目的点击事件。

基本用法：
1. xml中使用listview
```
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
    android:layout_width="match_parent"  
    android:layout_height="match_parent"  
    android:orientation="vertical" >  
  
    <ListView  
        android:id="@+id/list1"  
        android:layout_width="fill_parent"  
        android:layout_height="fill_parent" >  
    </ListView>   
    </LinearLayout>
```
2. 