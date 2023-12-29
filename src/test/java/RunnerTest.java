import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;

public class RunnerTest {
    /*
    public static void main(String[] args) {


        System.setProperty("webDriver.edge.driver","D:\\itera\\auto\\reto_yape\\auto\\demoWeb-Cucumber\\src\\test\\resources\\webDriver\\msedgedriver.exe");
        WebDriver driver1 = new EdgeDriver();
        String screenshotDir = "D:\\itera\\auto\\reto_yape\\auto\\demoWeb-Cucumber\\src\\test\\resources\\evidencias";
        driver1.get("https://www.amazon.com/-/es/");
        driver1.manage().window().maximize();
        takeScreenShot(driver1,screenshotDir,"screenshot1.png");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement txtBuscar = driver1.findElement(By.id("twotabsearchtextbox"));
        WebElement btnBuscar = driver1.findElement(By.id("nav-search-submit-button"));

        txtBuscar.click();
        txtBuscar.sendKeys("Libro de selenium");
        takeScreenShot(driver1,screenshotDir,"screenshot2.png");
        btnBuscar.click();

        WebElement lblResultado = driver1.findElement(By.xpath("//*[contains(text(),'Resultados')]"));
        String resultado = lblResultado.getText();
        System.out.println("Resultado: "+resultado);
        String esperado = "Resultados";
        Assertions.assertEquals(resultado,esperado);
        takeScreenShot(driver1,screenshotDir,"screenshot3.png");
        //Thread.sleep(5000);
        driver1.quit();


    }

    public static void takeScreenShot(WebDriver driver, String screenshotDir, String fileName){
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationPath = screenshotDir+fileName;
        try {
            FileUtils.copyFile(screenshotFile,new File(destinationPath));
            System.out.println("Captura de pantalla guardad");
        } catch (IOException e) {
            System.out.println("Error en la captura de pantalla guardad");
            throw new RuntimeException(e);
        }
    }

         */
}
