package com.ex.listadecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ex.listadecompras.Modelo.ListaDeCompras;
import com.ex.listadecompras.Modelo.Producto;

public class NuevoProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);
        Button btnIngresarProducto=(Button) findViewById(R.id.btnIngresarProducto);
        btnIngresarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           ingresarproducto(view);
            }
        });
    }

    public void ingresarproducto(View view)
    {
      String nombre=((TextView)findViewById(R.id.ingresarNombre)).getText().toString();
      String cantidadStr=((TextView)findViewById(R.id.ingresarCantidad)).getText().toString();
      String unidad=((Spinner)findViewById(R.id.ingresarUnidad)).getSelectedItem().toString();
      String unidadNueva=((TextView)findViewById(R.id.otraUnidad)).getText().toString();

      int cantidad=0;
      try {

          cantidad=Integer.parseInt(cantidadStr);

      }
      catch (NumberFormatException ex)
      {
          Toast.makeText(this,"Debe ingresar un numero en la cantidad",Toast.LENGTH_SHORT).show();
      }
      if (cantidad >0)
      {
          Producto producto;
          if(unidad.equals("Otros") && !(unidadNueva.isEmpty()))
          {
              producto=new Producto(nombre,cantidad,unidadNueva);
          }
          else
          {
              producto=new Producto(nombre,cantidad,unidad);
          }
          //No hay errores
          ListaDeCompras.getInstancia().agregarProducto(producto);
          finish();
      }
      else
      {
          Toast.makeText(this,"Ingrese una cantidad mayor a cero",Toast.LENGTH_SHORT).show();
      }
    }
}