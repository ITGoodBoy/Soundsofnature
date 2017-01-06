package com.example.soundsofnature;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainMenuScreen extends AppCompatActivity implements View.OnClickListener{



    private Button listeningButton;
    private Button quizButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_menu_screen);

        listeningButton = (Button) findViewById(R.id.listening_button);
        listeningButton.setOnClickListener(this);
        quizButton = (Button) findViewById(R.id.quiz_button);
        quizButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.listening_button:
                startActivity(new Intent(MainMenuScreen.this, ListeningScreen.class));
                break;
            case R.id.quiz_button:
                startActivity(new Intent(MainMenuScreen.this, QuizScreen.class));
                break;
        }
    }
}
