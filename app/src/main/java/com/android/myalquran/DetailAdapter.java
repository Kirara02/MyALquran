package com.android.myalquran;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.List;

public class DetailAdapter extends ArrayAdapter<DetailModel> {
    private Context context;
    private int resource;
    private List<DetailModel> detailModelList;
    MediaPlayer mediaPlayer;

    public DetailAdapter(@NonNull Context context, int resource, @NonNull List<DetailModel> detailModelList) {
        super(context, resource, detailModelList);
        this.context = context;
        this.resource = resource;
        this.detailModelList = detailModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(resource,null,false);
        }

        nomor.setText(detailModel.getNomor());
        arab.setText(detailModel.getArab());
        terjemah.setText(detailModel.getTerjemah());


        return convertView;
    }
}
