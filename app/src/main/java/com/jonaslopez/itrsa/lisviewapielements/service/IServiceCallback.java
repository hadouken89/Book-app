package com.jonaslopez.itrsa.lisviewapielements.service;

public interface IServiceCallback {
    void onSuccess(String response);
    void onFailure(Exception e);
}
