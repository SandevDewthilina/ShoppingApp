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
public class SkirtsFragment extends Fragment {

    private GridView grid_list_view;

    int skirts[] = {R.drawable.skirts_1, R.drawable.skirts_2, R.drawable.skirts_3, R.drawable.skirts_4, R.drawable.skirts_5, R.drawable.skirts_6, R.drawable.skirts_7, R.drawable.skirts_8, R.drawable.skirts_9, R.drawable.skirts_10};
    String prices[] ={"2550/=", "2699/=", "3650/=", "4599/=", "5899/=", "1250/=", "3250/=", "4500/=", "3000/=", "3100/="};

    public SkirtsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skirts, container, false);

        grid_list_view = view.findViewById(R.id.skirts_grid_view);

        SkirtsGridAdapter skirtsGridAdapter = new SkirtsGridAdapter(getContext(), skirts, prices); //////////check used getccontex instead of getApplicationContext
        grid_list_view.setAdapter(skirtsGridAdapter);

        // create onClickListner for the grid
        grid_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent previewIntent = new Intent(getActivity(), ImageViewActivity.class);

                previewIntent.putExtra("image", skirts[position]);
                previewIntent.putExtra("price", prices[position]);

                startActivity(previewIntent);

            }
        });


        return view;

    }

}
