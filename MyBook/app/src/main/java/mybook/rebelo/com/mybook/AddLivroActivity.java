package mybook.rebelo.com.mybook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mybook.rebelo.com.mybook.controller.BDSQLiteHelper;
import mybook.rebelo.com.mybook.model.Livro;

public class AddLivroActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.add_activity_name);
        setContentView(R.layout.activity_add_livro);

        bd = new BDSQLiteHelper(this);

        final EditText nome = (EditText) findViewById(R.id.edtNomeNovo);
        final EditText autor = (EditText) findViewById(R.id.edtAutorNovo);
        final EditText ano = (EditText) findViewById(R.id.edtAnoNovo);

        Button adicionar = (Button) findViewById(R.id.btnAddLivro);
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Livro livro = new Livro();
                livro.setTitulo(nome.getText().toString());
                livro.setAutor(autor.getText().toString());
                livro.setAno(Integer.parseInt(ano.getText().toString()));

                bd.addLivro(livro);

                Toast.makeText(getBaseContext(), "Livro inserido com sucesso", Toast.LENGTH_SHORT).show();

                nome.setText("");
                autor.setText("");
                ano.setText("");
            }
        });
    }
}
