package com.example.androidapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidapp.R;
import com.example.androidapp.control.Control;
import com.example.androidapp.control.Network;
import com.example.androidapp.model.IChallenge;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button searchFormButton;
    Control control;
    List<IChallenge> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);

        control = new Control();

        setListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(MainActivity.this, ChallengeActivity.class);
                control = new Control();
                intent.putExtra("ID", list.get(position).getId());
                intent.putExtra("CONTROL", control);
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


            Intent intent = new Intent(this, SearchForm.class );

            control = new Control();
            intent.putExtra("CONTROL", control);
            startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();

        setListView();
    }
    private void setListView(){
        ListView listView = findViewById(R.id.listview);
        list = control.getAll(new Network());

        ChallengeAdapter challengeAdapter = new ChallengeAdapter(this, list);

        listView.setAdapter(challengeAdapter);
    }
}