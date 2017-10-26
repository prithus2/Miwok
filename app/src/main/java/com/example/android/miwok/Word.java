package com.example.android.miwok;

/**
 * Created by PrithuSingh on 10/15/2017.
 */

public class Word {
    private String mEnglish;
    private String mMiwok;
    private final int NO_IMG_STATE=-1;
    private int mImageResourceId=NO_IMG_STATE;
    private int mMediaResourceId;
    public Word(String S1,String S2,int MediaResourceId){
        mEnglish=S1;
        mMiwok=S2;
        mMediaResourceId=MediaResourceId;
    }
    /*
    *@param rId is image resource id
     */

    public Word(String S1,String S2,int MediaResourceId,int rId){
        mEnglish=S1;
        mMiwok=S2;
        mMediaResourceId=MediaResourceId;
        mImageResourceId=rId;
    }

    //
    public String getmMiwokTranslation(){
        return mMiwok;
    }
    //
    public String getEnglishTranslation(){return mEnglish;}
    //
    public int getImageResourceId(){return mImageResourceId; }
    //
    public boolean hasImageView(){
        return mImageResourceId!=NO_IMG_STATE;
    }
    public int getmMediaResourceId(){return mMediaResourceId;}

}
