package com.example.soundsofnature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;


public class ListeningScreen extends AppCompatActivity implements View.OnClickListener, GridView.OnItemClickListener  {

    private GridView gridView;

    private ImageAdapter animalAdapter;
    private ImageAdapter transportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listening_screen);
        AdaptersInitialize();

        Button animalButton = (Button) findViewById(R.id.animalButton);
        Button transportButton = (Button) findViewById(R.id.transportButton);

        animalButton.setOnClickListener(this);
        transportButton.setOnClickListener(this);

        gridView = (GridView) findViewById(R.id.list);
        gridView.setAdapter(animalAdapter);
        gridView.setOnItemClickListener(this);
    }

    private void AdaptersInitialize()
    {
        int[] animalIcons = new int[SplashScreen.animalResources.size()];
        for (int i = 0; i < animalIcons.length; i++) {
            animalIcons[i] = SplashScreen.animalResources.keyAt(i);
        }
        animalAdapter = new ImageAdapter(this, animalIcons, SplashScreen.COLORS);

        int[] transportIcons = new int[SplashScreen.transportResources.size()];
        for (int i = 0; i < transportIcons.length; i++) {
            transportIcons[i] = SplashScreen.transportResources.keyAt(i);
        }
        transportAdapter = new ImageAdapter(this, transportIcons,  SplashScreen.COLORS);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.animalButton:
                gridView.setAdapter(animalAdapter);
                break;
            case R.id.transportButton:
                gridView.setAdapter(transportAdapter);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long pos) {
        if (adapterView.getAdapter().equals(animalAdapter)) {
            for (int i = 0; i < SplashScreen.animalResources.size(); i++)
            {
                if (position == i)
                {
                    SplashScreen.helps.playSound(this, SplashScreen.animalResources.valueAt(i));
                }
            }
        }

        if (adapterView.getAdapter().equals(transportAdapter)) {
            for (int i = 0; i < SplashScreen.transportResources.size(); i++)
            {
                if (position == i)
                {
                    SplashScreen.helps.playSound(this, SplashScreen.transportResources.valueAt(i));
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SplashScreen.helps.stop();
    }
}
