package com.example.satti.party;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeoutException;


public class Venues extends Fragment {
//private String s="";
private  TextView set;
    public Venues()
    {
        // Required empty public constructor
    }
    List<ParseObject> score;
    protected View v;
    protected ListView list;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_venues, container, false);

        list = (ListView) v.findViewById(R.id.listView1);

        ParseQuery query = ParseQuery.getQuery("venues");
        query.findInBackground(new FindCallback<ParseObject>() {
                                   public void done(List<ParseObject> scoreList, ParseException e) {
                                       if (e == null) {
                                           Venues.this.list.setAdapter(new CustomAdapter(v.getContext(), scoreList));

                                       } else {
                                           Log.v("score", "Error: " + e.getMessage());
                                       }

                                   }
                               }
        );
        return v;
    }
}
