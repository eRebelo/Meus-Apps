package mybook.rebelo.com.mybook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import mybook.rebelo.com.mybook.controller.BDSQLiteHelper;
import mybook.rebelo.com.mybook.model.Livro;
import mybook.rebelo.com.mybook.util.LivroAdapter;

public class MainActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    ArrayList<Livro> listaLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bd = new BDSQLiteHelper(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddLivroActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        ListView lista = (ListView) findViewById(R.id.lvLivros);
        listaLivros = bd.getAllLivros();
        //ArrayList<Livro> listaLivros = adicionarLivros();
        LivroAdapter adapter = new LivroAdapter(this, listaLivros);
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
