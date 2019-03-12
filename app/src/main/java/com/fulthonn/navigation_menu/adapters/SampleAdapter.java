package com.fulthonn.navigation_menu.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fulthonn.model.Sample;
import com.fulthonn.navigation_menu.R;

import java.util.ArrayList;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewHolder> {

    ArrayList<Sample> samples;
    SampleListener listener;

    ArrayList<Sample> collection;

    public SampleAdapter(ArrayList<Sample> samples, SampleListener listener) {
        this.samples = samples;
        this.collection = samples;
        this.listener = listener;
    }

    public void search(final String pattern){
        this.samples = new ArrayList<>();

        for (Sample sample: this.collection) {
            if (sample.getmText().contains(pattern))
                this.samples.add(sample);
        }

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.line_template, viewGroup, false);

        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder viewHolder, int i) {

        final Sample sample = this.samples.get(i);

        viewHolder.bind(sample);

        if (this.listener != null){
            viewHolder.ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(sample);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return (this.samples == null) ? 0 : this.samples.size();
    }

    public class SampleViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvTexte;

        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);

            this.ivImage = itemView.findViewById(R.id.iv_sample);
            this.tvTexte = itemView.findViewById(R.id.tv_sample);
        }

        public void bind(Sample sample){
            if (sample != null){
                this.tvTexte.setText(sample.getmText());
            }
        }
    }

    public interface SampleListener{
       void onClick(Sample sample);
    }
}
