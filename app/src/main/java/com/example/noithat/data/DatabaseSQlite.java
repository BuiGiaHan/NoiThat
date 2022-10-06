package org.coolstyles.baitap.data;

import android.content.Context;

import org.coolstyles.baitap.data.dao.CategoryDao;
import org.coolstyles.baitap.data.dao.ProductDao;
import org.coolstyles.baitap.data.implement.CategoryDaoImplement;
import org.coolstyles.baitap.data.implement.ProductDaoImplement;

public class DatabaseSQlite extends DatabaseDao{
    private Context context;

    public DatabaseSQlite(Context context){
        this.context = context;
    }

    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImplement(context);
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImplement(context);
    }
}
