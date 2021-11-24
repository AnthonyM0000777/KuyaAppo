package com.cite.newscoopup;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsRVModal implements Parcelable {
    private String newsName;
    private String newsDescription;
    private String newsImg;
    private String newsLink;
    private String newsID;


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
        newsID = in.readString();
        newsDescription = in.readString();
        newsImg = in.readString();
        newsLink = in.readString();
    }

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


    public NewsRVModal(String newsID, String newsName, String newsDescription, String newsImg, String newsLink) {
        this.newsName = newsName;
        this.newsID = newsID;
        this.newsDescription = newsDescription;
        this.newsImg = newsImg;
        this.newsLink = newsLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(newsName);
        dest.writeString(newsID);
        dest.writeString(newsDescription);
        dest.writeString(newsImg);
        dest.writeString(newsLink);
    }
}