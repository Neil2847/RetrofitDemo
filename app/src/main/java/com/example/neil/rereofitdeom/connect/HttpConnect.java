package com.example.neil.rereofitdeom.connect;

import com.example.neil.rereofitdeom.model.Museum;
import com.example.neil.rereofitdeom.util.MyObserver;
import com.example.neil.rereofitdeom.util.ObserverOnNextListener;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by neil on 2018/1/23.
 */

public class HttpConnect {

    // --------------------------------------------------------
    private final int _TIME_OUT = 10;

    private Retrofit retrofit;
    private APIService service;

    // --------------------------------------------------------
    public static HttpConnect getInstance() {
        return singleInstance.instance;
    }

    // --------------------------------------------------------
    private static class singleInstance {
        public static final HttpConnect instance = new HttpConnect();
    }

    // --------------------------------------------------------
    private HttpConnect() {
        init();
    }

    // --------------------------------------------------------
    private void init() {

        OkHttpClient client = new OkHttpClient.Builder().build();
        client.newBuilder().connectTimeout(_TIME_OUT, TimeUnit.MINUTES);

        retrofit = new Retrofit.Builder()
                .baseUrl(Config.WEB)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(APIService.class);
    }

    // --------------------------------------------------------
    public void getMuseumList(ObserverOnNextListener<Museum> listener) {
        addObserver(service.loadMuseumList(1, Config.NMTH), new MyObserver<Museum>(listener));
    }

    // --------------------------------------------------------
    private <T> void addObserver(Observable<T> data, Observer<T> observer) {

        data.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    // --------------------------------------------------------
}
