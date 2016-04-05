package com.rtfsc.rxjiandan.rest.api;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by kdroid on 16-4-5.
 */
public interface RequestCommon{
    @GET("/")
    Observable<Response> get();
}
