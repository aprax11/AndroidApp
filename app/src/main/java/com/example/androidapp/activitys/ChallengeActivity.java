package com.example.androidapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.androidapp.R;
import com.example.androidapp.model.Control;
import com.example.androidapp.model.IControl;
import com.example.androidapp.model.Network;
import com.example.androidapp.containers.IParticipant;

import java.util.ArrayList;

public class ChallengeActivity extends AppCompatActivity {
    EditText addParticipationName;
    EditText addParticipationScore;
    ListView participantsListView;
    String id;
    ArrayList<IParticipant> participantList;
    IControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);


        id = getIntent().getStringExtra("ID");
        control = (Control) getIntent().getSerializableExtra("CONTROL");

        participantsListView = findViewById(R.id.ParticipantsList);
        addParticipationName = (EditText) findViewById(R.id.addParticipationName);
        addParticipationScore = (EditText) findViewById(R.id.addParticipationScore);


        participantList = control.getParticipants(id, new Network());
        setParticipantList(participantList);


    }
    public void onSubmitParticipation(View view){
        String addParticipantName = this.addParticipationName.getText().toString();
        String addParticipantScore= this.addParticipationScore.getText().toString();

        String ret = control.addParticipation(addParticipantName, addParticipantScore, id, new Network());
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