package com.android.myalquran;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    DetailAdapter detailAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView turun = findViewById(R.id.turun);
        TextView arti = findViewById(R.id.arti);
        TextView ayat = findViewById(R.id.ayat);
        List<DetailModel> list = new ArrayList<DetailModel>();
        ListView listView = findViewById(R.id.list_item);

        Intent intent = getIntent();
        if (intent.hasExtra("no")){
            turun.setText(intent.getExtras().getString("turun"));
            arti.setText(intent.getExtras().getString("arti"));
            ayat.setText(intent.getExtras().getString("ayat")+" ayat");

            RequestQueue requestQueue = Volley.newRequestQueue(DetailActivity.this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://quran-api.santrikoding.com/api/surah/" + intent.getExtras().getString("no"), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonMain = new JSONObject(response);
                        JSONArray jsonArray = jsonMain.getJSONArray("ayat");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            list.add(new DetailModel(jsonObject.getString("nomor"), jsonObject.getString("ar"), jsonObject.getString("idn"), jsonObject.getString("audio")));
                        }
                        detailAdapter = new DetailAdapter(getApplicationContext(),R.layout.detail_surat,list);
                        listView.setAdapter(detailAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.getStackTrace();
                }
            });
            requestQueue.getCache().clear();
            requestQueue.add(stringRequest);
        }
    }
}