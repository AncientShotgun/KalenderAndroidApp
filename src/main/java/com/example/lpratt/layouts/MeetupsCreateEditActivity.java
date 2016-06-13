package com.example.lpratt.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MeetupsCreateEditActivity extends AppCompatActivity {

    EditText loc;
    EditText date;
    EditText desc;
    Spinner importance;
    Button collect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetups_create_edit);
        loc = (EditText)findViewById(R.id.editText_loc);
        date = (EditText)findViewById(R.id.editText_date);
        importance = (Spinner)findViewById(R.id.spinner_importance);
        desc =(EditText)findViewById(R.id.editText_desc);
        collect =(Button)findViewById(R.id.button_collect);

        if (savedInstanceState.getString("mode").equals("create")) {
            setTitle("Meetups: Create Meetup");
            collect.setText(R.string.button_create);
        } else if (savedInstanceState.getString("mode").equals("Edit")) {
            setTitle("Meetups: Edit Meetup");
            collect.setText(R.string.button_edit);
        } else{
            setTitle("Meetups: Debug Mode");
            collect.setText(R.string.button_debug);
        }

        ArrayList<String> importanceList = new ArrayList<>();
        importanceList.add("Unimportant");
        importanceList.add("Important");
        importanceList.add("Very Important");
        ArrayAdapter<String> importanceText = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, importanceList);
        importance.setAdapter(importanceText);

    }

    public void onClickCollectData(View view) {

        String locText = loc.getText().toString();
        String dateText = date.getText().toString();
        String descText = desc.getText().toString();
        String importanceText = (String) importance.getSelectedItem();
        Bundle result = new Bundle();
        result.putString("loc",locText);
        result.putString("date",dateText);
        result.putString("desc",descText);
        result.putString("importance",importanceText);

    }
}
