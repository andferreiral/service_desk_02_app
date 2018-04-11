package br.usjt.deswebmob.servicedesk.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.usjt.deswebmob.servicedesk.R;

/**
 * Created by Andrey on 21/03/2018.
 */

public class ChamadoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Chamado> chamados;

    public ChamadoAdapter(Context context, ArrayList<Chamado> chamados) {
        this.context = context;
        this.chamados = chamados;
    }

    @Override
    public int getCount() {
        return chamados.size();
    }

    @Override
    public Object getItem(int position) {
        return chamados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_chamado, parent, false);

            ImageView imagem = view.findViewById(R.id.imagem_fila);
            TextView numero = view.findViewById(R.id.numero_status_chamado);
            TextView datas = view.findViewById(R.id.abertura_fechamento_chamado);
            TextView descricao = view.findViewById(R.id.descricao_chamado);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.setNumero(numero);
            viewHolder.setDatas(datas);
            viewHolder.setDescricao(descricao);
            viewHolder.setImagem(imagem);
            view.setTag(viewHolder);
        }

        Chamado chamado = chamados.get(position);

        ViewHolder viewHolder = (ViewHolder)view.getTag();

        viewHolder.getImagem().setImageDrawable(Util.getDrawableDinamic(context, chamado.getFila().getFigura()));

        viewHolder.getNumero().setText(String.format("numero: %d - status:%s", chamado.getNumero(), chamado.getStatus()));
        viewHolder.getDatas().setText(String.format("aberture: %tD - fechamento: %tD",
                chamado.getDataAbertura(), chamado.getDataFechamento()));
        viewHolder.getDescricao().setText(chamado.getDescricao());

        return view;
    }
}