package com.example.aayushsinha.notice;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DisplayLast extends AppCompatActivity {
ListView lv;
    ArrayAdapter<String> adapter;
    String address="http://192.168.43.201/webapp/GetData2.php";
    InputStream is = null;
    String line = null;
    String result=null;
    String[] data;
    String[] mytime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_last);

        lv = (ListView) findViewById(R.id.listView11);

        //for allowing network in the main thread
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        // retrieve
         getData();

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        lv.setAdapter(adapter);

    }

    private void getData()
    {
        try {
            URL url = new URL(address);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            is=new BufferedInputStream(con.getInputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //reading is content into string
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb= new StringBuilder();

            while((line=br.readLine()) !=  null){
                sb.append(line+"\n");
            }

            is.close();
            result=sb.toString();

        }
        catch (Exception e){
            e.printStackTrace();
        }

        //parse json data
        try{
            JSONArray ja = new JSONArray(result);
            JSONObject jo=null;

            data=new String[ja.length()];
            mytime=new String[ja.length()];
           // condata=new String[2*ja.length()];

            for(int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);
                data[i]=jo.getString("msg");
                mytime[i]=jo.getString("timestamp");
                data[i]=data[i].concat(" ");
                data[i]=data[i].concat(mytime[i]);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
