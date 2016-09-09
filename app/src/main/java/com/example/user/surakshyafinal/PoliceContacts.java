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

public class PoliceContacts extends AppCompatActivity {
    ArrayList<String> policeContactsArray = new ArrayList<String>();
    ArrayList<String> callArray = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_contacts);


        final ListView policeContactLists = (ListView) findViewById(R.id.policeContactsList);
        policeContactsArray.add("Emergency Police Services");
        policeContactsArray.add("Traffic Police");
        policeContactsArray.add("Armed Police HQ, Halchowk ");
        policeContactsArray.add("Tourist Police Unit, Basantapur");



        arrayAdapter = new ArrayAdapter(PoliceContacts.this, android.R.layout.simple_list_item_1, policeContactsArray);
        policeContactLists.setAdapter(arrayAdapter);


        callArray.add("100");
        callArray.add("103");
        callArray.add("014270553");
        callArray.add("014268969");
//        addContactList();

        policeContactLists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(PersonalContacts.this, personalContactsArray.get(position), Toast.LENGTH_SHORT).show();
                callNumber(position);
            }
        });


    }

//    private void addContactList() {
//        policeContactsArray.add(AddContacts.contactName);
//        callArray.add(AddContacts.phoneNumber);
////        arrayAdapter.add(personalContactsArray);
//        arrayAdapter.add(policeContactsArray);
//        Toast.makeText(PoliceContacts.this, AddContacts.contactName + AddContacts.phoneNumber, Toast.LENGTH_SHORT).show();
//    }

    public void callNumber(int position) {
        String phoneNumber = callArray.get(position);
//        Toast.makeText(PersonalContacts.this, "Calling " + phoneNumber, Toast.LENGTH_SHORT).show();
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
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

        } catch (Exception e) {

        }
    }
}
