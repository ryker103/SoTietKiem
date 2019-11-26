package com.example.sotietkiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.regex.Pattern;

public class DangKyActivity extends AppCompatActivity {

   EditText emailA, passA, passConfim;
   Button btnDangky;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //có ít nhất 1 ký tự
                    //"(?=.*[a-z])" +         //ít nhất 1 chữ cái viết thường
                    //"(?=.*[A-Z])" +         //ít nhất 1 chữ cái in hoa
                    "(?=.*[a-zA-Z])" +      //bất kì chữ cái nào
                    "(?=.*[@#$%^&+=])" +    //ít nhát 1 ký tự đặc biệt
                    "(?=\\S+$)" +           //không có khoảng trắng
                    ".{8,}" +               //ít nhất 8 ký tự
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        emailA = findViewById(R.id.emailLayoutDK);
        passA = findViewById(R.id.passLayoutDK);
        passConfim = findViewById(R.id.passConfirmLayoutDK);
        btnDangky = findViewById(R.id.butDangKy);

        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = emailA.getText().toString();
                String pass = passA.getText().toString();
                String conform = passConfim.getText().toString();

                if (pass.compareToIgnoreCase(conform) == 0) {
                    Intent intent = new Intent(DangKyActivity.this, DangNhapActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("pass", pass);
                    setResult(101, intent);
                    finish();
                    /*Intent intent1 = new Intent(DangKyActivity.class, DangNhapActivity.class);*/
                   /* Toast.makeText(DangKyActivity.this, "Registered !!!" + intent.getStringExtra("name") + " " + intent.getStringExtra("pass"), Toast.LENGTH_SHORT).show();*/
                    startActivity(intent);
                }
            }
        });


    }



    public void dangky(View view)
    {
        TaoTaiKhoan();
    }


    private void TaoTaiKhoan() {

        String email = emailA.getText().toString();
        String password = passA.getText().toString();


         if(TextUtils.isEmpty(email))
        {
            emailA.setError("Bạn chưa điền Email.");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailA.setError("Vui lòng nhập đúng định dạng Email.");
        }
        else if(TextUtils.isEmpty(password))
        {
            passA.setError("Bạn chưa điền Mật khẩu.");
        }
        else if(!PASSWORD_PATTERN.matcher(password).matches())
        {
            passA.setError("Mật khẩu ít nhất 8 kí tự bao gồm chữ thường, chữ in hoa và số.");
        }

    }

    //check email
    @SuppressLint("NewApi")
    private boolean validateEmail() {
        String emailInput = emailA.getText().toString().trim();

        if (emailInput.isEmpty()) {
            emailA.setError("Không được để trống");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            emailA.setError("Vui lòng nhập địa chỉ email");
            return false;
        } else {
            emailA.setError(null);
            return true;
        }
    }

    //check pass
    @SuppressLint("NewApi")
    private boolean validatePassword() {
        String passwordInput = passA.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            passA.setError("Không được để trống");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            passA.setError("Mật khảu quá yếu");
            return false;
        } else {
            passA.setError(null);
            return true;
        }
    }

}
