package com.juntcompany.copykakaotalk.ChannelList;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.copykakaotalk.MyDecoration;
import com.juntcompany.copykakaotalk.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabChannelListFragment extends Fragment {

    private static final String FRAGMENT_TITLE = "채널";

    public TabChannelListFragment() {
        setHasOptionsMenu(true);

        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ChannelAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_channel_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        mAdapter = new ChannelAdapter();
        //mAdapter.setOnItemClick ......
        recyclerView.setAdapter(mAdapter);

//        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        layoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new MyDecoration(getContext(), MyDecoration.STAGGERED_VERTICAL_LIST));


        initData();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_channel, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void initData(){
        for(int i = 0 ; i<8; i++){
            ChannelDataNews data = new ChannelDataNews();
            data.text_title = "item : " + i;
            Drawable d = getResources().getDrawable(data.CHANNEL_DATA_IMAGE[i]);
            data.picture = d;
            mAdapter.add(data);
        }

    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle(FRAGMENT_TITLE);
        }
    }
}
