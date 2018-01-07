https://www.jianshu.com/p/e11cdfaf15dc
https://www.jianshu.com/p/f88b6a9f7462
1.首先在manifest中添加：
```
<uses-permission
        android:name="android.permission.PACKAGE_USAGE_STATS"
        tools:ignore="ProtectedPermissions" />
```
由于该权限默认只授予系统应用，所以添加了ignore属性。(不会报错)
在manifest设置权限之后，就可以自己在设置-->安全-->有权查看使用情况的应用
打开该app可以查看设备上应用的常规信息的权限。

但是如何弹窗强制用户选择呢？
https://www.cnblogs.com/Free-Thinker/p/6047968.html
逻辑：弹窗让用户选择打开权限，然后跳转到系统设置页面，打开之后，用户回到app，通过startActivityforresult  获取权限结果，获取权限之后app刷新获取数据。

