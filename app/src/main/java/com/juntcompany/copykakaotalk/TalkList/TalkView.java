package com.juntcompany.copykakaotalk.TalkList;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.copykakaotalk.R;

/**
 * Created by EOM on 2016-02-07.
 */
public class TalkView extends FrameLayout {
    public TalkView(Context context) {
        super(context);
        init();
    }

    ImageView image_room_profile;
    TextView text_room_name;
    TextView text_recent_speak;
    TextView text_people_count;
    TextView text_time;
    TalkData data;

    private void init(){
       inflate(getContext(), R.layout.view_talk, this);
        image_room_profile = (ImageView)findViewById(R.id.image_room_profile);
        text_room_name = (TextView)findViewById(R.id.text_room_name);
        text_recent_speak = (TextView)findViewById(R.id.text_recent_speak);
        text_people_count = (TextView)findViewById(R.id.text_people_count);
        text_time = (TextView)findViewById(R.id.text_time);

    }
    public void setTalkData(TalkData data){
        this.data = data;

        image_room_profile.setImageResource(data.getRoom_profile());
        text_room_name.setText(data.getRoom_name());
        text_recent_speak.setText(data.getRecent_speak());
        text_people_count.setText(""+data.getRoom_people_count());

    }

}
