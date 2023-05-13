package com.example.assignment3_login;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name=findViewById(R.id.editTextTextPersonName);
        EditText pass=findViewById(R.id.editTextTextPassword);
        EditText repass=findViewById(R.id.editTextTextPassword2);
        Button reg=findViewById(R.id.button);
        DB= new DBHelper(this);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1= name.getText().toString();
                String pass1=pass.getText().toString();
                String repass1=repass.getText().toString();

                if(pass1.equals(repass1)){

                    Boolean user1=DB.checkusername(name1);
                    if(user1==false){

                        Boolean insert=DB.insertdata(name1,pass1);
                        if(insert==true){
                            Toast.makeText(MainActivity.this,"Registration successful",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Registration unsuccessful",Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"user already exist",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });



    }
}