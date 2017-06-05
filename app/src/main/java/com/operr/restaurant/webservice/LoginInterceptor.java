package com.operr.restaurant.webservice;

import android.util.Log;

import com.operr.restaurant.model.AccessToken;
import com.operr.restaurant.utils.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class LoginInterceptor implements Interceptor {

    private String clientID;
    private String clientSecret;

    public LoginInterceptor(String clientID, String clientSecret) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
    }

    @Override
    public Response intercept(Interceptor.Chain chain)
            throws IOException {

        Request request = chain.request();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        YelpWebService service = retrofit.create(YelpWebService.class);

        Map<String, String> requestParms = new HashMap<>();
        requestParms.put("grant_type", "client_credentials ");
        requestParms.put("client_id", this.clientID);
        requestParms.put("client_secret", this.clientSecret);

        Call<AccessToken> resp = service.getAccessToken(requestParms);
        retrofit2.Response<AccessToken> result = resp.execute();
        Log.i("Access Token response", "" + result.isSuccessful());
        if (result.isSuccessful()) {
            //TODO save the access token to local storage
            request = request.newBuilder()
                    .addHeader("Authorization", "bearer " + result.body().getAccessToken())
                    .build();
        } else {
            Log.e("Access Token response-error", "" + result.errorBody().string());
        }
        Response response = chain.proceed(request);
        return response;

    }
}