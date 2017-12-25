####java泛型

首先告诉你 AdapterView < ? > arg0 参数得意思：官方解释说：the AdapterView where the click happened. 也就是当前点击的adapterview，这个参数是系统自动传入的，我们也不用调用，一般常用第二个和第三个参数。
然后给你讲AdapterView< ? > ，这个属于java基础的内容，叫做泛型，就是告诉你传入的参数是哪种类型。 比如String< ? >,List,Map,String 
?表示不确定的java类型。 
T  表示java类型。 
K V 分别代表java键值中的Key Value。 
E 代表Element。 
 ListView, GridView, Spinner and Gallery 中都要用到adapter，所以这里用问好表示不确定传入的是哪种类型，不用我们关系，系统自动传入

 常用的泛型：
 ？,T,K,V,E

注意：
T是虽然是任何类型，但是当T固定时，当前作用域内使用T类型的变量的类型应该是一样的。如果是？ ，他的意思是，虽然是任何类型，担当一个？有了之后，其他的应该是当前类型的子类或这个类 就像AdapterView一样。

listview，gridview都是AdapterView的子类【listview集成于adapterview,adapterview集成于viewgroup】