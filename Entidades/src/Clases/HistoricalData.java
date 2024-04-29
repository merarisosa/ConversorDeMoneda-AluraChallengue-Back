package Clases;

import java.util.Map;

public class HistoricalData extends ExchangeRate {

    private long year;
    private int month;
    private int day;
    private Map<String, Double> conversion_rates;

    public HistoricalData(String result, String documentation, String terms_of_use, long time_last_update_unix, String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String base_code) {
        super(result, documentation, terms_of_use, time_last_update_unix, time_last_update_utc, time_next_update_unix, time_next_update_utc, base_code);
    }

    public HistoricalData(String result, String documentation, String terms_of_use, long time_last_update_unix, String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String base_code, long year, int month, int day, Map<String, Double> conversion_rates) {
        super(result, documentation, terms_of_use, time_last_update_unix, time_last_update_utc, time_next_update_unix, time_next_update_utc, base_code);
        this.year = year;
        this.month = month;
        this.day = day;
        this.conversion_rates = conversion_rates;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    @Override
    public String toString() {
        return "Información de tasas de cambio por fecha" +
                "\n--> Status: " + result +
                "\n--> Año: " + year +
                "\n--> Mes: " + month +
                "\n--> Día: " + day +
                "\n--> Moneda base: " + base_code +
                "\n--> Tasa de cambio: " + conversion_rates ;
    }
}
