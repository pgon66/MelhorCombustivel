package pr.senac.br.melhorcombustivel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class ResultActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();

        String valorGasolina = intent.getStringExtra(pr.senac.br.melhorcombustivel.MainActivity.EXTRA_VALOR_GASOLINA);
        String valorEtanol = intent.getStringExtra(pr.senac.br.melhorcombustivel.MainActivity.EXTRA_VALOR_ETANOL);
        String consumoGasolina = intent.getStringExtra(pr.senac.br.melhorcombustivel.MainActivity.EXTRA_CONSUMO_GASOLINA);
        String consumoEtanol = intent.getStringExtra(pr.senac.br.melhorcombustivel.MainActivity.EXTRA_CONSUMO_ETANOL);

        TextView resultadoView = findViewById(R.id.ResultTextView);
        TextView resultadoValor = findViewById(R.id.resultadoValor);
        TextView resultadoKmL = findViewById(R.id.resultadoKmL);
        TextView resultadoValorEtanol = findViewById(R.id.resultadoValorEtanol);
        TextView resultadoKmLEtanol = findViewById(R.id.resultadoKmLEtanol);
        TextView resultadoEconomia = findViewById(R.id.resultadoEconomia);
        TextView ResultadoConsumo = findViewById(R.id.resultadoConsumo);

        double valorGasolinaBack = Double.parseDouble(valorGasolina);
        double valorEtanolBack = Double.parseDouble(valorEtanol);
        double consumoGasolinaBack = Double.parseDouble(consumoGasolina);
        double consumoEtanolBack = Double.parseDouble(consumoEtanol);
        double resultadoConsumoGasolina = valorGasolinaBack / consumoGasolinaBack;
        double resultadoConsumoEtanol = valorEtanolBack / consumoEtanolBack;
        double resultadoConsumo = 0;
        double relacaoCombustivel = (valorEtanolBack / valorGasolinaBack) * 100;

        resultadoValor.setText("R$ " + valorGasolina);
        resultadoKmL.setText(consumoGasolina);
        resultadoValorEtanol.setText("R$ " + valorEtanol);
        resultadoKmLEtanol.setText(consumoEtanol);

        ResultadoConsumo.setText(
                String.format("Relação Etanol/Gasolina %.2f", relacaoCombustivel) + ("%") +
                String.format("\nGasto com Gasolina R$%.2f", resultadoConsumoGasolina) +
                String.format("\nGasto com Etanol R$%.2f", resultadoConsumoEtanol));

        if (resultadoConsumoGasolina < resultadoConsumoEtanol) {
            resultadoConsumo = resultadoConsumoEtanol - resultadoConsumoGasolina;
            resultadoEconomia.setText(String.format("Economia de R$%.2f", resultadoConsumo) + " por litro");
        } else {
            resultadoConsumo = resultadoConsumoGasolina - resultadoConsumoEtanol;
            resultadoEconomia.setText(String.format("Economia de R$%.2f", resultadoConsumo) + " por litro");
        }

        if(relacaoCombustivel >= 70) {
            resultadoView.setText("Abasteça com Gasolina");
        } else {
            resultadoView.setText("Abasteça com Etanol");
        }

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultActivity.super.onBackPressed();
            }
        });
    }
}
