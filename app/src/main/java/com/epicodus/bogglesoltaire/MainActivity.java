package com.epicodus.bogglesoltaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
        private Button mPlayBoggleButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mPlayBoggleButton = (Button) findViewById(R.id.playBoggleButton);
            mPlayBoggleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Ready to play!", Toast.LENGTH_LONG).show();
                }
            });
        }
    }