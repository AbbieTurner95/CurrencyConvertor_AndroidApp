package android.example.com.ratescurrencyapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Rate implements Parcelable {
    private String symbol;
    private double rate;

    public Rate(){
    }

    public Rate(String symbol, double rate){
        this.symbol = symbol;
        this.rate = rate;

    }

    protected Rate(Parcel in) {
        symbol = in.readString();
        rate = in.readDouble();
    }

    public static final Creator<Rate> CREATOR = new Creator<Rate>() {
        @Override
        public Rate createFromParcel(Parcel in) {
            return new Rate(in);
        }

        @Override
        public Rate[] newArray(int size) {
            return new Rate[size];
        }
    };


    public String getSymbol(){
        return symbol;
    }

    public double getRate(){
        return rate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(symbol);
        parcel.writeDouble(rate);
    }
}
