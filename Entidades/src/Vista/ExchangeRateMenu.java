package Vista;

import Clases.TransactionLogger;
import Dao.ExchangeRateDao;
import Enums.AvailableCoin;
import Enums.Conversions;

import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class ExchangeRateMenu {
    public static Scanner sc =  new Scanner(System.in);

    public void menuBienvenida(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("\nBIENVENIDO AL SISTEMA DE CONVERSOR DE MONEDAS");
            System.out.println("********************************************************************************");
            System.out.println("1. Conocer tasa de cambio:");
            System.out.println("2. Consultar conversion de divisa de un monto:");
            System.out.println("3. Conocer tipos de cambio de moneda base a todas las demás monedas admitidas");
            System.out.println("4. Conocer información adicional de las divisas de cambio");
            System.out.println("5. Conocer tasas de cambio para fechas específicas");
            System.out.println("6. Salir");
            System.out.println("********************************************************************************");
            System.out.println("Teclee la opción deseada: ");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nOpción 1. Conocer tasas de cambio");
                    getPairConversion();
                    break;
                case 2:
                    System.out.println("\nOpción 2. Consultar conversion de divisa de un monto");
                    getPairConversionAmount();
                    break;
                case 3:
                    System.out.println("\nOpción 3. Consulta el historial de transacciones");
                    getLogs();
                    break;
                case 4:
                    System.out.println("\nINFORMACIÓN ADICIONAL ENTRE DIVISAS DE CAMBIO");
                    getEnrichedData();
                    break;
                case 5:
                    System.out.println("\nINFORMACIÓN DE TASAS DE CAMBIO SEGÚN FECHAS");
                    getHistoricalData();
                    break;
                case 6:
                    salir = true;
                    System.out.println("\nGracias por utilizar el sistema de conversiones de Merr MS");
                    break;
                default:
                    System.out.println("\nOpción no reconocida");
            }
        }
    }

    public  void showAvailableCoins(){
        String availableCoinsList = ExchangeRateDao.showAllAvailableCoins(AvailableCoin.values());
        System.out.println(availableCoinsList);
    }

    public  void showConversionsList(){
        List<Conversions> conversiones = ExchangeRateDao.showAllConversionsList();
        for (Conversions conversion : conversiones) {
            String nombreMonedaBase = conversion.getMonedaBase().toString();
            String nombreMonedaDestino = conversion.getMonedaDestino().toString();
            System.out.println(" *"+ nombreMonedaBase + " ==> " + nombreMonedaDestino);
        }
    }

    private boolean isValidCoin(String coinName) {
        for (AvailableCoin coin : AvailableCoin.values()) {
            if (coin.name().equalsIgnoreCase(coinName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidConversion(String baseCode, String targetCode) {
        for (Conversions conversion : Conversions.values()) {
            String base = conversion.getMonedaBase().name();
            String target = conversion.getMonedaDestino().name();
            if ((base.equalsIgnoreCase(baseCode) && target.equalsIgnoreCase(targetCode))
                    || (base.equalsIgnoreCase(targetCode) && target.equalsIgnoreCase(baseCode))) {
                return true;
            }
        }
        return false;
    }

    public void getPairConversionAmount() {
        System.out.println("Puede realizar cualquiera de las siguientes conversiones");
        System.out.println(" ");
        showConversionsList();
        System.out.println(" ");

        String base_code;
        String target_code;
        double amount;

        do {
            System.out.println("Introduzca las siglas de su moneda base: ");
            base_code = sc.nextLine();
            if (!isValidCoin(base_code)) {
                System.out.println("La moneda ingresada no está disponible. Por favor, inténtelo nuevamente.");
                continue;
            }
            System.out.println("Introduzca las siglas de la divisa a convertir: ");
            target_code = sc.nextLine();
            if (!isValidCoin(target_code)) {
                System.out.println("La moneda ingresada no está disponible. Por favor, inténtelo nuevamente.");
                continue;
            }
            if (!isValidConversion(base_code, target_code)) {
                System.out.println("La conversión entre las monedas especificadas no está disponible. Por favor, inténtelo nuevamente.");
                continue;
            }
            System.out.println("Introduzca la cantidad en " + base_code + " que desea convertir: ");
            amount = sc.nextDouble();
            break;
        } while (true);

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.pairConversionAmount(base_code, target_code, amount));
        TransactionLogger.logPairConversionAmount(amount, base_code, target_code);
    }

    public  void getPairConversion(){
        System.out.println("Puede consultar las tasas de cambio de las siguientes monedas");
        showAvailableCoins();

        String base_code;
        String target_code;
        do {
            System.out.println("Introduzca las siglas de su moneda base: ");
             base_code = sc.nextLine();
            if (!isValidCoin(base_code)) {
                System.out.println("La moneda ingresada no está disponible. Por favor, inténtelo nuevamente.");
                continue;
            }
            System.out.println("Introduzca las siglas de la divisa a convertir: ");
             target_code = sc.nextLine();
            if (!isValidCoin(target_code)) {
                System.out.println("La moneda ingresada no está disponible. Por favor, inténtelo nuevamente.");
                continue;
            }
            break;
        } while (true);

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.pairConversion(base_code, target_code));
        TransactionLogger.logPairConversion(base_code, target_code);
    }

    public void getLogs(){

    }

    //NO JALA
    public  void getStandardResponse(){
        System.out.println("Especifique cual es su moneda base: ");
        String base_code = sc.nextLine();

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.standardResponse(base_code));
    }

    //NO JALA
    public  void getEnrichedData(){
        System.out.println("Especifique cual es su moneda base: ");
        String base_code = sc.nextLine();
        System.out.println("Especifique el tipo de divisa a conocer: ");
        String target_code = sc.nextLine();

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.enrichedData(base_code, target_code));
    }

    public  void getHistoricalData(){
        System.out.println("Especifique cual es su moneda base: ");
        String base_code = sc.nextLine();
        System.out.println("Especifique el año: ");
        long year = sc.nextLong();
        System.out.println("Especifique el mes: ");
        int month = sc.nextInt();
        System.out.println("Especifique el día: ");
        int day = sc.nextInt();

        ExchangeRateDao dao = new ExchangeRateDao();
        String dataFromDao = String.valueOf(dao.historicalData(base_code, year, month, day));
    }

    public void ejecutaVista(){
        menuBienvenida();
    }
}
/*



* Historial de Conversiones: Agrega la capacidad de rastrear y mostrar el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.
Registros con Marca de Tiempo: Utiliza las funciones de la biblioteca java.time para crear registros que registren las conversiones realizadas, incluyendo información sobre qué monedas se convirtieron y en qué momento.
* */