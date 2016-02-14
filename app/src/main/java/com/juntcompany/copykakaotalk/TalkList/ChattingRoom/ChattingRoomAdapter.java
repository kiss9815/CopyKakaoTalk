package com.juntcompany.copykakaotalk.TalkList.ChattingRoom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.copykakaotalk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-02-10.
 */
public class ChattingRoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   List<ChattingRoomData> items = new ArrayList<ChattingRoomData>();

   public void add(ChattingRoomData data){
       items.add(data);
        notifyDataSetChanged();
   }
    private static final int VIEW_TYPE_RECEIVE = 100;
    private static final int VIEW_TYPE_SEND = 200;

    @Override
    public int getItemViewType(int position) {
        ChattingRoomData data = items.get(position);
        if (data instanceof ReceiveData) {
            return VIEW_TYPE_RECEIVE;
        }
           else{
                return VIEW_TYPE_SEND;
            }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
       switch (viewType){
           case VIEW_TYPE_RECEIVE:
               view =inflater.inflate(R.layout.view_receive, parent, false);
               return new ReceiveViewHolder(view);

           case VIEW_TYPE_SEND:
               view = inflater.inflate(R.layout.view_send, parent, false);
               return new SendViewHolder(view);
       }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case VIEW_TYPE_RECEIVE:
                ((ReceiveViewHolder)holder).setData((ReceiveData) items.get(position));
                break;
            case VIEW_TYPE_SEND:
                ((SendViewHolder)holder).setData((SendData)items.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
