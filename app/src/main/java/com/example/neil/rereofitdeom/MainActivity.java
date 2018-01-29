package com.example.neil.rereofitdeom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.neil.rereofitdeom.connect.APIService;
import com.example.neil.rereofitdeom.connect.Config;
import com.example.neil.rereofitdeom.connect.HttpConnect;
import com.example.neil.rereofitdeom.model.Museum;
import com.example.neil.rereofitdeom.util.MyObserver;
import com.example.neil.rereofitdeom.util.ObserverOnNextListener;
import com.orhanobut.logger.Logger;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // --------------------------------------------------------
    private ListView listView;
    private MuseumAdapter adapter;

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

        HttpConnect.getInstance().getMuseumList(this, new ObserverOnNextListener<Museum>() {
            @Override
            public void onNext(Museum museum) {
                adapter = new MuseumAdapter(museum.getData());
                listView.setAdapter(adapter);
            }
        });

    }

    // --------------------------------------------------------
    private <T> T findView(int id) {
        return (T) findViewById(id);
    }

    // --------------------------------------------------------
}
