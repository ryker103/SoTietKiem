package com.example.sotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DSSTKActivity extends AppCompatActivity {

    Button btnThemSTK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsstk);

        btnThemSTK = findViewById(R.id.btnThemSTK);

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
}
