package android.example.com.ratescurrencyapp;



public class SpinnerData {
    String rates_text;
    Integer flag_images;

    public SpinnerData(String rates_text, Integer flag_images){
        this.rates_text = rates_text;
        this.flag_images = flag_images;
    }

    public String getText(){
        return rates_text;
    }

    public Integer getImageId(){
        return flag_images;
    }
}
