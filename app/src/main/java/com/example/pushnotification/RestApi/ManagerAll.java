package com.example.pushnotification.RestApi;

import com.example.pushnotification.Result;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getIntance() {
        return ourInstance;
    }


    public Call<Result> ekle(String kullanıcıadi, String sifre, String mailadres) {
        Call<Result> x = getRestApi().addUser(kullanıcıadi,sifre,mailadres);
        return x;
    }

    public Call<Result> aktifEt(String mailAdres, String code) {
        Call<Result>y = getRestApi().aktifEt(mailAdres, code);

        return y;
    }
}
