package com.example.noithat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nongsan.R;
import com.example.noithat.data.dao.DatabaseDao;
import com.example.noithat.data.dao.model.Favourite;
import com.example.noithat.data.remote.entity.Product;
import com.example.noithat.ui.constract.ProductDetailConstract;
import com.example.noithat.ui.constract.ProductDetailPresenter;
import com.example.noithat.utils.Auth;
import com.example.noithat.utils.Constants;
import com.example.noithat.utils.StringHelper;
import com.squareup.picasso.Picasso;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ProductDetailActivity extends BaseActivity implements ProductDetailConstract.IView {
    private ProductDetailConstract.IPresenter mPresenter;

    private ImageView imgProduct;
    private TextView tvName;
    private TextView tvPrice;
    private TextView edQuantity;

    private ImageButton ibBtnBack;
    private ImageButton ibBtnFavourite;

    private ImageButton ibBtnMinus;
    private ImageButton ibBtnPlus;

    private Product mProduct;
    private TextView tvAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        initGUI();
        initData();
    }

    private void initGUI() {
        imgProduct = findViewById(R.id.img_detail);
        tvName = findViewById(R.id.tv_product_name);
        tvPrice = findViewById(R.id.tv_product_price);
        edQuantity = findViewById(R.id.ed_quantity);

        ibBtnBack = findViewById(R.id.ib_btn_back);
        ibBtnBack.setOnClickListener(view -> onBackPressed());

        ibBtnFavourite = findViewById(R.id.ib_btn_favourite);
        ibBtnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Favourite favourite = new Favourite(
                        mProduct.id,
                        mProduct.name,
                        mProduct.price,
                        mProduct.image,
                        mProduct.categoryId
                );
                DatabaseDao.getInstance().getProductDao().insert(favourite);
            }
        });

        tvAddToCart = findViewById(R.id.tv_add_to_cart);
        tvAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isLogged = Auth.getInstance(ProductDetailActivity.this).getAuthentication();
                if(!isLogged){
                    Intent intent = new Intent(ProductDetailActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else{
                    //Order
                    int quantity = Integer.parseInt(edQuantity.getText().toString());
                    mPresenter.order(mProduct, quantity);
                }
            }
        });
        ibBtnMinus = findViewById(R.id.ib_btn_minus);
        ibBtnPlus = findViewById(R.id.ib_btn_plus);

        ibBtnMinus.setOnClickListener(handleClick);
        ibBtnPlus.setOnClickListener(handleClick);
    }

    private void initData() {
        int productId = getIntent().getIntExtra(Constants.PRODUCT_ID, 1);

        mPresenter = new ProductDetailPresenter();
        mPresenter.setView(this);
        mPresenter.getProduct(productId);
    }

    @Override
    public void setProductToView(Product product) {
        mProduct = product;
        Picasso.get().load(product.image).into(imgProduct);
        tvName.setText(product.name);
        tvPrice.setText(StringHelper.currencyFormat(product.price));
    }

    @Override
    public void setOrderSuccess() {
        new SweetAlertDialog(this)
                .setTitleText("Đặt Hàng Thành Công")
                .show();
    }

    private View.OnClickListener handleClick = view -> {
        int quantity = Integer.parseInt(edQuantity.getText().toString());
        switch (view.getId()){
            case R.id.ib_btn_minus:
                if(quantity > 1) quantity--;
                break;
            case R.id.ib_btn_plus:
                quantity++;
                break;
        }
        edQuantity.setText(String.valueOf(quantity));
    };
//    private void noTiFiCaTion() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showDialog("Thêm vào giỏ hàng thành công !");
//            }
//        },1000);
//    }
//
//    private void showDialog(String s) {
//
//    }
}