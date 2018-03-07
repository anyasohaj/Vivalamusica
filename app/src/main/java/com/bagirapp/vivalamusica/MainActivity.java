package com.bagirapp.vivalamusica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public static String composer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button mozart = (Button) findViewById(R.id.mozart);
        Button beethoven = (Button) findViewById(R.id.beethoven);
        Button chopin = (Button) findViewById(R.id.chopin);
        Button bach = (Button) findViewById(R.id.bach);


        mozart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mozartIntent = new Intent(MainActivity.this, ComposerActivity.class);
                composer = "Mozart";
                mozartIntent.putExtra("composer", composer);
                startActivity(mozartIntent);
            }
        });

        beethoven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent beethovenIntent = new Intent(MainActivity.this, ComposerActivity.class);
                composer = "Beethoven";
                beethovenIntent.putExtra("composer", composer);
                startActivity(beethovenIntent);
            }
        });

        bach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bachIntent = new Intent(MainActivity.this, ComposerActivity.class);
                composer = "Bach";
                bachIntent.putExtra("composer", composer);
                startActivity(bachIntent);
            }
        });

        chopin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chopinIntent = new Intent(MainActivity.this, ComposerActivity.class);
                composer = "Chopin";
                chopinIntent.putExtra("composer", composer);
                startActivity(chopinIntent);
            }
        });


    }

}
