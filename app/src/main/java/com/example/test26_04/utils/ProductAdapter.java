package com.example.test26_04.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.test26_04.Detail_Product_Activity;

import com.example.test26_04.R;
import com.example.test26_04.models.Product;


import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHoler>{
    private List<Product> mListProduct;
    private Context mContext;

    public ProductAdapter(Context context, List<Product> mListProduct) {

        this.mListProduct = mListProduct;
        this.mContext = context;

    }

    @NonNull
    @Override
    public ProductViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ProductViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHoler holder, int position) {
        final Product product = mListProduct.get(position);

        if (product == null){
            return;
        }

        Glide.with(mContext).load(mListProduct.get(position).getImage()).into(holder.imgProduct);
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText(String.valueOf(product.getPrice()));

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGotoDetail(product);
            }
        });
    }
    private void onClickGotoDetail(Product product){
        Intent intent = new Intent(mContext, Detail_Product_Activity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("Object Product",product);
        intent.putExtras(bundle);
        mContext.startActivity(intent);


    }

    public void release(){
        mContext = null;
    }

    @Override
    public int getItemCount() {
        if(mListProduct != null ) {
            return mListProduct.size();
        }
        return 0;
    }

    public class ProductViewHoler extends RecyclerView.ViewHolder{

        private RelativeLayout layoutItem;
        private ImageView imgProduct;
        private TextView tvName;
        private TextView tvPrice;


        public ProductViewHoler(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);

            imgProduct = itemView.findViewById(R.id.image_product);
            tvName = itemView.findViewById(R.id.tv_nameOP);
            tvPrice = itemView.findViewById(R.id.tv_price);


        }
    }
}
