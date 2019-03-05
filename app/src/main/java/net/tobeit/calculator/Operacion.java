package net.tobeit.calculator;

public enum Operacion {

    SUMA(" + "),
    RESTA(" - "),
    MULTIPLICACION(" × "),
    DIVISION(" ÷ "),
    PORCENTAGE(" % ");

    private String texto = "";

    private Operacion(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return this.texto;
    }
}