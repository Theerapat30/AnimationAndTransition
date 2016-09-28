package com.theerapat.animationandtransition.supporting;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;

/**
 * Created by theerapat on 3/9/2559.
 */
public class MyDrawerLayout extends DrawerLayout implements DrawerLayout.DrawerListener{
    private static final String TAG = "DrawerLayout";
    private Context context;

    public MyDrawerLayout(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        Log.i(TAG,"onDrawerSlide");
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        Log.i(TAG,"onDrawerOpened");
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        Log.i(TAG,"onDrawerClosed");
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        Log.i(TAG,"onDrawerStateChanged");
    }


}
