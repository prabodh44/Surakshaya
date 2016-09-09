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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HospitalContacts extends AppCompatActivity {

    ArrayList<String> hospitalContactsArray = new ArrayList<String>();
    ArrayList<String> callArray = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_contacts);


        final ListView hospitalContactsList = (ListView) findViewById(R.id.hospitalContactsList);
        hospitalContactsArray.add("Bir Hosptial Emergency");
        hospitalContactsArray.add("Alka Hospital");
        hospitalContactsArray.add("Birendra Army Hosptial, Chhauni");
        hospitalContactsArray.add("Kathmandu Model Hospital");


        arrayAdapter = new ArrayAdapter(HospitalContacts.this, android.R.layout.simple_list_item_1, hospitalContactsArray);
        hospitalContactsList.setAdapter(arrayAdapter);


        callArray.add("014223807");
        callArray.add("015555555");
        callArray.add("014271941");
        callArray.add("014240805");

//        addContactList();

        hospitalContactsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
