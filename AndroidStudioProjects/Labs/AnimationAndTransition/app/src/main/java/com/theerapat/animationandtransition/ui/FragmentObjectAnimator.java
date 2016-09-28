package com.theerapat.animationandtransition.ui;

import android.animation.ObjectAnimator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.theerapat.animationandtransition.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by theerapat on 3/9/2559.
 */
public class FragmentObjectAnimator extends Fragment {
    @BindView(R.id.button_object_animator) Button buttonObjectAnimator;
    @BindView(R.id.title_panel) ViewGroup titlePanel;

    private OnFragmentObjectAnimatorListener objectAnimatorListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        objectAnimatorListener = (OnFragmentObjectAnimatorListener) getActivity();
        View view = inflater.inflate(R.layout.fragment_object_animator,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.button_object_animator)
    public void objectAnimatorClicked(){
        animate();
        objectAnimatorListener.onObjectAnimatorClicked();
    }

    private void animate(){
        int startTitlePanel = titlePanel.getTop();
        int endTitlePanel = titlePanel.getBottom();
        ObjectAnimator.ofInt(titlePanel,"bottom",startTitlePanel,endTitlePanel).start();
    }

    public interface OnFragmentObjectAnimatorListener{
        public void onObjectAnimatorClicked();
    }
}
