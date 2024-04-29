package Clases;

public class PairConversion extends ExchangeRate{
    private String target_code;
    private double conversion_rate;
    private double conversion_result;

    public PairConversion(String result, String documentation, String terms_of_use, long time_last_update_unix, String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String base_code) {
        super(result, documentation, terms_of_use, time_last_update_unix, time_last_update_utc, time_next_update_unix, time_next_update_utc, base_code);
    }

    public PairConversion(String result, String documentation, String terms_of_use, long time_last_update_unix, String time_last_update_utc, long time_next_update_unix, String time_next_update_utc, String base_code, String target_code, double conversion_rate, double conversion_result) {
        super(result, documentation, terms_of_use, time_last_update_unix, time_last_update_utc, time_next_update_unix, time_next_update_utc, base_code);
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
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

    public double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return "PairConversion{" +
                "target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", conversion_result=" + conversion_result +
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

    public String toStringNoAmount() {
        return "PairConversion{" +
                "target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
               // ", conversion_result=" + conversion_result +
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
