package com.example.anonymous.testingvolleyii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button showData;
    TextView name, email, phone;

    String json_url = "http://192.168.0.102/caffeineTrackerConn.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showData = (Button) findViewById(R.id.showData);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, json_url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    Toast.makeText(MainActivity.this, " " + response, Toast.LENGTH_LONG).show();
                                    name.setText(response.getString("name"));
                                    email.setText(response.getString("email_id"));
                                    phone.setText(response.getString("phone_no"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Toast.makeText(MainActivity.this, "SOMETHING WENT WRONG" + error, Toast.LENGTH_LONG).show();
                                error.getStackTrace();

                            }
                        });

                Singleton.getmInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);

            }
        });
    }
}
