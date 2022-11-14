package com.example.pelimax.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pelimax.R;
import com.example.pelimax.model.Pelicula;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PeliculaAdapter extends FirestoreRecyclerAdapter<Pelicula, PeliculaAdapter.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PeliculaAdapter(@NonNull FirestoreRecyclerOptions<Pelicula> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Pelicula model) {
        holder.fechas.setText(model.getFecha());
        holder.generos.setText(model.getGenero());
        holder.sipnosiss.setText(model.getSipnosis());
        holder.titulos.setText(model.getTitulo());
        holder.times.setText(model.getTime());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pelicula_sigle, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fechas,generos,sipnosiss,titulos,times;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fechas = itemView.findViewById(R.id.Fecha);
            generos = itemView.findViewById(R.id.genero);
            sipnosiss = itemView.findViewById(R.id.sipnosis);
            titulos = itemView.findViewById(R.id.titulo);
            times = itemView.findViewById(R.id.time);
        }
    }
}
