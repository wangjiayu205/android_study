@Override是伪代码,表示重写(当然不写也可以),不过写上有如下好处: 1、可以当注释用,方便阅读 2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的,如果没有则报错 比如你如果没写@Override而你下面的方法名又写错了,这时你的编译器是可以通过的(它以为这个方法是你的子类中自己增加的方法)
 
example:
 
在重写父类的onCreate时，在方法前面加上@Override 系统可以帮你检查方法的正确性。例如，public void onCreate(Bundle savedInstanceState){…….}这种写法是正确的，如果你写成public void oncreate(Bundle savedInstanceState){…….}这样编译器回报如下错误——The method oncreate(Bundle) of type HelloWorld must override or implement a supertype method，以确保你正确重写onCreate方法。（因为oncreate应该为onCreate）
而如果你不加@Override，则编译器将不会检测出错误，而是会认为你新定义了一个方法oncreate。

Java 里使用 long 类型的数据一定要在数值后面加上 L，否则将作为整型解析：
long g = (long)9223372036854775807;
long h = (long)-9223372036854775808;

或者

long g = 9223372036854775807;
long h = -9223372036854775808;
会出现以下报错信息：
Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
The literal 9223372036854775807 of type int is out of range
The literal 9223372036854775808 of type int is out of range 
溢出了~
解决方法在数值后面加上 L：
long value = 9223372036854775807L;