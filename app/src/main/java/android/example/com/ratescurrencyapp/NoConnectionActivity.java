package android.example.com.ratescurrencyapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NoConnectionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);


        /*new Handler().postDelayed(new Runnable() {
            public void run() {
                ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

                if (activeNetwork != null) {                                                    //check if connected to the internet
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        // connected to wifi
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        // check if connected to mobile data
                    }
                } else {                                                                        //if not connected start no internet page
                    Intent intent = new Intent(NoConnectionActivity.this, SelectRatesActivity.class);
                    startActivity(intent);
                }
            }
        }, 100);

    }*/

    }
}
