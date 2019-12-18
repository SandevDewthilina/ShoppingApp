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
public class TrousersFragment extends Fragment {

    private GridView grid_list_view;

    int trousers[] = {R.drawable.trousers_1, R.drawable.trousers_2, R.drawable.trousers_3, R.drawable.trousers_4, R.drawable.trousers_5, R.drawable.trousers_6, R.drawable.trousers_7, R.drawable.trousers_8, R.drawable.trousers_9, R.drawable.trousers_10};
    String prices[] ={"2550/=", "2699/=", "3650/=", "4599/=", "5899/=", "1250/=", "3250/=", "4500/=", "3000/=", "3100/="};
    boolean likedTrousers[] = {false, false, false, false, false, false, false, false, false, false};

    public TrousersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trousers, container, false);

        grid_list_view = view.findViewById(R.id.trousers_grid_view);

        TrousersGridAdapter trousersGridAdapter = new TrousersGridAdapter(getContext(), trousers, prices, likedTrousers); //////////check used getccontex instead of getApplicationContext
        grid_list_view.setAdapter(trousersGridAdapter);

        // create onClickListner for the grid
        grid_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent previewIntent = new Intent(getActivity(), ImageViewActivity.class);

                previewIntent.putExtra("image", trousers[position]);
                previewIntent.putExtra("price", prices[position]);
                previewIntent.putExtra("liked", likedTrousers[position]);

                startActivity(previewIntent);

            }
        });


        return view;

    }

}
