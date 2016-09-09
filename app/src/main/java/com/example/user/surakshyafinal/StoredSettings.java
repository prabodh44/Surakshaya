package com.example.user.surakshyafinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StoredSettings extends AppCompatActivity {

    Button saveButton;
    EditText phoneNumberText;
    EditText recipientNameText;

    String recipientName;
    String phoneNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stored_settings);

        saveButton = (Button)findViewById(R.id.saveButton);
        phoneNumberText = (EditText)findViewById(R.id.phoneNumberText);
        recipientNameText = (EditText)findViewById(R.id.recipientNameText);




    }

    public void saveInfo(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("storedInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        recipientName = recipientNameText.getText().toString();
        editor.putString("recipientName", recipientName);

        phoneNumber = phoneNumberText.getText().toString();
        editor.putString("phoneNumber", phoneNumber);

        editor.apply();

        Toast.makeText(StoredSettings.this, recipientName + " " + phoneNumber, Toast.LENGTH_SHORT).show();



    }
}
