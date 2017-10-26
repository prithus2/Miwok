package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    // method to release media and free up media resources
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
        words.add(new Word("Where are You Going?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What's Your Name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is.","oyaaset...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I am feeling good.","kuchi achit ",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","әәnәs'aa? ",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I am coming.","hәә’ әәnәm ",R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.","әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("Let's go.","yoowutis ",R.raw.phrase_lets_go));
        words.add(new Word("Come Here.","әnni'nem",R.raw.phrase_come_here));


        WordAdapter itemsAdapter= new WordAdapter(this,words,R.color.category_phrases);

        final ListView listVIew = (ListView) findViewById(R.id.list);

        listVIew.setAdapter(itemsAdapter);

        listVIew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word wordPositon = (Word) listVIew.getItemAtPosition(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,wordPositon.getmMediaResourceId());
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
