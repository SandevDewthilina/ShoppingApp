package com.javapoint.shoppingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllCategoriesFragment extends Fragment {

    private RecyclerView categories_list_view;
    private ArrayList<Category> categoriesArrayList;
    private  CategoriesAdapter categoriesAdapter;
    private Toolbar toolbar;



    public AllCategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_categories, container, false);

        categoriesArrayList = new ArrayList<>();

        categories_list_view = view.findViewById(R.id.categories_list_view);
        //toolbar = view.findViewById(R.id.all_category_toolbar);
        //toolbar.setTitle("All categories");


        Category cat1 = new Category();
        cat1.setId("cat_dresses");
        cat1.setName("Dresses");
        cat1.setImageResource(R.drawable.cat_dress);

        Category cat2 = new Category();
        cat2.setId("cat_tops");
        cat2.setName("Tops");
        cat2.setImageResource(R.drawable.cat_tops);

        Category cat3 = new Category();
        cat3.setId("cat_jeans");
        cat3.setName("Jeans");
        cat3.setImageResource(R.drawable.cat_jeans);

        Category cat4 = new Category();
        cat4.setId("cat_skirts");
        cat4.setName("Skirts");
        cat4.setImageResource(R.drawable.cat_skirts);

        Category cat5 = new Category();
        cat5.setId("cat_trousers");
        cat5.setName("Trousers");
        cat5.setImageResource(R.drawable.cat_trousers);

        Category cat6 = new Category();
        cat6.setId("cat_shorts");
        cat6.setName("Shorts");
        cat6.setImageResource(R.drawable.cat_shorts);

        categoriesArrayList.add(cat1);
        categoriesArrayList.add(cat2);
        categoriesArrayList.add(cat3);
        categoriesArrayList.add(cat4);
        categoriesArrayList.add(cat5);
        categoriesArrayList.add(cat6);

        categoriesAdapter = new CategoriesAdapter(categoriesArrayList);
        categories_list_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        categories_list_view.setAdapter(categoriesAdapter);



        return view;
    }

}
