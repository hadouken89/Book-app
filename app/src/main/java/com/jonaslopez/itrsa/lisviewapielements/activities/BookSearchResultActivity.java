package com.jonaslopez.itrsa.lisviewapielements.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.jonaslopez.itrsa.lisviewapielements.R;
import com.jonaslopez.itrsa.lisviewapielements.adapter.MyAdapter;

import java.util.ArrayList;

public class BookSearchResultActivity extends AppCompatActivity {

    private ListView lvListBooks;
    private ArrayList<Object> mBookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_book_search_result );

        initProperties();
        showBookPortraits();
    }

    private void initProperties() {
        mBookList = (ArrayList<Object>) getIntent().getExtras().get("bookList");
        lvListBooks = findViewById( R.id.lvListBooks );
    }

    private void showBookPortraits() {
        MyAdapter adapter = new MyAdapter( this, mBookList );
        lvListBooks.setAdapter( adapter );
    }
}
