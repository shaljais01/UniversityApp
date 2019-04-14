package com.example.random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public  class AddResult extends AppCompatActivity {

    DatabaseReference databaseinfo;

    private EditText editText_rn,editText_ea,editText_name,editText_brn,editText_p;
    private Button button_add,button_em;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresult);

        databaseinfo= FirebaseDatabase.getInstance().getReference("info");

        editText_rn= (EditText) findViewById(R.id.editText_rn);
        editText_ea = (EditText) findViewById(R.id.editText_ea);
        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_brn= (EditText) findViewById(R.id.editText_brn);
        editText_p= (EditText) findViewById(R.id.editText_p);
        button_add = (Button) findViewById(R.id.button_add);
        button_em = (Button) findViewById(R.id.button_em);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                fill();
            }
        });

        button_em.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String branch=editText_brn.getText().toString().trim();
                String rollno=editText_rn.getText().toString().trim();
                String name=editText_name.getText().toString().trim();
                String email=editText_ea.getText().toString().trim();
                String CSE="CSE";
                if(branch.equals(CSE) )
                {
                    Intent i = new Intent(AddResult.this, CSEActivity.class);
                    i.putExtra("Roll no",rollno);
                    i.putExtra("name",name);
                    i.putExtra("branch",branch);
                    i.putExtra("email",email);
                    startActivity(i);
                }
               /* if(branch=="MAE")
                {
                    Intent i = new Intent(AddResult.this, MAEActivity.class);
                    i.putExtra("Roll no",rollno);
                    i.putExtra("name",name);
                    i.putExtra("branch",branch);
                    i.putExtra("email",email);
                    startActivity(i);
                }
                if(branch=="IT")
                {
                    Intent i = new Intent(AddResult.this, ITActivity.class);
                    i.putExtra("Roll no",rollno);
                    i.putExtra("name",name);
                    i.putExtra("branch",branch);
                    i.putExtra("email",email);
                    startActivity(i);
                }
                if(branch=="ECE")
                {
                    Intent i = new Intent(AddResult.this, ECEActivity.class);
                    i.putExtra("Roll no",rollno);
                    i.putExtra("name",name);
                    i.putExtra("branch",branch);
                    i.putExtra("email",email);
                    startActivity(i);
                }*/
            }
        });
    }

        private void fill()
        {
            String rn = editText_rn.getText().toString().trim();
            String rn2=rn;
            String ea = editText_ea.getText().toString().trim();
            String name = editText_name.getText().toString().trim();
            String brn = editText_brn.getText().toString().trim();
            String p=editText_p.getText().toString().trim();

            if(!TextUtils.isEmpty(rn)){
                String roll=databaseinfo.push().getKey();
               Info info=new Info(roll,ea,name,brn,p,rn2);
               databaseinfo.child(roll).setValue(info);

                Toast.makeText(this,"Info added",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"roll no required",Toast.LENGTH_SHORT).show();
            }

        }


}

