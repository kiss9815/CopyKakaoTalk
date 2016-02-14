package com.juntcompany.copykakaotalk.FriendsList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.juntcompany.copykakaotalk.R;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFriendsListFragment extends Fragment {

    private static final String FRAGMENT_TITLE = "친구";

    private static final String HEADER_DATA = "header";
    public TabFriendsListFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    ListView listView;
    FriendsAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_friends_list, container, false);
        listView = (ListView)view.findViewById(R.id.listView);

        View headerView = inflater.inflate(R.layout.view_header_friend_search,null);
        listView.addHeaderView(headerView, HEADER_DATA, false);

        View headerView2 = inflater.inflate(R.layout.view_header_friend_title,null); // header뷰 추가할때는 container 를 추가하지 않음
        TextView text_friend_title = (TextView)headerView2.findViewById(R.id.text_friend_title);
        text_friend_title.setText("내 프로필");
        listView.addHeaderView(headerView2, HEADER_DATA, false);

        View headerView_my_profile = inflater.inflate(R.layout.view_friends,null); // 내 프로필 header
        listView.addHeaderView(headerView_my_profile, HEADER_DATA, true);

        View headerView3 = inflater.inflate(R.layout.view_header_friend_title,null);
        TextView text_friend_title2 = (TextView)headerView3.findViewById(R.id.text_friend_title);
        text_friend_title2.setText("친구");
        listView.addHeaderView(headerView3, HEADER_DATA, false);

        mAdapter = new FriendsAdapter();
        listView.setAdapter(mAdapter);

        initData();
        return view;

    }

    private void initData(){
        Random r = new Random();
        for( int i = 0; i <12; i++){
            FriendsData d = new FriendsData();
            d.setName(d.friends_sample[i]);
            d.setProfile(R.mipmap.ic_launcher);
            mAdapter.add(d);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_friend_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle(FRAGMENT_TITLE);
        }
    }
}
