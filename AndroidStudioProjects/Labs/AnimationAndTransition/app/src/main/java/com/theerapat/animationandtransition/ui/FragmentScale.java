package com.theerapat.animationandtransition.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.theerapat.animationandtransition.R;
import com.theerapat.animationandtransition.logging.LoggingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by theerapat on 3/9/2559.
 */
public class FragmentScale extends LoggingFragment {
    @BindView(R.id.button_animate_scale) Button buttonAnimateScale;
    @BindView(R.id.image_view_face) ImageView imageViewFace;

    private OnFragmentScaleListener scaleListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        scaleListener = (OnFragmentScaleListener) getActivity();
        View view = inflater.inflate(R.layout.fragment_scale,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.button_animate_scale)
    public void onAnimateScaleClicke(){
        animate();
        scaleListener.onScaleClicked();
    }

    private void animate(){
        imageViewFace.setScaleX(0);
        imageViewFace.setScaleY(0);
        imageViewFace.animate().scaleX(1).scaleY(1).start();
    }

    public interface OnFragmentScaleListener{
        public void onScaleClicked();
    }
}
