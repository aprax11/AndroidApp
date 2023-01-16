package com.example.androidapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidapp.R;
import com.example.androidapp.containers.Challenge;
import com.example.androidapp.containers.IChallenge;
import com.example.androidapp.model.IModel;
import com.example.androidapp.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ChallengeOverviewActivity extends AppCompatActivity {

    Button searchFormButton;
    IModel model = Model.getInstance();
    List<IChallenge> list = new ArrayList<>();
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_over_view);

        ListView listView = findViewById(R.id.listview);

        mode = getIntent().getStringExtra("MODE");

        setListView(mode);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(ChallengeOverviewActivity.this, ChallengeActivity.class);
                intent.putExtra("ID", list.get(position).getId());
                intent.putExtra("MODE", "run");
                startActivity(intent);
            }
        });

        searchFormButton = (Button) findViewById(R.id.buttonSearchForm);
        searchFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddChallengeFormActivity();
            }
        });

    }
    public void openAddChallengeFormActivity() {

        Intent intent = new Intent(this, AddChallengeForm.class );
        intent.putExtra("MODE", "run");
        startActivity(intent);
    }

    public void onReload(View view){
        setListView(mode);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setListView(mode);
    }


    private void setListView(String mode){
        ListView listView = findViewById(R.id.listview);
        if(mode.equals("run")){
            list = model.getAll();
        }else{
            IChallenge testChallenge = new Challenge();
            testChallenge.setName("hardcodedTestChallenge");
            testChallenge.setDescription("hardcodedTestChallengeDescription");
            testChallenge.setId("1");
            list.add(testChallenge);
        }

        ChallengeAdapter challengeAdapter = new ChallengeAdapter(this, list);

        listView.setAdapter(challengeAdapter);
    }
}