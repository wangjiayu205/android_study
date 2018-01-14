它可以使用用户滚动显示一个占据的空间大于物理显示的视图列表。值得注意的是，ScrollView只能包含一个子视图或视图组，在实际项目中，通常包含的是一个垂直的LinearLayout。

ScrollTo 和 ScrollBy 
ScrollTo (x,y)  x,y是偏移量
比如要移动到坐标为（100,100）的位置上
ScrollTo (-100,-100)

ScrollBy （-20，-20）
return ScrollTo（mScrollX+dx，mScrollY+dy）
return ScrollTo（-100+-20，-100+-20）
就是相对于目前的位置的偏移量

smoothScrollTo是在ScrollTo上面加了平滑滚动的动画
smoothScrollBy是在ScrollBy上面加了平滑滚动的动画
