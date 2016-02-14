package com.juntcompany.copykakaotalk;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.juntcompany.copykakaotalk.ChannelList.TabChannelListFragment;
import com.juntcompany.copykakaotalk.FriendsList.TabFriendsListFragment;
import com.juntcompany.copykakaotalk.MoreList.TabMoreFragment;
import com.juntcompany.copykakaotalk.TalkList.TabTalkListFragment;

/**
 * Created by EOM on 2016-02-02.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter{
    private static final int TAB_COUNT = 4;
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabFriendsListFragment();

            case 1:
                return new TabTalkListFragment();
            case 2:
                return new TabChannelListFragment();
            case 3:
                return new TabMoreFragment();
            default:  return TabFragment.newInstance("item : " + position);
        }

    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
