package com.fieldbear.androidtutorial190826.T12_retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fieldbear.androidtutorial190826.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<MyPost> list;


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        MyPost post = list.get(position);
        holder.onBind(post);
    }

    @Override
    public int getItemCount() {
        if(list == null)
            return 0;
        else{
            return list.size();
        }

    }

    public void setPosts(List<MyPost> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle, textViewBody;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewBody = itemView.findViewById(R.id.textViewBody);
        }

        public void onBind(MyPost post) {
            textViewTitle.setText(post.title);
            textViewBody.setText(post.body);
        }
    }
}
