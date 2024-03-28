package com.donhat.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {
    private final List<Sport> _sports;

    public SportAdapter(List<Sport> sports) {
        _sports = sports;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sport_item_layout, parent, false);
        return new SportViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        Sport sport = _sports.get(position);

        holder.sportImageView.setImageResource(sport.getImage());
        holder.sportNameTextView.setText(sport.getName());

        holder.itemView.setOnClickListener(v1 ->
                Toast.makeText(v1.getContext(), sport.getName(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return _sports.size();
    }

    public static class SportViewHolder extends RecyclerView.ViewHolder {
        ImageView sportImageView;
        TextView sportNameTextView;

        public SportViewHolder(@NonNull View itemView) {
            super(itemView);

            sportImageView = itemView.findViewById(R.id.sport_image_view);
            sportNameTextView = itemView.findViewById(R.id.sport_name_text_view);
        }
    }
}
