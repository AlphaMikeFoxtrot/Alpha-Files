package com.example.anonymous.sngregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        // EditText view class variables :
        EditText et_name = (EditText) findViewById(R.id.nameET);
        EditText et_contact = (EditText) findViewById(R.id.contactET);
        EditText et_address = (EditText) findViewById(R.id.addressET);

        // Buttons view class variables :
        Button b_insert = (Button) findViewById(R.id.insert);
        Button b_update = (Button) findViewById(R.id.update);
        Button b_delete = (Button) findViewById(R.id.delete);

        // EditText view class variables :
        et_name = (EditText) findViewById(R.id.nameET);
        et_contact = (EditText) findViewById(R.id.contactET);

        // Volley class variable :
        // ****?**** //
        RequestQueue queue;

        // url :
        String url = "https://iamanonymous729.000webhostapp.com/testGet.php";
    }

    // creating 'send' function to interact with primary database :

    public void sendToDb(final String action){

        StringRequest stringReqObj = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            if (jsonObj.getString("status").equals("success")) {
                                Toast.makeText(getApplicationContext(), jsonObj.getString("message"), Toast.LENGTH_SHORT);
                            } else {
                                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {

        }
        }

    }
}
