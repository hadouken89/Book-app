package com.jonaslopez.itrsa.lisviewapielements.service;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jonaslopez.itrsa.lisviewapielements.models.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class VolleyImp {
    protected final static String url = "http://www.etnassoft.com/api/v1/get/";
    private RequestQueue mRequestQueue;
    private Context mContext;
    private IServiceCallback mResponseEvent;
    private Gson sGson = new GsonBuilder().create();

    public VolleyImp(Context context,IServiceCallback _responseEvent){
        this.mContext = context;
        this.mResponseEvent = _responseEvent;
    }

    public void callJsonResponse(){
        mRequestQueue = Volley.newRequestQueue(mContext);

        StringRequest postRequest = new StringRequest(
                getMethod(),
                getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String data) {
                        try {
                            String formatData = formatDataToJson(data);
                          //  mResponseEvent.onSuccess(  parseJsonToObject( formatData ) );
                            mResponseEvent.onSuccess( formatData );
                        } catch (Exception e) {
                            mResponseEvent.onFailure(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mResponseEvent.onFailure( error );
                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() {
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("Content-Type","application/json");
                        return params;
                    }
                };

        mRequestQueue.add(postRequest);
    }

    private String formatDataToJson(String data) {
       return data.substring( 1,data.length() - 2 );
    }

    protected abstract String getUrl();

    protected abstract int getMethod();

    protected abstract List parseJsonToObject(String jsonString);
}
