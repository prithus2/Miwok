package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent family,color,phrase,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creating new explicit intent object
        family= new Intent(this,FamilyActivity.class);
        color = new Intent(this,ColorsActivity.class);
        phrase= new Intent(this,PhrasesActivity.class);
        number= new Intent(this,NumbersActivity.class);

        Button familyButton = (Button)findViewById(R.id.familyMembers);
        Button colorButton =  (Button) findViewById(R.id.colors);
        Button numberButton = (Button) findViewById(R.id.numbers);
        Button phraseButton= (Button) findViewById(R.id.phrases);



        familyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                startActivity(family);
            }
        });
        numberButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                startActivity(number);
            }
        });
        phraseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                startActivity(phrase);
            }
        });
        colorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(color);
            }
        });


    }

}
