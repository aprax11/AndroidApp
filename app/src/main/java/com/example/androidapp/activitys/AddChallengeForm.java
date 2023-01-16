package com.example.androidapp.activitys;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.androidapp.R;
import com.example.androidapp.model.IModel;
import com.example.androidapp.model.Model;

public class AddChallengeForm extends AppCompatActivity {
    IModel model = Model.getInstance();
    EditText challengeName;
    EditText challengeDescription;

    String mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_form);

        mode = getIntent().getStringExtra("MODE");

        challengeName = (EditText) findViewById(R.id.challengeName);
        challengeDescription = (EditText) findViewById(R.id.challengeDescription);
        
    }

        public void onAddChallenge(View view){
        String challengeName = this.challengeName.getText().toString();
        String challengeDescription = this.challengeDescription.getText().toString();

        if(mode.equals("run")){
            model.addChallenge(challengeName, challengeDescription);
        }

        finish();
    }
}