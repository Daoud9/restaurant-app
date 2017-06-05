package com.operr.restaurant.webservice;


import com.operr.restaurant.model.AccessToken;
import com.operr.restaurant.model.SearchResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Daoud Shaheen on 6/3/2017.
 */
public interface YelpWebService {

    @GET("v3/businesses/search")
    @Headers({
            "Content-Type: application/json"
    })
    Call<SearchResponse> searchNearBy( @QueryMap Map<String, Object> options );

    @POST("/oauth2/token")
    @Headers({
            "Content-Type: application/json"
    })
    Call<AccessToken> getAccessToken(@QueryMap Map<String, String> options );

}
