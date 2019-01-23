package com.jonaslopez.itrsa.lisviewapielements.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

   private RequestQueue mRequestQueue;
   private static Context mAppContext;
   private static VolleySingleton mInstance = null;

    public VolleySingleton(RequestQueue mRequestQueue) {
        this.mRequestQueue = mRequestQueue;
    }

    /**
     * Singleton
     *
     * @param appContext Contexto de la Aplicación.
     */
    private VolleySingleton(Context appContext) {
        mAppContext = appContext;
        mRequestQueue = getRequestQueue();
    }


    public static synchronized VolleySingleton getInstance(Context appContext) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(appContext);
        }
        return mInstance;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue( this.mAppContext );

        }
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

}
