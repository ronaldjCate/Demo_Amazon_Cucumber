package bdd.step;

import bdd.page.BuscarProductoPage;

public class BuscarProductoStep {

    public BuscarProductoPage buscarProductopage(){
        return new BuscarProductoPage();
    }

    public void stepHacerClickBuscar(){
        buscarProductopage().hacerClickBuscar();
    }
    public void stepEscribirBuscar(String text){
        buscarProductopage().escribirBuscar(text);
    }
    public void stepClickBuscarProducto(){
        buscarProductopage().clickBuscarProducto();
    }
    public String stepValidarResultado(){
        return buscarProductopage().validarResultado();
    }
    public void stepIniciarNavegador(String url){
        buscarProductopage().iniciarNavegador(url);
    }

}
