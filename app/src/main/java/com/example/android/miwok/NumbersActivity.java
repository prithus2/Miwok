package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.MediaController;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
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
        words.add(new Word("One","Lutti",R.raw.number_one,R.drawable.number_one));
        words.add(new Word("Two","Otiiko",R.raw.number_two,R.drawable.number_two));
        words.add(new Word("Three","Tolookosu",R.raw.number_three,R.drawable.number_three));
        words.add(new Word("Four","oyyisa",R.raw.number_four,R.drawable.number_four));
        words.add(new Word("Five","massokka",R.raw.number_five,R.drawable.number_five));
        words.add(new Word("Six","temmokka",R.raw.number_six,R.drawable.number_six));
        words.add(new Word("Seven","kenekaku",R.raw.number_seven,R.drawable.number_seven));
        words.add(new Word("Eight","kawinta",R.raw.number_eight,R.drawable.number_eight));
        words.add(new Word("Nine","wo'e",R.raw.number_nine,R.drawable.number_nine));
        words.add(new Word("Ten","Na'aacha",R.raw.number_ten,R.drawable.number_ten));


//       using linear vertical  layout with high memory usage and no view recycling
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//
//        for(int i=0;i<words.size();i++) {
//            TextView num = new TextView(this);
//            num.setText(words.get(i));
//            rootView.addView(num);
//
//        }

     // using list view and array adapter to minimize memory usage and recycle views
        WordAdapter itemsAdapter= new WordAdapter(this,words,R.color.category_numbers);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Word  wordPosition= (Word) listView.getItemAtPosition(position);
                // intialising media player objet
                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(NumbersActivity.this,wordPosition.getmMediaResourceId());
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
