package com.example.androidapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.androidapp.R;
import com.example.androidapp.model.IModel;
import com.example.androidapp.model.Model;
import com.example.androidapp.containers.IChallenge;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button searchFormButton;
    IModel model = Model.getInstance();
    List<IChallenge> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        searchFormButton = (Button) findViewById(R.id.continueButton);
        searchFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchFormActivity();
            }
        });

    }
        public void openSearchFormActivity() {


            Intent intent = new Intent(this, ChallengeOverviewActivity.class );
            intent.putExtra("MODE", "run");
            startActivity(intent);
    }


}