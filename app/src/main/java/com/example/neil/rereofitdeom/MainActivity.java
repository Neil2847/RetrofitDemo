package com.example.neil.rereofitdeom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.neil.rereofitdeom.connect.HttpConnect;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // --------------------------------------------------------
    private ListView listView;

    // --------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    // --------------------------------------------------------
    private void init() {

        listView = findView(R.id.list);

        HttpConnect.getInstance().getCline();

    }

    // --------------------------------------------------------
    private <T> T findView(int id) {
        return (T) findViewById(id);
    }

    // --------------------------------------------------------
}
