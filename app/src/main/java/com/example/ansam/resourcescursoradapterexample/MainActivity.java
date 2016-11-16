package com.example.ansam.resourcescursoradapterexample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    HelperDB helper;
    EditText name,email;
    String Name,Email;
    Button add,show;
    ListView list;
    ResourceAdapter adapter;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.etName);
        email=(EditText)findViewById(R.id.etEmail);
        add=(Button)findViewById(R.id.add);
        show=(Button)findViewById(R.id.show);
        list=(ListView)findViewById(R.id.listView);
        helper=new HelperDB(this);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name=name.getText().toString();
                Email=email.getText().toString();
                if(Name.equals("")||Email.equals("")){
                    Toast.makeText(getApplicationContext(),"please enter all fields!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean b= helper.insertStudent(Name,Email);
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                    name.setText("");
                    email.setText("");


                }

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=helper.getData();
                c.moveToFirst();
                if(c.getCount()>0) {
                    adapter = new ResourceAdapter(getApplicationContext(),R.layout.adapter_layout, c,0);
                }
                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);

            }


        });






    }
}
