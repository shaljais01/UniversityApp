package com.example.random;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public  class CSEActivity extends AppCompatActivity {

    private EditText roll,name,branch,email,ds,ade,dbms,oops,maths;
    private Button adddata;
    DatabaseReference databaseinfo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);

        databaseinfo2= FirebaseDatabase.getInstance().getReference("info2");

        roll=(EditText)findViewById(R.id.editText_roll);
        name=(EditText)findViewById(R.id.editText_name);
        branch=(EditText)findViewById(R.id.editText_branch);
        email=(EditText)findViewById(R.id.editText_email);
        ds=(EditText)findViewById(R.id.editText_ds);
        ade=(EditText)findViewById(R.id.editText_ade);
        dbms=(EditText)findViewById(R.id.editText_dbms);
        oops=(EditText)findViewById(R.id.editText_oops);
        maths=(EditText)findViewById(R.id.editText_maths);
        adddata=(Button)findViewById(R.id.button_adddata);

        roll.setText(getIntent().getStringExtra("Roll no"));
        name.setText(getIntent().getStringExtra("name"));
        branch.setText(getIntent().getStringExtra("branch"));
        email.setText(getIntent().getStringExtra("email"));

        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                fill();
            }
        });

    }
    private void fill()
    {
        String rn = roll.getText().toString().trim();
        String ea = email.getText().toString().trim();
        String nam = name.getText().toString().trim();
        String brn = branch.getText().toString().trim();

        String dsm = ds.getText().toString().trim();
        String dbmsm = dbms.getText().toString().trim();
        String oopsm = oops.getText().toString().trim();
        String adem = ade.getText().toString().trim();
        String mm = maths.getText().toString().trim();



        if(!TextUtils.isEmpty(rn)){
            String roll=databaseinfo2.push().getKey();
            Info2 CSE=new Info2(rn,ea,nam,brn,dsm,dbmsm,oopsm,adem,mm);
            databaseinfo2.child(roll).setValue(CSE);

            Toast.makeText(this,"Info added",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"roll no required",Toast.LENGTH_SHORT).show();
        }

    }

}
