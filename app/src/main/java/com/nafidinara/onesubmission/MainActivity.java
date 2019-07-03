package com.nafidinara.onesubmission;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    private String [] dataName;
    private String [] dataRelease;
    private String [] dataOverview;
    private TypedArray dataPhoto;
    private TypedArray dataPhotoBg;
    private Adapter adapter;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv);
        adapter = new Adapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        prepare();
        addItem();
    }

    private void addItem() {
        items = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Item item = new Item();
            item.setOverview(dataOverview[i]);
            item.setName(dataName[i]);
            item.setRelease(dataRelease[i]);
            item.setImage(dataPhoto.getResourceId(i,-1));
            item.setImage_bg(dataPhotoBg.getResourceId(i,-1));
            items.add(item);
        }
        adapter.setItems(items);
    }

    private void prepare() {
        dataOverview= getResources().getStringArray(R.array.movie_overview);
        dataName = getResources().getStringArray(R.array.movie_name);
        dataRelease = getResources().getStringArray(R.array.movie_release);
        dataPhoto = getResources().obtainTypedArray(R.array.movie_poster);
        dataPhotoBg = getResources().obtainTypedArray(R.array.movie_poster_bg);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.MOVIE_ITEMS, items.get(position));
        startActivity(intent);
    }
}

