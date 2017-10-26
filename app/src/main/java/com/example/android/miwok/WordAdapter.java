package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PrithuSingh on 10/16/2017.
 */


    public class WordAdapter extends ArrayAdapter<Word> {
         private int mResourceid;
        //private static final String LOG_TAG = AndroidFlavorAdapter.class.getSimpleName();

        /**
         * This is our own custom constructor (it doesn't mirror a superclass constructor).
         * The context is used to inflate the layout file, and the list is the data we want
         * to populate into the lists.
         *
         * @param context        The current context. Used to inflate the layout file.
         * @param Words A List of AndroidFlavor objects to display in a list
         */
        public WordAdapter(Activity context, ArrayList<Word> Words,int color) {
            // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
            // the second argument is used when the ArrayAdapter is populating a single TextView.
            // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
            // going to use this second argument, so it can be any value. Here, we used 0.
            super(context, 0, Words);
            mResourceid=color;
        }

        /**
         * Provides a view for an AdapterView (ListView, GridView, etc.)
         *
         * @param position    The position in the list of data that should be displayed in the
         *                    list item view.
         * @param convertView The recycled view to populate.
         * @param parent      The parent ViewGroup that is used for inflation.
         * @return The View for the position in the AdapterView.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            //getting current WORD item;
            Word currentWord = getItem(position);
            //stting Miwok Translation
            TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokNumber);
            miwokTextView.setText(currentWord.getmMiwokTranslation());

            //setting ENglish Translation
            TextView englishTextView = (TextView) listItemView.findViewById(R.id.englishNumber);
            englishTextView.setText(currentWord.getEnglishTranslation());

            //setting Image
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageView);
            if(currentWord.hasImageView()){
            imageView.setImageResource(currentWord.getImageResourceId());
            }
            else{
              imageView.setVisibility(View.GONE);
            }
            //setting color of each activity;
          View linearLayout= (View) listItemView.findViewById(R.id.linearLayout);
          int color = ContextCompat.getColor(getContext(),mResourceid);
           linearLayout.setBackgroundColor(color);
            return listItemView;
        }
    }