package com.dta.demo13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_username,edt_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        new TestThread().start();
    }

    private void initView() {
        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
                String body = "{\"verifyValue\":\""+password+"\",\"openInvite\":\"\",\"phoneNumber\":\""+username+"\",\"verifyMode\":\"2\",\"openChannel\":\"\"}";

                HashMap<String,String> headers = new HashMap<>();
                headers.put("Content-Type","text/plain; charset=utf-8");
                headers.put("device_system","8.1.0");
                headers.put("device_name","aos");
                headers.put("device_model","Nexus 5X");
                headers.put("device_brand","google");
                headers.put("package_name","com.caratlover");
                headers.put("imei","imei: 353627074774533");
                headers.put("api_version","4600");
                headers.put("client_version","4600");
                headers.put("post_time",""+System.currentTimeMillis()/1000);
                headers.put("app_market","uc");
                headers.put("oaid","");
                headers.put("mac","78:F8:82:A1:9D:1A");
                headers.put("gps","");
                headers.put("gps_city","");
                headers.put("gps_province","");
                headers.put("area","");
                headers.put("township","");
                headers.put("number","");


                OkHttpUtil.post("http://uc.pairui1.com:8668//auth/login", headers, new String(AESUtils.encrypt(body,"f87210e0ed3079d8")), new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        //Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        //Toast.makeText(MainActivity.this,response.body().string(),Toast.LENGTH_LONG).show();
                        Log.i("DTA===>",AESUtils.decrypt(response.body().string(),"f87210e0ed3079d8"));
                    }
                });
                break;
            default:

        }
    }
}