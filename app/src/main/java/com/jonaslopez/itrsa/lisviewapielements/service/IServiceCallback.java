package com.jonaslopez.itrsa.lisviewapielements.service;

import java.util.List;

public interface IServiceCallback {
    void onSuccess(List<Object> object);
    void onFailure(Exception e);
}
