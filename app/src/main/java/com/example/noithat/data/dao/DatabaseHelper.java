package com.example.noithat.data.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.noithat.data.dao.model.Favourite;
import com.example.noithat.data.dao.model.OrderDetail;
import com.example.noithat.utils.Constants;

public class DatabaseHelper extends SQLiteOpenHelper {
    protected Context context;
    protected SQLiteDatabase db;

    public DatabaseHelper(Context context){
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Favourite.SQL_CREATE_ENTRIES);
        db.execSQL(OrderDetail.SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(Favourite.SQL_DELETE_ENTRIES);
        db.execSQL(OrderDetail.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}