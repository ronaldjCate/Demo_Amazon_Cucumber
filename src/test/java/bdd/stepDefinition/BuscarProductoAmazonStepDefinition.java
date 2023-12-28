package bdd.stepDefinition;

import bdd.step.BuscarProductoStep;
import bdd.webDriver.DOM;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;

public class BuscarProductoAmazonStepDefinition {

    private final BuscarProductoStep buscarProductoStep = new BuscarProductoStep();
    private final DOM dom = new DOM();
    private Scenario scenario;

    @After
    public void afterScenario(Scenario scenario) {
        this.scenario = scenario;
        dom.takeScreenShot(scenario);
        dom.quitDriver();
    }

    @Given("ingreso a la pagina de amazon {string}")
    public void ingresoALaPaginaDeAmazon(String url) {
        buscarProductoStep.stepIniciarNavegador(url);
    }

    @When("ingreso el producto a buscar {string}")
    public void ingresoElProductoABuscar(String producto) {
        buscarProductoStep.stepHacerClickBuscar();
        buscarProductoStep.stepEscribirBuscar(producto);
    }

    @And("selecciono buscar")
    public void seleccionoBuscar() {
        buscarProductoStep.stepClickBuscarProducto();
    }

    @Then("debe mostrar el valor {string}")
    public void debeMostrarElValor(String esperado) {
        Assertions.assertEquals(esperado,buscarProductoStep.stepValidarResultado());
    }
}
