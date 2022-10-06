package org.coolstyles.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int id = getIntent().getIntExtra("id", 1);
        TextView tvId = findViewById(R.id.tv_id);
        tvId.setText(id + "");
    }
}