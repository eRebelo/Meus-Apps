package persistencerealm.rebelo.com.persistencerealm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rebelo on 10/05/2017.
 */

public class Livro extends RealmObject {

    @PrimaryKey
    private int id;
    private String titulo;
    private String autor;
    private int ano;

    public Livro() {
    }

    public Livro(String titulo, String autor, int ano) {
        super();
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
