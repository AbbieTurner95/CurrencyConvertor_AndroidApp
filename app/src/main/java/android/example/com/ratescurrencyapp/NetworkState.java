package android.example.com.ratescurrencyapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import static android.net.ConnectivityManager.TYPE_WIFI;

public class NetworkState {

    public final static int TYPE_CONNECTED = 1;
    public final static int TYPE_NOT_CONNECTED = 0;

    public static int getConnectivityStatus(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()) {
            Log.d("NetworkStatus", "getConnectivityStatus: type=" + activeNetwork.getType() + ", connected?=" + activeNetwork.isConnected());
            return TYPE_CONNECTED;
        } else {
            return TYPE_NOT_CONNECTED;
        }
    }

}