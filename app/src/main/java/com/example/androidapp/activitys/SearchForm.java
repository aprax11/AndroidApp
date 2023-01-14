package com.example.androidapp.activitys;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.androidapp.R;
import com.example.androidapp.control.Control;
import com.example.androidapp.control.Network;

public class SearchForm extends AppCompatActivity {
    Control control;
    EditText challengeName;
    EditText challengeDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_form);

        control = (Control) getIntent().getSerializableExtra("CONTROL");
        challengeName = (EditText) findViewById(R.id.challengeName);
        challengeDescription = (EditText) findViewById(R.id.challengeDescription);
        
    }

        public void onAddChallenge(View view){
        String challengeName = this.challengeName.getText().toString();
        String challengeDescription = this.challengeDescription.getText().toString();

        control.addChallenge(challengeName, challengeDescription, new Network());

        finish();
    }
}