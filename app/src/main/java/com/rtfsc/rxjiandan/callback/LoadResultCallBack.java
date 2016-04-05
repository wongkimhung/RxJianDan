package com.rtfsc.rxjiandan.callback;

/**
 * Created by kdroid on 16-3-30.
 */
public interface LoadResultCallBack {
    int SUCCESS_OK = 1001;
    int SUCCESS_NONE = 1002;
    int ERROR_NET = 1003;

    void onSuccess(int result, Object object);

    void onError(int code, String msg);
}
