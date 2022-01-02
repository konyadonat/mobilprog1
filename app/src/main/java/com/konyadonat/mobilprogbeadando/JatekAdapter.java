package com.konyadonat.mobilprogbeadando;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class JatekAdapter extends BaseAdapter {

    public  JatekAdapter(String [] adat, Context context){
        this.setAdat(adat);
        this.setContext(context);
    }

    private String [] adat;

    public String [] getAdat(){
        return adat;
    }
    public String [] setAdat(String [] adat){
        return this.adat = adat;
    }

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return adat.length;
    }

    @Override
    public Object getItem(int i) {
        return adat[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista,viewGroup,false);
        }
        TextView listaelemnev = view.findViewById(R.id.listaelemnev);
        TextView listaelempozicio = view.findViewById(R.id.listaelempozicio);

        listaelemnev.setText(adat[i]);
        listaelempozicio.setText(String.valueOf(i));

        return view;
    }


}
