package com.example.user.surakshyafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.PendingResult;

public class AddContacts extends AppCompatActivity {



    String contactName, phoneNumber;
    EditText contactNameText, phoneNumberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        contactNameText = (EditText)this.findViewById(R.id.contactNameText);
         phoneNumberText = (EditText)this.findViewById(R.id.phoneNumberText);




    }

    public void gotoPersonalContacts(View view){
        contactName = contactNameText.getText().toString();
        phoneNumber = phoneNumberText.getText().toString();



        Intent gotoPersonalContacts = new Intent(AddContacts.this, PersonalContacts.class);
        gotoPersonalContacts.putExtra("contactName", contactName);
        gotoPersonalContacts.putExtra("phoneNumber", phoneNumber);
        startActivity(gotoPersonalContacts);

    }
}
