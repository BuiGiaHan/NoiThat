package com.example.noithat;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.noithat.data.dao.DatabaseDao;
import com.example.noithat.data.dao.DatabaseSQlite;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseDao.init(new DatabaseSQlite(this));
    }
}
