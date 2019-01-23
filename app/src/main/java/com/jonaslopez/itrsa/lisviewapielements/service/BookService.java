package com.jonaslopez.itrsa.lisviewapielements.service;

import android.content.Context;

import com.android.volley.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jonaslopez.itrsa.lisviewapielements.models.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookService extends VolleyImp implements IBookParams {

    private String mRequestParamKey;
    private String mRequestParamValue;

    public BookService(Context context, String paramKey, String paramValue,IServiceCallback _responseEvent) {
       super(context,_responseEvent);
        this.mRequestParamKey = paramKey;
        this.mRequestParamValue = paramValue;
    }

    public void callApiData(){
        callJsonResponse();
    }

    @Override
    protected String getUrl() {
        return url + mRequestParamKey + mRequestParamValue;
    }

    @Override
    protected int getMethod() {
        return Request.Method.POST;
    }

    @Override
    public List parseJsonToObject(String jsonString) {
        Gson gson = new GsonBuilder().create();
        ArrayList<Book> bookList = new ArrayList<>( );

        try {
            JSONArray jsonarray = new JSONArray(jsonString);

            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                String dataObject = jsonobject.toString();
                Book book = gson.fromJson( dataObject, Book.class );
                bookList.add( book );
            }

        } catch (JSONException e1) {
            e1.printStackTrace();

        }
        return   bookList;
    }

    @Override
    public void setRequestParamKey(String paramKey) {
        this.mRequestParamKey = paramKey;
    }

    @Override
    public void setRequestParamValue(String paramValue) {
        this.mRequestParamValue = paramValue;
    }
}

