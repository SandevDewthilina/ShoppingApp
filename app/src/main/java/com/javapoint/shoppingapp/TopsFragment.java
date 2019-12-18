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
public class TopsFragment extends Fragment {


    private GridView grid_list_view;

    int tops[] = {R.drawable.tops_1, R.drawable.tops_2, R.drawable.tops_3, R.drawable.tops_4, R.drawable.tops_5, R.drawable.tops_6, R.drawable.tops_7, R.drawable.tops_8, R.drawable.tops_9, R.drawable.tops_10};
    String prices[] ={"2550/=", "2699/=", "3650/=", "4599/=", "5899/=", "1250/=", "3250/=", "4500/=", "3000/=", "3100/="};
    boolean likedTops[] = {false, false, false, false, false, false, false, false, false, false};

    public TopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tops, container, false);

        grid_list_view = view.findViewById(R.id.tops_grid_view);

        TopsGridAdapter topsGridAdapter = new TopsGridAdapter(getContext(), tops, prices, likedTops); //////////check used getccontex instead of getApplicationContext
        grid_list_view.setAdapter(topsGridAdapter);

        // create onClickListner for the grid
        grid_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent previewIntent = new Intent(getActivity(), ImageViewActivity.class);

                previewIntent.putExtra("image", tops[position]);
                previewIntent.putExtra("price", prices[position]);
                previewIntent.putExtra("liked", likedTops[position]);

                startActivity(previewIntent);

            }
        });


        return view;
    }

}
