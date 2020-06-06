package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    Button btn1, btn2;
    int ImageList[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.img_swi);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

        for(int i=0;i<6;i++)
        {
            int resId = getResources().getIdentifier("i" + (i+1), "drawable", getPackageName());
            ImageList[i] = resId;
        }
        for(int i=0;i<6;i++)
        {
            System.out.println(ImageList[i]);
        }
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setImageResource(R.drawable.i1);
                return imageView;

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSwitcher.setImageResource(R.drawable.i2);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String currentImage = "i"+nextImage;
              //  Toast.makeText(MainActivity.this, R.drawable.i3, Toast.LENGTH_SHORT).show();
                imageSwitcher.setImageResource(R.drawable.i3);
            }

        });
    }
}
