package com.jonaslopez.itrsa.lisviewapielements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jonaslopez.itrsa.lisviewapielements.Constants.Constants;
import com.jonaslopez.itrsa.lisviewapielements.models.Book;
import com.jonaslopez.itrsa.lisviewapielements.service.BookService;
import com.jonaslopez.itrsa.lisviewapielements.service.IServiceCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Object> booksByAuthor = new ArrayList<>();
    private  Book bookById = new Book();

    private EditText mAuthor;
    private EditText mYear;
    private EditText mName;
    private Button btnSearch;
    private ImageView bookCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        initProperties();

        executeEventSearch();
    }

    private void initProperties() {
      //  mName = findViewById( R.id.textName ) ;
      //  mAuthor = findViewById( R.id.textAuthor );
      //  mYear = findViewById( R.id.textYear );
        btnSearch = findViewById( R.id.btnSearch );
      //  bookCover = findViewById( R.id.bookCover );
    }

    private void executeEventSearch() {
        btnSearch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callServiceBookByAuthor(mAuthor.getText().toString());
                callServiceBookByAuthor( "adrian paenza" );
            }
        } );
    }

    private void callServiceBookByAuthor(String paramValue) {
        BookService bookService = new BookService( this, Constants.PARAM_BOOK_AUTHOR, paramValue, new IServiceCallback() {
            @Override
            public void onSuccess(List<Object> object) {
                booksByAuthor = (ArrayList<Object>) object;
                showBookPortraits();
            }

            @Override
            public void onFailure(Exception e) {
                //TODO
            }
        } );
        bookService.callApiData();
    }

    private void showBookPortraits() {
        String urlCover = ((Book) booksByAuthor.get( 0 )).getCover();
    //    Picasso.get().load(  urlCover).into( bookCover );

        Toast.makeText( this,"cargo imagen",Toast.LENGTH_SHORT ).show();

    }

    private void setBookResponse(Object object){

      //  Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(bookCover);

    }

}
