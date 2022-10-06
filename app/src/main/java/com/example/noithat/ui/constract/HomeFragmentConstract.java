package com.example.noithat.ui.constract;

import com.example.noithat.data.remote.entity.Category;
import com.example.noithat.data.remote.entity.Product;

import java.util.List;

public interface HomeFragmentConstract {
    interface IView{
        void setCategoryListToView(List<Category> categoryList);
        void showCategory(Category category);
        void setHotProductsToView(List<Product> productList);
        void setProductListSearchToView(List<Product> productList);
        void setNewProductsToView(List<Product> productList);
        void setLRProductsToView(List<Product> productList);
        void setBedroomProductsToView(List<Product> productList);
        void setKitchenProductsToView(List<Product> productList);
    }

    interface IPresenter{
        void setView(IView view);
        void getCategoryList();
        void getHotProducts();
        void search(String key);
        void getBedroom();
        void getNewProducts();
        /*void getViewProducts();*/
        void getLRProducts();
        void getKitchenProducts();
    }
}
