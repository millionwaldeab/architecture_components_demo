package com.asmarasoftwaresolutions.core;

public interface SuccessOrException<T> {
    void onSuccess(T type);
    void onExceptionThrown(Exception exc);
}
