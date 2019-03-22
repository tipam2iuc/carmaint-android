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

import com.fulthonn.model.Categorie;
import com.fulthonn.model.Model;
import com.fulthonn.navigation_menu.R;

import java.util.ArrayList;
import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelHolder> implements Filterable {

    private List<Model> models;
    private List<Model> samplesFull;
    private OnItemClickListener listener;

    public ModelAdapter(List<Model> models) {
        this.models = models;
        samplesFull = new ArrayList<>(models);
    }

    @Override
    public Filter getFilter() {
        return listSamplesFilter;
    }

    private Filter listSamplesFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Model> models = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                models.addAll(samplesFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Model model : samplesFull){
                    if(model.getNomModel().toLowerCase().contains(filterPattern)){
                        models.add(model);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = models;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            models.clear();
            models.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    public interface OnItemClickListener{
        void onItemClick(Model model);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    class ModelHolder extends RecyclerView.ViewHolder{
        ImageView im_model;
        TextView tv_nomModel;

        public ModelHolder(@NonNull View itemView) {
            super(itemView);
            im_model = itemView.findViewById(R.id.tv_ImageCategorie);
            tv_nomModel = itemView.findViewById(R.id.tv_nomNategorie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(models.get(position));
                    }
                }
            });
        }
    }

    @NonNull
    @Override

    public ModelHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.line_template_categorie,viewGroup, false);
        return new ModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelHolder modelHolder, int i) {
        modelHolder.tv_nomModel.setText(models.get(i).getNomModel());
        modelHolder.im_model.setImageResource(R.drawable.mclaren);


    }

    @Override
    public int getItemCount() {
        return (models == null ? 0 : models.size());
    }
}
