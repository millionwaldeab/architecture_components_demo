package com.asmarasoftwaresolutions.core;

import com.sun.net.httpserver.Authenticator;


public interface SuccessOrFailure<T>{
    void onSuccess(T someType);
    void onFailure(Authenticator.Failure failure);
}
