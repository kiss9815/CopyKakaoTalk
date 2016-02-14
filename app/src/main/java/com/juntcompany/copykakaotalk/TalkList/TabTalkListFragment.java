package com.juntcompany.copykakaotalk.TalkList;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.juntcompany.copykakaotalk.R;
import com.juntcompany.copykakaotalk.TalkList.ChattingRoom.ChattingRoomActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabTalkListFragment extends Fragment  {

    private static final String FRAGMENT_TITLE = "대화";

    public TabTalkListFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    ListView listView;
    TalkAdapter mAdapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_talk_list, container, false);

        listView = (ListView)view.findViewById(R.id.listView);
        mAdapter = new TalkAdapter();
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TalkData data = (TalkData)listView.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), ChattingRoomActivity.class);
                intent.putExtra(ChattingRoomActivity.INTENT_ROOM_TITLE, data.getRoom_name());
                intent.putExtra(ChattingRoomActivity.INTENT_ROOM_PICTURE, data.getRoom_profile());
                startActivity(intent);
            }
        });
        initData();
        return view;
    }

    private void initData(){

        for (int i = 0; i<10; i++){
            TalkData data = new TalkData();
            data.setRoom_name("room name : " + (i +1));
            mAdapter.add(data);
        }

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
       inflater.inflate(R.menu.menu_talk_list, menu);
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
