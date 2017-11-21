package com.example.android.myfirebasetest.Classes;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.myfirebasetest.SingInActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.example.android.myfirebasetest.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.R.attr.order;
import static android.R.attr.y;
import static android.support.v7.appcompat.R.attr.title;

public class OrderActivity extends AppCompatActivity {
    private OrderActivityClass ordername;
    private OrderActivityClass orderquantity;
    //private DatabaseReference mDatabase;
    private ArrayList<OrderActivity> userCourseDetailsesList;
    private EditText mOrdername;
    private EditText mOrderquantity;
    private Button mOrderButton;
    private DatabaseReference mFirebaseDatabaseReference;
    private DatabaseReference mDatabase;
    private static final String TAG = SingInActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Button button = (Button)findViewById(R.id.orderButton);
        button.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                //do your fancy method

            }

        });

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference("");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("orderactivityclass");
        //String userId = mDatabase.push().getKey();
        String userId = mDatabase.push().getKey();

        //DatabaseReference pushedOrderActivityClassRef = OrderActivityClassRef.push();
        OrderActivityClass orderactivityclass = new OrderActivityClass("pizza",75);
        mDatabase.child(userId).setValue(orderactivityclass);
        mDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                OrderActivityClass orderActivityClass1 = dataSnapshot.getValue(OrderActivityClass.class);
            assert orderActivityClass1 !=null;
                Log.d(TAG, " ordername: " + orderActivityClass1.getName() + ", quantity " + orderActivityClass1.getOrderquantity());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        String newName = "Pizza";

        mDatabase.child(userId).child("name").setValue(newName);




//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        mOrdername = (EditText)findViewById(R.id.Order_name);
//        mOrderquantity = (EditText)findViewById(R.id.Order_quantity);
//        mOrderButton = (Button)findViewById(R.id.orderButton);

        //DatabaseReference mRef = mDatabase.getReference("orderquantity");

        //mRef.setValue("©2016 androidhive. All rights Reserved");

    }


}
