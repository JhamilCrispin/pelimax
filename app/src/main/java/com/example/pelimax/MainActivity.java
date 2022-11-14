package com.example.pelimax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pelimax.adapter.PeliculaAdapter;
import com.example.pelimax.databinding.ActivityMainBinding;
import com.example.pelimax.model.Pelicula;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    RecyclerView mRecycler;
    PeliculaAdapter maAdapter;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirestore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.recilerPelicula);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("Peliculas");

        FirestoreRecyclerOptions<Pelicula> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Pelicula>().setQuery(query,Pelicula.class).build();
        maAdapter = new PeliculaAdapter(firestoreRecyclerOptions);
        maAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(maAdapter);


        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.promocion:
                    replaceFragment(new PromocionFragment());
                    break;
                case R.id.regional:
                    replaceFragment(new RegionalFragment());
                    break;
                case R.id.carrito:
                    replaceFragment(new ShopFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        maAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        maAdapter.stopListening();
    }
}