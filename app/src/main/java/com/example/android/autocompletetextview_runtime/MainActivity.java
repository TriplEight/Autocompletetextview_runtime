package com.example.android.autocompletetextview_runtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> li;
    AutoCompleteTextView auto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li=new ArrayList<String>();
        li.add("Item 1");
        li.add("Item 2");
        li.add("Item 3");

        auto=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        final EditText et1=(EditText) findViewById(R.id.editText1);
        Button b1=(Button) findViewById(R.id.button1);

        add();

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                li.add(et1.getText().toString());
                et1.setText(null);

                add();

                Toast.makeText(getBaseContext(), "Item Added",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void add() {
        // TODO Auto-generated method stub

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,li);

        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        auto.setThreshold(1);
        auto.setAdapter(adp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
