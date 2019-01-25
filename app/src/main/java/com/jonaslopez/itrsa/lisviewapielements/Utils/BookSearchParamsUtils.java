package com.jonaslopez.itrsa.lisviewapielements.Utils;

import com.jonaslopez.itrsa.lisviewapielements.Constants.Constants;

import java.util.ArrayList;

public class BookSearchParamsUtils {
    private static ArrayList<String> listSearchParams = new ArrayList( );

    static {
        listSearchParams.add( Constants.PARAM_BOOK_TITLE );
        listSearchParams.add(Constants.PARAM_BOOK_AUTHOR);
        listSearchParams.add(Constants.PARAM_KEYWORD);
        listSearchParams.add(Constants.PARAM_PUBLISHER);
    }

  //  public static void addListSearchParams(String searchParamKey){
  //      listSearchParams.add( searchParamKey );
  //  }

    public static ArrayList<String> getListSearchParams(){
        return listSearchParams;
    }
}
