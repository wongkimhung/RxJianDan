package com.rtfsc.rxjiandan.rest.api;


import com.rtfsc.rxjiandan.model.Comment4FreshNews;
import com.rtfsc.rxjiandan.model.FreshNewsDetail;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * http://jandan.net/?oxwlxojflwblxbsapi=get_post&include=comments&id=77370
 * Created by kdroid on 16-3-29.
 */
public interface RequestFreshNewsComment {
    @GET("/")
    Observable<Comment4FreshNews> get(
            @Query("oxwlxojflwblxbsapi") String api,
            @Query("include") String include,
            @Query("id") String id);
}
