package com.juntcompany.copykakaotalk.TalkList;

import android.graphics.drawable.Drawable;

import java.util.Date;

/**
 * Created by EOM on 2016-02-07.
 */
public class TalkData {
    private int room_profile;
    private String room_name;
    private String recent_speak;
    private int room_people_count;
    private String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRecent_speak() {
        return recent_speak;
    }

    public void setRecent_speak(String recent_speak) {
        this.recent_speak = recent_speak;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getRoom_people_count() {
        return room_people_count;
    }

    public void setRoom_people_count(int room_people_count) {
        this.room_people_count = room_people_count;
    }

    public int getRoom_profile() {
        return room_profile;
    }

    public void setRoom_profile(int room_profile) {
        this.room_profile = room_profile;
    }
}
