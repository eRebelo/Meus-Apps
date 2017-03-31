package campinho.rebelo.com.campinho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TimeActivity extends AppCompatActivity {

    private TextView boasVindas;
    private ListView listaTimes;
    private String[] times = {
            "Flamengo", "Vasco", "Fluminense", "Botafogo", "São Paulo", "Corinnthians", "Santos",
            "Palmeiras", "Internacional", "Gremio"
    };
    private String[] fundado = {
            "17/Nov/1895", "21/Ago/1898", "21/Jul/1902", "08/Dez/1942", "25/Jan/1930", "01/Set/1910",
            "14/Abr/1912", "26/Ago/1914", "04/Abr/1909", "15/Set/1903"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        boasVindas = (TextView) findViewById(R.id.idBoasVindas);
        listaTimes = (ListView) findViewById(R.id.idListView);

        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            String textoBoasVindas = extra.getString("nomePelada");

            boasVindas.setText("Bem vindo " + textoBoasVindas);


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    R.layout.text_listview,
                    android.R.id.text1,
                    times
            );

            listaTimes.setAdapter(adapter);

            listaTimes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    int codigoPosicao = i;
                    Toast.makeText(getApplicationContext(), fundado[codigoPosicao], Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
