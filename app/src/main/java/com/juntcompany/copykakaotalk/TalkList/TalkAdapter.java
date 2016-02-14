package com.juntcompany.copykakaotalk.TalkList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-02-07.
 */
public class TalkAdapter extends BaseAdapter {

    List<TalkData> items = new ArrayList<TalkData>();

    public void add(TalkData data){
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

        TalkView view;
        if(convertView==null){
            view = new TalkView(parent.getContext());
        }else {
            view = (TalkView)convertView;
        }
        view.setTalkData(items.get(position));

        return view;
    }
}
