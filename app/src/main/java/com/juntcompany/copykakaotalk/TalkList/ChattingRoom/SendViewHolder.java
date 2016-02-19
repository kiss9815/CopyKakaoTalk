package com.juntcompany.copykakaotalk.TalkList.ChattingRoom;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.copykakaotalk.R;

/**
 * Created by EOM on 2016-02-10.
 */
public class SendViewHolder extends ReceiveViewHolder{

    TextView text_message;
    TextView text_date;
    SendData data;
    public SendViewHolder(View itemView) {
        super(itemView);
        text_message =(TextView)itemView.findViewById(R.id.text_message);
        text_date = (TextView)itemView.findViewById(R.id.text_date);
    }
    public void setData(SendData data){
        this.data = data;
        text_message.setText(data.message);
        text_date.setText(data.date);
//        image_profile.setImageDrawable(data.image_profile);
    }
}
