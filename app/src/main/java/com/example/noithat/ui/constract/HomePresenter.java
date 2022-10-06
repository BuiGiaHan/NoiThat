package org.coolstyles.baitap.ui.constract;

import android.content.Context;

import org.coolstyles.baitap.data.DatabaseDao;
import org.coolstyles.baitap.data.DatabaseSQlite;
import org.coolstyles.baitap.data.model.Product;

import java.util.List;

public class HomePresenter implements HomeConstract.IPresenter{
    private HomeConstract.IView mView;

    public HomePresenter(Context context){
        DatabaseDao.init(new DatabaseSQlite(context));
    }
    @Override
    public void setView(HomeConstract.IView view) {
        mView = view;
    }

    @Override
    public void getProductList() {
        List<Product> productList = DatabaseDao.getInstance().getProductDao().all();
        mView.setProductListToView(productList);
    }

    @Override
    public void getProduct(int productId) {
        Product product = DatabaseDao.getInstance().getProductDao().find(productId);
        mView.showProductDetail(product);
    }
}
