package com.example.soundsofnature;


import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

 class ImageAdapter extends BaseAdapter {

    private Context context;
    private int[] imageId;
    private LayoutInflater inflater;

    private int[] colors;

    public ImageAdapter(Context context, int[] prgmImages, int[] colors) {
        this.context = context;
        imageId = prgmImages;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.colors = colors;

        if (colors.length < prgmImages.length)
        {
            this.colors = new int[prgmImages.length];
            for (int i = 0; i < colors.length; i++) {
                this.colors[i] = colors[i];
            }
            for (int i = colors.length; i < prgmImages.length; i++) {

                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);

                this.colors[i] = Color.rgb(red, green, blue);
            }
        }
        else this.colors = colors;
    }


    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View imageView;
        imageView = inflater.inflate(R.layout.image_adapter, null);
        ImageView imageView1 = (ImageView) imageView.findViewById(R.id.imageView1);

        RelativeLayout rl = (RelativeLayout) imageView.findViewById(R.id.rl);
        rl.setBackgroundColor(colors[position]);
        imageView1.setImageResource(imageId[position]);
        return imageView;
    }




}
