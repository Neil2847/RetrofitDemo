package com.example.neil.rereofitdeom.connect;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.example.neil.rereofitdeom.model.Museum;
import com.example.neil.rereofitdeom.util.MyApplication;
import com.example.neil.rereofitdeom.util.MyObserver;
import com.example.neil.rereofitdeom.util.ObserverOnNextListener;

import io.reactivex.Observable;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by neil on 2018/1/23.
 */

public class HttpConnect {

    // --------------------------------------------------------
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;

    private static final int _READ_TIME_OUT = 5;
    private static final int _CONNECT_TIME_OUT = 5;

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

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // set cache path
//        File cacheFile = new File(MyApplication.getContext().getCacheDir(), "cache");
//        // set cache 100 MB
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
        // add header message.
//        Interceptor headerInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request build = chain.request().newBuilder()
//                        .addHeader("Content-Type", "application/json")
//                        .build();
//                return chain.proceed(build);
//            }
//        };

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(_CONNECT_TIME_OUT, TimeUnit.MINUTES)
                .readTimeout(_READ_TIME_OUT, TimeUnit.MINUTES)
//                .addInterceptor(mRewriteCacheControlInterceptor)
//                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
//                .addInterceptor(headerInterceptor)
                .addInterceptor(logInterceptor)
//                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Config.WEB)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(APIService.class);
    }

    // --------------------------------------------------------
    /**
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
//    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            String cacheControl = request.cacheControl().toString();
//            if (!NetWorkUtils.isNetConnected(MyApplication.getContext())) {
//                request = request.newBuilder()
//                        .cacheControl(TextUtils.isEmpty(cacheControl) ? CacheControl
//                                .FORCE_NETWORK : CacheControl.FORCE_CACHE)
//                        .build();
//            }
//            Response originalResponse = chain.proceed(request);
//            if (NetWorkUtils.isNetConnected(MyApplication.getContext())) {
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", cacheControl)
//                        .removeHeader("Pragma")
//                        .build();
//            } else {
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" +
//                                CACHE_STALE_SEC)
//                        .removeHeader("Pragma")
//                        .build();
//            }
//        }
//    };

    // --------------------------------------------------------
    public void getMuseumList(Context context, ObserverOnNextListener<Museum> listener) {
        addObserver(service.loadMuseumList(1, Config.NMTH), new MyObserver<Museum>(context, listener));
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
