package com.example.soundsofnature;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;


public class QuizScreen extends AppCompatActivity implements View.OnClickListener {

    HashSet<Integer> set = new HashSet<>();
    ArrayList<ImageButton> randomImageButtons = new ArrayList<>();
    SparseArray<int[]> randomArray;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private int trueAnswer;
    private int level = 2;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_screen);

        randomArray = new SparseArray<>();
        for (int i = 0; i < SplashScreen.animalResources.size(); i++) {
            randomArray.put(SplashScreen.animalResources.keyAt(i), SplashScreen.animalResources.get(i));
        }
        for (int i = 0; i < SplashScreen.transportResources.size(); i++) {
            randomArray.put(SplashScreen.transportResources.keyAt(i), SplashScreen.animalResources.get(i));
        }

        layout1 = (LinearLayout) findViewById(R.id.quiz_screen_Linear_layout_1);
        layout2 = (LinearLayout) findViewById(R.id.quiz_screen_Linear_layout_2);

        levelUp(level);
    }

    private static int id = 0;
    private ImageButton createImageButton(int resource)
    {
        if (id == SplashScreen.COLORS.length) id = 0;
        ImageButton imageButton = new ImageButton(this);
        imageButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setImageResource(resource);
        imageButton.setBackgroundColor(SplashScreen.COLORS[id]);
        id++;
        imageButton.setOnClickListener(this);
        return imageButton;
    }

    private void levelUp(int level)
    {
        layout1.removeAllViews();
        layout2.removeAllViews();

        trueAnswer = randomSound();
        set = new HashSet<>();
        set.add(trueAnswer);

        while (true)
        {
            int a = (int) (Math.random() * randomArray.size());
            set.add(randomArray.keyAt(a));
            if (set.size() == level) break;
        }

        randomImageButtons = new ArrayList<>();

        for (Integer i: set)
        {
            if (i == trueAnswer)
            {
                ImageButton button = createImageButton(trueAnswer);
                button.setId(trueAnswer);
                randomImageButtons.add(button);
            }
          else  randomImageButtons.add(createImageButton(i));
        }



        for (int i = 0; i < level; i++) {
            if (i < 3)
                layout1.addView(randomImageButtons.get(i));
            else
                layout2.addView(randomImageButtons.get(i));
        }
    }

    private int correctAnswers = 0;
    private int[] levelQuiz = {5, 9, 13, 18, 25};
    @Override
    public void onClick(View view) {
        if (view.getId() == trueAnswer)
        {
            correctAnswers++;
            SplashScreen.helps.stop();
            set.clear();
            randomImageButtons.clear();
            levelUp(level);

            if (correctAnswers == levelQuiz[4])
            {
                Toast.makeText(this, "ВІТАЮ, ВИ ВІДПОВІЛИ НА ВСІ ЗАПИТАННЯ", Toast.LENGTH_LONG).show();
                onBackPressed();
            }

            for (int i = 0; i < levelQuiz.length; i++) {
                if (correctAnswers == levelQuiz[i]) level++;
            }
        }
        else
        {
            Toast.makeText(this, "Невірна відповідь, спробуйте ще раз будь-ласка.", Toast.LENGTH_SHORT).show();
        }
    }



    private int randomSound()
    {
        int random = (int) (Math.random() * 2);
        if (random == 0)
        {
            return randomAnimalSound();
        }

        else return randomTransportSound();
    }

    private int randomAnimalSound()
    {
        int animalRandom = (int) (Math.random() * SplashScreen.animalResources.size());
        int[] animalSounds = SplashScreen.animalResources.valueAt(animalRandom);
        SplashScreen.helps.playSound(this, animalSounds);

        return SplashScreen.animalResources.keyAt(animalRandom);
    }

    private int randomTransportSound()
    {

        int transportRandom = (int) (Math.random() * SplashScreen.transportResources.size());
        int[] animalSounds = SplashScreen.transportResources.valueAt(transportRandom);
        SplashScreen.helps.playSound(this, animalSounds);

        return SplashScreen.transportResources.keyAt(transportRandom);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SplashScreen.helps.stop();
    }
}
