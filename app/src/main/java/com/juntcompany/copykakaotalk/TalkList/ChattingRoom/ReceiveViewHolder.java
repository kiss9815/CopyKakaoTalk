package com.juntcompany.copykakaotalk.TalkList.ChattingRoom;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.copykakaotalk.R;

/**
 * Created by EOM on 2016-02-10.
 */
public class ReceiveViewHolder extends RecyclerView.ViewHolder {

    TextView text_message;
    ImageView image_profile;
    TextView text_date;
    ReceiveData data ;
    public ReceiveViewHolder(View itemView) {
        super(itemView);
        text_message =(TextView)itemView.findViewById(R.id.text_message);
        image_profile = (ImageView)itemView.findViewById(R.id.image_picture);
        text_date = (TextView)itemView.findViewById(R.id.text_date);
    }
    public void setData(ReceiveData data){
        this.data = data;
        text_message.setText(data.message);
        text_date.setText(data.date);
        image_profile.setImageDrawable(data.image_profile);
    }
}
