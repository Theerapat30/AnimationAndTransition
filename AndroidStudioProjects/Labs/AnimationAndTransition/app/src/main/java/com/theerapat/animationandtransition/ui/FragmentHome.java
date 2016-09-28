package com.theerapat.animationandtransition.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theerapat.animationandtransition.R;
import com.theerapat.animationandtransition.logging.LoggingFragment;

/**
 * Created by theerapat on 3/9/2559.
 */
public class FragmentHome extends LoggingFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LoggingFragment.TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

}
