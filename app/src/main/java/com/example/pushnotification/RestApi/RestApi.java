package com.example.pushnotification.RestApi;

import com.example.pushnotification.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/kayitol.php")
    Call<Result> addUser(@Field("kadi") String kullaniciadi, @Field("sifre") String sifre, @Field("mail") String mailadres);

    @FormUrlEncoded
    @POST("/kayitolaktif.php")
    Call<Result> aktifEt(@Field("mail") String mail, @Field("kod") String code);
}
