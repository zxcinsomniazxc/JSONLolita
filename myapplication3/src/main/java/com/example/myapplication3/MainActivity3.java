package com.example.myapplication3;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final ListView listView = (ListView)findViewById(R.id.ListView);
        /***
         * Sample JSON Code ***'
         [{
         "MemberID":"1",
         "Name":"Елена",
         "Tel":"4954876107"
         },
         {
         "MemberID":"2",
         "Name":"Сергей",
         "Tel":"4954780121"
         },
         {
         "MemberID":"3",
         "Name":"Витюша",
         "Tel":"4954543211"
         }]
         */
        String rawJSON = "[{\"MemberID\":\"1\",\"Name\":\"Елена\",\"Tel\":\"4954876107\"}"
                + ",{\"MemberID\":\"2\",\"Name\":\"Сергей\",\"Tel\":\"4954780121\"}"
                + ",{\"MemberID\":\"3\",\"Name\":\"Витя\",\"Tel\":\"4954543211\"}]";
        try {
            JSONArray data = new JSONArray(rawJSON);
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            HashMap<String, String> map;
            for (int i = 0; i < data.length(); i++)
            {
                JSONObject jsonObject = data.getJSONObject(i);
                map = new HashMap<>();
                map.put("MemberID", jsonObject.getString("MemberID"));
                map.put("Name", jsonObject.getString("Name"));
                map.put("Tel", jsonObject.getString("Tel"));
                arrayList.add(map);
            }
            SimpleAdapter simpleAdapter;
            simpleAdapter = new SimpleAdapter(this, arrayList,
                    R.layout.list_item, new String[]{"MemberID",
                    "Name", "Tel"}, new int[]{R.id.item_textViewMemberID,
                    R.id.item_textViewName, R.id.item_textViewNumber});
            listView.setAdapter(simpleAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}