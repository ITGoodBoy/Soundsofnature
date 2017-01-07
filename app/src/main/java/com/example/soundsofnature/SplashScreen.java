package com.example.soundsofnature;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {
                 //the color of animals and transport
    public static final int[] COLORS = {Color.BLUE, Color.RED, Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.GREEN, Color.rgb(145, 56, 54), Color.rgb(255, 0, 127),
            Color.rgb(162, 22, 232), Color.rgb(235, 111, 3), Color.rgb(178, 239, 11)};

    public static final Helps helps = new Helps();

    public static SparseArray<int[]> animalResources;
    public static SparseArray<int[]> transportResources;




    //splash screen with a duration of SPLASH_SCREEN_DURATION seconds
    private final int SPLASH_SCREEN_DURATION = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        //download our resources
        resourcesInitialize();

        //run the main menu screen and end the current screen by finish in SPLASH_SCREEN_DURATION seconds
        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent menuIntent = new Intent(SplashScreen.this, MainMenuScreen.class);
                    SplashScreen.this.startActivity(menuIntent);
                    SplashScreen.this.finish();
                }
            }, SPLASH_SCREEN_DURATION);
    }




    private void resourcesInitialize()
    {
        //load the resources of the new thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                animalResources = new SparseArray<>();
                animalResources.put(R.drawable.animal_icon_01_big_size, new int[]{R.raw.tiger_1, R.raw.tiger_2});
                animalResources.put(R.drawable.animal_icon_02_big_size, new int[]{R.raw.monkey_1, R.raw.monkey_2});
                animalResources.put(R.drawable.animal_icon_03_big_size, new int[]{R.raw.elephant_1, R.raw.elephant_2});
                animalResources.put(R.drawable.animal_icon_04_big_size, new int[]{R.raw.frog_1, R.raw.frog_2});
                animalResources.put(R.drawable.animal_icon_05_big_size, new int[]{R.raw.pig_1, R.raw.pig_2});
                animalResources.put(R.drawable.animal_icon_06_big_size, new int[]{R.raw.horse_1, R.raw.horse_2});
                animalResources.put(R.drawable.animal_icon_07_big_size, new int[]{R.raw.cat_1, R.raw.cat_2});
                animalResources.put(R.drawable.animal_icon_08_big_size, new int[]{R.raw.sheep_1, R.raw.sheep_2});
                animalResources.put(R.drawable.animal_icon_09_big_size, new int[]{R.raw.dog_1, R.raw.dog_2});
                animalResources.put(R.drawable.animal_icon_10_big_size, new int[]{R.raw.chicken_1, R.raw.chicken_2});
                animalResources.put(R.drawable.animal_icon_11_big_size, new int[]{R.raw.cow_1, R.raw.cow_2});
                animalResources.put(R.drawable.animal_icon_12_big_size, new int[]{R.raw.lion_1, R.raw.lion_2});

                transportResources = new SparseArray<>();
                transportResources.put(R.drawable.transport_icon_01_big_size, new int[]{R.raw.police_car});
                transportResources.put(R.drawable.transport_icon_02_big_size, new int[]{R.raw.ambulance});
                transportResources.put(R.drawable.transport_icon_03_big_size, new int[]{R.raw.fire_engine});
                transportResources.put(R.drawable.transport_icon_04_big_size, new int[]{R.raw.rocket});
                transportResources.put(R.drawable.transport_icon_05_big_size, new int[]{R.raw.airplane});
                transportResources.put(R.drawable.transport_icon_06_big_size, new int[]{R.raw.helicopter});
                transportResources.put(R.drawable.transport_icon_07_big_size, new int[]{R.raw.train});
                transportResources.put(R.drawable.transport_icon_08_big_size, new int[]{R.raw.car});
                transportResources.put(R.drawable.transport_icon_09_big_size, new int[]{R.raw.motorcycle});
                transportResources.put(R.drawable.transport_icon_10_big_size, new int[]{R.raw.bicycle});
                transportResources.put(R.drawable.transport_icon_11_big_size, new int[]{R.raw.ship});
                transportResources.put(R.drawable.transport_icon_12_big_size, new int[]{R.raw.bus});

            }
        });
        //and start thread
        thread.start();

    }
}
