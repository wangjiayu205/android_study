[原文传送门](http://www.cnblogs.com/topcoderliu/archive/2011/05/07/2039862.html)
package com.myAndroid.test;   
  
 import java.util.ArrayList;   
 import java.util.HashMap;   
import java.util.List;   
import java.util.Map;   
  
import Android.app.Activity;   
import Android.app.AlertDialog;   
import Android.content.DialogInterface;   
import Android.os.Bundle;   
import Android.view.View;   
import Android.view.View.OnClickListener;   
import Android.widget.ArrayAdapter;   
import Android.widget.ImageButton;   
import Android.widget.ListView;   
  
public class MyListView extends Activity {   
       
    private ListView listView;   
    private ImageButton imgbt_sum;   
    private ListViewAdapter listViewAdapter;   
    private List<Map<String, Object>> listItems;   
    private Integer[] imgeIDs = {R.drawable.cake,    
            R.drawable.gift, R.drawable.letter,   
            R.drawable.love, R.drawable.mouse,   
            R.drawable.music};   
    private String[] goodsNames = {"蛋糕", "礼物",    
            "邮票", "爱心", "鼠标", "音乐CD"};   
    private String[] goodsDetails = {   
            "蛋糕：好好吃。",    
            "礼物：礼轻情重。",    
            "邮票：环游世界。",    
            "爱心：世界都有爱。",   
            "鼠标：反应敏捷。",   
            "音乐CD：酷我音乐。"};   
       
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {   
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.main);   //加载主页面
           
        listView = (ListView)findViewById(R.id.list_goods);   //找到主页面里面的listview
        imgbt_sum = (ImageButton) findViewById(R.id.imgbt_sum);  //主页面listview上面有一个btn 
        imgbt_sum.setOnClickListener(new ClickEvent());   //在btn上面设置点击监听器
        listItems = getListItems();   //获取商品信息，就是listview里面应该有的内容
        listViewAdapter = new ListViewAdapter(this, listItems
        ); //创建适配器，把应该放在listview里面的内容放进适配器里面   
        listView.setAdapter(listViewAdapter);   //为listview设置适配器
    }   
       
    /**  
     * 初始化商品信息  
     */  
    private List<Map<String, Object>> getListItems() {   
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
        for(int i = 0; i < goodsNames.length; i++) {   
            Map<String, Object> map = new HashMap<String, Object>();    
            map.put("image", imgeIDs[i]);               //图片资源   
            map.put("title", "物品名称：");              //物品标题   
            map.put("info", goodsNames[i]);     //物品名称   
            map.put("detail", goodsDetails[i]); //物品详情   
            listItems.add(map);   
        }      
        return listItems;   
    }   
       
    class ClickEvent implements OnClickListener{   
  
        @Override  
        public void onClick(View v) {   
            // TODO Auto-generated method stub   
            String goodsList = "";   
            for(int i = 0; i < listItems.size(); i++) {   
                goodsList += listViewAdapter.hasChecked(i)? goodsNames[i] + "  ": "";   
            }   
            new AlertDialog.Builder(MyListView.this)   
            .setTitle("购物清单：")   
            .setMessage("你好，你选择了如下商品：\n" + goodsList)   
            .setPositiveButton("确定", null)   
            .show();   
        }   
           
    }   
}   


package com.myAndroid.test;   
  
 import java.util.List;   
import java.util.Map;   
  
import Android.app.AlertDialog;   
import Android.content.Context;   
import Android.util.Log;   
import Android.view.LayoutInflater;   
import Android.view.View;   
import Android.view.ViewGroup;   
import Android.widget.BaseAdapter;   
import Android.widget.Button;   
import Android.widget.CheckBox;   
import Android.widget.CompoundButton;   
import Android.widget.ImageView;   
import Android.widget.ListView;   
import Android.widget.TextView;   
  
public class ListViewAdapter extends BaseAdapter {   
    private Context context;                        //运行上下文   
    private List<Map<String, Object>> listItems;    //商品信息集合   
    private LayoutInflater listContainer;           //视图容器   
    private boolean[] hasChecked;                   //记录商品选中状态   
    public final class ListItemView{                //自定义控件集合     
            public ImageView image;     
            public TextView title;     
            public TextView info;   
            public CheckBox check;   
            public Button detail;          
     }     
       
       
    public ListViewAdapter(Context context, List<Map<String, Object>> listItems) {   
        this.context = context;            
        listContainer = LayoutInflater.from(context);   //创建视图容器并设置上下文   
        this.listItems = listItems;   
        hasChecked = new boolean[getCount()];   
    }   
  
    public int getCount() {   
        // TODO Auto-generated method stub   
        return listItems.size();   
    }   
  
    public Object getItem(int arg0) {   
        // TODO Auto-generated method stub   
        return null;   
    }   
  
    public long getItemId(int arg0) {   
        // TODO Auto-generated method stub   
        return 0;   
    }   
       
    /**  
     * 记录勾选了哪个物品  
     * @param checkedID 选中的物品序号  
     */  
    private void checkedChange(int checkedID) {   
        hasChecked[checkedID] = !hasChecked[checkedID];   
    }   
       
    /**  
     * 判断物品是否选择  
     * @param checkedID 物品序号  
     * @return 返回是否选中状态  
     */  
    public boolean hasChecked(int checkedID) {   
        return hasChecked[checkedID];   
    }   
       
    /**  
     * 显示物品详情  
     * @param clickID  
     */  
    private void showDetailInfo(int clickID) {   
        new AlertDialog.Builder(context)   
        .setTitle("物品详情：" + listItems.get(clickID).get("info"))   
        .setMessage(listItems.get(clickID).get("detail").toString())                 
        .setPositiveButton("确定", null)   
        .show();   
    }   
       
          
    /**  
     * ListView Item设置  
     */  
    public View getView(int position, View convertView, ViewGroup parent) {   
        // TODO Auto-generated method stub   
        Log.e("method", "getView");   
        final int selectID = position;   
        //自定义视图   
        ListItemView  listItemView = null;   
        if (convertView == null) {   
            listItemView = new ListItemView();    
            //获取list_item布局文件的视图   
            convertView = listContainer.inflate(R.layout.list_item, null);   
            //使用LayoutInflater加载布局
            //获取控件对象   
            listItemView.image = (ImageView)convertView.findViewById(R.id.imageItem);   
            listItemView.title = (TextView)convertView.findViewById(R.id.titleItem);   
            listItemView.info = (TextView)convertView.findViewById(R.id.infoItem);   
            listItemView.detail= (Button)convertView.findViewById(R.id.detailItem);   
            listItemView.check = (CheckBox)convertView.findViewById(R.id.checkItem);   
            //设置控件集到convertView   
            convertView.setTag(listItemView);   
        }else {   
            listItemView = (ListItemView)convertView.getTag();   
        }   
//      Log.e("image", (String) listItems.get(position).get("title"));  //测试   
//      Log.e("image", (String) listItems.get(position).get("info"));   
           
        //设置文字和图片   
        listItemView.image.setBackgroundResource((Integer) listItems.get(   
                position).get("image"));   
        listItemView.title.setText((String) listItems.get(position)   
                .get("title"));   
        listItemView.info.setText((String) listItems.get(position).get("info"));   
        listItemView.detail.setText("商品详情");   
        //注册按钮点击时间爱你   
        listItemView.detail.setOnClickListener(new View.OnClickListener() {   
            @Override  
            public void onClick(View v) {   
                //显示物品详情   
                showDetailInfo(selectID);   
            }   
        });   
        // 注册多选框状态事件处理   
        listItemView.check   
                .setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {   
                    @Override  
                    public void onCheckedChanged(CompoundButton buttonView,   
                            boolean isChecked) {   
                        //记录物品选中状态   
                        checkedChange(selectID);   
                    }   
        });   
           
        return convertView;   
    }   
}  