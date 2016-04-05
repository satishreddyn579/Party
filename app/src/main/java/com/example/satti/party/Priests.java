package com.example.satti.party;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;


public class Priests extends Fragment {
    public Priests() {
    }
List<ParseObject> score;
    protected View v;
    protected ListView list;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_priests, container, false);

        list = (ListView) v.findViewById(R.id.listView1);

        ParseQuery query = ParseQuery.getQuery("priests");
        query.findInBackground(new FindCallback<ParseObject>() {
                                   public void done(List<ParseObject> scoreList, ParseException e) {
                                       if (e == null) {
                                           Priests.this.list.setAdapter(new CustomAdapter(v.getContext(), scoreList));

                                       } else {
                                           Log.v("score", "Error: " + e.getMessage());
                                       }

                                   }
                               }
        );
        return v;
    }
}