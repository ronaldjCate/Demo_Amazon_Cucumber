package bdd.page;

import bdd.webDriver.DOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuscarProductoPage extends DOM {
    @FindBy(id = "twotabsearchtextbox")
    WebElement txtBuscar;
    @FindBy(id = "nav-search-submit-button")
    WebElement btnBuscar;
    @FindBy(xpath = "//*[contains(text(),'Resultados')]")
    WebElement lblResultado;

    public void hacerClickBuscar(){
        onClick(txtBuscar);
    }
    public void escribirBuscar(String text){
        type(txtBuscar,text);
    }
    public void clickBuscarProducto(){
        onClick(btnBuscar);
    }
    public String validarResultado(){
        return getText(lblResultado);
    }
    public void iniciarNavegador(String url){
        inicializarNavegador(url);
    }
}
