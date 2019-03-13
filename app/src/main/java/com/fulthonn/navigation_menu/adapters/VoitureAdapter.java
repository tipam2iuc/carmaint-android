package com.fulthonn.navigation_menu.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.fulthonn.model.Sample;
import com.fulthonn.navigation_menu.R;

import java.util.ArrayList;
import java.util.List;

public class VoitureAdapter extends RecyclerView.Adapter<VoitureAdapter.VoitureHolder> implements Filterable {

    private List<Sample> samples;
    private List<Sample> samplesFull;
    private OnItemClickListener listener;

    public VoitureAdapter(List<Sample> samples) {
        this.samples = samples;
        samplesFull = new ArrayList<>(samples);
    }

    @Override
    public Filter getFilter() {
        return listSamplesFilter;
    }

    private Filter listSamplesFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Sample> samples = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                samples.addAll(samplesFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Sample sample : samplesFull){
                    if(sample.getmText().toLowerCase().contains(filterPattern)){
                        samples.add(sample);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = samples;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            samples.clear();
            samples.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    public interface OnItemClickListener{
        void onItemClick(Sample sample);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    class VoitureHolder extends RecyclerView.ViewHolder{
        TextView tv_matricule;
        ImageView im_voiture;

        public VoitureHolder(@NonNull View itemView) {
            super(itemView);
            tv_matricule = itemView.findViewById(R.id.tv_sample);
            im_voiture = itemView.findViewById(R.id.iv_sample);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(samples.get(position));
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public VoitureHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.line_template,viewGroup, false);
        return new VoitureHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoitureHolder voitureHolder, int i) {
        voitureHolder.tv_matricule.setText(samples.get(i).getmText());
        voitureHolder.im_voiture.setImageResource(R.drawable.logo);
    }

    @Override
    public int getItemCount() {
        return (samples == null ? 0 : samples.size());
    }
}
