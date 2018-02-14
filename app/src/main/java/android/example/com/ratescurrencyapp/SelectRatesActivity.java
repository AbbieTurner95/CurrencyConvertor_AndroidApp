package android.example.com.ratescurrencyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.greenrobot.eventbus.EventBus;

public class SelectRatesActivity extends AppCompatActivity implements SelectRatesFragment.OnRateSelectedListener{
    public static final String CURRENCY_EXTRA_KEY = "currencyToConvertExtraKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_rates);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onRateSelected(String currencyToConvert) {
        Intent intent = new Intent(SelectRatesActivity.this, MainActivity.class);
        intent.putExtra(CURRENCY_EXTRA_KEY, currencyToConvert);
        startActivity(intent);
    }
}