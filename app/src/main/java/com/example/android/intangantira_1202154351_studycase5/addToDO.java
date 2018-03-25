package com.example.android.intangantira_1202154351_studycase5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Intan Gantira on 3/25/2018.
 */

public class addToDO extends AppCompatActivity {
    //deklarasi variable yang akan digunakan
    EditText ToDo, Description, Priority;
    database dat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        //set title menjadi add to do
        setTitle("Add To Do");

        //mengakses id edit text pada layout
        ToDo = (EditText) findViewById(R.id.eToDo);
        Description = (EditText) findViewById(R.id.eDesc);
        Priority = (EditText) findViewById(R.id.ePrio);
        dat = new database(this);
    }

    @Override
    public void onBackPressed() {
        //intent dari add to do menuju list to do
        Intent intent = new Intent(addToDO.this, listToDO.class);
        //memulai intent
        startActivity(intent);
        //menutup aktivitas setelah intent dijalankan
        this.finish();
    }

    //method yang dijalanan ketika tombol tambah to do di klik
    public void tambah(View view) {
        //apabila data todoname, deskripsi dan prioritas di isi,
        if (dat.inputdata(new addData(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            //maka akan menampilkan toast bawha data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "To Do List added!", Toast.LENGTH_SHORT).show();
            //berpindah dari add to do ke list to do
            startActivity(new Intent(addToDO.this, listToDO.class));
            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();
        }else {
            //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "Cannot add the list", Toast.LENGTH_SHORT).show();
            //set semua edit text menjadi kosong
            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }

}
