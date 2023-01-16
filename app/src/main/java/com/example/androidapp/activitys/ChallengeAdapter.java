package com.example.androidapp.activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidapp.R;
import com.example.androidapp.containers.IChallenge;

import java.util.List;

public class ChallengeAdapter extends ArrayAdapter<IChallenge> {

    public ChallengeAdapter(@NonNull Context context, List<IChallenge> challengesList) {
        super(context, 0,  challengesList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        IChallenge challenge = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_challenge_list_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.ChallengeListItemName);

        TextView tvDescription = (TextView) convertView.findViewById(R.id.challengeListItemDescription);
        // Populate the data into the template view using the data object
        tvName.setText(challenge.getName());

        tvDescription.setText(challenge.getDescription());
        // Return the completed view to render on screen
        return convertView;
    }



}
