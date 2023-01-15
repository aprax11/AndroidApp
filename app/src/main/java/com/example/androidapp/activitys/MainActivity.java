package com.example.androidapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidapp.R;
import com.example.androidapp.model.Model;
import com.example.androidapp.model.IModel;
import com.example.androidapp.containers.IChallenge;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button searchFormButton;
    IModel model;
    List<IChallenge> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);

        model = new Model();

        setListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(MainActivity.this, ChallengeActivity.class);
                model = new Model();
                intent.putExtra("ID", list.get(position).getId());
                intent.putExtra("CONTROL", model);
                startActivity(intent);
            }
        });

        searchFormButton = (Button) findViewById(R.id.buttonSearchForm);
        searchFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchFormActivity();
            }
        });

    }
        public void openSearchFormActivity() {


            Intent intent = new Intent(this, AddChallengeForm.class );

            model = new Model();
            intent.putExtra("CONTROL", model);
            startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();

        setListView();
    }
    private void setListView(){
        ListView listView = findViewById(R.id.listview);
        list = model.getAll();

        ChallengeAdapter challengeAdapter = new ChallengeAdapter(this, list);

        listView.setAdapter(challengeAdapter);
    }
}