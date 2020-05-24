package com.example.mydirectory;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
//import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    private TextView text_content_mine;
    private ImageView ImageContent;
    private int category = 0;
    private  int element = 0;
    private Typeface face_one;                                                                      //переменная для хранения шрифта
    private  int [] array_one = {R.string.text_one_one, R.string.text_two_one, R.string.text_three_one, R.string.text_four_one};
    private  int [] array_two = {R.string.text_one_two, R.string.text_two_two, R.string.text_three_two,R.string.text_four_two};
    private  int [] array_three = {R.string.text_one_three, R.string.text_two_three, R.string.text_three_three,R.string.text_four_three};
    private  int [] array_four = {R.string.text_one_four, R.string.text_two_four, R.string.text_three_four,R.string.text_four_four};
    private  int [] array_image = {R.drawable.temperature08, R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();                                                 //функция инициализации текста и картинок
        resiveIntent();
    }
    private void  resiveIntent(){
        Intent i = getIntent();
        if (i != null){
          category = i.getIntExtra("category", 0);
          element = i.getIntExtra("element", 0);

        switch (category){
            case 0:
                ImageContent.setImageResource(array_image[element]);
                text_content_mine.setText(array_one[element]);
                break;
            case 1:
                ImageContent.setImageResource(array_image[element]);
                text_content_mine.setText(array_two[element]);
                break;
            case 2:
                ImageContent.setImageResource(array_image[element]);
                text_content_mine.setText(array_three[element]);
                break;
            case 3:
                ImageContent.setImageResource(array_image[element]);
                text_content_mine.setText(array_four[element]);
                break;

        }
    }
    }
    private  void init()                                        //функция инициализации текста, картинок
    {
        text_content_mine = findViewById(R.id.TextContentOne);           //в фале Text_content.xml ищем и присваеваем переменной конкретный текст вью
        ImageContent = findViewById(R.id.image_content);                   //тоже ис имейджвью
        face_one = Typeface.createFromAsset(this.getAssets(),"fonts/comfortaa-700-normal.ttf"); //присваеваем  шрифт переменной face_one
        text_content_mine.setTypeface(face_one);                                                      //меняем шрифт текста
    }
}

/*Для добавления шрифта - качаем шрифт, создаем папку assets, а вней папку fonts, в которую копируем шрифт*/