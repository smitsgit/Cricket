package com.cricket.material.cricket;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cricket.material.cricket.TeamInfo.Team;
import com.cricket.material.cricket.TeamInfo.TeamInfo;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.List;

/**
 * Created by smitald on 9/9/2015.
 */
public class TeamInfoAdapter extends ArrayAdapter<Team> implements ValueEventListener {

    private final String LOG_TAG = ScoresAdapter.class.getSimpleName();
    private Firebase mRef;

    public TeamInfoAdapter(Context context) {
        super(context, 0);
        Firebase.setAndroidContext(context);
        mRef = new Firebase("https://coolapi.firebaseio.com/teaminfo");
        mRef.addValueEventListener(this);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Team team = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.teaminfo_item, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.team_title);
        title.setText(team.getTeamName());
        TextView shortname = (TextView) convertView.findViewById(R.id.team_shortname);
        shortname.setText(team.getShortName());
        TextView captain = (TextView) convertView.findViewById(R.id.team_captain);
        captain.setText(team.getCaptain());
        return convertView;
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Log.d(LOG_TAG, "onDataChange ");
        TeamInfo teamInfo = dataSnapshot.getValue(TeamInfo.class);
        List<Team> teams = teamInfo.getTeam();
        for (Team team : teams) {
            add(team);
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}
