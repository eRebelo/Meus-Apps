package mybook.rebelo.com.mybook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mybook.rebelo.com.mybook.controller.BDSQLiteHelper;
import mybook.rebelo.com.mybook.model.Livro;

public class EditLivroActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.edit_activity_name);
        setContentView(R.layout.activity_edit_livro);

        // Obtendo ID passado por parâmetro e buscando no banco de dados seus valores
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        bd = new BDSQLiteHelper(this);
        Livro livro = bd.getLivro(id);

        final EditText nome = (EditText) findViewById(R.id.edtNomeNovo);
        final EditText autor = (EditText) findViewById(R.id.edtAutorNovo);
        final EditText ano = (EditText) findViewById(R.id.edtAnoNovo);

        // Atribuindo na tela os valores encontrados
        nome.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        ano.setText(String.valueOf(livro.getAno()));

        Button alterar = (Button) findViewById(R.id.btnEditLivro);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Livro livro = new Livro();
                livro.setId(id);
                livro.setTitulo(nome.getText().toString());
                livro.setAutor(autor.getText().toString());
                livro.setAno(Integer.parseInt(ano.getText().toString()));
                bd.updateLivro(livro);
                Toast.makeText(getBaseContext(), "Livro alterado com sucesso.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        final Button remover = (Button) findViewById(R.id.btnDeleteLivro);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Livro livro = new Livro();
                livro.setId(id);
                bd.deleteLivro(livro);
                remover.setEnabled(false);
                Toast.makeText(getBaseContext(), "Livro removido com sucesso.",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
