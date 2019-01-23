package com.jonaslopez.itrsa.lisviewapielements.models;

import java.util.HashMap;

class Categories {
    private String category_id;
    private String name;
    private String nicename;

    private HashMap hmCategories = new HashMap(  );

    public Categories() {}

    public Categories(String category_id, String name, String nicename) {
        this.category_id = category_id;
        this.name = name;
        this.nicename = nicename;
    }


    private HashMap getCategories(){
        return null;
    }

    private void setCategories(){

    }

    private void addCategories(HashMap hmparams){

    }


}

