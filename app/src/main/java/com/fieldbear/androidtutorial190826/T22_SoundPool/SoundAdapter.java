package com.fieldbear.androidtutorial190826.T22_SoundPool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fieldbear.androidtutorial190826.R;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundHolder> {

    @NonNull
    @Override
    public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sound, parent, false);
        return new SoundHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SoundHolder extends RecyclerView.ViewHolder{
        Button mButton;

        public SoundHolder(@NonNull View itemView) {
            super(itemView);
            mButton = (Button) itemView;
        }
    }
}
