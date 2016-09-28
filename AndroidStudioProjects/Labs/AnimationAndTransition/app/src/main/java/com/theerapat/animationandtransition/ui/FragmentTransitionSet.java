package com.theerapat.animationandtransition.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theerapat.animationandtransition.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by theerapat on 4/9/2559.
 */
public class FragmentTransitionSet extends Fragment{
    @BindView(R.id.title_book) ViewGroup titleBook;
    @BindView(R.id.track_book) ViewGroup trackBook;
    @BindView(R.id.detail_container) ViewGroup detailContainer;

    private TransitionManager transitionManager;
    private Scene expandedScene;
    private Scene collapseScene;
    private Scene currentScene;

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transition_set, container, false);
        myView = view;
        ButterKnife.bind(this,view);
        setupTransition();
        return view;
    }

    @OnClick(R.id.title_book)
    public void onTitleBookClicked(){
        if (currentScene == expandedScene){
            currentScene = collapseScene;
        }
        else{
            currentScene = expandedScene;
        }
        transitionManager.transitionTo(currentScene);
    }

    private void setupTransition(){
        ViewGroup transitionRoot = detailContainer;
        transitionManager = new TransitionManager();

        //expanded
        expandedScene = Scene.getSceneForLayout(transitionRoot, R.layout.fragment_transition_set_expaned, getContext());
        expandedScene.setEnterAction(new Runnable() {
            @Override
            public void run() {
                ButterKnife.bind(FragmentTransitionSet.this,myView);
                currentScene = expandedScene;
            }
        });

        TransitionSet expandedTransitionSet = new TransitionSet();
        expandedTransitionSet.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);

        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(200);
        expandedTransitionSet.addTransition(changeBounds);

        Fade fadeLyric = new Fade();
        fadeLyric.addTarget(R.id.lyrics);
        fadeLyric.setDuration(150);
        expandedTransitionSet.addTransition(fadeLyric);

        //Collapse
        collapseScene = Scene.getSceneForLayout(transitionRoot, R.layout.fragment_transition_set, getContext());
        collapseScene.setEnterAction(new Runnable() {
            @Override
            public void run() {
                ButterKnife.bind(FragmentTransitionSet.this,myView);
                currentScene = collapseScene;
            }
        });
        TransitionSet collapseTransitionSet = new TransitionSet();
        collapseTransitionSet .setOrdering(TransitionSet.ORDERING_SEQUENTIAL);

        Fade fadeOutLyric = new Fade();
        fadeOutLyric.addTarget(R.id.lyrics);
        fadeOutLyric.setDuration(150);
        collapseTransitionSet.addTransition(fadeOutLyric);

        ChangeBounds resetChangeBounds = new ChangeBounds();
        resetChangeBounds.setDuration(200);
        collapseTransitionSet.addTransition(resetChangeBounds);

        transitionManager.setTransition(expandedScene,collapseScene,collapseTransitionSet);
        transitionManager.setTransition(collapseScene,expandedScene,expandedTransitionSet);
        collapseScene.enter();
    }
}
