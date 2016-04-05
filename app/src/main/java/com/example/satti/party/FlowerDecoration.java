package com.example.satti.party;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class FlowerDecoration extends Fragment{

    public FlowerDecoration(){
        // Required empty public constructor
    }

    List<ParseObject> score;
    protected View v;
    protected ListView list;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_flower_decoration, container, false);

        list = (ListView) v.findViewById(R.id.listView1);

        ParseQuery query = ParseQuery.getQuery("flowers");
        query.findInBackground(new FindCallback<ParseObject>() {
                                   public void done(List<ParseObject> scoreList, ParseException e) {
                                       if (e == null) {
                                           FlowerDecoration.this.list.setAdapter(new CustomAdapter(v.getContext(), scoreList));

                                       } else {
                                           Log.v("score", "Error: " + e.getMessage());
                                       }

                                   }
                               }
        );
        return v;
    }
}
