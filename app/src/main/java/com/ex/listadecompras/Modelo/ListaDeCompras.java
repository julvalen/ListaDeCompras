package com.ex.listadecompras.Modelo;

import java.util.ArrayList;

public class ListaDeCompras {
    //Patron de diseño Singleton:solo un objeto ListaDeCompras en memoria

    private static ListaDeCompras instancia=new ListaDeCompras();

    private ArrayList<Producto> listaDeCompras;

    //Constructor singleton

    private ListaDeCompras()
    {
      listaDeCompras=new ArrayList<>();
     // agregarProducto(new Producto("pan",2,"kilos"));
    }

    //Metodo para devolver la instancia

    public static ListaDeCompras getInstancia()
    {
        return instancia;
    }
    //metodo para agregar un producto
    public void agregarProducto(Producto producto)
    {
        listaDeCompras.add(producto);
    }
    //leer un producto deacuerdo a su posicion
    public Producto getProducto(int id)
    {
        return listaDeCompras.get(id);
    }
    //leer la lista completa
    public ArrayList<Producto> getListaDeCompras()
    {
        return listaDeCompras;
    }
    public void eliminarComprados()
    {
       for (int i=0; i<listaDeCompras.size();i++)
       {
           if (listaDeCompras.get(i).isEstado()==Producto.COMPRADO)
           {
               listaDeCompras.remove(i);
               i--;
           }
       }
    }
}
