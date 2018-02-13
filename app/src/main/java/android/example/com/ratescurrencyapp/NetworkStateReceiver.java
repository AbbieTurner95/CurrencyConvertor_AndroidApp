package android.example.com.ratescurrencyapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

public class NetworkStateReceiver extends BroadcastReceiver {
    private final EventBus eventBus = EventBus.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        int status = NetworkState.getConnectivityStatus(context);

        // Post the event with this line
        eventBus.post(new NetworkStateEvent(status));
    }
}