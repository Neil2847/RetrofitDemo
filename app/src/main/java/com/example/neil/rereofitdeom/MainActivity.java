package com.example.neil.rereofitdeom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.neil.rereofitdeom.connect.APIService;
import com.example.neil.rereofitdeom.connect.Config;
import com.example.neil.rereofitdeom.connect.HttpConnect;
import com.example.neil.rereofitdeom.model.Museum;
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

        HttpConnect.getInstance().getMuseumList(new Observer<Museum>() {

            Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                Logger.d("Disposable");
                this.d = d;
            }

            @Override
            public void onNext(Museum value) {
                Logger.d("onNext");

                adapter = new MuseumAdapter(value.getData());
                Logger.d(value.getData().size());
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("onError");
                d.dispose();
            }

            @Override
            public void onComplete() {
                Logger.d("onComplete");
                d.dispose();
            }
        });

    }

    // --------------------------------------------------------
    private <T> T findView(int id) {
        return (T) findViewById(id);
    }

    // --------------------------------------------------------
}
