package com.optimalsystems.AdminChurch.retrofit;

import com.optimalsystems.AdminChurch.models.FCMBody;
import com.optimalsystems.AdminChurch.models.FCMResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMApi {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAACQiNi8w:APA91bG24Mx2TbTg9lUAAT5QdtL-PXuFun5ACKwfD1DxjD_7iqb8-kRuFcPlCIwcDDxBZEib49u3HRuxxl7BvfVLGi3MsEgfhr8dJxbnCapx02szc3IhvuB8D5UBa9tY4m7Iaqo3gg2x"
    })
    @POST("fcm/send")
    Call<FCMResponse> send(@Body FCMBody body);
}
