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

import com.fulthonn.model.Voiture;
import com.fulthonn.navigation_menu.R;

import java.util.ArrayList;
import java.util.List;

public class VoitureAdapter extends RecyclerView.Adapter<VoitureAdapter.VoitureHolder> implements Filterable {

    private List<Voiture> voitures;
    private List<Voiture> samplesFull;
    private OnItemClickListener listener;

    public VoitureAdapter(List<Voiture> voitures) {
        this.voitures = voitures;
        samplesFull = new ArrayList<>(voitures);
    }

    @Override
    public Filter getFilter() {
        return listSamplesFilter;
    }

    private Filter listSamplesFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Voiture> voitures = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                voitures.addAll(samplesFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Voiture voiture : samplesFull){
                    if(voiture.getMatricule().toLowerCase().contains(filterPattern)){
                        voitures.add(voiture);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = voitures;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            voitures.clear();
            voitures.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    public interface OnItemClickListener{
        void onItemClick(Voiture voiture);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    class VoitureHolder extends RecyclerView.ViewHolder{
        TextView tv_matricule;
        ImageView im_voiture;
        TextView tv_marque;
        TextView tv_statut;

        public VoitureHolder(@NonNull View itemView) {
            super(itemView);
            tv_matricule = itemView.findViewById(R.id.tv_sample);
            im_voiture = itemView.findViewById(R.id.iv_sample);
            tv_marque=itemView.findViewById(R.id.tv_marque);
            tv_statut=itemView.findViewById(R.id.tv_statut);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(voitures.get(position));
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
        voitureHolder.tv_matricule.setText(voitures.get(i).getMatricule());
        voitureHolder.im_voiture.setImageResource(R.drawable.mclaren);
        voitureHolder.tv_marque.setText(voitures.get(i).getMarque());
        voitureHolder.tv_statut.setText(voitures.get(i).getStatut());

    }

    @Override
    public int getItemCount() {
        return (voitures == null ? 0 : voitures.size());
    }
}
