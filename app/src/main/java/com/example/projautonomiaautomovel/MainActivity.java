package com.example.projautonomiaautomovel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtnConsumoMedio;
    private EditText txtnQtdCombustivel;
    private TextView txtsAutonomia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnQtdCombustivel = findViewById(R.id.txtnQtdCombustivel);
        txtnQtdCombustivel.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        txtnConsumoMedio = findViewById(R.id.txtnConsumoMedio);
        txtnConsumoMedio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        txtsAutonomia = findViewById(R.id.txtsAutonomia);
        txtsAutonomia.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> Calcular());
    }

    private void Calcular ()
    {
        double qtdCombustivel = Double.parseDouble(txtnQtdCombustivel.getText().toString());
        double consumoMedio = Double.parseDouble(txtnConsumoMedio.getText().toString());

        double resultado = (consumoMedio * qtdCombustivel) * 1000;

        String msg =getString(R.string.sAutonomia) + " " + resultado + " metros";
        txtsAutonomia.setText(msg);
    }
}