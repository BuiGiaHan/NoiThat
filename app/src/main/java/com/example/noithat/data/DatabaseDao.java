package org.coolstyles.baitap.data;

import org.coolstyles.baitap.data.dao.CategoryDao;
import org.coolstyles.baitap.data.dao.ProductDao;

public abstract class DatabaseDao {
    private static DatabaseDao instance;
    public static void init(DatabaseDao inst){
        instance = inst;
    }
    public static DatabaseDao getInstance(){
        return instance;
    }
    public abstract CategoryDao getCategoryDao();
    public abstract ProductDao getProductDao();
}
