
//public class MainActivity extends AppCompatActivity {
//    public static final String TAG = MainActivity.class.getSimpleName();
//    private Button mPlayBoggleButton;
//    private EditText mRollDiceEditText;
//    private TextView mBoggleSoltaireTextView;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//            mRollDiceEditText = (EditText) findViewById(R.id.rollDiceEditText);
//            mPlayBoggleButton = (Button) findViewById(R.id.playBoggleButton);
//            mBoggleSoltaireTextView = (TextView) findViewById(R.id.boggleSolitaireTextView);
//            Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-sans/ostrich-regular.ttf");
//            mBoggleSoltaireTextView.setTypeface(ostrichFont);
//            mPlayBoggleButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String location = mRollDiceEditText.getText().toString();
//                    Log.d(TAG, location);
//                    Intent intent = new Intent(MainActivity.this, BoggleActivity.class);
//                    startActivity(intent);
//                }
//            });
//        }
//    }

package com.epicodus.bogglesoltaire;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.username) EditText mUsername;
    @Bind(R.id.playButton) Button mPlayButton;
    @Bind(R.id.boggleSoltaire) TextView mBoggleSoltaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-sans/ostrich-regular.ttf");
          mBoggleSoltaire.setTypeface(ostrichFont);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsername.getText().toString();
                Log.d(TAG, username);

                Intent intent = new Intent(MainActivity.this, BoggleActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

    }
}