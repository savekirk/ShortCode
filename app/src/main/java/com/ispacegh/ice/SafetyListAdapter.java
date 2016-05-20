package com.ispacegh.ice;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SafetyListAdapter extends RecyclerView.Adapter<SafetyListAdapter.ArticleViewHolder> {

    List<ArticleListItem> articles;

    SafetyListAdapter(List<ArticleListItem> articles) {
        this.articles = articles;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_row_safety, viewGroup, false);
        ArticleViewHolder avh = new ArticleViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder articleViewHolder, int i) {
        articleViewHolder.artTitle.setText(articles.get(i).title);
        articleViewHolder.artSubtitle.setText(articles.get(i).subtitle);
        articleViewHolder.artImage.setImageResource(articles.get(i).imageId);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        TextView artTitle;
        TextView artSubtitle;
        ImageView artImage;

        ArticleViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            itemView.setOnClickListener(this);
            artTitle = (TextView) itemView.findViewById(R.id.art_title);
            artSubtitle = (TextView) itemView.findViewById(R.id.art_subtitle);
            artImage = (ImageView) itemView.findViewById(R.id.art_image);
        }

        @Override
        public void onClick(View view) {

            if (getAdapterPosition() == 0) {
                view.getContext().startActivity(new Intent(view.getContext(), RoadSafetyListActivity.class));
            } else if (getAdapterPosition() == 1) {
                view.getContext().startActivity(new Intent(view.getContext(), HomeSafetyListActivity.class));
            } else if (getAdapterPosition() == 2) {
                view.getContext().startActivity(new Intent(view.getContext(), WorkSafetyListActivity.class));
            } else if (getAdapterPosition() == 3) {
                view.getContext().startActivity(new Intent(view.getContext(), AirSafetyListActivity.class));
            } else {
                return;
            }

        }

    }


}
