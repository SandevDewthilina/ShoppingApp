package com.javapoint.shoppingapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShortsFragment extends Fragment {


    private GridView grid_list_view;

    int shorts[] = {R.drawable.shorts_1, R.drawable.shorts_2, R.drawable.shorts_3, R.drawable.shorts_4, R.drawable.shorts_5, R.drawable.shorts_6, R.drawable.shorts_7, R.drawable.shorts_8, R.drawable.shorts_9, R.drawable.shorts_10};
    String prices[] ={"2550/=", "2699/=", "3650/=", "4599/=", "5899/=", "1250/=", "3250/=", "4500/=", "3000/=", "3100/="};

    public ShortsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_shorts, container, false);

        grid_list_view = view.findViewById(R.id.shorts_grid_view);

        ShortsGridAdapter shortsGridAdapter = new ShortsGridAdapter(getContext(), shorts, prices); //////////check used getccontex instead of getApplicationContext
        grid_list_view.setAdapter(shortsGridAdapter);

        // create onClickListner for the grid
        grid_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent previewIntent = new Intent(getActivity(), ImageViewActivity.class);

                previewIntent.putExtra("image", shorts[position]);
                previewIntent.putExtra("price", prices[position]);

                startActivity(previewIntent);

            }
        });


        return view;
    }

}
