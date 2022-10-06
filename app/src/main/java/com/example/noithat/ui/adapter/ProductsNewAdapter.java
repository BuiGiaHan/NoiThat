package com.example.noithat.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noithat.ProductDetailActivity;
import com.example.nongsan.R;
import com.example.noithat.data.remote.entity.Product;
import com.example.noithat.utils.Constants;
import com.example.noithat.utils.StringHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsNewAdapter extends RecyclerView.Adapter<ProductsNewAdapter.ViewHolder>{

    private List<Product> productList;
    private Context mContext;

    public ProductsNewAdapter(Context context, List<Product> productList){
        mContext = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductsNewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_new, parent, false);

        return new ProductsNewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsNewAdapter.ViewHolder holder, int position) {
        Product product = productList.get(position);
        Picasso.get().load(product.image).fit().into(holder.imgProduct);
        holder.tvProductName.setText(product.name);
        holder.tvPrice.setText(StringHelper.currencyFormat(product.price));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra(Constants.PRODUCT_ID, product.id);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgProduct;
        private TextView tvProductName;
        private TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
