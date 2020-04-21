package com.example.shebeimanage2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.example.shebeimanage2.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button register = findViewById(R.id.button2);
        register.setOnClickListener(
                v ->
                {
                    new Thread(()-> {
                        OkHttpClient okHttpClient = new OkHttpClient();
                        String name = ((EditText) findViewById(R.id.text_userid)).getText().toString();
                        //String pswd = ((EditText)findViewById(R.id.text_userpwd)).getText().toString();
                        FormBody formBody = new FormBody.Builder().add("userAccout", name).build();
                        Request request = new Request.Builder()
                                .url(Constant.ADD)
                                .post(formBody)
                                .build();
                        try (Response response = okHttpClient.newCall(request).execute()) {
                            Looper.prepare();
                            if (Boolean.parseBoolean(Objects.requireNonNull(response.body()).string()))
                            {
                                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
                            }
                            Looper.loop();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
        );
        Button login = findViewById(R.id.button1);
        login.setOnClickListener(
                v ->
                {
                    new Thread(()-> {
                        OkHttpClient okHttpClient = new OkHttpClient();
                        String name = ((EditText) findViewById(R.id.text_userid)).getText().toString();
                        String pwd = ((EditText)findViewById(R.id.text_userpwd)).getText().toString();
                        Request request = new Request.Builder()
                                .url(Constant.GET + "/login?" + "userAccount=" + name + "&" + "userPassword=" + pwd)
//                                .url(Constant.GET + "/userAccount?" + "userAccount=" + name)
                                .build();
                        try (Response response = okHttpClient.newCall(request).execute()) {
                            String info = response.body().string();
                            ArrayList<ResultBean> resultBeans = new ArrayList<>();
                                JSONObject json = JSONObject.parseObject(info);
                                ResultBean resultBean = (ResultBean) JSONObject.toJavaObject(json,ResultBean.class);
                                resultBeans.add(resultBean);

//                            String info = response.body().string();
//                            System.out.println(info);
                            Looper.prepare();
                            if((resultBeans.get(0).getCode())==0)
                            {
                                String message = resultBeans.get(0).getMessage();
                                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(com.example.shebeimanage2.activity.login.this,splsh.class));

                            }
                            else
                            {
                                String message = resultBeans.get(0).getMessage();
                                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

                            }
                            Looper.loop();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
        );
    }
}
