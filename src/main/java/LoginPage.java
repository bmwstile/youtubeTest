import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    @Step("Логинимся \"{0}\" , вводим пароль \"{1}\"")
    void login(String login, String password) throws InterruptedException {
        driver.findElement(By.xpath(".//input[@id='identifierId']")).sendKeys(login);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Далее')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//input[@type='password']")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Далее')]")).click();
    }

    @Step("Выходим из под своей учетки")
    void logout() throws InterruptedException {
        new Actions(driver).moveToElement(driver.findElement(By.xpath(".//button[@id = 'gh-ug']"))).perform();

    }

}
