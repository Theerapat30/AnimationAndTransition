package com.theerapat.animationandtransition.supporting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.theerapat.animationandtransition.R;
import com.theerapat.animationandtransition.ui.FragmentHome;

/**
 * Created by theerapat on 3/9/2559.
 */
public class ViewFragment extends Fragment {
    private FragmentManager manager;

    public static void render(FragmentManager manager){
        render(manager,new FragmentHome());
    }

    public static void render(FragmentManager manager, Fragment fragment){
        new ViewFragment(manager).render(fragment);
    }

    private ViewFragment(FragmentManager manager) {
        this.manager = manager;
    }

    private void render(Fragment fragment){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }
}
