package com.juntcompany.copykakaotalk.MoreList;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.copykakaotalk.R;

/**
 * Created by EOM on 2016-02-14.
 */
public class MoreItemView extends FrameLayout {
    public MoreItemView(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView titleView;
    private void init() {
        inflate(getContext(), R.layout.view_item_more, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        titleView = (TextView)findViewById(R.id.text_title);
    }

    public void setImageTextData(MoreData data) {
        iconView.setImageDrawable(data.picture);
        titleView.setText(data.title);
    }
}
