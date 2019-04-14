package com.example.random;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Studentlogin extends AppCompatActivity {
    private Button test; private Button log;
    EditText editTextp,editTextPa;
    FirebaseAuth mAuth1;


    private void userlogin()
    {
        final String rollno = editTextp .getText().toString().trim();
        final String password=editTextPa.getText().toString().trim();



        FirebaseDatabase.getInstance().getReference().child("info")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Info user = snapshot.getValue(Info.class);
                            if(user.rollno2.equals(rollno) && user.p.equals(password) && user.branch.equals("CSE"))
                            {
                                FirebaseDatabase.getInstance().getReference().child("info2")
                                        .addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                    Info2 user = snapshot.getValue(Info2.class);
                                                    if(user.rollno.equals(rollno) )
                                                    {
                                                        String rollno231;
                                                        String name1;
                                                        String email1;
                                                        String branch1;
                                                        String dsm1;
                                                        String adem1;
                                                        String oopsm1;
                                                        String mm1;
                                                        String dbmsm1;


                                                        rollno231=user.rollno;
                                                         name1=user.name;
                                                       email1=user.email;
                                                        branch1=user.branch;
                                                        dsm1=user.dsm;
                                                         adem1=user.adem;
                                                        oopsm1=user.oopsm;
                                                      mm1=user.mm;
                                                         dbmsm1=user.dbmsm;

                                                        Intent i = new Intent(Studentlogin.this, StudentProfileActivity.class);
                                                        i.putExtra("Roll no",rollno231);
                                                        i.putExtra("email",email1);
                                                        i.putExtra("name",name1);
                                                        i.putExtra("branch",branch1);
                                                        i.putExtra("dsm",dsm1);
                                                        i.putExtra("mm",mm1);
                                                        i.putExtra("oopsm",oopsm1);
                                                        i.putExtra("adem",adem1);
                                                        i.putExtra("dbmsm",dbmsm1);
                                                        Intent j = new Intent(Studentlogin.this, toto.class);

                                                        startActivity(i);
                                                    }
                                                }
                                            }
                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {
                                            }
                                        });


                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);


        log=(Button)findViewById(R.id.button4);


        editTextp=(EditText)findViewById(R.id.editText5);
        editTextPa=(EditText)findViewById(R.id.editText3);

        FirebaseApp.initializeApp(this);
        mAuth1=FirebaseAuth.getInstance();



        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userlogin();
            }
        });


    }

}

