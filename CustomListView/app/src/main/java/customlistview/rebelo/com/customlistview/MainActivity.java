package customlistview.rebelo.com.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import customlistview.rebelo.com.customlistview.model.Livro;
import customlistview.rebelo.com.customlistview.util.LivroAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListView lista = (ListView) findViewById(R.id.lvLivros);
        ArrayList<Livro> livros = adicionarLivros();
        ArrayAdapter adapter = new LivroAdapter(this, livros);
        lista.setAdapter(adapter);
    }

    private ArrayList<Livro> adicionarLivros() {
        ArrayList<Livro> livros = new ArrayList<Livro>();
        Livro l = new Livro("Os Sete Mares", "Eduardo Rebelo", 2017);
        livros.add(l);
        l = new Livro("Mares", "Eduardo Rebelo", 2014);
        livros.add(l);
        l = new Livro("Sol da Meia Noite", "Eduardo Rebelo", 2015);
        livros.add(l);
        l = new Livro("Lua Cheia", "Eduardo Rebelo", 2016);
        livros.add(l);
        l = new Livro("Felicidade Verdareira", "Eduardo Rebelo", 2012);
        livros.add(l);
        l = new Livro("Paz Espiritual", "Eduardo Rebelo", 2013);
        livros.add(l);
        l = new Livro("7 Dons Espiriruais", "Eduardo Rebelo", 2011);
        livros.add(l);
        return livros;
    }
}
