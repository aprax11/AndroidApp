package com.example.androidapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidapp.R;
import com.example.androidapp.control.Control;
import com.example.androidapp.model.IParticipant;

import java.util.ArrayList;
import java.util.List;

public class ChallengeActivity extends AppCompatActivity {
    EditText addParticipationName;
    EditText addParticipationScore;
    ListView participantsListView;
    TextView descriptionTextView;
    TextView nameTextView;
    String id;
    ArrayList<IParticipant> participantList;
    Control control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        control = new Control();

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        id = getIntent().getStringExtra("ID");
        participantList = (ArrayList<IParticipant>) getIntent().getSerializableExtra("PARTICIPANTLIST");

        nameTextView = findViewById(R.id.Name);
        descriptionTextView = findViewById(R.id.Description);
        participantsListView = findViewById(R.id.ParticipantsList);
        addParticipationName = (EditText) findViewById(R.id.addParticipationName);
        addParticipationScore = (EditText) findViewById(R.id.addParticipationScore);



        setParticipantList(participantList);
        nameTextView.setText(name);
        descriptionTextView.setText(description);

    }
    public void onSubmitParticipation(View view){
        String addParticipantName = this.addParticipationName.getText().toString();
        String addParticipantScore= this.addParticipationScore.getText().toString();

        Control control = new Control();

        String ret = control.addParticipation(addParticipantName, addParticipantScore, id);
        if(ret.equals("1")){
            finish();
        }else{
            ret = "Error";
        }
    }
    public void setParticipantList(ArrayList<IParticipant> participantList){
        ParticipantAdapter participantAdapter = new ParticipantAdapter(this, participantList);
        participantsListView.setAdapter(participantAdapter);
    }
}