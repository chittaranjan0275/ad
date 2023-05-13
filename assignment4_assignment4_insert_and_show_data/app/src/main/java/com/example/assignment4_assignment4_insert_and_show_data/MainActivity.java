package com.example.assignment4_assignment4_insert_and_show_data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.editTextPersonName);
        EditText pass= findViewById(R.id.editTextPassword);
        EditText repass= findViewById(R.id.editTextPassword2);
        RadioGroup gend= findViewById(R.id.radioGroup);
        Spinner subj= findViewById(R.id.spinner);
        Button reg = findViewById(R.id.btnhello);
        Intent intent= new Intent(MainActivity.this,ShowActivity.class);


        ArrayList<String> sub=new ArrayList<>();
        sub.add("Engineering");
        sub.add("Arts");

        ArrayAdapter<String> str1= new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sub);

        subj.setAdapter(str1);
        subj.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("sub",sub.get(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


       gend.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {
               int selid= radioGroup.getCheckedRadioButtonId();
               RadioButton radioButton = findViewById(selid);
               intent.putExtra("gend",radioButton.getText().toString());
           }
       });

       reg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               intent.putExtra("name",name.getText().toString());
               startActivity(intent);
           }
       });

    }
}