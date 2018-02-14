package android.example.com.ratescurrencyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NoConnectionFragment extends Fragment {
    public NoConnectionFragment() {
        // Required empty public constructor
    }

    public static NoConnectionFragment newInstance() {
        NoConnectionFragment fragment = new NoConnectionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_no_connection, container, false);
    }
}
