
fragment的正确用法：nekocode/ToastAndroid · GitHub
####fragment出现的意义

Fragment的出现一方面是为了缓解Activity任务过重的问题，另一方面是为了处理在不同屏幕上UI组件的布局问题，而且它还提供了一些新的特性（例如Retainable）来处理一些在 Activity 中比较棘手的问题。

* Fragment 拥有和 Activity 一致的生命周期，它和 Activity 一样被定义为 Controller 层的类。有过中大型项目开发经验的开发者，应该都会遇到过 Activity 过于臃肿的情况，而 Fragment 的出现就是为了缓解这一状况，可以说 它将屏幕分解为多个「Fragment（碎片）」（这句话很重要），但它又不同于 View，它干的实质上就是 Activity 的事情，负责控制 View 以及它们之间的逻辑。
* 将屏幕碎片化为多个 Fragment 后，其实 Activity 只需要花精力去管理当前屏幕内应该显示哪些 Fragments，以及应该对它们进行如何布局就行了。这是一种组件化的思维，用 Fragment 去组合了一系列有关联的 UI 组件，并管理它们之间的逻辑，而 Activity 负责在不同屏幕下（例如横竖屏）布局不同的 Fragments 组合。
* 这种碎片不单单能管理可视的 Views，它也能执行不可视的 Tasks，它提供了 retainInstance 属性，能够在 Activity 因为屏幕状态发生改变（例如切换横竖屏时）而销毁重建时，依然保留实例。这示意着我们能在 RetainedFragment 里面执行一些在屏幕状态发生改变时不被中断的操作。例如在 ToastAndroid/StartActivity.kt at master 我使用了 RetainedFragment 来缓存在线音乐文件，它在横竖屏切换时依然维持下载进度，并通过一个 DialogFragment 来展示进度。

其实从 Google 推出 Support 包来支持在早些版本实现 Fragment 这一行为就可以看出，谷歌认为 Fragment 比 Activity 更适合管理屏幕组件，因为 Activity 在单屏下无法细分，注定了如果使用 Activity 来管理页面所有 UI 组件的话会造成组件耦合以及不可复用，代码也臃肿地会令人头痛。总而言之，我认为使用 Fragment 绝对是一种好习惯。

####fragment和view的比较
* Fragment的复用粒度更大。Fragment有完整的生命周期，从代码设计角度讲可以提高内聚性，不同情况下还可以设计不同的Fragment，比如横屏和竖屏情况下View的显示不一样，那么可以建立2个不同的Fragment去处理，代码上面可以有效的扩展。
从形态上讲和Activity更为接近，当然从编程角度上看也比View更为复杂。但是Fragment可以组装更多的View同一展示，而且生命周期有助于资源的管理。

* **简单的直接view，复杂的才用fragment,fragment资源消耗比较大。**

* 一个fragment必须总是绑定到一个activity中，虽然fragment有自己的生命周期，但同时也被它的宿主activity的生命周期直接影响。
大部分情况下，Fragment用来封转UI的模块化组件；但是也可以创建没有UI的Fragment来提供后台行为，该行为会一直持续到Activity重新启动。这特别适合于定期和UI交互的后台任务或者当因配置改变而导致Activity重新启动是，保存状态变得特别重要的场合。
注意：当Activity因为配置发生改变（屏幕旋转）或者内存不足被系统杀死，造成重新创建时，我们的fragment会被保存下来，但是会创建新的FragmentManager，新的FragmentManager会首先会去获取保存下来的fragment队列，重建fragment队列，从而恢复之前的状态。
