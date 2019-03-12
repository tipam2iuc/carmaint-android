package com.fulthonn.model;

public class Sample {

    private String mText;
    private String mImageURL;

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public void setmImageURL(String mImageURL) {
        this.mImageURL = mImageURL;
    }

    public Sample(String mText, String mImageURL) {
        this.mText = mText;
        this.mImageURL = mImageURL;
    }


}
