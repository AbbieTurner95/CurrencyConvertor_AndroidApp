package android.example.com.ratescurrencyapp;

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

/**
 * Created by Abbie on 29/01/2018.
 */

public class CurrencyRatesJSON {


   /* public void loadCurrencyRates(){

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
                                Rate rate = new Rate(key, ratesJSON.getDouble(key));
                                currency.addRate(rate);
                            }

                            ArrayList<Rate> rates = currency.getRates();
                            mAdapter.updateData(rates);

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
    }*/

}
