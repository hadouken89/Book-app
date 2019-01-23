package com.jonaslopez.itrsa.lisviewapielements.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String id;
    private String title;
    private String author;
    private String content;
    private String content_short;
    private String publisher;
    private String publisher_date;
    private String pages;
    private String language;
    private String url_details;
    private String url_download;
    private String cover;
    private String thumbnail;
    private String num_comments;
   // private Categories categories;

    public Book(){}

    public Book(Parcel in) {

        this.id = in.readString();
        this.title = in.readString();
        this.author = in.readString();
        this.content = in.readString();
        this.content_short = in.readString();
        this.publisher = in.readString();
        this.publisher_date = in.readString();
        this.pages = in.readString();
        this.language = in.readString();
        this.url_details = in.readString();
        this.url_download = in.readString();
        this.cover = in.readString();
        this.thumbnail = in.readString();
        this.num_comments = in.readString();
     //   this.categories = in.readArray(categories);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getContent_short() {
        return content_short;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublisher_date() {
        return publisher_date;
    }

    public String getPages() {
        return pages;
    }

    public String getLanguage() {
        return language;
    }

    public String getUrl_details() {
        return url_details;
    }

    public String getUrl_download() {
        return url_download;
    }

    public String getCover() {
        return cover;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getNum_comments() {
        return num_comments;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(content);
        dest.writeString(content_short);
        dest.writeString(publisher);
        dest.writeString(publisher_date);
        dest.writeString(pages);
        dest.writeString(language);
        dest.writeString(url_details);
        dest.writeString(url_download);
        dest.writeString(cover);
        dest.writeString(thumbnail);
        dest.writeString(num_comments);
       // dest.writeTypedObject(categories);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

}
