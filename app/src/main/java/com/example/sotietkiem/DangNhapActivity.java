package com.example.sotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


public class DangNhapActivity extends AppCompatActivity {

    EditText emailAc, passAc;
    Button btnDangNhap;
    String username, password;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        emailAc = (EditText) findViewById(R.id.emailLayoutDN);
        passAc = (EditText) findViewById(R.id.passLayoutDN);

        username =getIntent().getStringExtra("name");
        password =getIntent().getStringExtra("pass");

        btnDangNhap = (Button)findViewById(R.id.butDangNhap);

        btnDangNhap.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View view)
            {
                if(emailAc.getText().toString().equals(username) && passAc.getText().toString().equals(password))
                {

                    Intent intent = new Intent(DangNhapActivity.this, DSSTKActivity.class);
                    startActivity(intent);
                    Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công !!!" + username + password, Toast.LENGTH_SHORT).show();
                }
                if(emailAc.getText().toString().equals("minh") && passAc.getText().toString().equals("minh"))
                {

                    Intent intent = new Intent(DangNhapActivity.this, DSSTKActivity.class);
                    startActivity(intent);
                    Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công !!!" + username + password, Toast.LENGTH_SHORT).show();
                }
                if(emailAc.getText().toString().equals("minh98@gmail.com") && passAc.getText().toString().equals("Quangminh98@"))
                {

                    Intent intent = new Intent(DangNhapActivity.this, DSSTKActivity.class);
                    startActivity(intent);
                    Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công !!!" + username + password, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(DangNhapActivity.this, "Đăng nhập thất bại !!!" + username + password, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==101)
        {
            /*edt1.setText(data.getStringExtra("name"));
            edt2.setText(data.getStringExtra("pass"));*/
            username = data.getStringExtra("name");
            password = data.getStringExtra("pass");
            /*Toast.makeText(DangNhapActivity.this, "test" + username+ " " + password, Toast.LENGTH_SHORT).show();*/
        }
    }

    //check email
    @SuppressLint("NewApi")
    private boolean validateEmail() {
        String emailInput = emailAc.getText().toString().trim();

        if (emailInput.isEmpty()) {
            emailAc.setError("Không được để trống");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            emailAc.setError("Vui lòng nhập địa chỉ email");
            return false;
        } else {
            emailAc.setError(null);
            return true;
        }
    }

    //check pass
    @SuppressLint("NewApi")
    private boolean validatePassword() {
        String passwordInput = passAc.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            passAc.setError("Không được để trống");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            passAc.setError("Mật khảu quá yếu");
            return false;
        } else {
            passAc.setError(null);
            return true;
        }
    }



}