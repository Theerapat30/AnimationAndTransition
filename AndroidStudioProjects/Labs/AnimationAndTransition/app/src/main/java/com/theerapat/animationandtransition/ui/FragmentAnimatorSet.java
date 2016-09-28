package com.theerapat.animationandtransition.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.theerapat.animationandtransition.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by theerapat on 3/9/2559.
 */
public class FragmentAnimatorSet extends Fragment {
    @BindView(R.id.button_animator_set) Button buttonAnimatorSet;
    @BindView(R.id.image_view_face) ImageView imageViewFace;
    @BindView(R.id.title_band) ViewGroup titleBand;
    @BindView(R.id.track_band) ViewGroup trackBand;

    private OnFragmentAnimatorSetListener animatorSetListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        animatorSetListener = (OnFragmentAnimatorSetListener) getActivity();
        View view = inflater.inflate(R.layout.fragment_animator_set, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.button_animator_set)
    public void animatorSetClicked(){
        animate();
        animatorSetListener.onAnimatorSetClicked();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void animate(){
        Animator scale = AnimatorInflater.loadAnimator(getContext(),R.animator.scale);
        scale.setTarget(imageViewFace);

        int startTitle = titleBand.getTop();
        int endTitle = titleBand.getBottom();
        ObjectAnimator animatorTitle = ObjectAnimator.ofInt(titleBand,"bottom",startTitle,endTitle);
        animatorTitle.setInterpolator(new AccelerateInterpolator());

        int startTrack = trackBand.getTop();
        int endTrack = trackBand.getBottom();
        ObjectAnimator animatorTrack = ObjectAnimator.ofInt(trackBand,"bottom",startTrack,endTrack);
        animatorTrack.setInterpolator(new DecelerateInterpolator());

        /*smooth title and track*/
        titleBand.setBottom(startTitle);
        trackBand.setBottom(startTitle);
        imageViewFace.setScaleY(0);
        imageViewFace.setScaleY(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorTitle,animatorTrack,scale);
        animatorSet.start();
    }

    public interface OnFragmentAnimatorSetListener{
        public void onAnimatorSetClicked();
    }
}
