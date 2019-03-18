package com.fulthonn;

import com.fulthonn.Personne2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public  interface ApiInterface {

    @FormUrlEncoded
    @POST("add_user.php")
    Call<Personne2> add_personne
            (
                    @Field("cni") String cni,
                    @Field("firtname") String firstname,
                    @Field("lastname") String lastname,
                    @Field("email") String email,
                    @Field("role") String role
            );
}
