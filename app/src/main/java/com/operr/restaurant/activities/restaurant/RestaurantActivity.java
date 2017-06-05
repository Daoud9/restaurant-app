package com.operr.restaurant.activities.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.operr.restaurant.R;
import com.operr.restaurant.model.Business;
import com.squareup.picasso.Picasso;

public class RestaurantActivity extends AppCompatActivity implements RestaurantView {

    private ImageView mRestaurantImageView;
    private TextView mRestaurantNameView;
    private ListView mCategoriesView;
    private TextView mPhoneNumberView;
    private TextView mReviewCountView;
    private TextView mAddressView;
    private RatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Business restaurant = (Business) getIntent().getSerializableExtra("restaurant");
        init(restaurant);
    }

    @Override
    public void init(Business resturant) {

        //load restaurant image
        mRestaurantImageView = (ImageView) findViewById(R.id.restaurantImage);
        Picasso.with(this).load(resturant.getImageUrl()).into(mRestaurantImageView);

        //initiaze restaurant name view
        mRestaurantNameView = (TextView) findViewById(R.id.restaurantName);
        mRestaurantNameView.setText(resturant.getName());

        //initiaze restaurant rating view
        mPhoneNumberView = (TextView) findViewById(R.id.phoneView);
        mPhoneNumberView.setText(mPhoneNumberView.getText() + String.valueOf(resturant.getPhone()));

        //initiaze restaurant rating view
        mReviewCountView = (TextView) findViewById(R.id.reviewsView);
        mReviewCountView.setText(mReviewCountView.getText() + String.valueOf(resturant.getReviewCount()));

        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        mRatingBar.setNumStars(5);
        mRatingBar.setRating((float)resturant.getRating());
        mRatingBar.setStepSize(1);

        mCategoriesView = (ListView) findViewById(R.id.cateoryListView);
        CategoryListAdapter adapter = new CategoryListAdapter(this, resturant.getCategories());
        mCategoriesView.setAdapter(adapter);

        //initiaze restaurant address view
        mAddressView = (TextView) findViewById(R.id.addressTextView);
        mAddressView.setText(resturant.getLocation().toString());

    }
}
