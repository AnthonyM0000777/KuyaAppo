package com.cite.newscoopup;

import com.cite.newscoopup.modals.NewsHeadLines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadLines> list, String message);
    void onError(String message);
}
