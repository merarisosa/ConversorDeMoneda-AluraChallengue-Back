package Clases;

import java.util.Map;

public class StandardResponse extends ExchangeRate{

    private Map<String, Double> conversionRates;

    public StandardResponse(String result, String documentation, String terms_of_use, long time_last_update_unix, String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String base_code) {
        super(result, documentation, terms_of_use, time_last_update_unix, time_last_update_utc, time_next_update_unix, time_next_update_utc, base_code);
    }

    public StandardResponse(String result, String documentation, String terms_of_use, long time_last_update_unix, String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String base_code, Map<String, Double> conversionRates) {
        super(result, documentation, terms_of_use, time_last_update_unix, time_last_update_utc, time_next_update_unix, time_next_update_utc, base_code);
        this.conversionRates = conversionRates;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversionRates = conversionRates;
    }

    @Override
    public String toString() {
        return "StandardResponse{" +
                ", conversionRates=" + conversionRates +
                ", result='" + result + '\'' +
              //  ", documentation='" + documentation + '\'' +
              //  ", terms_of_use='" + terms_of_use + '\'' +
              //  ", time_last_update_unix=" + time_last_update_unix +
               // ", time_last_update_utc='" + time_last_update_utc + '\'' +
               // ", time_next_update_unix=" + time_next_update_unix +
               // ", time_next_update_utc='" + time_next_update_utc + '\'' +
                ", base_code='" + base_code + '\'' +
                '}';
    }
}

