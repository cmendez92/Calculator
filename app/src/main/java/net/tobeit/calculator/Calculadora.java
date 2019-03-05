package net.tobeit.calculator;


import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

public class Calculadora implements Serializable {

    private Operador operador1 = new Operador();
    private Operador operador2 = new Operador();
    private Operacion operacion = null;
    private boolean finalizado = false;
    private NumberFormat nf = NumberFormat.getNumberInstance();

    public void setCaracter(char caracter) throws ParseException {
        if(finalizado) {
            operador1 = new Operador();
            operador2 = new Operador();
            operacion = null;
            finalizado = false;
        }

        if (operacion == null) {
            operador1.setCaracter(caracter);
        } else if (!finalizado) {
            operador2.setCaracter(caracter);
        }
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }


    public String getValorTexto() {
        String op1 = operador1.getValorTexto();
        String op2 = operador2.getValorTexto();

        String texto = "";

        if (operacion == null) {
            texto += "";
        } else if (!finalizado) {
            texto += op1 + operacion;
        } else {
            texto += op1 + operacion + op2;
        }

        return texto;
    }

    public String getValorTextoPrincipal() {
        String op1 = operador1.getValorTexto();
        String op2 = operador2.getValorTexto();

        String texto = "";

        if (operacion == null) {
            texto += op1;
        } else if (!finalizado) {
            texto += op2;
        } else {
            texto += getResultado();
        }

        return texto;
    }

    public String getResultado() {
        double op1 = operador1.getValor();
        double op2 = operador2.getValor();
        double resultado = 0;
        if (operacion == Operacion.SUMA) {
            resultado = op1 + op2;
        } else if (operacion == Operacion.RESTA) {
            resultado = op1 - op2;
        } else if (operacion == Operacion.MULTIPLICACION) {
            resultado = op1 * op2;
        } else if (operacion == Operacion.DIVISION) {
            resultado = op1 / op2;
        } else if (operacion == Operacion.PORCENTAGE) {
            resultado = op1 * op2 / 100;
        } else {
            throw new UnsupportedOperationException("Operação não implementada.");
        }
        return nf.format(resultado);
    }

    public void calcular() {
        this.finalizado = true;
    }

    public void removerUltimoCaracter() throws ParseException {
        if (operacion == null) {
            operador1.removerUltimoCaracter();
        } else if (!finalizado) {
            operador2.removerUltimoCaracter();
        }
    }

    @Override
    public String toString() {
        String texto = getValorTexto();
        if (getValorTextoPrincipal().trim().length() > 0) {
            texto += " = " + getValorTextoPrincipal();
        }
        return texto;
    }
}