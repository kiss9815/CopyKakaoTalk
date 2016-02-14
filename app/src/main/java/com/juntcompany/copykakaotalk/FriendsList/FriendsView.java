package com.juntcompany.copykakaotalk.FriendsList;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.copykakaotalk.R;

/**
 * Created by EOM on 2016-02-04.
 */
public class FriendsView extends FrameLayout {
    public FriendsView(Context context) {
        super(context);
        init();
    }

     ImageView image_profile;
    TextView text_name;
    TextView text_talk_name;
    FriendsData data;
    private void init(){
        inflate(getContext(), R.layout.view_friends, this);
         image_profile = (ImageView)findViewById(R.id.image_room_profile);
         text_name = (TextView)findViewById(R.id.text_room_name);
         text_talk_name = (TextView)findViewById(R.id.text_talk_name);

    }

    public void setFriend(FriendsData data){
        this.data  = data;
//        image_profile.setImageResource(data.profile);
        image_profile.setImageResource(data.getProfile());

        text_name.setText(data.getName());
        text_talk_name.setText(data.getTalk_name());
    }
}
