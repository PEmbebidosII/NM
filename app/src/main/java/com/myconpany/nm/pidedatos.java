package com.myconpany.nm;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;


public class pidedatos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pidedatos);

        TextView textoPidePresup = (TextView) findViewById(R.id.texto_presup);
        final TextView muestraTexto = (TextView) findViewById(R.id.multiTexto);

        final EditText editaPidePresup = (EditText) findViewById(R.id.edit_presup);

        Button botonGuarda = (Button) findViewById(R.id.boton_guarda);
        final Button mostrar_dato = (Button) findViewById(R.id.mostrar_dato);

        botonGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String presupuesto_1 = editaPidePresup.getText().toString();
                    OutputStreamWriter fout= new OutputStreamWriter(openFileOutput("guarda_dato.txt", CONTEXT_IGNORE_SECURITY));
                    //fout.write("guardando datos\n");
                    fout.write(presupuesto_1);
                    fout.close();
                    Toast.makeText(getBaseContext(),
                            "El archivo ha sido guardado", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    android.util.Log.e("Ficheros", "Error al escribir fichero a memoria interna");

                }

            }
        });

        //------Mostrando dato en pantalla-------


        mostrar_dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    java.io.BufferedReader fin = new java.io.BufferedReader(new InputStreamReader(openFileInput("guarda_dato.txt")));
                    String texto = fin.readLine();

                    fin.close();
                    muestraTexto.setText(texto);
                    //Toast.makeText(getBaseContext(),
                    //        "El archivo ha sido cargado", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    android.util.Log.e("Ficheros", "Error al leer fichero desde memoria interna");
                }

            }
        });



    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pidedatos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
