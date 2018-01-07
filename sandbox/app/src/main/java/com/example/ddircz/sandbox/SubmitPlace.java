package com.example.ddircz.sandbox;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;

public class SubmitPlace extends AppCompatActivity{
    ImageView imagePreview;
    Button uploadButton;
    Button submitButton;
    Button clearButton;
    private static final int PICK_IMAGE = 100;
    Uri imageURI;
    EditText locationName;
    Drawer drawer = new Drawer();

    public static ArrayList<Places> submitPlaces = new ArrayList<Places>();

    public static void addPlace(String locName, double dblLat, double dblLong){
        submitPlaces.add(new Places(locName, dblLat, dblLong));
    }

    public static ArrayList<Places> getData() {
        return submitPlaces;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_place);

        setupActionBar();

        imagePreview = (ImageView)findViewById(R.id.imageToUpload);
        uploadButton = (Button)findViewById(R.id.buttonUploadImage);
        submitButton = (Button)findViewById(R.id.submit);
        locationName = (EditText)findViewById(R.id.nameLocation);
        clearButton = (Button)findViewById(R.id.clear);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (locationName.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter a Name for the Location", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Submitting New Location", Toast.LENGTH_SHORT).show();
//                    setContentView(R.layout.submission_confirm);
                    addPlace(locationName.getText().toString(), 44.975316, -93.233532);
                    startActivity(new Intent(SubmitPlace.this, Drawer.class));
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancelling Submission", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageURI = data.getData();
            imagePreview.setImageURI(imageURI);
        }

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
