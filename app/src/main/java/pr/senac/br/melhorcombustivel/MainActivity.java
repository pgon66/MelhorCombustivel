package pr.senac.br.melhorcombustivel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    public static final String EXTRA_VALOR_GASOLINA = "VALOR_GASOLINA";
    public static final String EXTRA_VALOR_ETANOL = "VALOR_ETANOL";
    public static final String EXTRA_CONSUMO_GASOLINA = "CONSUMO_GASOLINA";
    public static final String EXTRA_CONSUMO_ETANOL = "CONSUMO_ETANOL";
    private Button buttonCalcular;
    private EditText valorGasolina;
    private EditText valorEtanol;
    private EditText consumoGasolina;
    private EditText consumoEtanol;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_main);
        valorGasolina = findViewById(R.id.valorGasolina);
        valorEtanol = findViewById(R.id.valorEtanol);
        consumoGasolina = findViewById(R.id.consumoGasolina);
        consumoEtanol = findViewById(R.id.consumoEtanol);
        buttonCalcular = findViewById(R.id.back_button);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToResultScreen();
            }
        });
    }

    private void changeToResultScreen() {
        Intent intent = new Intent( this, ResultActivity.class);
        EditText valorGasolina = (EditText) findViewById(R.id.valorGasolina);
        EditText valorEtanol = (EditText) findViewById(R.id.valorEtanol);
        intent.putExtra(EXTRA_VALOR_GASOLINA, valorGasolina.getText().toString());
        intent.putExtra(EXTRA_VALOR_ETANOL, valorEtanol.getText().toString());

        EditText consumoGasolina = (EditText) findViewById(R.id.consumoGasolina);
        EditText consumoEtanol = (EditText) findViewById(R.id.consumoEtanol);
        intent.putExtra(EXTRA_CONSUMO_GASOLINA, consumoGasolina.getText().toString());
        intent.putExtra(EXTRA_CONSUMO_ETANOL, consumoEtanol.getText().toString());

        startActivity(intent);
    }

}
