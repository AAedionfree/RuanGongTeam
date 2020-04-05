package com.example.shebeimanage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shebeimanage.MainActivity;
import com.example.shebeimanage.R;
import com.example.shebeimanage.bean.user;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class login extends AppCompatActivity {
    private EditText username,password;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);

        Bmob.initialize(this,"805e0b014f2a55bfe85aa3cc673c6004");
            BmobUser bmobUser = BmobUser.getCurrentUser(BmobUser.class);
            username=findViewById(R.id.username);
            password=findViewById(R.id.password);

            //用户登录
            final user user=new user();
            user.setUsername(username.getText().toString().trim());
            user.setPassword(password.getText().toString().trim());
            user.login(new SaveListener<user>() {
                @Override
                public void done (user o, BmobException e){
                    if (e!=null){
                        Toast.makeText(login.this, "登录成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this, MainActivity.class);
                    }else{
                        Toast.makeText(login.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });

    }
}
