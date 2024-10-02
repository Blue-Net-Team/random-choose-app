package com.example.randomchoice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public String[] canteens = {"一饭", "二饭", "三饭", "四饭", "商中"};
    public String[] foods = {"麻辣烫", "生煎包","手抓饼","肉夹馍","大众伙食","炒面","水煮牛肉"};
    public String[] random_nums = {};
    private final Handler handler = new Handler(Looper.getMainLooper());
    private String res;
    private String[] now_lst = canteens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView randomChoice = findViewById(R.id.textView);

        //setting 按钮
        Button setting_button = findViewById(R.id.setting_button);
        setting_button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);

        });

        // choose按钮
        Button button = findViewById(R.id.choice_button);
        button.setOnClickListener(v -> change_text(randomChoice));

        // canteen按钮
        Button canteen_button = findViewById(R.id.canteen_button);
        canteen_button.setOnClickListener(v -> canteen_button_callback(randomChoice));

        // food按钮
        Button food_button = findViewById(R.id.food_button);
        food_button.setOnClickListener(v -> food_button_callback(randomChoice));
    }

    //随机生成选择
    private void change_text(TextView randomChoice) {
        for (int i = 0; i < 10; i++) {
            handler.postDelayed(() -> {
                res = String.valueOf(now_lst[(int) (Math.random() * canteens.length)]);
                randomChoice.setText(res);
            }, i * 100);
        }
    }

    private void canteen_button_callback(TextView randomChoice) {
        randomChoice.setText("选择饭堂");
        now_lst = canteens;
    }

    private void food_button_callback(TextView randomChoice) {
        randomChoice.setText("选择食物");
        now_lst = foods;
    }
}