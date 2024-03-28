package com.donhat.sportsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView _sportsRecyclerView;
    private List<Sport> _sports;
    private SportAdapter _sportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        _sportsRecyclerView = findViewById(R.id.sports_recycler_view);

        _sports = new ArrayList<>(
                Arrays.asList(
                        new Sport(R.drawable.football, "Football"),
                        new Sport(R.drawable.basketball, "Basketball"),
                        new Sport(R.drawable.volley, "Volleyball"),
                        new Sport(R.drawable.tennis, "Tennis"),
                        new Sport(R.drawable.ping, "Ping Pong")
                )
        );

        _sportAdapter = new SportAdapter(_sports);

        _sportsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        _sportsRecyclerView.setAdapter(_sportAdapter);
    }
}