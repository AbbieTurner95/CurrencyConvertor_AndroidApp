package android.example.com.ratescurrencyapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class SelectRatesFragment extends Fragment {

    public static final String CURRENCY_EXTRA_KEY = "currencyToConvertExtraKey";

    private OnRateSelectedListener mListener;

    public SelectRatesFragment() {
        // Required empty public constructor
    }

    public static SelectRatesFragment newInstance() {
        SelectRatesFragment fragment = new SelectRatesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<SpinnerData> list = new ArrayList<>();                           //populate spinner with currency rates and flags
        list.add(new SpinnerData(getString(R.string.select_string), null)); //hint
        list.add(new SpinnerData("USD", R.drawable.us));
        list.add(new SpinnerData("GBP", R.drawable.gb));
        list.add(new SpinnerData("AUD", R.drawable.au));
        list.add(new SpinnerData("BGN", R.drawable.bg));
        list.add(new SpinnerData("EUR", R.drawable.eu));
        list.add(new SpinnerData("BRL", R.drawable.br));
        list.add(new SpinnerData("CAD", R.drawable.ca));
        list.add(new SpinnerData("CHF", R.drawable.ch));
        list.add(new SpinnerData("CNY", R.drawable.cn));
        list.add(new SpinnerData("CZK", R.drawable.cz));
        list.add(new SpinnerData("DKK", R.drawable.dk));
        list.add(new SpinnerData("HKD", R.drawable.hk));
        list.add(new SpinnerData("HRK", R.drawable.hr));
        list.add(new SpinnerData("HUF", R.drawable.hu));
        list.add(new SpinnerData("IDR", R.drawable.id));
        list.add(new SpinnerData("ILS", R.drawable.il));
        list.add(new SpinnerData("INR", R.drawable.in));
        list.add(new SpinnerData("JPY", R.drawable.jp));
        list.add(new SpinnerData("KRW", R.drawable.kr));
        list.add(new SpinnerData("MXN", R.drawable.mx));
        list.add(new SpinnerData("MYR", R.drawable.my));
        list.add(new SpinnerData("NOK", R.drawable.no));
        list.add(new SpinnerData("NZD", R.drawable.nz));
        list.add(new SpinnerData("PHP", R.drawable.ph));
        list.add(new SpinnerData("PLN", R.drawable.pl));
        list.add(new SpinnerData("RON", R.drawable.ro));
        list.add(new SpinnerData("RUB", R.drawable.ru));
        list.add(new SpinnerData("SEK", R.drawable.se));
        list.add(new SpinnerData("SGD", R.drawable.sg));
        list.add(new SpinnerData("THB", R.drawable.th));
        list.add(new SpinnerData("TRY", R.drawable.tr));
        list.add(new SpinnerData("ZAR", R.drawable.za));

        final Spinner rateSpinner = getView().findViewById(R.id.rates_spinner);
        SpinnerAdapter adapter = new SpinnerAdapter(getActivity(), R.layout.spinner_layout, R.id.rates_text, list);
        rateSpinner.setAdapter(adapter);
        rateSpinner.setSelection(rateSpinner.getSelectedItemPosition(), false);

        rateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String currencyToConvert = ((SpinnerData) parentView.getItemAtPosition(position)).getText(); //get selected item from drop down

                if (position == 0) {          //check to see if user selects the hint if they do
                    return;                   //return
                }
                mListener.onRateSelected(currencyToConvert);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_rates, container, false);
    }

    @Override
    public void onAttach(Context context) { //check to see if instance of method is implemented
        super.onAttach(context);
        if (context instanceof OnRateSelectedListener) {
            mListener = (OnRateSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnRateSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnRateSelectedListener {
        void onRateSelected(String currencyToConvert);
    }
}
