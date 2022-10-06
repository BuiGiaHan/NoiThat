package org.coolstyles.baitap.data.implement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.coolstyles.baitap.data.DatabaseHelper;
import org.coolstyles.baitap.data.dao.CategoryDao;
import org.coolstyles.baitap.data.model.Category;
import org.coolstyles.baitap.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImplement extends DatabaseHelper implements CategoryDao {

    public CategoryDaoImplement(Context context){
        super(context);
    }

    @Override
    public Category find(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("categories", null, "id = ?", new String[] { String.valueOf(id) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Category category = new Category(cursor.getInt(0), cursor.getString(1));
        return category;

    }

    @Override
    public List<Category> all() {
        List<Category>  categoryList = new ArrayList<>();
        String query = "SELECT * FROM CATEGORIES";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Category category = new Category(cursor.getInt(0), cursor.getString(1));
            categoryList.add(category);
            cursor.moveToNext();
        }
        return categoryList;
    }

    @Override
    public void insert(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", category.name);

        db.insert("categories", null, values);
        db.close();

    }

    @Override
    public void update(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", category.name);

        db.update("categories", values, "id = ?", new String[] { String.valueOf(category.id) });
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("categories", "id = ?", new String[] { String.valueOf(id) });
        db.close();
    }

    @Override
    public List<Category> findByName(String name) {
        List<Category>  categoryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("categories", null, "name = ?", new String[] { name },null, null, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Category category = new Category(cursor.getInt(0), cursor.getString(1));
            categoryList.add(category);
            cursor.moveToNext();
        }
        return categoryList;
    }
}
