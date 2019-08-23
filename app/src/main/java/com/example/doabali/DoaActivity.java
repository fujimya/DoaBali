package com.example.doabali;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.doabali.Adapter.AdapterDoa;
import com.example.doabali.Adapter.AdapterHariRaya;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DoaActivity extends AppCompatActivity {
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> subtitle =  new ArrayList<>();

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("doa");

        textView = findViewById(R.id.keterangan);


        rvView = findViewById(R.id.rv_main_hari);
        rvView.setHasFixedSize(true);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                title.clear();
                subtitle.clear();
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    title.add(child.child("title").getValue().toString());
                    subtitle.add(child.child("isi").getValue().toString());

                }
                if (title.isEmpty()) {
                    rvView.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                }
                else {
                    rvView.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.GONE);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        rvView.setLayoutManager(new GridLayoutManager(DoaActivity.this, 1));
        adapter = new AdapterDoa(DoaActivity.this,title,subtitle);

        if (title.isEmpty()) {
            rvView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
        else {
            rvView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }
        rvView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
