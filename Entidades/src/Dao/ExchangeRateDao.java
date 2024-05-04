package Dao;

import Clases.EnrichedData;
import Clases.HistoricalData;
import Clases.PairConversion;
import Clases.StandardResponse;
import Enums.AvailableCoin;
import Enums.Conversions;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateDao {

    public String consumeAPI(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String jsonFile = response.body();
        //System.out.println("Body del API Request: " + jsonFile);
        return jsonFile;
    }

    public PairConversion pairConversionAmount(String base_code, String target_code, double amount) {
        String url = "https://v6.exchangerate-api.com/v6/7d9e702bed562b64f1b90f05/pair/" + base_code + "/" + target_code + "/" + amount;
        Gson gson = new Gson();
        PairConversion erConsumeAPI = null;
        try {
            erConsumeAPI = gson.fromJson(consumeAPI(url), PairConversion.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(erConsumeAPI.toString());
        return erConsumeAPI;
    }

    public PairConversion pairConversion(String base_code, String target_code) {
        String url = "https://v6.exchangerate-api.com/v6/7d9e702bed562b64f1b90f05/pair/" + base_code + "/" + target_code;
        Gson gson = new Gson();
        PairConversion erConsumeAPI = null;
        try {
            erConsumeAPI = gson.fromJson(consumeAPI(url), PairConversion.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nTasa de cambio de "+base_code.toUpperCase()+" a "+target_code.toUpperCase()+ "...");
       // System.out.println("--> Cantidad: " + amount + " "+base_code);
        System.out.println(erConsumeAPI.toStringNoAmount());
        return erConsumeAPI;
    }

    public StandardResponse standardResponse(String base_code) {
        String url = "https://v6.exchangerate-api.com/v6/7d9e702bed562b64f1b90f05/latest/" + base_code;
        Gson gson = new Gson();
        StandardResponse erConsumeAPI = null;
        try {
            erConsumeAPI = gson.fromJson(consumeAPI(url), StandardResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Converted to Object: " + erConsumeAPI);
        return erConsumeAPI;
    }

    public EnrichedData enrichedData(String base_code, String target_code){
        String url = "https://v6.exchangerate-api.com/v6/7d9e702bed562b64f1b90f05/enriched/" + base_code + "/" + target_code;
        Gson gson = new Gson();
        EnrichedData edConsumeAPI =  null;
        try {
            edConsumeAPI = gson.fromJson(consumeAPI(url), EnrichedData.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Converted to Object: " + edConsumeAPI.toString());
        return edConsumeAPI;
    }

    public HistoricalData historicalData(String base_code, long year, int month, int day){
        String url = "https://v6.exchangerate-api.com/v6/7d9e702bed562b64f1b90f05/history/"+base_code+"/"+year+"/"+month+"/"+day;
        Gson gson = new Gson();
        HistoricalData hdConsumeAPI =  null;
        try {
            hdConsumeAPI = gson.fromJson(consumeAPI(url), HistoricalData.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Converted to Object: " + hdConsumeAPI.toString());
        return hdConsumeAPI;
    }

    public static String showAllAvailableCoins(Enum<?>[] opciones) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < opciones.length; i++) {
            builder.append((i + 1)).append(". ").append(opciones[i]).append("\n");
        }
        return builder.toString();
    }

    public static List<Conversions>  showAllConversionsList (){
        List<Conversions> conversiones = new ArrayList<>();
        for (Conversions conversion : Conversions.values()) {
            conversiones.add(conversion);
        }
        return conversiones;
    }


}
