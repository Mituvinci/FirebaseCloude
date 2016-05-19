package com.example.mitu.firebasecloude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView  mTextFieldCondition;
    Button mButtonFoggy;
    Button mButtonSunny;
    Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mTextFieldCondition = (TextView) findViewById(R.id.textViewCondition);
        mButtonFoggy = (Button) findViewById(R.id.buttonfoggy);
        mButtonSunny  = (Button) findViewById(R.id.buttonsunny);
        mRef = new Firebase("https://crowd-weather.firebaseio.com/condition");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                    String text = dataSnapshot.getValue(String.class);
                    mTextFieldCondition.setText(text);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }
}
