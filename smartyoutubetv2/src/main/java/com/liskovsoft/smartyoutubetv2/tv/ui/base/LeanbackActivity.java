package com.liskovsoft.smartyoutubetv2.tv.ui.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentActivity;
import com.liskovsoft.sharedutils.mylogger.Log;
import com.liskovsoft.smartyoutubetv2.tv.ui.search.SearchActivity;

/**
 * This parent class contains common methods that run in every activity such as search.
 */
public abstract class LeanbackActivity extends FragmentActivity {
    private static final String TAG = LeanbackActivity.class.getSimpleName();
    private LongClickManager mLongClickManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLongClickManager = new LongClickManager();
    }

    @Override
    public boolean onSearchRequested() {
        startActivity(new Intent(this, SearchActivity.class));
        return true;
    }
    
    @SuppressLint("RestrictedApi")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(TAG, event);

        mLongClickManager.dispatchKeyEvent(event);

        return super.dispatchKeyEvent(event);
    }

    public boolean isLongClick() {
        return mLongClickManager.isLongClick();
    }
}