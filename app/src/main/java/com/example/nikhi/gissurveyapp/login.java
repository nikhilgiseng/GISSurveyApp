package com.example.nikhi.gissurveyapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nikhi on 22-02-2017.
 */

public class login extends AppCompatActivity {
    private Button btn;
    private EditText username;
    private EditText password;
    Integer counter=3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btn=(Button)findViewById(R.id.loginButton);
        username=(EditText)findViewById(R.id.usernameBox);
        password=(EditText)findViewById(R.id.passwordBox);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(username.getText().toString().equals("user")&& password.getText().toString().equals("user"))
                {
                    Intent intent = new Intent(login.this,MainActivity.class);
                    startActivity(intent);

                   //map_view.instantiate()
                }

                else

                    Toast.makeText(login.this, "Login UnSuccessful.Try Again...", Toast.LENGTH_SHORT).show();
                counter--;
                if(counter==0)
                {
                    AlertDialog.Builder builder=new AlertDialog.Builder(login.this);
                    builder.setMessage("You have made three un-successful login attempts. The application terminates now").setTitle("Three un-successful Login attempts");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    });
                    AlertDialog dialog=builder.create();
                    dialog.show();



                }
            }
        });

    }
}
