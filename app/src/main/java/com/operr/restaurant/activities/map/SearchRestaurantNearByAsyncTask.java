package com.operr.restaurant.activities.map;

import android.os.AsyncTask;
import android.util.Log;

import com.operr.restaurant.model.SearchResponse;
import com.operr.restaurant.utils.Constants;
import com.operr.restaurant.webservice.LoginInterceptor;
import com.operr.restaurant.webservice.YelpWebService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchRestaurantNearByAsyncTask extends AsyncTask<String, Void, SearchResponse> {
    private MapView mapView;
    private double latitude;
    private double longitude;

    public SearchRestaurantNearByAsyncTask(double latitude, double longitude, MapView mapView) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.mapView = mapView;
    }

    public SearchRestaurantNearByAsyncTask() {
    }

    @Override
    protected void onPostExecute(SearchResponse result) {
        super.onPostExecute(result);
        mapView.dismissProgressDialog();
        if (result != null)
            mapView.setRestaurantsOnMap(result.getBusinesses());
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mapView.showProgressDialog();
    }

    @Override
    protected SearchResponse doInBackground(String... params) {
        try {
            // create client
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new LoginInterceptor(Constants.YELP_CLIENT_ID,
                    Constants.YELP_CLIENT_SECRET)).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            YelpWebService service = retrofit.create(YelpWebService.class);

            Map<String, Object> requestParms = new HashMap<>();
            requestParms.put("term", "restaurants");
            requestParms.put("latitude", latitude);
            requestParms.put("longitude", longitude);
            requestParms.put("radius", 400);

            Call<SearchResponse> resp = service.searchNearBy(requestParms);
            Response<SearchResponse> response = resp.execute();
            Log.i("response", "" + response.isSuccessful());
            if (response.isSuccessful()) {
                return response.body();
            } else {
                Log.e("response-error", "" + response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}