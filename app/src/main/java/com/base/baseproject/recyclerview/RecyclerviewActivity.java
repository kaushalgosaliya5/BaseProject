
package com.base.baseproject.recyclerview;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.base.baseproject.R;
import com.base.baseproject.base.BaseActivity;
import com.base.baseproject.bean.Recipe;

import java.security.MessageDigest;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class RecyclerviewActivity extends BaseActivity {


    RecyclerView recyclerview;
    DataAdapter dataAdapter;
    List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initializeViewController();
    }

    private void initializeViewController() {
        recipeList = new ArrayList<Recipe>();
        recipeList.add(new Recipe(1, "Kaushal", "Gosaliya"));
        recipeList.add(new Recipe(2, "Kaushal", "Gosaliya"));
        recipeList.add(new Recipe(3, "Kaushal", "Gosaliya"));
        recipeList.add(new Recipe(4, "Kaushal", "Gosaliya"));

        dataAdapter = new DataAdapter(this, recipeList);
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(dataAdapter);
        List<Recipe> list = new ArrayList<Recipe>();
        list.add(new Recipe());
        List<String> list1 = new ArrayList<String>();
        list1.add("");

    }

    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

        Context context;
        List<Recipe> recipeList;

        DataAdapter(Context context, List<Recipe> recipeList) {
            this.context = context;
            this.recipeList = recipeList;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tvId, tvName, tvDescription;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                tvId = (AppCompatTextView) itemView.findViewById(R.id.tvId);
                tvName = (AppCompatTextView) itemView.findViewById(R.id.tvName);
                tvDescription = (AppCompatTextView) itemView.findViewById(R.id.tvDescription);
            }
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.tvId.setText(recipeList.get(position).getId() + "");
            holder.tvName.setText(recipeList.get(position).getName() + "");
            holder.tvDescription.setText(recipeList.get(position).getDescription() + "");
        }

        @Override
        public int getItemCount() {
            return recipeList.size();
        }
    }
}
