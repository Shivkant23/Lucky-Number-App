package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyActivity extends AppCompatActivity {
    TextView textViewText, textViewNumber;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        textViewText = findViewById(R.id.textViewLucky);

        textViewNumber = findViewById(R.id.textViewLuckyNumber);
        button = findViewById(R.id.btn);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");
        textViewText.setText(userName+" Lucky Number is: ");
        int num = new Random().nextInt(10);
        textViewNumber.setText(num+"");

        Toast.makeText(this, "Username is "+userName, Toast.LENGTH_LONG).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(textViewText+"", num);
            }
        });
    }

    public void shareData(String userName, int randomNumber){
        System.out.println("This is sharedata");

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, userName);
        intent.putExtra(Intent.EXTRA_TEXT, randomNumber);

        startActivity(Intent.createChooser(intent, "Choose a platform"));
    }
}