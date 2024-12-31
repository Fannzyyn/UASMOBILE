package com.example.listfilm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // Grid 2x2

        // Panggil metode untuk mendapatkan data film
        List<Film> movieList = getMovieList();

        // Set Adapter
        MovieAdapter adapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(adapter);

        // Tombol Search
        Button searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        });
    }

    // Daftar film
    private List<Film> getMovieList() {
        List<Film> movieList = new ArrayList<>();
        movieList.add(new Film("Lebaran 2019", R.drawable.horor1));
        movieList.add(new Film("The Conjuring", R.drawable.horor2));
        movieList.add(new Film("Halloween", R.drawable.horor3));
        movieList.add(new Film("Shape of Water", R.drawable.horor4));
        movieList.add(new Film("No Info", R.drawable.drakor5));
        movieList.add(new Film("Qoeen of Tears", R.drawable.drakor6));
        movieList.add(new Film("No Info", R.drawable.drakor7));
        movieList.add(new Film("Business Proposal", R.drawable.drakor8));
        movieList.add(new Film("Minions The Rise", R.drawable.kartun9));
        movieList.add(new Film("Elsa Frozen", R.drawable.kartun10));
        movieList.add(new Film("Toy Story GG", R.drawable.kartun11));
        movieList.add(new Film("Ikan Badut", R.drawable.kartun12));
        return movieList;
    }
}
