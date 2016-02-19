package com.juntcompany.copykakaotalk.TalkList.ChattingRoom;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.juntcompany.copykakaotalk.R;

import java.util.Date;


public class ChattingRoomActivity extends AppCompatActivity {


    ChattingRoomAdapter mAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EditText edit_input;

    public static final String INTENT_ROOM_TITLE = "room_title";
    public static final String INTENT_ROOM_PICTURE= "room_profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting_room);
        setSupportActionBar((Toolbar) findViewById(R.id.chattingToolbar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        mAdapter = new ChattingRoomAdapter();

        recyclerView.setAdapter(mAdapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        edit_input = (EditText)findViewById(R.id.edit_input);

        Intent intent = getIntent();
        String message = intent.getStringExtra(INTENT_ROOM_TITLE);
        int profile = intent.getIntExtra(INTENT_ROOM_PICTURE, 0);
        setTitle(message);
        final Handler mHandler = new Handler(Looper.getMainLooper());
        Button btn = (Button)findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendData sd = new SendData();

                sd.message = edit_input.getText().toString();
                sd.date = new Date().toString();
                mAdapter.add(sd);


                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ReceiveData rd = new ReceiveData();
                        rd.image_profile = getResources().getDrawable(R.drawable.friend);
                        rd.date = new Date().toString();
                        rd.message = edit_input.getText().toString();
                        mAdapter.add(rd);
                        edit_input.setText("");
                    }
                }, 2000);


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.chatting_room_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
