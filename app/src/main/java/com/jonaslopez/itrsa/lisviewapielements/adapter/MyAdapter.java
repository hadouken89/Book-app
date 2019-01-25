package com.jonaslopez.itrsa.lisviewapielements.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonaslopez.itrsa.lisviewapielements.R;
import com.jonaslopez.itrsa.lisviewapielements.activities.BookInformation;
import com.jonaslopez.itrsa.lisviewapielements.models.Book;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<Object> listStorage;
    private Context context;

    public MyAdapter(Context context, List<Object> listView)  {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = listView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listStorage.get( position );
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View view = convertView;

        final Book currentItem = (Book) getItem( position );

        if(view == null){
            view =((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_elements,null);
        }
        else{
            LayoutInflater layoutInflater = LayoutInflater.from( this.context );
            view = layoutInflater.inflate( R.layout.list_elements,null );
        }

        TextView title = view.findViewById( R.id.titulo );
        TextView author = view.findViewById( R.id.author );
        TextView publisher = view.findViewById( R.id.publisher );
        ImageView bookCover = view.findViewById( R.id.imageView );

        title.setText( currentItem.getTitle() );
        author.setText( currentItem.getAuthor() );
        publisher.setText( currentItem.getPublisher() );
        Picasso.get().load( currentItem.getCover() ).into( bookCover );

        bookCover.setTag( position );
        bookCover.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, BookInformation.class);
                myIntent.putExtra("bookItem", currentItem);
                context.startActivity(myIntent);
            }
        } );

        return view;
    }





}
