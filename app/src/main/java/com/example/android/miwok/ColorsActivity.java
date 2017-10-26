package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    private void releaseMediaPlayer()
    {
        if(mMediaPlayer!=null)
        {
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
    }
    private MediaPlayer.OnCompletionListener  mCompletionListner= new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mMediaPlayer){
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_layout);
        final ArrayList<Word> words =new ArrayList<Word>();
        words.add(new Word("Red","weṭeṭṭi",R.raw.color_red,R.drawable.color_red));
        words.add(new Word("Green","chokokki",R.raw.color_green,R.drawable.color_green));
        words.add(new Word("Brown","ṭakaakki",R.raw.color_brown,R.drawable.color_brown));
        words.add(new Word("Gray","ṭopoppi",R.raw.color_gray,R.drawable.color_gray));
        words.add(new Word("Black","kululli",R.raw.color_black,R.drawable.color_black));
        words.add(new Word("White","kelelli",R.raw.color_white,R.drawable.color_white));
        words.add(new Word("Dusty Yellow","ṭopiisә",R.raw.color_dusty_yellow,R.drawable.color_dusty_yellow));
        words.add(new Word("Musterd Yellow","chiwiiṭә",R.raw.color_mustard_yellow,R.drawable.color_mustard_yellow));


        WordAdapter itemsAdapter= new WordAdapter(this,words,R.color.category_colors );

        final ListView listVIew = (ListView) findViewById(R.id.list);

        listVIew.setAdapter(itemsAdapter);

        listVIew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Word wordPositon = (Word) listVIew.getItemAtPosition(position);
               releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,wordPositon.getmMediaResourceId());
               mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListner);
            }
        });



    }
    @Override
    protected void onStop()
    {
        super.onStop();

        releaseMediaPlayer();
    }
}
