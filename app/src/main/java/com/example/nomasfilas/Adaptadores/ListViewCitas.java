package com.example.nomasfilas.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nomasfilas.Models.Cita;
import com.example.nomasfilas.R;

import java.util.ArrayList;

public class ListViewCitas extends BaseAdapter {

    Context context;
    ArrayList<Cita> citasData;
    LayoutInflater layoutInflater;
    Cita citaModel;

    public ListViewCitas(Context context, ArrayList<Cita> citasData) {
        this.context = context;
        this.citasData = citasData;
        layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }

    @Override
    public int getCount() {
        return citasData.size();
    }

    @Override
    public Object getItem(int position) {
        return citasData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null){
            rowView = layoutInflater.inflate(R.layout.lista_citas,null,true);
        }
        TextView consultorio = rowView.findViewById(R.id.txConsulView);
        TextView medico = rowView.findViewById(R.id.txMedView);
        TextView fecha = rowView.findViewById(R.id.txFechaView);
        TextView hora = rowView.findViewById(R.id.txHoraView);

        citaModel = citasData.get(position);
        consultorio.setText(citaModel.getConsultorio());
        medico.setText(citaModel.getMedico());
        fecha.setText(citaModel.getFecha());
        hora.setText(citaModel.getHora());

        return rowView;
    }
}
