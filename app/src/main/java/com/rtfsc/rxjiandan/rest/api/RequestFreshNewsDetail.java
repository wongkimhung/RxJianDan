package com.rtfsc.rxjiandan.rest.api;


import com.rtfsc.rxjiandan.model.FreshNews;
import com.rtfsc.rxjiandan.model.FreshNewsDetail;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kdroid on 16-3-29.
 */
public interface RequestFreshNewsDetail {
//    String URL_FRESH_NEWS_DETAIL = "http://i.jandan.net/?oxwlxojflwblxbsapi=get_post&include=content";
    @GET("/")
    Observable<FreshNewsDetail> get(
            @Query("oxwlxojflwblxbsapi") String api,
            @Query("include") String include,
            @Query("id") String id);
}
