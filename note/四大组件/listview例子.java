package com.coloros.push.vip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by branch.ao on 2017/12/5 17:24.
 *
 * @see
 */

public class TestArrayAdapter extends BaseAdapter {

    private Context context;

    private List<UserInfoModel> userInfoModelList;

    public TestArrayAdapter(Context context, List<UserInfoModel> userInfoModelList) {
        this.context = context;
        this.userInfoModelList = userInfoModelList;
    }

    @Override
    public int getCount() {
        return userInfoModelList == null ? 0 : userInfoModelList.size();
    }

    @Override
    public UserInfoModel getItem(int i) {
        return userInfoModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.user_info_layout, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();

        UserInfoModel userInfoModel = getItem(i);

        viewHolder.nameTv.setText(userInfoModel.name);
        viewHolder.ageTv.setText(String.valueOf(userInfoModel.age));

        return view;
    }


    private class ViewHolder {

        public TextView nameTv;

        public TextView ageTv;

        public ViewHolder(View itemView) {

            nameTv = (TextView) itemView.findViewById(R.id.user_name);
            ageTv = (TextView) itemView.findViewById(R.id.user_age);
        }


    }
}
