package Enums;

public enum Conversions {
    USD_ARS(AvailableCoin.USD, AvailableCoin.ARS),
    ARS_USD(AvailableCoin.ARS, AvailableCoin.USD),
    BOB_COP(AvailableCoin.BOB, AvailableCoin.COP),
    COP_BOB(AvailableCoin.COP, AvailableCoin.BOB),
    USD_BOB(AvailableCoin.USD, AvailableCoin.BOB),
    BOB_USD(AvailableCoin.BOB, AvailableCoin.USD),
    USD_MXN(AvailableCoin.USD, AvailableCoin.MXN),
    MXN_USD(AvailableCoin.MXN, AvailableCoin.USD);

    private final AvailableCoin monedaBase;
    private final AvailableCoin monedaDestino;

    Conversions(AvailableCoin monedaBase, AvailableCoin monedaDestino) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
    }

    public AvailableCoin getMonedaBase() {
        return monedaBase;
    }

    public AvailableCoin getMonedaDestino() {
        return monedaDestino;
    }

    @Override
    public String toString() {
        return monedaBase.getNombre() + " ==> " + monedaDestino.getNombre();
    }
}
