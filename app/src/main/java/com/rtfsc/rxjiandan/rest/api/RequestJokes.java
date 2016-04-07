package com.rtfsc.rxjiandan.rest.api;

import com.rtfsc.rxjiandan.model.Jokes;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kdroid on 16-4-6.
 */
public interface RequestJokes {
    //    http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_duan_comments&page=1
    @GET("/")
    Observable<Jokes> get(
            @Query("oxwlxojflwblxbsapi") String api,
            @Query("page") String page);
}
