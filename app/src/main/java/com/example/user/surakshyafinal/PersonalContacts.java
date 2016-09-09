package com.example.user.surakshyafinal;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.plus.model.people.Person;

import java.util.ArrayList;

public class PersonalContacts extends AppCompatActivity {
        ArrayList<String> personalContactsArray = new ArrayList<String>();
        ArrayList<String> callArray = new ArrayList<String>();
        String contactName, phoneNumber;
        ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_contacts);

        Intent i = getIntent();
        contactName = i.getStringExtra("contactName");
        phoneNumber = i.getStringExtra("phoneNumber");
        Toast.makeText(PersonalContacts.this, contactName + " " + phoneNumber, Toast.LENGTH_SHORT).show();





        final ListView personalContactsList = (ListView) findViewById(R.id.personalContactsList);
        personalContactsArray.add("Tina");
        personalContactsArray.add("Arapana");
        personalContactsArray.add("Ruhi");
        personalContactsArray.add("Ashesh");
        personalContactsArray.add(contactName);


        arrayAdapter = new ArrayAdapter(PersonalContacts.this, android.R.layout.simple_list_item_1, personalContactsArray);
        personalContactsList.setAdapter(arrayAdapter);


        callArray.add("9818741099");
        callArray.add("9849674729");
        callArray.add("9861155100");
        callArray.add("9841403473");
        callArray.add(phoneNumber);

//        addContactList();

        personalContactsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(PersonalContacts.this, personalContactsArray.get(position), Toast.LENGTH_SHORT).show();
                callNumber(position);
            }
        });


    }

//    private void addContactList() {
//        personalContactsArray.add(AddContacts.contactName);
//        callArray.add(AddContacts.phoneNumber);
////        arrayAdapter.add(personalContactsArray);
//        arrayAdapter.add(personalContactsArray);
//        Toast.makeText(PersonalContacts.this, AddContacts.contactName + AddContacts.phoneNumber, Toast.LENGTH_SHORT).show();
//    }

    public void callNumber(int position) {
        String phoneNumber = callArray.get(position);
//        Toast.makeText(PersonalContacts.this, "Calling " + phoneNumber, Toast.LENGTH_SHORT).show();
        try{
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneNumber));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callIntent);

        }catch (Exception e){

        }

    }
}
