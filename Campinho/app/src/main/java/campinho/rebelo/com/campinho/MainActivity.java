package campinho.rebelo.com.campinho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nomePelada;
    private Button botaoIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomePelada = (EditText) findViewById(R.id.idNomePelada);
        botaoIniciar = (Button) findViewById(R.id.idBotaoIniciar);

        botaoIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoNomePelada = nomePelada.getText().toString();

                if (!textoNomePelada.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, TimeActivity.class);
                    intent.putExtra("nomePelada", textoNomePelada);

                    startActivity(intent);
                }
            }
        });
    }
}
