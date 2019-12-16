package com.javapoint.shoppingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Category> categoryArrayList;

    public CategoriesAdapter(ArrayList<Category> categoryArrayList) {

        this.categoryArrayList = categoryArrayList;

    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_list_item, viewGroup, false);
        context = viewGroup.getContext();
        return new CategoriesAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final CategoriesAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.category_name.setText(categoryArrayList.get(i).getName());

        Glide.with(context).load(categoryArrayList.get(i).getImageResource()).into(viewHolder.category_image);

        viewHolder.category_name.setOnClickListener(new View.OnClickListener() {    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            @Override
            public void onClick(View v) {

                String categoryId = categoryArrayList.get(i).getId();

                if (categoryId.equals("cat_dresses")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new DressesFragment()).commit();
                }

                if (categoryId.equals("cat_tops")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new TopsFragment()).commit();
                }

                if (categoryId.equals("cat_jeans")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new JeansFragment()).commit();
                }

                if (categoryId.equals("cat_skirts")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new SkirtsFragment()).commit();
                }

                if (categoryId.equals("cat_trousers")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new TrousersFragment()).commit();
                }

                if (categoryId.equals("cat_shorts")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new ShortsFragment()).commit();
                }

            }
        });

        viewHolder.category_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String categoryId = categoryArrayList.get(i).getId();

                if (categoryId.equals("cat_dresses")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new DressesFragment()).commit();
                }

                if (categoryId.equals("cat_tops")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new TopsFragment()).commit();
                }

                if (categoryId.equals("cat_jeans")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new JeansFragment()).commit();
                }

                if (categoryId.equals("cat_skirts")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new SkirtsFragment()).commit();
                }

                if (categoryId.equals("cat_trousers")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new TrousersFragment()).commit();
                }

                if (categoryId.equals("cat_shorts")) {

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container, new ShortsFragment()).commit();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView category_name;
        CircleImageView category_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.category_name);
            category_image = itemView.findViewById(R.id.category_image);

        }
    }
}
