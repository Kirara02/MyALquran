package com.android.myalquran;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SuratAdapter extends ArrayAdapter<SuratModel> {
    private Context context;
    private int resource;
    private List<SuratModel> suratModelslList;

    public SuratAdapter(@NonNull Context context, int resource, @NonNull List<SuratModel> suratModelslList) {
        super(context, resource, suratModelslList);
        this.context = context;
        this.resource = resource;
        this.suratModelslList = suratModelslList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(resource,null,false);
        }
        SuratModel suratModel = suratModelslList.get(position);
        TextView no = convertView.findViewById(R.id.no);
        TextView nama = convertView.findViewById(R.id.nama);
        TextView latin = convertView.findViewById(R.id.latin);
        TextView turun_ayat = convertView.findViewById(R.id.turun_ayat);
        LinearLayout linear = convertView.findViewById(R.id.linear);

        no.setText(suratModel.getNo());
        nama.setText(suratModel.getNama());
        latin.setText(suratModel.getLatin());
        turun_ayat.setText(suratModel.getTurun()+" | "+suratModel.getAyat()+" ayat");

        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("no",suratModel.getNo());
                intent.putExtra("arti",suratModel.getArti());
                intent.putExtra("ayat",suratModel.getAyat());
                intent.putExtra("turun",suratModel.getTurun());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
