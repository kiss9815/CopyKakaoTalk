package com.juntcompany.copykakaotalk.ChannelList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.copykakaotalk.OnItemClickListener;
import com.juntcompany.copykakaotalk.R;

/**
 * Created by EOM on 2016-02-07.
 */
public class ChannelViewHolder extends RecyclerView.ViewHolder{

    ImageView image_picture;
    TextView text_title;
    ChannelDataNews data;

    public OnItemClickListener itemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }

    public ChannelViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, getAdapterPosition());
                }
            }
        });
       image_picture = (ImageView)itemView.findViewById(R.id.image_picture);
        text_title = (TextView)itemView.findViewById(R.id.text_title);

    }
    public void setData(ChannelDataNews data){
        this.data = data;
       image_picture.setImageDrawable(data.picture);
        text_title.setText(data.text_title);
    }

}
