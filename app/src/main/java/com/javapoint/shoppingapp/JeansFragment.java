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
public class JeansFragment extends Fragment {

    private GridView grid_list_view;

    int jeans[] = {R.drawable.jeans_1, R.drawable.jeans_2, R.drawable.jeans_3, R.drawable.jeans_4, R.drawable.jeans_5, R.drawable.jeans_6, R.drawable.jeans_7, R.drawable.jeans_8, R.drawable.jeans_9, R.drawable.jeans_10};
    String prices[] ={"2550/=", "2699/=", "3650/=", "4599/=", "5899/=", "1250/=", "3250/=", "4500/=", "3000/=", "3100/="};

    public JeansFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jeans, container, false);

        grid_list_view = view.findViewById(R.id.jeans_grid_view);

        JeansGridAdapter jeansGridAdapter = new JeansGridAdapter(getContext(), jeans, prices); //////////check used getccontex instead of getApplicationContext
        grid_list_view.setAdapter(jeansGridAdapter);

        // create onClickListner for the grid
        grid_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent previewIntent = new Intent(getActivity(), ImageViewActivity.class);

                previewIntent.putExtra("image", jeans[position]);
                previewIntent.putExtra("price", prices[position]);

                startActivity(previewIntent);

            }
        });


        return view;

    }

}
