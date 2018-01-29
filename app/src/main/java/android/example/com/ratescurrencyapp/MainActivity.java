package android.example.com.ratescurrencyapp;

import android.content.Context;
import android.example.com.ratescurrencyapp.RatesAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity implements RatesAdapter.RateClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;
    private RatesAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        // Define a layout for RecyclerView
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new RatesAdapter(this, this);

        // Set the adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onRateItemClick(Rate rate){
        Log.d(TAG, "onRateItemClick: " + rate.toString());
    }
}