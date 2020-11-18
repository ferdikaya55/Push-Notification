package com.example.pushnotification;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pushnotification.RestApi.ManagerAll;
import com.onesignal.OneSignal;

public class MainActivity extends AppCompatActivity {
    Button kayitOlBtn;
    EditText kadiEditText,sifreEditText,mailEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pushNotificationCode();
        initComponents();

    }
    public void initComponents(){
        kadiEditText = findViewById(R.id.kullaniciAdiEditText);
        sifreEditText = findViewById(R.id.sifreEditText);
        mailEditText = findViewById(R.id.mailEditText);
        kayitOlBtn = findViewById(R.id.kayitOlButon);
        kayitOlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kadi,ksifre,kmail;
                kadi = kadiEditText.getText().toString();
                ksifre = sifreEditText.getText().toString();
                kmail = mailEditText.getText().toString();
                register(kadi,ksifre,kmail);
            }
        });
    }
    public void register(String ad,String sifre,final String mail){
        Call<Result> request = ManagerAll.getIntance().ekle(ad,sifre,mail);
        request.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("mail",mail);
        startActivity(intent);
    }
    public void pushNotificationCode(){
        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}