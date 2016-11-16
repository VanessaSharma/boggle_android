//package com.epicodus.bogglesoltaire;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Arrays;
//import java.util.Random;
//
//public class Letter {
//    private String letter;
//
//    public Letter(String letter) {
//        this.letter = letter;
//    }
//
//    public String getLetter() {
//        return letter;
//    }
//}
//
//public class BoggleActivity extends AppCompatActivity {
//    private String[] letters = { "a", "b", "c", "d", "e", "f", "g",
//            "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
//            "u", "v", "w", "x", "y", "z" };
//    private ArrayList<Letter> alphebet = new ArrayList<Letter>();
//    private ArrayList<Letter> randomLetters = new ArrayList<Letter>();
//
//    public ArrayList<Letter> getAlphebet() {
//        int value = 1;
//        for (String letter: letters) {
//            Letter letter = new Letter(letter);
//            value ++;
//            alphebet.add(letter);
//        }
//        return alphebet;
//    }
//
//    public ArrayList<Letter> getRandomLetters() {
//        for (int i = 0; i < 8; i++) {
//            Random random = new Random();
//            int randomNumber = random.nextInt(alphebet.size());
//            String chosen = alphebet.get(randomNumber);
//            randomLetters.add(chosen);
//            alphebet.remove(chosen);
//        }
//        return randomLetters;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_boggle);
//        Intent intent = getIntent();
//    }
//}

package com.epicodus.bogglesoltaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BoggleActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.start) EditText mStart;
    @Bind(R.id.lettersGrid) GridView mLettersGrid;
    @Bind(R.id.generateButton) Button mGenerateButton;
    @Bind(R.id.enterWord) Button mEnterWord;
    private String[] vowels = new String[] {"A", "E", "I", "O", "U"};
    private String[] letters = new String[] { "B", "C", "D",
            "F", "G", "H", "H","H", "J",
            "K", "L", "M", "N","N", "N",
            "P", "Q", "R","R", "S","S", "T","T", "T",
             "V", "W", "X", "Y", "Z"};
    private ArrayList<String> randomLetters = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boggle);

        ButterKnife.bind(this);
        mEnterWord.setVisibility(View.INVISIBLE);



        mGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    Random random = new Random();
                    int randomNum = random.nextInt(letters.length);
                    String theLetter = letters[randomNum];
                    Log.d(TAG, theLetter);
                    randomLetters.add(theLetter);
                    ArrayAdapter adapter = new ArrayAdapter(BoggleActivity.this, android.R.layout.simple_list_item_1, randomLetters);
                    mLettersGrid.setAdapter(adapter);
                }while (randomLetters.size() <6);

                do {
                    Random random = new Random();
                    int randomNumber = random.nextInt(vowels.length);
                    String theVowel = vowels[randomNumber];
                    Log.d(TAG, theVowel);
                    randomLetters.add(theVowel);
                    ArrayAdapter adapter = new ArrayAdapter(BoggleActivity.this, android.R.layout.simple_list_item_1, randomLetters);
                    mLettersGrid.setAdapter(adapter);
                } while (randomLetters.size() <8);

                v.setVisibility(View.GONE);
                mEnterWord.setVisibility(View.VISIBLE);
            }
        });

//        mEnterWord.setOnClickListener(new View.OnClickListener() {
//
//        });




        Intent intent = getIntent();
        String userWord = intent.getStringExtra("userWord");
    }
}
