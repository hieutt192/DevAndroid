package com.example.test26_04.utils;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test26_04.R;
import com.example.test26_04.models.Item;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.ViewHolder> {

    private ArrayList<Item> localDataSet;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private  TextView  itemNameView;
        private  TextView  itemPriceView;
        private  TextView  itemQuantityView;
        private  ImageView itemImageView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            itemNameView = (TextView) view.findViewById(R.id.itemName);
            itemPriceView = (TextView) view.findViewById(R.id.itemPrice);
            itemQuantityView = (TextView) view.findViewById(R.id.itemQuantity);
            itemImageView = (ImageView) view.findViewById(R.id.profile_pic);
            view.setOnClickListener(this);
        }

        public TextView getItemNameView() {
            return itemNameView;
        }

        public TextView getItemPriceView() {
            return itemPriceView;
        }

        public TextView getItemQuantityView() {
            return itemQuantityView;
        }

        public ImageView getItemImageView(){
            return itemImageView;
        }

        @Override
        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomeAdapter(Context context, ArrayList dataSet) {
        this.mInflater = LayoutInflater.from(context);
        localDataSet = dataSet;
    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_listitem_nhap_xuat, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getItemNameView().setText(localDataSet.get(position).getName());
        viewHolder.getItemPriceView().setText(String.valueOf(localDataSet.get(position).getPrice()));
        viewHolder.getItemQuantityView().setText(String.valueOf(localDataSet.get(position).getQuantity()));
        viewHolder.getItemImageView().setImageResource(R.drawable.img_item);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
