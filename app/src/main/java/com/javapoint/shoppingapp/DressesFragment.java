package com.javapoint.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DressesFragment extends Fragment {

    private GridView grid_list_view;
    private ImageView likeBtn;

    int dresses[] = {R.drawable.dress_1, R.drawable.dress_2, R.drawable.dress_3, R.drawable.dress_4, R.drawable.dress_5, R.drawable.dress_6, R.drawable.dress_7, R.drawable.dress_8, R.drawable.dress_9, R.drawable.dress_10};
    String prices[] ={"2550/=", "2699/=", "3650/=", "4599/=", "5899/=", "1250/=", "3250/=", "4500/=", "3000/=", "3100/="};
    boolean likedDress[] = {false, false, false, false, false, false, false, false, false, false};


    public DressesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dresses, container, false);

        grid_list_view = view.findViewById(R.id.dress_grid_view);
        likeBtn = view.findViewById(R.id.like_btn);


        DressGridAdapter dressGridAdapter = new DressGridAdapter(getContext(), dresses, prices, likedDress);            //check used getContext instead of getApplicationContext
        grid_list_view.setAdapter(dressGridAdapter);

        // create onClickListner for the grid
        grid_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent previewIntent = new Intent(getActivity(), ImageViewActivity.class);

                previewIntent.putExtra("image", dresses[position]);
                previewIntent.putExtra("price", prices[position]);
                previewIntent.putExtra("liked", likedDress[position]);

                startActivity(previewIntent);

            }
        });




        return view;
    }

}
