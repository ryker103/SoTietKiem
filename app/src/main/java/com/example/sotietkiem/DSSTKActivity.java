package com.example.sotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DSSTKActivity extends AppCompatActivity {

    Button bunThemSTK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsstk);

        bunThemSTK = findViewById(R.id.btnThemSoTK);

    }

    public void themstk(View View)
    {
        Intent intent = new Intent(DSSTKActivity.this, ThemSTK.class);
        startActivity(intent);
    }

    public void rutmotphan(View View)
    {
        Intent intent = new Intent(DSSTKActivity.this, RutMotPhan.class);
        startActivity(intent);
    }

    public void guithem(View View)
    {
        Intent intent = new Intent(DSSTKActivity.this, GuiThem.class);
        startActivity(intent);
    }

    public void tachtoan(View View)
    {
        Intent intent = new Intent(DSSTKActivity.this, TachToan.class);
        startActivity(intent);
    }

    public void sua(View View)
    {
        Intent intent = new Intent(DSSTKActivity.this, SuaSTK.class);
        startActivity(intent);
    }
}
