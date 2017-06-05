package com.operr.restaurant.activities.splashes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.operr.restaurant.R;
import com.operr.restaurant.activities.map.MapsActivity;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private final String TAG = SplashActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new InitializeSplashAsyncTask().execute();
    }

    @Override
    public void startAPP() {
        Intent toActivty;
        toActivty = new Intent(getApplicationContext(),
                MapsActivity.class);

        startActivity(toActivty);
        finish();
    }


    // / private inner class
    private class InitializeSplashAsyncTask extends AsyncTask<Void, Void, String> {

        public InitializeSplashAsyncTask() {

        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(Void... params) {
            try {

                Thread.sleep((long) (2000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "done";
        }

        protected void onPostExecute(String results) {
            startAPP();
        }

    }
}