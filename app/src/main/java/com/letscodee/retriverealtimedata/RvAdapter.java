package com.letscodee.retriverealtimedata;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class RvAdapter extends ListAdapter<String,RvAdapter.rvViewHolder> {
    Activity callerActivity;

    public RvAdapter(Activity activity) {

        super(new DiffUtil.ItemCallback<String>() {
            @Override
            public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                return oldItem.equals(newItem);
            }
        });
        callerActivity=activity;
    }


    @NonNull
    @NotNull
    @Override
    public rvViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return (new rvViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull rvViewHolder holder, int position) {
        String item = getItem(position);
        holder.mTextView.setText(item);
    }

    public class rvViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public rvViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.rv_text);
        }
    }
}
