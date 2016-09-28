package com.theerapat.animationandtransition;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;

import com.theerapat.animationandtransition.supporting.ManagerHome;
import com.theerapat.animationandtransition.supporting.MyDrawerLayout;
import com.theerapat.animationandtransition.supporting.ViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityHome extends ManagerHome implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.drawer_layout_home) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
//        FragmentHome fragmentHome = (FragmentHome) getFragmentManager().findFragmentById(R.id.container);
        render(savedInstanceState);
    }

    private void render(Bundle savedInstanceState){
        if (savedInstanceState == null) setDefaultFragment();
        setNavigationView();
    }

    private void setDefaultFragment() {
        ViewFragment.render(getSupportFragmentManager());
    }

    private void setNavigationView(){
        drawerLayout = new MyDrawerLayout(this);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        ViewFragment.render(getSupportFragmentManager(),selectedFragment(item));
        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public Fragment selectedFragment(MenuItem item) {
       return new NavigationViewFactoryImpl().itemSelected(item);
    }

}
