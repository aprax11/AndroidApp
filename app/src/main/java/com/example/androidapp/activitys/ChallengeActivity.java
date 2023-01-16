package com.example.androidapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.androidapp.R;
import com.example.androidapp.containers.Participant;
import com.example.androidapp.model.IModel;
import com.example.androidapp.model.Model;
import com.example.androidapp.containers.IParticipant;

import java.util.ArrayList;

public class ChallengeActivity extends AppCompatActivity {
    EditText addParticipationName;
    EditText addParticipationScore;
    ListView participantsListView;
    String id;
    String mode;
    ArrayList<IParticipant> participantList = new ArrayList<>();
    IModel model = Model.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);


        id = getIntent().getStringExtra("ID");
        mode = getIntent().getStringExtra("MODE");

        participantsListView = findViewById(R.id.ParticipantsList);
        addParticipationName = (EditText) findViewById(R.id.addParticipationName);
        addParticipationScore = (EditText) findViewById(R.id.addParticipationScore);

        setParticipantList(mode);
    }
    public void onSubmitParticipation(View view){
        String addParticipantName = this.addParticipationName.getText().toString();
        String addParticipantScore= this.addParticipationScore.getText().toString();

        if(mode.equals("run")){
            String ret = model.addParticipation(addParticipantName, addParticipantScore, id);
        }
        finish();
    }
    public void setParticipantList(String mode){

        if(mode.equals("run")){
            participantList = model.getParticipants(id);
        }else{
            IParticipant testParticipant = new Participant();
            testParticipant.setName("hardCodedTestParticipant");
            testParticipant.setScore("10");

            participantList.add(testParticipant);
        }
        ParticipantAdapter participantAdapter = new ParticipantAdapter(this, participantList);
        participantsListView.setAdapter(participantAdapter);
    }
}