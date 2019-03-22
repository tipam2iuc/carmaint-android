package com.fulthonn.navigation_menu.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;
import com.fulthonn.model.Categorie;
import com.fulthonn.model.Voiture;
import com.fulthonn.navigation_menu.R;

import java.util.ArrayList;
import java.util.List;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.CategorieHolder> implements Filterable {

    private List<Categorie> categories;
    private List<Categorie> samplesFull;
    private OnItemClickListener listener;
    private ImageView imgeCategorie;
    private Context context;

    public CategorieAdapter(List<Categorie> categories) {
        this.categories = categories;
        samplesFull = new ArrayList<>(categories);
    }

    @Override
    public Filter getFilter() {
        return listSamplesFilter;
    }

    private Filter listSamplesFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Categorie> categories = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                categories.addAll(samplesFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Categorie categorie : samplesFull){
                    if(categorie.getNomCategorie().toLowerCase().contains(filterPattern)){
                        categories.add(categorie);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = categories;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            categories.clear();
            categories.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    public interface OnItemClickListener{
        void onItemClick(Categorie categorie);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    class CategorieHolder extends RecyclerView.ViewHolder{
        ImageView im_categorie;
        TextView tv_nomCategorie;

        public CategorieHolder(@NonNull View itemView) {
            super(itemView);
            im_categorie = itemView.findViewById(R.id.tv_ImageCategorie);
            tv_nomCategorie = itemView.findViewById(R.id.tv_nomNategorie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(categories.get(position));
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public CategorieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.line_template_categorie,viewGroup, false);
        return new CategorieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieHolder categorieHolder, int i) {
        String iso = categories.get(i).getNomCategorie();
//        if(iso != "toyota"){
//            ArrayList<Image> imageCategories=new ArrayList<>();

         //   imageCategories.add(d);
            //categorieHolder.im_categorie.setImageResource();
           // categorieHolder.im_categorie.setImageResource(context.getResources().getIdentifier(iso,"drawable",context.getApplicationContext().getPackageName()));
      //  }
        categorieHolder.tv_nomCategorie.setText(categories.get(i).getNomCategorie());
        categorieHolder.im_categorie.setImageResource(R.drawable.bmw);
    }

    @Override
    public int getItemCount() {
        return (categories == null ? 0 : categories.size());
    }
}
