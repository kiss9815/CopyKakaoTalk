package com.juntcompany.copykakaotalk.FriendsList;

import android.graphics.drawable.Drawable;

/**
 * Created by EOM on 2016-02-04.
 */
public class FriendsData  {
   private String name;
    private String talk_name;
    private int profile;

    public FriendsData(){

    }
    public FriendsData(int profile, String name, String talk_name){
        this.name = name;
        this.talk_name = talk_name;
        this.profile = profile;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTalk_name(String talk_name){
        this.talk_name = talk_name;
    }

    public void setProfile(int profile){
        this.profile = profile;
    }

    public String getName(){
        return name;
    }
    public String getTalk_name(){
        return talk_name;
    }
    public int getProfile(){
        return profile;
    }

    String[] friends_sample = {"진하윤", "주현우", "이지훈", "김혜민", "최혜선", "이재형", "주해찬", "김홍규",
            "김정호" , "이인호", "김현중", "장한솔", "모영호"};


}

