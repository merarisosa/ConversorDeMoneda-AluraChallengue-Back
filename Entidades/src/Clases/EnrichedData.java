package Clases;

import java.util.Map;

public class EnrichedData extends ExchangeRate{
   private String target_code;
   private double conversion_rate;
   private Map<String, String> target_data;

    public EnrichedData(String result, String documentation, String terms_of_use, long time_last_update_unix, String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String base_code) {
        super(result, documentation, terms_of_use, time_last_update_unix, time_last_update_utc, time_next_update_unix, time_next_update_utc, base_code);
    }

    public EnrichedData(String result, String documentation, String terms_of_use, long time_last_update_unix, String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String base_code, String target_code, double conversion_rate, Map<String, String> target_data) {
        super(result, documentation, terms_of_use, time_last_update_unix, time_last_update_utc, time_next_update_unix, time_next_update_utc, base_code);
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.target_data = target_data;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public Map<String, String> getTarget_data() {
        return target_data;
    }

    public void setTarget_data(Map<String, String> target_data) {
        this.target_data = target_data;
    }

    @Override
    public String toString() {
        return "EnrichedData{" +
                "target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", target_data=" + target_data +
                ", result='" + result + '\'' +
               // ", documentation='" + documentation + '\'' +
               // ", terms_of_use='" + terms_of_use + '\'' +
               // ", time_last_update_unix=" + time_last_update_unix +
               // ", time_last_update_utc='" + time_last_update_utc + '\'' +
               // ", time_next_update_unix=" + time_next_update_unix +
               // ", time_next_update_utc='" + time_next_update_utc + '\'' +
                ", base_code='" + base_code + '\'' +
                '}';
    }
}
