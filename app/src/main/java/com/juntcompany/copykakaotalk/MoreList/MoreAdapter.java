package com.juntcompany.copykakaotalk.MoreList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-02-10.
 */
public class MoreAdapter extends BaseAdapter{
    List<MoreData> items = new ArrayList<MoreData>();

    public void add(MoreData data){
        items.add(data);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MoreItemView view;
        if (convertView == null) {
            view = new MoreItemView(parent.getContext());
        } else {
            view = (MoreItemView)convertView;
        }
        view.setImageTextData(items.get(position));
        return view;
    }
}
