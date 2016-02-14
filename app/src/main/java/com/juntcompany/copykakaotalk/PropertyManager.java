package com.juntcompany.copykakaotalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;

/**
 * Created by EOM on 2016-02-14.
 */
public class PropertyManager {
    private static PropertyManager instance;
    public static PropertyManager getInstance(){
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    private static final String USER_PROFILE = "user_profile";
    private static final String USER_NAME = "user_name";

    private PropertyManager() {
        Context context = MyApplication.getContext();
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPrefs.edit();
    }

    public void setUserProfile(int userProfile){
        mEditor.putInt(USER_PROFILE, userProfile);
        mEditor.commit();
    }
    public int getUserProfile(){
        return mPrefs.getInt(USER_PROFILE, 1);
    }

    public void setUserName(String userName){
        mEditor.putString(USER_NAME, userName);
        mEditor.commit();
    }
    public String getUserName(){
        return mPrefs.getString(USER_NAME, "");
    }

}
