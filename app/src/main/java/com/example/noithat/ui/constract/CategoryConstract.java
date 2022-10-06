package com.example.noithat.ui.constract;

import com.example.noithat.data.remote.entity.Category;
import com.example.noithat.data.remote.entity.Product;

import java.util.List;

public interface CategoryConstract {
    interface IView{
        void setProductListToView(List<Product> productList);
        void setCategoryToView(Category category);
    }

    interface IPresenter{
        void setView(IView view);
        void getProductListByCategory(int categoryId);
        void getCategory(int categoryId);
    }
}
