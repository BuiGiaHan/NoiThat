package com.example.noithat.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noithat.ui.adapter.CategoryAdapter;
import com.example.noithat.ui.adapter.ProductAdapter;
import com.example.noithat.ui.adapter.ProductsNewAdapter;
import com.example.noithat.ui.custom.SearchDialog;
import com.example.nongsan.R;
import com.example.noithat.data.remote.entity.Category;
import com.example.noithat.data.remote.entity.Product;
import com.example.noithat.ui.constract.HomeFragmentConstract;
import com.example.noithat.ui.constract.HomeFragmentPresenter;

import java.util.List;

public class HomeFragment extends Fragment implements HomeFragmentConstract.IView {

    private HomeFragmentConstract.IPresenter mPresenter;
    private RecyclerView rc;
    private RecyclerView rcHotProducts;
    private ViewFlipper v_flipper;
    private SearchView svSearch;
    private RecyclerView rcLRProducts;
    private RecyclerView rcNewProducts;
    private RecyclerView rcbedroomProducts;
    private RecyclerView rckitchenProducts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initGUI(rootView);
        initData();

        return rootView;
    }
    private void initGUI(View rootView){
        rc = rootView.findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rcHotProducts = rootView.findViewById(R.id.rc_hot_products);
        rcbedroomProducts = rootView.findViewById(R.id.rc_bedroom_products);
        rcLRProducts = rootView.findViewById(R.id.rc_living_room_products);
        rckitchenProducts = rootView.findViewById(R.id.rc_kitchen_products);
        rcNewProducts = rootView.findViewById(R.id.rc_new_products);

        int images [] = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3};
        v_flipper = rootView.findViewById(R.id.v_flipper);
        /*svSearch = rootView.findViewById(R.id.sv_search);*/
       /* svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
            *//*    String key = svSearch.getQuery().toString();*//*
                mPresenter.search(key);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });*/

        for (int image: images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView view = new ImageView(getContext());
        view.setBackgroundResource(image);

        v_flipper.addView(view);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }

    private void initData(){
        mPresenter = new HomeFragmentPresenter(getContext());
        mPresenter.setView(this);
        mPresenter.getCategoryList();
        mPresenter.getHotProducts();
        mPresenter.getLRProducts();
        mPresenter.getBedroom();
        mPresenter.getNewProducts();
        mPresenter.getKitchenProducts();
    }

    @Override
    public void setCategoryListToView(List<Category> categoryList) {
        CategoryAdapter adapter = new CategoryAdapter(getContext(), categoryList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void showCategory(Category category) {

    }

    @Override
    public void setHotProductsToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(getContext(), productList);
        rcHotProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcHotProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setProductListSearchToView(List<Product> productList) {
        SearchDialog searchDialog = new SearchDialog(getContext(), productList);
        searchDialog.show();
    }

    @Override
    public void setNewProductsToView(List<Product> productList) {
        ProductsNewAdapter adapter = new ProductsNewAdapter(getContext(), productList);
        rcNewProducts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcNewProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void setLRProductsToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(getContext(), productList);
        rcLRProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcLRProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void setBedroomProductsToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(getContext(), productList);
        rcbedroomProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcbedroomProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setKitchenProductsToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(getContext(), productList);
        rckitchenProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rckitchenProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
