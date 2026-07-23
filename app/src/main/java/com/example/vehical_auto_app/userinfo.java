package com.example.vehical_auto_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;

public class userinfo extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase ;
    DatabaseReference mref;
    FirebaseStorage firebaseStorage;
    ImageButton imageButton ;
    EditText edfirst,edlast,edprice;
    Button btninsert;
    private static final int code=1;
    Uri imageurl = null;
    String gname,longi,name,place1,place2,place3,address,gaddress,gnumber;

    EditText edname,edaddress,edcontact,editem1,eduaddress,editem2,editem2price;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);


        Intent intent = getIntent();
        gname = intent.getStringExtra("gname");
        gaddress = intent.getStringExtra("address");
        gnumber = intent.getStringExtra("number");

        imageButton = findViewById(R.id.imageButton2);
        edname = findViewById(R.id.edname);
        edaddress = findViewById(R.id.edaddress);
        edcontact = findViewById(R.id.edmobile);
        editem1 = findViewById(R.id.editem1);

        editem2 = findViewById(R.id.editem2);

        btninsert = findViewById(R.id.btninsert);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mref = firebaseDatabase.getReference().child("order");
        firebaseStorage = FirebaseStorage.getInstance();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == code && resultCode == RESULT_OK)
        {

            imageurl = data.getData();
            imageButton.setImageURI(imageurl);
        }

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 name = edname.getText().toString().trim();
                 place1 = edaddress.getText().toString().trim();
                 address = edcontact.getText().toString().trim();
                 place2 = editem1.getText().toString().trim();

                 place3 = editem2.getText().toString().trim();


//                Geocoder coder = new Geocoder(getApplicationContext());
//
//                try {
//                    ArrayList<Address> adresses = (ArrayList<Address>) coder.getFromLocationName(uaddress, 50);
//
//
//                    for(Address add : adresses){
//                        double longitude = add.getLongitude();
//                        double latitude = add.getLatitude();
//                        lati = String.valueOf(latitude);
//                        longi = String.valueOf(longitude);
//                        Toast.makeText(getApplicationContext(),lati.toString(),Toast.LENGTH_LONG).show();
//
//
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                StorageReference filepath =firebaseStorage.getReference().child("imagepost").child(imageurl.getLastPathSegment());
                filepath.putFile(imageurl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> downloadurl =taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {

                                String t =task.getResult().toString();
                                DatabaseReference newpost =mref.push();

                                newpost.child("type").setValue(name);
                                newpost.child("problem").setValue(place1);
                                newpost.child("modelno").setValue(address);
                                newpost.child("username").setValue(place2);
                                newpost.child("gname").setValue(gname);
                                newpost.child("gaddress").setValue(gaddress);
                                newpost.child("gnumber").setValue(gnumber);


                                newpost.child("number").setValue(place3);



                                newpost.child("imageurl").setValue(task.getResult().toString());
                                Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();

                                sendrequest();

                            }
                        });
                    }
                });
            }
        });
    }

    private void sendrequest() {

        String msg = "User Name "+ place2 + "User Number "+ place3 + "Model No"+address;
        SharedPreferences sharedPreferences = getSharedPreferences("My", Context.MODE_PRIVATE);
        String value = sharedPreferences.getString("number","default");
        Toast.makeText(getApplicationContext(),value.toString(),Toast.LENGTH_LONG).show();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+91"+value.toString(),null,msg,null,null);


    }
}