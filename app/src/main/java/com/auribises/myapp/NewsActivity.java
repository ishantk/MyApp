package com.auribises.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> adapter;

    void initViews(){
        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("Zee News"); //0
        adapter.add("ABP News");
        adapter.add("AAJ TAK");
        adapter.add("BBC");
        adapter.add("CNN");
        adapter.add("India Today"); //n-1
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initViews();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String news = adapter.getItem(i);
        Toast.makeText(this,"You Selected "+news,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(NewsActivity.this, WebViewActivity.class);
        startActivity(intent);
    }
}
