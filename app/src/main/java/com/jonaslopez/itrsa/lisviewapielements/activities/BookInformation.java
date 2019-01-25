package com.jonaslopez.itrsa.lisviewapielements.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonaslopez.itrsa.lisviewapielements.R;
import com.jonaslopez.itrsa.lisviewapielements.Utils.Utils;
import com.jonaslopez.itrsa.lisviewapielements.models.Book;
import com.squareup.picasso.Picasso;

public class BookInformation extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvPublishDate;
    private TextView tvContent;
    private ImageView imgBookCover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_book_information );

        initProperties();
    }

    private void initProperties() {
        tvTitle = findViewById( R.id.tvBookTitle );
        tvAuthor = findViewById( R.id.tvBookAuthor );
        tvPublishDate = findViewById( R.id.tvBookPublishDate );
        tvContent = findViewById( R.id.tvBookContent );
        imgBookCover = findViewById( R.id.imgBookCover );

        Book book = (Book) getIntent().getExtras().get( "bookItem" );

        String bookContent = book.getContent();

        bookContent = Utils.encodeStringToUTF8( bookContent );

        tvTitle.setText( book.getTitle() );
        tvAuthor.setText( book.getAuthor() );
        tvPublishDate.setText( book.getPublisher() );
        tvContent.setText( bookContent );
        Picasso.get().load( book.getCover() ).into( imgBookCover );
    }
}
