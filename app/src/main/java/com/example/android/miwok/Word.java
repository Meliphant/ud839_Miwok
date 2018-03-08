package com.example.android.miwok;

import android.content.Context;

/**
 * Created by Meliphant on 24.02.2018.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImage = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int image){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImage = image;
    }

    public String getDefaultTranslation (){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation (){
        return mMiwokTranslation;
    }
    public int getImage (){
        return mImage;
    }
    public boolean hasImage(){
        return mImage != NO_IMAGE_PROVIDED;
    }
}
