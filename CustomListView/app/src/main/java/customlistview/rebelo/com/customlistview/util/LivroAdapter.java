package customlistview.rebelo.com.customlistview.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import customlistview.rebelo.com.customlistview.R;
import customlistview.rebelo.com.customlistview.model.Livro;

/**
 * Created by rebelo on 27/04/2017.
 */

public class LivroAdapter extends ArrayAdapter<Livro> {
    private final Context context;
    private final ArrayList<Livro> elementos;

    public LivroAdapter(Context context, ArrayList<Livro> elementos) {
        super(context, R.layout.linha_livro, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_livro
                , parent, false);
        TextView titulo = (TextView) rowView.findViewById(R.id.txtNome);
        TextView ano = (TextView) rowView.findViewById(R.id.txtAno);
        TextView autor = (TextView) rowView.findViewById(R.id.txtAutor);
        titulo.setText(elementos.get(position).getTitulo());
        autor.setText(elementos.get(position).getAutor());
        ano.setText(Integer.toString(elementos.get(position).getAno()));
        return rowView;
    }


}
