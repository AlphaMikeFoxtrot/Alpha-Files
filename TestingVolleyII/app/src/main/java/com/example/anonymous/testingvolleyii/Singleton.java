package com.example.anonymous.testingvolleyii;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ANONYMOUS on 03-Sep-17.
 */

public class Singleton {

    private static Singleton mInstance;
    private static RequestQueue requestQueue;
    private static Context mContext;

    private Singleton(Context context){

        mContext = context;
        requestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue(){

        if(requestQueue == null){

            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());

        }

        return requestQueue;

    }

    public static synchronized Singleton getmInstance(Context context){

        if(mInstance == null){

            mInstance = new Singleton(context);

        }
        return mInstance;

    }

    public<T> void addToRequestQue(Request<T> request){

        requestQueue.add(request);

    }

}
