package com.ex.listadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ex.listadecompras.Modelo.ListaDeCompras;
import com.ex.listadecompras.Modelo.Producto;

public class DetallesActivity extends AppCompatActivity {
    public Producto producto;
    public Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        //obtener la posicion del prducto
        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idProducto");
        //obtener el producto desde el Arraylist
        producto= ListaDeCompras.getInstancia().getProducto(id);

        //Nombre del producto
        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());

        //cantidad y unidad
        TextView txtCantidad=(TextView) findViewById(R.id.txtCantidad);
        txtCantidad.setText("Cantidad:  "+producto.getCantidad()+" "+producto.getUnidad());

        //estado y boton
        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button estado=(Button) findViewById(R.id.estado);
        if(producto.isEstado()==Producto.COMPRADO)
        {
            txtEstado.setText("Comprado");
            estado.setText("Marcar como Pendiente");
        }
        else
        {
         txtEstado.setText("Pendiente");
         estado.setText("Marcar como Comprado");
        }

        estado.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                producto.setEstado(!producto.isEstado());
                setResult(RESULT_OK,intent);
                finish();
            }

            });


    }
}