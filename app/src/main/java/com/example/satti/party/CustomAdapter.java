package com.example.satti.party;

/**
 * Created by satti on 3/2/2016.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<ParseObject> {
    public CustomAdapter(Context context, List<ParseObject> list) {
        super(context,R.layout.acivity_priests1,list);
    }

protected ImageView imgc;
    protected Context context;
     protected View custom;
    protected  ParseObject i;
    @Override
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup){
        LayoutInflater inflate1 = LayoutInflater.from(getContext());
        custom = inflate1.inflate(R.layout.acivity_priests1, paramViewGroup, false);

         imgc = (ImageView)custom.findViewById(R.id.img);
        i = (ParseObject)getItem(paramInt);
        ParseFile img=(ParseFile)i.get("image");


        img.getDataInBackground(new GetDataCallback() {
            @Override
            public void done(byte[] bytes, ParseException e) {
                if (e==null){
                    Bitmap bit = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    imgc.setImageBitmap(bit);

                }else{
                    Log.v("byte", "Error: " + e.getMessage());
                }
            }
        });
        TextView name = (TextView)custom.findViewById(R.id.name);
        TextView city = (TextView)custom.findViewById(R.id.city);
        TextView phone = (TextView)custom.findViewById(R.id.phone);
        name.setText(i.getString("name"));
        city.setText(i.getString("city_name"));
        phone.setText(i.getString("phone_no"));

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(custom.getContext());
                builder.setTitle("Do you want to book ");
                builder.setMessage("Name:" + i.getString("name") + "\nContact No.:" + i.getString("phone_no")+"\n");
                builder.setCancelable(false);
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(custom.getContext(), "Releasing Shortly ", Toast.LENGTH_LONG).show();
                       //call();
                        /*Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                        sendIntent.setType("plain/text");
                        sendIntent.setData(Uri.parse(i.getParseObject("user").getString("email")));
                        sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                        sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{i.getParseObject("User").getString("email")});
                        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Intrested to buy");
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "This message is from user with above mail interested in booking your product :-)");
                        context.startActivity(sendIntent);*/

                    }

                   // private void call() {
                        /*Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("99999999999"));
                        try{
                            context.startActivity(in);
                        }

                        catch (android.content.ActivityNotFoundException ex){
                            Toast.makeText(custom.getContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
                        }
                    }*/
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return  custom;

    }
}
