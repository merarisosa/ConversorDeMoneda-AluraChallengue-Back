package Clases;

import java.util.logging.*;

public class TransactionLogger {
    private static final Logger logger = Logger.getLogger(TransactionLogger.class.getName());

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
    }

    public static void logPairConversionAmount(double amount, String baseCurrency, String targetCurrency) {
        logger.info("Transacción: Convertido "+  baseCurrency + " a " + targetCurrency + ". Cantidad convertida: " + amount);
    }

    public static void logPairConversion(String baseCurrency, String targetCurrency ) {
        logger.info("Transacción: Tasa de cambio de " + baseCurrency + " a " + targetCurrency);
    }

    public static void handleLogs(){
        Logger transactionLogger = Logger.getLogger(TransactionLogger.class.getName());
        Handler[] handlers = transactionLogger.getHandlers();

        for (Handler handler : handlers) {
            if (handler instanceof ConsoleHandler) {
                ConsoleHandler consoleHandler = (ConsoleHandler) handler;
                Filter filter = consoleHandler.getFilter();
                LogRecord[] logRecords = filter == null ? new LogRecord[0] : new LogRecord[0];
                for (LogRecord record : logRecords) {
                    if (filter.isLoggable(record)) {
                        System.out.println(record.getMessage());
                    }
                }
            }
        }
    }
}