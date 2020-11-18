package com.example.pushnotification;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pushnotification.RestApi.ManagerAll;

public class MainActivity2 extends AppCompatActivity {
    Button aktifEtButton;
    EditText mailEditText, kodEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    public void init() {
        mailEditText = findViewById(R.id.mailEditText2);
        mailEditText.setText(getMail());
        kodEditText = findViewById(R.id.kodEditText);
        aktifEtButton = findViewById(R.id.aktifEtButton);
        aktifEtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail,kod;
                mail = mailEditText.getText().toString();
                kod = kodEditText.getText().toString();
                request(mail,kod);
            }
        });
    }

    public String getMail() {
        String mail;
        Bundle bundle = getIntent().getExtras();
        mail = bundle.getString("mail");
        return mail;
    }

    public void request(String mail,String kod){
        Call req = ManagerAll.getIntance().aktifEt(mail,kod);
        req.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}