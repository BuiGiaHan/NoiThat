package com.example.noithat.ui.constract;

import android.content.Context;

import com.example.noithat.data.dao.DatabaseDao;
import com.example.noithat.data.dao.DatabaseSQlite;
import com.example.noithat.data.remote.entity.Category;
import com.example.noithat.data.remote.entity.Product;
import com.example.noithat.data.remote.RetrofitContrller;
import com.example.noithat.data.remote.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentPresenter implements  HomeFragmentConstract.IPresenter{
    private HomeFragmentConstract.IView mView;

    public HomeFragmentPresenter(Context context){
        DatabaseDao.init((new DatabaseSQlite(context)));
    }
    @Override
    public void setView(HomeFragmentConstract.IView view) {
        mView = view;
    }

    @Override
    public void getCategoryList() {
        WebService service = RetrofitContrller.service();
        service.categoryList().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                mView.setCategoryListToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getHotProducts() {
        WebService service = RetrofitContrller.service();
        service.hotProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setHotProductsToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

    @Override
    public void search(String key) {
        WebService service = RetrofitContrller.service();
        service.search(key).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setProductListSearchToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getBedroom() {
        WebService service = RetrofitContrller.service();
        service.bedroomProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setBedroomProductsToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

    @Override
    public void getNewProducts() {
        WebService service = RetrofitContrller.service();
        service.newProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setNewProductsToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }



    @Override
    public void getLRProducts() {
        WebService service = RetrofitContrller.service();
        service.lrProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setLRProductsToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

    @Override
    public void getKitchenProducts() {
        WebService service = RetrofitContrller.service();
        service.kitchenProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setKitchenProductsToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

}
