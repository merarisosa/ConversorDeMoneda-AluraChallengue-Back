package Enums;

public enum  AvailableCoin {
    ARS("Peso Argentino"),
    USD("Dólar estadounidense"),
    COP("Peso colombiano"),
    MXN("Peso mexicano"),
    BOB("Boliviano boliviano");


    private final String nombre;

    AvailableCoin(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return this.name() + " (" + nombre+ ")";
    }
}
