package com.ispacegh.ice;

/**
 * Created by kenny on 4/16/16.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {

    private List<ItemObject> itemList;


    public CardViewDataAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CardViewDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_row, null);

        //Todo: set the view's size, margins, paddings and layout parameters
        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.image_view.setImageResource(itemList.get(position).getPhoto());
        viewHolder.image_name.setText(itemList.get(position).getName());

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is a string and an image in this case
        public ImageView image_view;
        public TextView image_name;
        public Context context;


        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            this.image_view = (ImageView) itemLayoutView.findViewById(R.id.image_view);
            this.image_name = (TextView) itemLayoutView.findViewById(R.id.image_name);

            // Attach a click listener to the entire row view
            itemLayoutView.setOnClickListener(this);
            itemLayoutView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(v.getContext(), "OnLongClick Coming soon! :" + getAdapterPosition(),
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });


        }


        // Handles the row being being clicked
        @Override

        public void onClick(View view) {

            if (getAdapterPosition() == 0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:192"));
                view.getContext().startActivity(callIntent);
            } else if (getAdapterPosition() == 1) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:193"));
                view.getContext().startActivity(callIntent);
            } else if (getAdapterPosition() == 2) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:191"));
                view.getContext().startActivity(callIntent);
            } else if (getAdapterPosition() == 3) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:18555"));
                view.getContext().startActivity(callIntent);
            } else if (getAdapterPosition() == 4) {
                view.getContext().startActivity(new Intent(view.getContext(), SafetyActivity.class));
            } else if (getAdapterPosition() == 5) {
                view.getContext().startActivity(new Intent(view.getContext(), FirstAidActivity.class));
            } else {
                return;
            }
        }

    }


}


