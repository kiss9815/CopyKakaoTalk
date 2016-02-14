package com.juntcompany.copykakaotalk.MoreList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.juntcompany.copykakaotalk.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabMoreFragment extends Fragment {

    private static final String FRAGMENT_TITLE = "더보기";

    public TabMoreFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    GridView gridView;
    MoreAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_more, container, false);
         gridView= (GridView)view.findViewById(R.id.gridView);
        mAdapter = new MoreAdapter();
        //mAdapter.setOnItemClick ...
        gridView.setAdapter(mAdapter);


        initData();
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_more, menu);
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

    private void initData(){
        for(int i=0; i<12; i++){
            MoreData data = new MoreData();
            data.title = data.MORE_DATA_TITLE[i];
            data.picture = getResources().getDrawable(data.MORE_DATA_IMAGE[i%data.MORE_DATA_IMAGE.length]);
            mAdapter.add(data);
        }
    }
}
