package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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
        words.add(new Word("Father","әpә",R.raw.family_father,R.drawable.family_father));
        words.add(new Word("Mother","әṭa",R.raw.family_father,R.drawable.family_mother));
        words.add(new Word("Son","angsi",R.raw.family_father,R.drawable.family_son));
        words.add(new Word("Daughter","tune",R.raw.family_father,R.drawable.family_daughter));
        words.add(new Word("Older Brother","taachi",R.raw.family_father,R.drawable.family_older_brother));
        words.add(new Word("Younger Brother","chalitti",R.raw.family_father,R.drawable.family_younger_brother));
        words.add(new Word("Older Sister","teṭe",R.raw.family_father,R.drawable.family_older_sister));
        words.add(new Word("Younger Sister","kolliti",R.raw.family_father,R.drawable.family_younger_sister));
        words.add(new Word("Grandmother","ama",R.raw.family_father,R.drawable.family_grandmother));
        words.add(new Word("Grandfather","paapa",R.raw.family_father,R.drawable.family_grandfather));


        WordAdapter itemsAdapter= new WordAdapter(this,words,R.color.category_family);

        final ListView listVIew = (ListView) findViewById(R.id.list);

        listVIew.setAdapter(itemsAdapter);

        listVIew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word wordPositon = (Word) listVIew.getItemAtPosition(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,wordPositon.getmMediaResourceId());
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
