package com.example.noithat.data.dao;

import android.content.Context;

import com.example.noithat.data.dao.implement.FavouriteDaoImplement;
import com.example.noithat.data.dao.implement.OrderDetailDaoImplement;

public class DatabaseSQlite extends DatabaseDao{
    private Context context;

    public DatabaseSQlite(Context context){
        this.context = context;
    }
    @Override
    public FavouriteDao getProductDao() {
        return new FavouriteDaoImplement(context);
    }

    @Override
    public OrderDetailDao getOrderDetailDao() {
        return new OrderDetailDaoImplement(context);
    }
}
