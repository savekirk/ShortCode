package com.ispacegh.ice;

/**
 * Created by kenny on 4/16/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {

    private List<ItemObject> itemList;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is a string and an image in this case
        public ImageView image_view;
        public TextView image_name;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            image_view = (ImageView) itemLayoutView.findViewById(R.id.image_view);
            image_name = (TextView) itemLayoutView.findViewById(R.id.image_name);
        }
    }

  /*  //Todo: Create a string dataset
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
*/
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


    public CardViewDataAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }


}
