package com.example.sotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDangky, btnDangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangky = findViewById(R.id.button);
        btnDangnhap = findViewById(R.id.button2);
    }

    public void dangky(View View)
    {
        Intent intent = new Intent(MainActivity.this, DangKyActivity.class);
        startActivity(intent);
    }
    public void dangnhap(View View)
    {
        Intent intent = new Intent(MainActivity.this, DangNhapActivity.class);
        startActivity(intent);
    }

}
