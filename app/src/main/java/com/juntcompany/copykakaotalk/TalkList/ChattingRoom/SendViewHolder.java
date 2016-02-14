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

    SendData data;
    public SendViewHolder(View itemView) {
        super(itemView);
        text_message =(TextView)itemView.findViewById(R.id.text_message);

    }
    public void setData(SendData data){
        this.data = data;
        text_message.setText(data.message);
//        image_profile.setImageDrawable(data.image_profile);
    }
}
