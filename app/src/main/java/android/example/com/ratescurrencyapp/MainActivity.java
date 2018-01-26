package android.example.com.ratescurrencyapp;

import android.content.Context;
import android.example.com.ratescurrencyapp.RatesAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity {

    private final static String JSON_URL = "https://api.fixer.io/latest";
    private Currency currency;
    private Context mContext;
    RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Rate> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        loadCurrencyRates();


        // Define a layout for RecyclerView
        mLayoutManager = new GridLayoutManager(mContext,3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new RatesAdapter(mContext,arrayList);

        // Set the adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }

    public void loadCurrencyRates(){

        final StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject currency_obj = new JSONObject(response);
                            currency = new Currency(currency_obj.getString("base"), currency_obj.getString("date"));

                            JSONObject ratesJSON = currency_obj.getJSONObject("rates");
                            Iterator<String> keys = ratesJSON.keys();
                            while (keys.hasNext()){
                                String key = keys.next();
                                currency.addRate(new Rate(key, ratesJSON.getDouble(key)));
                            }

                            RatesAdapter adapter = new RatesAdapter(mContext, arrayList);
                            arrayList = currency.getRates();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}