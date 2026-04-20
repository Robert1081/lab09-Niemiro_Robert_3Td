package com.example.myapplication;

import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    EditText editText;
  
    TextView textView;

    @Override
  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_main);

      

        editText = findViewById(R.id.editText);
      
        textView = findViewById(R.id.textView);
    }

    public void createFile(View v) {
        String text = editText.getText().toString();
        try {
            FileOutputStream fos = openFileOutput("mojplik.txt", Context.MODE_PRIVATE);
          
            fos.write(text.getBytes());
          
            fos.close();
          
            Toast.makeText(this, "Zapisano", Toast.LENGTH_SHORT).show();
          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



  
    public void readFile(View v) {
        try {
            FileInputStream fis = openFileInput("mojplik.txt");
            int i;
            StringBuilder sb = new StringBuilder();
            while ((i = fis.read()) != -1) {
                sb.append((char)i);
            }
            fis.close();
            textView.setText(sb.toString());
        } catch (IOException e) {
            textView.setText("Błąd odczytu: Brak pliku");
        }
    }


  
    public void deleteFile(View v) {

        getApplicationContext().deleteFile("mojplik.txt");
        Toast.makeText(this, "Plik usunięty", Toast.LENGTH_SHORT).show();
        textView.setText("");
    }
}
