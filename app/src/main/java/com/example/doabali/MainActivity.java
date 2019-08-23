package com.example.doabali;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        for(int a=0; a < 8; a++) {
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
//            DatabaseReference myRef = database.getReference("kidung");
//            Map mParent = new HashMap();
//            mParent.put("url", "https://firebasestorage.googleapis.com/v0/b/desa-d3f44.appspot.com/o/gambar%2FIMG_4394.JPG?alt=media&token=65468fc5-fa16-4cbd-9c03-56130a56a6e1");
//            mParent.put("title", "Judul Kegiatan "+(a+1));
//            mParent.put("isi", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
//            String kunci = myRef.push().getKey();
//            //Toast.makeText(TambahProdukActivity.this, "key :"+kunci, Toast.LENGTH_SHORT).show();
//
//            myRef.child(kunci).setValue(mParent).addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//
//
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//
//                }
//            });
//
//        }

    }

    public void hari_raya(View view) {
        Intent intent = new Intent(MainActivity.this, HariRayaActivity.class);
        startActivity(intent);
    }

    public void doa(View view) {
        Intent intent = new Intent(MainActivity.this, DoaActivity.class);
        startActivity(intent);
    }

    public void kidung(View view) {
        Intent intent = new Intent(MainActivity.this, KidungActivity.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        finishAffinity();
    }
}
