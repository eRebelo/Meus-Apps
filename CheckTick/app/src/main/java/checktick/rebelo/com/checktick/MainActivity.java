package checktick.rebelo.com.checktick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import checktick.rebelo.com.checktick.Util.Util;

public class MainActivity extends AppCompatActivity {

    Button mButtonCheck;
    ImageButton mButtonDelete;
    TextView mTextUltimaMarcacao;
    String mUltimaMarcacao;

    TextView txtCurrentDate;
    TextView txtCurrentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtem o valor salvo do ultimo check time e exibe na tela
        setLastTimeDisplay();

        // Instanciando variáveis date/time
        txtCurrentDate = (TextView) findViewById(R.id.currentDate);
        txtCurrentTime = (TextView) findViewById(R.id.currentTime);

        // Instanciando variável do botão check in/out e o evento do click
        mButtonCheck = (Button) findViewById(R.id.bCheck);
        mButtonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Atualizando o valor salvo
                String currentTime = (String) txtCurrentDate.getText() + " " + txtCurrentTime.getText();
                Util.saveCheckTime(MainActivity.this, currentTime);

                Toast.makeText(getBaseContext(), currentTime, Toast.LENGTH_SHORT).show();

                //Exibindo o valor atualizado
                setLastTimeDisplay();
            }
        });

        // Instanciando variável do botão delete e o evento do click
        mButtonDelete = (ImageButton) findViewById(R.id.bDelete);
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpando o valor salvo
                Util.clearCheckTime(MainActivity.this);

                //Exibindo o valor atualizado
                setLastTimeDisplay();
            }
        });

        // Thread do current timme
        Thread myThread = null;
        Runnable runnable = new CountDownRunner();
        myThread = new Thread(runnable);
        myThread.start();


    }

    public void setLastTimeDisplay() {
        mTextUltimaMarcacao = (TextView) findViewById(R.id.textUltimaMarcacao);
        mUltimaMarcacao = Util.getCheckTime(MainActivity.this);
        mTextUltimaMarcacao.setText(mUltimaMarcacao);
    }

    public void doWork() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Calendar cal = Calendar.getInstance();
                    String time_str = dateFormat.format(cal.getTime());

                    String[] s = time_str.split(" ");
                    String currentDate = s[0];
                    String currentTime = s[1];

                    txtCurrentDate.setText(currentDate);
                    txtCurrentTime.setText(currentTime);
                } catch (Exception e) {
                }
            }
        });
    }


    class CountDownRunner implements Runnable {
        // @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    doWork();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                }
            }
        }
    }
}