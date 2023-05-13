package com.example.assignment4_assignment4_insert_and_show_data;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        TextView name=findViewById(R.id.textView);
        TextView gend=findViewById(R.id.textView2);
        TextView sub=findViewById(R.id.textView3);
        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            name.setText(extras.getString("name"));
            gend.setText(extras.getString("gend"));
            sub.setText(extras.getString("sub"));
        }
    }
}