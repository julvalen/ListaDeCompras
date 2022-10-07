package com.ex.listadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ex.listadecompras.Modelo.ListaDeCompras;
import com.ex.listadecompras.Modelo.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button verLista=(Button) findViewById(R.id.ver_lista);
        verLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Producto> productos= ListaDeCompras.getInstancia().getListaDeCompras();
                if(productos.size() > 0)
                {
                    Intent intent=new Intent(MainActivity.this,ListaProductosActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"La lista de compras esta vacia",Toast.LENGTH_SHORT).show();
                }



            }
        });

        Button botonNuevo=(Button) findViewById(R.id.botonNuevo);
        botonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NuevoProductoActivity.class);
                startActivity(intent);

            }
        });

        Button botonEliminar=(Button) findViewById(R.id.botonEliminar);
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListaDeCompras.getInstancia().eliminarComprados();
                Toast.makeText(MainActivity.this,"Se han eliminado los productos comprados",Toast.LENGTH_SHORT).show();
            }
        });

    }
}