package com.rtfsc.rxjiandan.rest.api;


import com.rtfsc.rxjiandan.model.Comment4Pic;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rtfsc on 2016/4/13.
 */
public interface RequestPictures {
    @GET("/")
    Observable<Comment4Pic> get(
            @Query("oxwlxojflwblxbsapi") String api,
            @Query("page") String page);
}
