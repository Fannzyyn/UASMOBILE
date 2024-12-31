package com.example.listfilm;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSearch;
    private MovieAdapter movieAdapter;
    private List<Film> movieList = new ArrayList<>();
    private List<Film> filteredList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerViewSearch = findViewById(R.id.recycler_view_search);
        recyclerViewSearch.setLayoutManager(new LinearLayoutManager(this));

        // Menyiapkan data film
        movieList = getMovieList();
        filteredList.addAll(movieList);
        movieAdapter = new MovieAdapter(filteredList);
        recyclerViewSearch.setAdapter(movieAdapter);

        // Setup SearchView
        SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMovies(newText);
                return true;
            }
        });
    }

    private void filterMovies(String query) {
        filteredList.clear();
        if (TextUtils.isEmpty(query)) {
            filteredList.addAll(movieList);
        } else {
            for (Film movie : movieList) {
                if (movie.getTitle().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(movie);
                }
            }
        }
        movieAdapter.notifyDataSetChanged();
    }

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
