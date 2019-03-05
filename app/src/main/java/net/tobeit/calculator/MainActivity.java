package net.tobeit.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Calculadora calculadora = new Calculadora();
    private TextView visor;
    private TextView visorPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.visor = (TextView) findViewById(R.id.visor);
        this.visorPrincipal = (TextView) findViewById(R.id.visorPrincipal);
        atualizarVisor();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("calculadora", this.calculadora);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getSerializable("calculadora") != null) {
            this.calculadora = (Calculadora) savedInstanceState.getSerializable("calculadora");
            atualizarVisor();
        }
    }

    private void setCaracter(char caracter) {
        try {
            calculadora.setCaracter(caracter);
            atualizarVisor();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    private void atualizarVisor() {
        if (this.calculadora != null) {
            visor.setText(calculadora.getValorTexto());
            visorPrincipal.setText(calculadora.getValorTextoPrincipal());
        } else {
            visor.setText("");
            visorPrincipal.setText("0");
        }
    }

    private void setOperacion(Operacion operation) {
        calculadora.setOperacion(operation);
        atualizarVisor();
    }

    public void clickButtonUno(View view) {
        setCaracter('1');
    }

    public void clickButtonDos(View view) {
        setCaracter('2');
    }

    public void clickButtonTres(View view) {
        setCaracter('3');
    }

    public void clickButtonCuatro(View view) {
        setCaracter('4');
    }

    public void clickButtonCinco(View view) {
        setCaracter('5');
    }

    public void clickButtonSeis(View view) {
        setCaracter('6');
    }

    public void clickButtonSiete(View view) {
        setCaracter('7');
    }

    public void clickButtonOcho(View view) {
        setCaracter('8');
    }

    public void clickButtonNueve(View view) {
        setCaracter('9');
    }

    public void clickButtonZero(View view) {
        setCaracter('0');
    }

    public void clickButtonSumar(View view) {
        setOperacion(Operacion.SUMA);
    }

    public void clickButtonRestar(View view) {
        setOperacion(Operacion.RESTA);
    }

    public void clickButtonMultiplicar(View view) {
        setOperacion(Operacion.MULTIPLICACION);
    }

    public void clickButtonDividir(View view) {
        setOperacion(Operacion.DIVISION);
    }

    public void clickButtonPorcentage(View view) {
        setOperacion(Operacion.PORCENTAGE);
    }

    public void clickButtonComa(View view) {
        setCaracter(',');
    }

    public void clickButtonResultado(View view) {
        calculadora.calcular();
        atualizarVisor();
    }

    public void clickButtonLimpar(View view) {
        calculadora = new Calculadora();
        atualizarVisor();
    }

    public void clickButtonDeshacer(View view) {
        try {
            calculadora.removerUltimoCaracter();
            atualizarVisor();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Error!", Toast.LENGTH_SHORT).show();
        }
    }
}