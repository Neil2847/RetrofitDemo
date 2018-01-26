package com.example.neil.rereofitdeom.connect;

import com.example.neil.rereofitdeom.model.Museum;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by neil on 2018/1/23.
 */

public interface APIService {

    @GET("api/Exhibition/ListMulti?types=99,1,11,12,13")
    Observable<Museum> loadMuseumList(@Query("lang") int lang, @Query("museumId") String museumId);
}
