package com.optimalsystems.AdminChurch.providers;

import com.optimalsystems.AdminChurch.models.FCMBody;
import com.optimalsystems.AdminChurch.models.FCMResponse;
import com.optimalsystems.AdminChurch.retrofit.IFCMApi;
import com.optimalsystems.AdminChurch.retrofit.RetrofitClient;

import retrofit2.Call;

public class NotificationProvider {

    private String url = "https://fcm.googleapis.com";

    public NotificationProvider() {

    }

    public Call<FCMResponse> sendNotification(FCMBody body) {
        return RetrofitClient.getClient(url).create(IFCMApi.class).send(body);
    }

}
