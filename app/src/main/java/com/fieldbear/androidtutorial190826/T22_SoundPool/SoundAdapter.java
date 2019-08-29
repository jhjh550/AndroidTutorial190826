package com.fieldbear.androidtutorial190826.T22_SoundPool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fieldbear.androidtutorial190826.R;

import java.util.List;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundHolder> {
    private List<Sound> mSounds;

    public SoundAdapter(List<Sound> sounds) {
        mSounds = sounds;
    }

    @NonNull
    @Override
    public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sound, parent, false);
        return new SoundHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundHolder holder, int position) {
        Sound sound = mSounds.get(position);
        holder.onBind(sound);
    }

    @Override
    public int getItemCount() {
        return mSounds.size();
    }

    class SoundHolder extends RecyclerView.ViewHolder{
        Button mButton;
        Sound mSound;

        public SoundHolder(@NonNull View itemView) {
            super(itemView);
            mButton = (Button) itemView;
        }

        public void onBind(Sound sound){
            mSound = sound;
            mButton.setText(sound.getName());
        }
    }
}
