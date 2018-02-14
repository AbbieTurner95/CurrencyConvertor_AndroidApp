package android.example.com.ratescurrencyapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SelectRatesActivity extends AppCompatActivity implements SelectRatesFragment.OnRateSelectedListener{
    public static final String CURRENCY_EXTRA_KEY = "currencyToConvertExtraKey";

    private NetworkStateReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_rates);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.selectBaseActivity, SelectRatesFragment.newInstance())
                .commit();

    }



    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(android.net.ConnectivityManager.CONNECTIVITY_ACTION); //filter so broad-reciv only picks up this
        registerReceiver(receiver, filter);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        if (receiver!=null) {
            unregisterReceiver(receiver);
        }
        super.onStop();
    }

    @Override
    public void onRateSelected(String currencyToConvert) {
        Intent intent = new Intent(SelectRatesActivity.this, MainActivity.class);
        intent.putExtra(CURRENCY_EXTRA_KEY, currencyToConvert);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //select fragment based on connection levels
    public void onEvent(NetworkStateEvent event) {
        int state = event.getNetworkState();
        switch (state) {
            case NetworkState.TYPE_NOT_CONNECTED:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.selectBaseActivity, NoConnectionFragment.newInstance())
                        .commit();
                break;
            case NetworkState.TYPE_CONNECTED:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.selectBaseActivity, SelectRatesFragment.newInstance())
                        .commit();
                break;
        }
    }
}