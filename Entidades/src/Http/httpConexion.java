package Http;

import Clases.EnrichedData;
import Dao.ExchangeRateDao;

import java.io.IOException;
import java.util.Scanner;

public class httpConexion {
    public static Scanner sc =  new Scanner(System.in);
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("********************************************************************************");
            System.out.println("1. Conversión de tipo de cambio de su moneda base a otra:");
            System.out.println("2. Conversión de tipo de cambio de moneda base a otra según una cantidad:");
            System.out.println("3. Conocer tipos de cambio de moneda base a todas las demás monedas admitidas");
            System.out.println("4. Conocer información adicional de las divisas de cambio");
            System.out.println("5. Conocer tasas de cambio para fechas específicas");
            System.out.println("6. Salir");
            System.out.println("********************************************************************************");
            System.out.println("Teclee la opción deseada: ");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("CONSULTAR DE TIPO DE CAMBIO");
                    getPairConversion();
                    break;
                case 2:
                    System.out.println("CONSULTAR TIPO DE CAMBIO SEGÚN UN MONTO");
                    getPairConversionAmount();
                    break;
                case 3:
                    System.out.println("CONOCER TIPOS DE CAMBIO DE DIVISAS DISPONIBLES");
                    getStandardResponse();
                    break;
                case 4:
                    System.out.println("INFORMACIÓN ADICIONAL ENTRE DIVISAS DE CAMBIO");
                    getEnrichedData();
                    break;
                case 5:
                    System.out.println("INFORMACIÓN DE TASAS DE CAMBIO SEGÚN FECHAS");
                    getHistoricalData();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no reconocida");
            }
        }
    }

    public static void getPairConversionAmount(){
        System.out.println("Especifique cual es su moneda base: ");
        String base_code = sc.nextLine();
        System.out.println("Especifique a qué tipo de divisa desea convertir: ");
        String target_code = sc.nextLine();
        System.out.println("Especifique la cantidad en " +base_code+ " que desea convertir: ");
        double amount = sc.nextDouble();

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.pairConversionAmount(base_code, target_code, amount));
    }

    public static void getPairConversion(){
        System.out.println("Especifique cual es su moneda base: ");
        String base_code = sc.nextLine();
        System.out.println("Especifique a qué tipo de divisa desea convertir: ");
        String target_code = sc.nextLine();

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.pairConversion(base_code, target_code));
    }

    //NO JALA
    public static void getStandardResponse(){
        System.out.println("Especifique cual es su moneda base: ");
        String base_code = sc.nextLine();

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.standardResponse(base_code));
    }

    //NO JALA
    public static void getEnrichedData(){
        System.out.println("Especifique cual es su moneda base: ");
        String base_code = sc.nextLine();
        System.out.println("Especifique el tipo de divisa a conocer: ");
        String target_code = sc.nextLine();

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.enrichedData(base_code, target_code));
    }

    public static void getHistoricalData(){
        System.out.println("Especifique cual es su moneda base: ");
        String base_code = sc.nextLine();
        System.out.println("Especifique el año: ");
        long year = sc.nextLong();
        System.out.println("Especifique el nes: ");
        int month = sc.nextInt();
        System.out.println("Especifique el día: ");
        int day = sc.nextInt();

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.historicalData(base_code, year, month, day));
    }
}
/*
ARS - Peso argentino
BOB - Boliviano boliviano
BRL - Real brasileño
CLP - Peso chileno
COP - Peso colombiano
USD - Dólar estadounidense


* Historial de Conversiones: Agrega la capacidad de rastrear y mostrar el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.
Soporte para Más Monedas: Amplía la lista de monedas disponibles para la elección, permitiendo a los usuarios convertir entre una variedad aún mayor de opciones monetarias.
Registros con Marca de Tiempo: Utiliza las funciones de la biblioteca java.time para crear registros que registren las conversiones realizadas, incluyendo información sobre qué monedas se convirtieron y en qué momento.
* */