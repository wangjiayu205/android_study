[原文传送门](http://blog.csdn.net/guolin_blog/article/details/12921889)
[详细代码解析](http://blog.csdn.net/lmj623565791/article/details/38171465)
两种写法：
1. LayoutInflater layoutInflater = LayoutInflater.from(context); 
2. LayoutInflater layoutInflater = (LayoutInflater) context 
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE); 

inflate()方法一般接收两个参数，第一个参数就是要加载的布局id，第二个参数是指给该布局的外部再嵌套一层父布局，如果不需要就直接传null。这样就成功成功创建了一个布局的实例，之后再将它添加到指定的位置就可以显示出来了。

用法：
先setContentView设置一个布局，然后用inflate方法把布局加载进之前的布局去；
例子：
1. main_layout：一个LinearLayout
2. 
public class MainActivity extends Activity { 
    private LinearLayout mainLayout; 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
        mainLayout = (LinearLayout) findViewById(R.id.main_layout); 
        LayoutInflater layoutInflater = LayoutInflater.from(this); 
        View buttonLayout = layoutInflater.inflate(R.layout.button_layout, null); 
        mainLayout.addView(buttonLayout); //把button加进LinearLayout里面
    } 
} 

layout_width和layout_height属性不是指的空间的大小，而是指在layout中的大小，所以控件必须存在在一个布局中可会有效。平时setContentView也会有效，是因为Android会自动在布局文件的最外层再嵌套一个FrameLayout。

从上面的分析已经可以看出：
Inflate(resId , null ) 只创建temp ,返回temp
Inflate(resId , parent, false )创建temp，然后执行temp.setLayoutParams(params);返回temp
Inflate(resId , parent, true ) 创建temp，然后执行root.addView(temp, params);最后返回root
由上面已经能够解释：
Inflate(resId , null )不能正确处理宽和高是因为：layout_width,layout_height是相对了父级设置的，必须与父级的LayoutParams一致。而此temp的getLayoutParams为null
Inflate(resId , parent,false ) 可以正确处理，因为temp.setLayoutParams(params);这个params正是root.generateLayoutParams(attrs);得到的。