package com.javapoint.shoppingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class CollectionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        Toolbar toolbar = findViewById(R.id.collection_toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setTitle("Store");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AllCategoriesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_all_categories);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.toolbar_menu_logout:

                Intent mainIntent = new Intent(CollectionActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
                return true;

            case R.id.toolbar_menu_about:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                return true;

            default :
                return false;
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_dresses:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DressesFragment()).addToBackStack(null).commit();
                break;

            case R.id.nav_jeans:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new JeansFragment()).addToBackStack(null).commit();
                break;

            case R.id.nav_shorts:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ShortsFragment()).commit();
                break;

            case R.id.nav_skirts:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SkirtsFragment()).commit();
                break;

            case R.id.nav_tops:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TopsFragment()).commit();
                break;

            case R.id.nav_trousers:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TrousersFragment()).commit();
                break;

            case R.id.nav_all_categories:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AllCategoriesFragment()).commit();
                break;

            case R.id.nav_favourites:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FavouriteFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }
}
