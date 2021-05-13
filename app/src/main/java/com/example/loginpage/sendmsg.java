package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class sendmsg extends AppCompatActivity {
    ListView contacts;
    ArrayList<String> namelist;
    ArrayList<String> mobilelist;
    ArrayAdapter<String> adapter;
    String trouble="I'm in trouble";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmsg);

        check();
        readcontact();
        listofcontacts();
    }


//Permission Allow Or Deny -- Send Msg Module
    public void check() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 1);

        } else {
            readcontact();
        }
    }
    //if permission code is 1= Allow means permission is grant -- Send msg Module
@Override
public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            if (requestCode == 1) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readcontact();
                }
            }
        }

        //Show Contact List  in listview from  -- Send msg Module
public void listofcontacts(){
    contacts=(ListView)findViewById(R.id.contacts);
    adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,namelist);
    readcontact();
    contacts.setAdapter(adapter);
    contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //Open Sms Screen -- Send msg Module
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
          Intent smsIntent=new Intent(Intent.ACTION_VIEW);
          smsIntent.setData(Uri.parse("smsto:"+mobilelist));
          smsIntent.setType("vnd.android-dir/mms-sms");
          smsIntent.putExtra("sms_body",trouble);
          smsIntent.putExtra("address",mobilelist.get(i));
            startActivity(smsIntent);
        }
    });
    }
    //use to read contact from devices  -- Send Msg Module
        public void readcontact () {
        namelist=new ArrayList<>();
        mobilelist=new ArrayList<>();
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String mobile = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                namelist.add(name);
                mobilelist.add(mobile);
            }

        }
    }


