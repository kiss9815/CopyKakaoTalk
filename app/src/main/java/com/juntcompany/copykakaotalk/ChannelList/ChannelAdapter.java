package com.juntcompany.copykakaotalk.ChannelList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.copykakaotalk.OnItemClickListener;
import com.juntcompany.copykakaotalk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-02-07.
 */
public class ChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnItemClickListener {

    List<ChannelData> items = new ArrayList<ChannelData>();

    public void add(ChannelData data){
        items.add(data);
        notifyDataSetChanged();
    }

    OnItemClickListener itemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }

    @Override
    public void onItemClick(View view, int position) {
        if(itemClickListener !=null){
            itemClickListener.onItemClick(view, position);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_channel, parent, false);
        ChannelViewHolder holder = new ChannelViewHolder(view);
        holder.setOnItemClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChannelViewHolder)holder).setData((ChannelDataNews)items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
