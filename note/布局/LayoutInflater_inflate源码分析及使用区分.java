
//http://blog.csdn.net/u012480018/article/details/47404301 详细分析
//http://blog.csdn.net/guolin_blog/article/details/12921889  第一行代码的大神
/*

四种重载方式：（都是调用的下面的代码）
 inflate(int resource, ViewGroup root) 
          Inflate a new view hierarchy from the specified xml resource.
  inflate(int resource, ViewGroup root, boolean attachToRoot) 
          Inflate a new view hierarchy from the specified xml resource.
 inflate(XmlPullParser parser, ViewGroup root) 
          Inflate a new view hierarchy from the specified xml node.
   inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) 
          Inflate a new view hierarchy from the specified XML node.
*/
public View inflate(XmlPullParser parser, @Nullable ViewGroup root, boolean attachToRoot) {
        synchronized (mConstructorArgs) {
            Trace.traceBegin(Trace.TRACE_TAG_VIEW, "inflate");

            final Context inflaterContext = mContext;
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            Context lastContext = (Context) mConstructorArgs[0];
            mConstructorArgs[0] = inflaterContext;
            View result = root;

            try {
                // Look for the root node.
                int type;
                //逻辑：找到开始标签和文件结束的地方就跳出循环
                //如果是开始标签，获取标签名字，
                //parser.next()获取xml文件的标签类型，STAR_TAG（开始标签），
                //END_DOCUMENT（文件结束）
                while ((type = parser.next()) != XmlPullParser.START_TAG &&
                        type != XmlPullParser.END_DOCUMENT) {
                    // Empty
                }

                if (type != XmlPullParser.START_TAG) {
                    throw new InflateException(parser.getPositionDescription()
                            + ": No start tag found!");
                }

                final String name = parser.getName();

                if (DEBUG) {
                    System.out.println("**************************");
                    System.out.println("Creating root view: "
                            + name);
                    System.out.println("**************************");
                }

                if (TAG_MERGE.equals(name)) {
                    if (root == null || !attachToRoot) {
                        throw new InflateException("<merge /> can be used only with a valid "
                                + "ViewGroup root and attachToRoot=true");
                    }

                    rInflate(parser, root, inflaterContext, attrs, false);
                } else {
            // Temp is the root view that was found in the xml
/*temp=createViewFromTag(name, attrs) 根据标签名和参数创建View对象，
在createViewFromTag()方法的内部又会去调用createView()方法，
然后使用反射的方式创建出View的实例并返回。这样createViewFromTag等到的是一个根布局，还需要创建这个根标签下子标签的组件。
此时调用rInflate(parser, temp, attrs)将布局文件、根布局、布局参数都传入。
这是一个递归调用自身的方法。目的是递归的将根View（temp）下的子View实例化并addView到其父View中。
这样，把整个布局文件都解析完成后就形成了一个完整的DOM结构，最终会把最顶层的根布局返回，至此inflate()过程全部结束。
*/

                    final View temp = createViewFromTag(root, name, inflaterContext, attrs);

                    ViewGroup.LayoutParams params = null;

                    if (root != null) {
                        if (DEBUG) {
                            System.out.println("Creating params from root: " +
                                    root);
                        }
                        // Create layout params that match root, if supplied
                        params = root.generateLayoutParams(attrs);
                        if (!attachToRoot) {
                            // Set the layout params for temp if we are not
                            // attaching. (If we are, we use addView, below)
                            temp.setLayoutParams(params);
                        }
                    }
                     if (DEBUG) {
                        System.out.println("-----> start inflating children");
                    }

                    // Inflate all children under temp against its context.
                    rInflateChildren(parser, temp, attrs, true);

                    if (DEBUG) {
                        System.out.println("-----> done inflating children");
                    }

                    // We are supposed to attach all the views we found (int temp)
                    // to root. Do that now.
                    if (root != null && attachToRoot) {
                        root.addView(temp, params);
                    }

                    // Decide whether to return the root that was passed in or the
                    // top view found in xml.
                    if (root == null || !attachToRoot) {
                        result = temp;
                    }
                }

            } catch (XmlPullParserException e) {
                final InflateException ie = new InflateException(e.getMessage(), e);
                ie.setStackTrace(EMPTY_STACK_TRACE);
                throw ie;
            } catch (Exception e) {
                final InflateException ie = new InflateException(parser.getPositionDescription()
                        + ": " + e.getMessage(), e);
                ie.setStackTrace(EMPTY_STACK_TRACE);
                throw ie;
            } finally {
                // Don't retain static reference on context.
                mConstructorArgs[0] = lastContext;
                mConstructorArgs[1] = null;

                Trace.traceEnd(Trace.TRACE_TAG_VIEW);
            }

            return result;
        }
    }


