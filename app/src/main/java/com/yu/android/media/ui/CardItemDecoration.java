package com.yu.android.media.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yu.android.media.R;

public class CardItemDecoration extends RecyclerView.ItemDecoration {
    private int mDividerHeight;
    private Paint mPaint;

    public CardItemDecoration(Context context) {
        mDividerHeight = (int) context.getResources().getDimension(R.dimen.divider_height);
        mPaint = new Paint();
        mPaint.setColor(context.getResources().getColor(R.color.cardview_dark_background));
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = mDividerHeight;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < parent.getChildCount(); i++) {
            View v = parent.getChildAt(i);
            int top = v.getBottom();
            int bottom = v.getBottom() + mDividerHeight;
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }
}
