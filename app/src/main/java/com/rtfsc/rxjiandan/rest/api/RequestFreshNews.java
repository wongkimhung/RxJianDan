package com.rtfsc.rxjiandan.rest.api;


import com.rtfsc.rxjiandan.model.FreshNews;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kdroid on 16-3-29.
 */
public interface RequestFreshNews {
    //    ?oxwlxojflwblxbsapi={api}&include={include}&custom_fields={fields}&dev={dev}&page={page}
    @GET("/")
    Observable<FreshNews> get(
            @Query("oxwlxojflwblxbsapi") String api,
            @Query("include") String include,
            @Query("custom_fields") String fields,
            @Query("dev") String dev,
            @Query("page") String page);
}
