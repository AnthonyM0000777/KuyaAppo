package com.cite.newscoopup;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;
import java.util.Map;

public class NewsRVModal implements Parcelable{

    private String newsName;
    private String newsDescription;
    private String newsImg;
    private String newsLink;
    private String newsUpload;
    private String newsID;
    private String newsDate;
    private String uid;


    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }


    public NewsRVModal() {

    }

    protected NewsRVModal(Parcel in) {
        newsName = in.readString();
        newsDescription = in.readString();
        newsImg = in.readString();
        newsLink = in.readString();
        newsUpload = in.readString ();
        newsID = in.readString();
        newsDate = in.readString ();
        uid = in.readString ();

    }

    public static Comparator<NewsRVModal> NewsAZComparator = new Comparator<NewsRVModal> () {
        @Override
        public int compare(NewsRVModal p1, NewsRVModal p2) {
            return p1.getNewsName ().compareTo (p2.getNewsName ());
        }
    };

    public static Comparator<NewsRVModal> NewsZAComparator = new Comparator<NewsRVModal> () {
        @Override
        public int compare(NewsRVModal p1, NewsRVModal p2) {
            return p2.getNewsName ().compareTo (p1.getNewsName ());
        }
    };

    /*public static Comparator<NewsRVModal> NewsDateAscendingComparator = new Comparator<NewsRVModal> () {
        @Override
        public int compare(NewsRVModal p1, NewsRVModal p2) {
            return p1.getNewsDate ().compareTo (p2.getNewsDate ());
        }
    };*/



    public static final Creator<NewsRVModal> CREATOR = new Creator<NewsRVModal>() {
        @Override
        public NewsRVModal createFromParcel(Parcel in) {
            return new NewsRVModal(in);
        }

        @Override
        public NewsRVModal[] newArray(int size) {
            return new NewsRVModal[size];
        }
    };

    // creating getter and setter methods.
    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    public String getNewsUpload(){
        return newsUpload;
    }

    public void setNewsUploadBy(String newsUploadBy) {
        this.newsUpload = newsUpload;
    }

    public  String getNewsDate(){
        return  newsDate;
    }
    public void setNewsDate(String newsDate){
        this.newsDate = newsDate;
    }

    public String getUid(){
        return uid;
    }
    public void setUid(String uid){
        this.uid = uid;
    }

    public NewsRVModal(String newsID,String newsName, String newsDescription, String newsImg, String newsLink, String newsUpload, String newsDate, String uid ) {
        this.newsName = newsName;
        this.newsDescription = newsDescription;
        this.newsImg = newsImg;
        this.newsLink = newsLink;
        this.newsUpload = newsUpload;
        this.newsID = newsID;
        this.newsDate = newsDate;
        this.uid = uid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(newsName);
        dest.writeString(newsDescription);
        dest.writeString(newsImg);
        dest.writeString(newsLink);
        dest.writeString(newsUpload);
        dest.writeString(newsID);
        dest.writeString (newsDate);
        dest.writeString (uid);
    }
}