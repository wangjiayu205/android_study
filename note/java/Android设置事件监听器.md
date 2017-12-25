主要是通过intent
核心代码：
Intent intent = new Intent();
intent.setClass(MainActivity.this, SecondActivity.class); 
或者：
Intent intent=new Intent(this,SecondActivity.class);

[原文传送门](https://www.cnblogs.com/smyhvae/p/3863720.html)
两种方法：
第一种：设置监听器 
第二种：在xml中设置android：onClick="xxxx";
然后写：
public void xxxx(View view){
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }