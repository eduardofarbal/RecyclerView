package com.farbal.ejercicio.ejerciciorecycleview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<ModeloImagenes> modeloImagenes;
    private int layout;
    private  onItemClickListener onItemClickListener;
    private Context context;
    public Adapter(ArrayList<ModeloImagenes> modeloImagenes, int layout, Adapter.onItemClickListener onItemClickListener) {
        this.modeloImagenes = modeloImagenes;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        context=parent.getContext();
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(modeloImagenes.get(position), (onItemClickListener) onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return modeloImagenes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombreImagenes;
        ImageView imagenes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreImagenes=itemView.findViewById(R.id.tv_nombre_imagenes);
            imagenes=itemView.findViewById(R.id.iv_imagenes);
        }

        public void  bind(final ModeloImagenes MODELO_IMAGENES, final onItemClickListener ON_ITEM_CLICK_LISTENER){
            imagenes.setImageResource(MODELO_IMAGENES.getImagenes());
            Glide.with(context)
                    .load(MODELO_IMAGENES.getImagenes())
                    .fitCenter()
                    .into(imagenes);
            nombreImagenes.setText(MODELO_IMAGENES.getNombreImagenes());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ON_ITEM_CLICK_LISTENER.onClick(getAdapterPosition());
                }
            });

        }
    }
    interface  onItemClickListener{
        void onClick(int position);
    }
}
