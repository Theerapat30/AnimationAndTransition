package com.theerapat.animationandtransition.supporting;


import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.Toast;

import com.theerapat.animationandtransition.R;
import com.theerapat.animationandtransition.logging.LoggingActivity;
import com.theerapat.animationandtransition.ui.FragmentAnimatorSet;
import com.theerapat.animationandtransition.ui.FragmentHome;
import com.theerapat.animationandtransition.ui.FragmentObjectAnimator;
import com.theerapat.animationandtransition.ui.FragmentScale;
import com.theerapat.animationandtransition.ui.FragmentTransitionSet;

/**
 * Created by theerapat on 3/9/2559.
 */
public abstract class ManagerHome extends LoggingActivity implements
        FragmentScale.OnFragmentScaleListener,
        FragmentObjectAnimator.OnFragmentObjectAnimatorListener,
        FragmentAnimatorSet.OnFragmentAnimatorSetListener{

    public abstract Fragment selectedFragment(MenuItem item);

    public interface NavigationViewFactory {
        public Fragment itemSelected(MenuItem menuItem);
    }

    public class NavigationViewFactoryImpl implements NavigationViewFactory {
        @Override
        public Fragment itemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.page_home:
                    return new FragmentHome();
                case R.id.page_animate_scale:
                    return new FragmentScale();
                case R.id.page_object_animator:
                    return new FragmentObjectAnimator();
                case R.id.page_animator_set:
                    return new FragmentAnimatorSet();
                case R.id.page_transition_set:
                    return new FragmentTransitionSet();
                default:return null;
            }
        }
    }

    @Override
    public void onScaleClicked() {
        Toast.makeText(this, "Scale", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onObjectAnimatorClicked() {
        Toast.makeText(this, "ObjectAnimator", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimatorSetClicked() {
        Toast.makeText(this, "AnimatorSet", Toast.LENGTH_SHORT).show();
    }
}
