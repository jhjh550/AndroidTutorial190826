package com.fieldbear.androidtutorial190826.T21_RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fieldbear.androidtutorial190826.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter
        extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<T21_RecyclerViewActivity.MyRecyclerViewData> list;

    public MyRecyclerViewAdapter(ArrayList<T21_RecyclerViewActivity.MyRecyclerViewData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewWeather;
        TextView textViewCityName;
        TextView textViewWeather;
        TextView textViewTemperature;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewWeather = itemView.findViewById(R.id.imageViewWeather);
            textViewCityName = itemView.findViewById(R.id.textViewCityName);
            textViewWeather = itemView.findViewById(R.id.textViewWeather);
            textViewTemperature = itemView.findViewById(R.id.textViewTemperature);
        }

        public void onBind(T21_RecyclerViewActivity.MyRecyclerViewData data){
            textViewCityName.setText(data.title);
            textViewWeather.setText(data.desc);
            textViewTemperature.setText(data.temp+"'c");
            imageViewWeather.setImageResource(data.img);

        }
    }
}
