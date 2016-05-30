package com.example.lpratt.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MeetupsCreateEditActivity extends AppCompatActivity {

    EditText loc;
    EditText date;
    Spinner importance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState.getString("mode").equals("create")) {
            setTitle("Meetups: Create Meetup");
        } else if (savedInstanceState.getString("mode").equals("Edit")) {
            setTitle("Meetups: Edit Meetup");
        }

        setContentView(R.layout.activity_meetups_create_edit);
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
        String importanceText = (String) importance.getSelectedItem();

    }
}
