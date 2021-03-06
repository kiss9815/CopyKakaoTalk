package com.juntcompany.copykakaotalk;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by dongja94 on 2016-01-18.
 */
public class MyDecoration extends RecyclerView.ItemDecoration {

    int[] ATTR = {android.R.attr.listDivider};

    public static final int HORIZONTAL_LIST = 0;

    public static final int VERTICAL_LIST = 1;

    public static final int STAGGERED_VERTICAL_LIST = 2;


    private Drawable mDivider;

    private int mOrientation;

    public MyDecoration(Context context, int orientation) {
        TypedArray ta = context.obtainStyledAttributes(ATTR);
        mDivider = ta.getDrawable(0);
        ta.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST  && orientation !=STAGGERED_VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        super.onDraw(c, parent, state);
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else if(mOrientation == HORIZONTAL_LIST){
            drawHorizontal(c, parent);
        }else {

            drawHorizontal(c, parent);
            drawVertical(c, parent);
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else if(mOrientation ==HORIZONTAL_LIST){
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }else {
            outRect.set(0,0,mDivider.getIntrinsicWidth(),mDivider.getIntrinsicHeight() );
        }
    }
}
