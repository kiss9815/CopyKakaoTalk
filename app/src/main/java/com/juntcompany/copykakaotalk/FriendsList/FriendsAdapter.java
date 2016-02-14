package com.juntcompany.copykakaotalk.FriendsList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by EOM on 2016-02-04.
 */
public class FriendsAdapter extends BaseAdapter{

    ArrayList<FriendsData> items = new ArrayList<FriendsData>();


    public void add(FriendsData data){
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
        FriendsView view;
        if(convertView == null){
            view = new FriendsView(parent.getContext());
        }else {
            view = (FriendsView)convertView;
        }
        view.setFriend(items.get(position));

    return view;
    }
}
