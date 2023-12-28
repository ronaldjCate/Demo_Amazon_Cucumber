package bdd.webDriver;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class DOM {

    static String screenshotDir="D:\\itera\\auto\\reto_yape\\auto\\demoWeb-Cucumber\\src\\test\\resources\\evidencias";

    private static WebDriver driver;
    public static WebDriver webDriver(){
        if (driver==null){
            String edgeDriverPath="C:\\Users\\Ronald\\IdeaProjects\\Demo_Amazon_Cucumber\\src\\test\\resources\\webDriver\\edge\\msedgedriver.exe";
            System.setProperty("webDriver.edge.driver",edgeDriverPath);
            driver=new EdgeDriver();
        }
        return driver;
    }

    public DOM(){
        PageFactory.initElements(webDriver(),this);
    }
    public void takeScreenShot(Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) webDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Captura de pantalla");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(WebElement element){
        element.click();
    }
    public void type(WebElement element, String text){
        element.sendKeys(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public static void inicializarNavegador(String url){
        webDriver().get(url);
        webDriver().manage().window().maximize();
    }

    public void quitDriver(){
        webDriver().quit();
    }
}
