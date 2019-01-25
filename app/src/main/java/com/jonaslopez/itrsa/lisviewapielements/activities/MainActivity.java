package com.jonaslopez.itrsa.lisviewapielements.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jonaslopez.itrsa.lisviewapielements.R;
import com.jonaslopez.itrsa.lisviewapielements.Utils.BookSearchParamsUtils;
import com.jonaslopez.itrsa.lisviewapielements.Utils.Utils;
import com.jonaslopez.itrsa.lisviewapielements.service.BookService;
import com.jonaslopez.itrsa.lisviewapielements.service.IServiceCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextSearchBook;
    private String mSearchBookValue;
    private Button btnSearch;

    private ArrayList<Object> mBookList;
    private ArrayList<String> searchParamsList = BookSearchParamsUtils.getListSearchParams();
    private static final int BOOK_KEY_PARAM_POSITION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        initProperties();
        executeSearchButton();
    }

    private void executeSearchButton() {
        btnSearch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBookSearch();
            }
        } );
    }

    private void initBookSearch() {
        setSearchBookValue();
        searchDataRequest( BOOK_KEY_PARAM_POSITION );
    }

    private void searchDataRequest(final int paramKeyPosition) {
        String paramKey = searchParamsList.get( paramKeyPosition );

        BookService bookService = new BookService( this, paramKey, getSearchBookValue(), new IServiceCallback() {
            @Override
            public void onSuccess(String response) {
                if(responseIsEmpty(response)){
                    recallSearchDataRequest(paramKeyPosition);
                }
                else {
                    mBookList = (ArrayList<Object>) Utils.parseJsonToObject( response );
                    showNewActivity();
                    Toast.makeText( MainActivity.this,"SE ENCONTRARON VALORES !", Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void onFailure(Exception e) {
                //TODO
            }
        } );
        bookService.callApiData();
    }

    private void recallSearchDataRequest(int paramKeyPosition) {
        if(searchParamsList.size() > paramKeyPosition ){
            searchDataRequest( paramKeyPosition + 1  );
        }
        else{
            Toast.makeText( MainActivity.this,"no hay libros con el texto ingresado", Toast.LENGTH_SHORT ).show();
        }
    }

    private boolean responseIsEmpty(String jsonString) {
        return jsonString.equalsIgnoreCase( "[]" );
    }

    private void showNewActivity() {
        Intent myIntent = new Intent(MainActivity.this, BookSearchResultActivity.class);
        myIntent.putExtra("bookList", mBookList );
        startActivity(myIntent);
    }

    private void setSearchBookValue() {
        mSearchBookValue = editTextSearchBook.getText().toString();
    }

    private String getSearchBookValue(){
        return mSearchBookValue;
    }

    private void initProperties() {
        editTextSearchBook = findViewById( R.id.edtSearchBook );
        btnSearch = findViewById( R.id.btnSearch );
    }

}
