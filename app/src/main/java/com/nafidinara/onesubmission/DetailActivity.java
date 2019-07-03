package com.nafidinara.onesubmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String MOVIE_ITEMS = "movie_items";
    TextView detailName, detailOverview;
    ImageView detailImage, detailImageBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Item item = getIntent().getParcelableExtra(MOVIE_ITEMS);

        detailName = findViewById(R.id.tv_detail_name);
        detailOverview = findViewById(R.id.tv_detail_overview);
        detailImage = findViewById(R.id.detail_image_full);
        detailImageBg = findViewById(R.id.detail_image_bg);

        detailName.setText(item.getName());
        detailOverview.setText(item.getOverview());
        detailImage.setImageResource(item.getImage());
        detailImageBg.setImageResource(item.getImage_bg());
    }
}
