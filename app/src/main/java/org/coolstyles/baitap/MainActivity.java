package org.coolstyles.baitap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.coolstyles.baitap.adapter.StudentAdapter;
import org.coolstyles.baitap.data.DatabaseDao;
import org.coolstyles.baitap.data.DatabaseSQlite;
import org.coolstyles.baitap.data.dao.CategoryDao;
import org.coolstyles.baitap.data.dao.ProductDao;
import org.coolstyles.baitap.data.implement.CategoryDaoImplement;
import org.coolstyles.baitap.data.implement.ProductDaoImplement;
import org.coolstyles.baitap.data.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rc;
    List<String> studentName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGUI();
        initData();
    }

    private void initGUI(){
        rc = findViewById(R.id.rc);
    }

    private void initData(){
        for (int i=0; i < 10; i++){
            studentName.add("Student " + i);
        }

        StudentAdapter adapter = new StudentAdapter((Context) studentName);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));

        DatabaseDao.init(new DatabaseSQlite(this));

        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = new Category(1, "Java");
        categoryDao.insert(category);

        List<Category> categoryList = categoryDao.all();
        for (Category cat : categoryList) {
            Log.i("Category", String.format("id:%d - name:%s", cat.id, cat.name));
        }

        Category find = categoryDao.find(1);
        categoryDao.delete(1);

        category.name = "Java Web";
        categoryDao.update(category);
    }
}
