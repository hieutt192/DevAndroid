package com.example.test26_04.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.test26_04.R;
import com.example.test26_04.models.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ordViewHolder>{
    private List<Order> listOrd;
    private Context mContext;
    private Class onClickItemDestination;

    public OrderAdapter(Context context, List<Order> listOrd, Class onClickItemDestination) {

        this.listOrd = listOrd;
        this.mContext = context;
        this.onClickItemDestination = onClickItemDestination;

    }

    @NonNull
    @Override
    public ordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ordViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ordViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout layoutItem;
        private TextView txtNameCus;
        private TextView txtMaDonHang;
        private TextView txtTotal;
        private TextView txtQuanlity;
        private TextView txtStatus;


        public ordViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layoutItem);
            txtNameCus = itemView.findViewById(R.id.txtCusName);
            txtMaDonHang = itemView.findViewById(R.id.txtIdOrd);
            txtTotal = itemView.findViewById(R.id.txtTotal);
            txtQuanlity = itemView.findViewById(R.id.txtQuantity);
            txtStatus = itemView.findViewById(R.id.txtStatus);


        }
    }
}
