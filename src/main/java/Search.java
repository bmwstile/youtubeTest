import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

public class Search {
    private WebDriver driver;
    public Search(WebDriver driver) { this.driver = driver; }

    @Step("Поиск")
    void search() throws InterruptedException {
        driver.findElement(By.xpath(".//input[@id = 'search']")).sendKeys("TestVideo");
    }

    @Step("Нажать поиск")
    void searchButton() throws InterruptedException {
        driver.findElement(By.xpath(".//button[@id = 'search-icon-legacy']")).click();
    }
}
