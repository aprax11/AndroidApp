package com.example.androidapp.activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidapp.R;
import com.example.androidapp.containers.IParticipant;

import java.util.List;

public class ParticipantAdapter extends ArrayAdapter<IParticipant> {

    public ParticipantAdapter(@NonNull Context context, List<IParticipant> participantList) {
        super(context, 0,  participantList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        IParticipant participant = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_paticipant_list_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.ParticipantListItemName);

        TextView tvDescription = (TextView) convertView.findViewById(R.id.challengeListItemDescription);
        // Populate the data into the template view using the data object
        tvName.setText(participant.getName());

        tvDescription.setText(participant.getScore());
        // Return the completed view to render on screen
        return convertView;
    }
}
