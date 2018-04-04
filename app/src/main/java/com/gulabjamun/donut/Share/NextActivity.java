package com.gulabjamun.donut.Share;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import com.gulabjamun.donut.R;
import com.gulabjamun.donut.Utils.FirebaseMethods;
import com.gulabjamun.donut.Utils.SquareImageView;
import com.gulabjamun.donut.Utils.UniversalImageLoader;
import com.gulabjamun.donut.models.User;

/**
 * Created by User on 7/24/2017.
 */

public class NextActivity extends AppCompatActivity {

    private static final String TAG = "NextActivity";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private FirebaseMethods mFirebaseMethods;

    //widgets
    private EditText mCaption;

    //vars
    private String mAppend = "file:/";
    private int imageCount = 0;
    private String imgUrl;
    private Bitmap bitmap;
    private Intent intent;

    private Dialog myDialog;

    //int
    private int comment_color;
    private String comment_color_firebase;

//Colors
    private SquareImageView color1;
    private SquareImageView color2;
    private SquareImageView color3;
    private SquareImageView color4;
    private SquareImageView color5;
    private SquareImageView color6;
    private SquareImageView color7;
    private SquareImageView color8;
    private SquareImageView color9;
    private SquareImageView color10;
    private SquareImageView color11;
    private SquareImageView color12;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        mFirebaseMethods = new FirebaseMethods(NextActivity.this);
        mCaption = (EditText) findViewById(R.id.caption) ;

        setupFirebaseAuth();

        ImageView backArrow = (ImageView) findViewById(R.id.ivBackArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing the activity");
                finish();
            }
        });


        TextView share = (TextView) findViewById(R.id.tvShare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to the final share screen.");
                //upload the image to firebase

                final String caption = mCaption.getText().toString();


                //Adding color to database----------------------------------------------------------------------------------------



                myDialog = new Dialog(NextActivity.this);

                myDialog.setContentView(R.layout.color_dialogue);



                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                myDialog.show();




                //color 1
                color1 = (SquareImageView) myDialog.findViewById(R.id.color1);
                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#FF1744"));
                        comment_color_firebase = "a";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }


                    }
                });

                //color 2
                color2 = (SquareImageView) myDialog.findViewById(R.id.color2);
                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#1B5E20"));
                        comment_color_firebase = "b";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });

                //color 3
                color3 = (SquareImageView) myDialog.findViewById(R.id.color3);
                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#039BE5"));
                        comment_color_firebase = "c";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });

                //color 4
                color4 = (SquareImageView) myDialog.findViewById(R.id.color4);
                color4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#4CAF50"));
                        comment_color_firebase = "d";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });


                //color 5
                color5 = (SquareImageView) myDialog.findViewById(R.id.color5);
                color5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#FFEB3B"));
                        comment_color_firebase = "e";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });

                //color 6
                color6 = (SquareImageView) myDialog.findViewById(R.id.color6);
                color6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#E91E63"));
                        comment_color_firebase = "f";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });

                //color 7
                color7 = (SquareImageView) myDialog.findViewById(R.id.color7);
                color7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#FF5722"));
                        comment_color_firebase = "g";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });

                //color 8
                color8 = (SquareImageView) myDialog.findViewById(R.id.color8);
                color8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#9C27B0"));
                        comment_color_firebase = "h";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });


                //color 9
                color9 = (SquareImageView) myDialog.findViewById(R.id.color9);
                color9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#673AB7"));
                        comment_color_firebase = "i";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });

                //color 10
                color10 = (SquareImageView) myDialog.findViewById(R.id.color10);
                color10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#795548"));
                        comment_color_firebase = "j";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });

                //color 11
                color11 = (SquareImageView) myDialog.findViewById(R.id.color11);
                color11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#FAFAFA"));
                        comment_color_firebase = "k";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });

                //color 12
                color12 = (SquareImageView) myDialog.findViewById(R.id.color12);
                color12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        comment_color = ( Color.parseColor("#90A4AE"));
                        comment_color_firebase = "l";

                        //--------------------------------------------------------------------------------------------------------------------
                        Toast.makeText(NextActivity.this, "Attempting to upload new photo", Toast.LENGTH_SHORT).show();
                        if(intent.hasExtra(getString(R.string.selected_image))){
                            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, imgUrl,null,comment_color_firebase);
                        }
                        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
                            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
                            mFirebaseMethods.uploadNewPhoto(getString(R.string.new_photo), caption, imageCount, null,bitmap,comment_color_firebase);
                        }
                    }
                });



































            }
        });

        setImage();
    }

    private void someMethod(){
        /*
            Step 1)
            Create a data model for Photos

            Step 2)
            Add properties to the Photo Objects (caption, date, imageUrl, photo_id, tags, user_id)

            Step 3)
            Count the number of photos that the user already has.

            Step 4)
            a) Upload the photo to Firebase Storage
            b) insert into 'photos' node
            c) insert into 'user_photos' node

         */

    }


    /**
     * gets the image url from the incoming intent and displays the chosen image
     */
    private void setImage(){
        intent = getIntent();
        ImageView image = (ImageView) findViewById(R.id.imageShare);

        if(intent.hasExtra(getString(R.string.selected_image))){
            imgUrl = intent.getStringExtra(getString(R.string.selected_image));
            Log.d(TAG, "setImage: got new image url: " + imgUrl);
            UniversalImageLoader.setImage(imgUrl, image, null, mAppend);
        }
        else if(intent.hasExtra(getString(R.string.selected_bitmap))){
            bitmap = (Bitmap) intent.getParcelableExtra(getString(R.string.selected_bitmap));
            Log.d(TAG, "setImage: got new bitmap");
            image.setImageBitmap(bitmap);
        }
    }

     /*
     ------------------------------------ Firebase ---------------------------------------------
     */

    /**
     * Setup the firebase auth object
     */
    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth.");
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        Log.d(TAG, "onDataChange: image count: " + imageCount);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();


                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                imageCount = mFirebaseMethods.getImageCount(dataSnapshot);
                Log.d(TAG, "onDataChange: image count: " + imageCount);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}