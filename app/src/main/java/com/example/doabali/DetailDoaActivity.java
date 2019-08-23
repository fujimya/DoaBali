package com.example.doabali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailDoaActivity extends AppCompatActivity {
    TextView title,isi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_doa);
        title = findViewById(R.id.texttitle);
        isi = findViewById(R.id.isi);

        title.setText(""+getIntent().getExtras().getString("title"));
        isi.setText(""+getIntent().getExtras().getString("isi"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
