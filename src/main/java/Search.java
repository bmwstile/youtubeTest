import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

public class Search {
    private WebDriver driver;
    public Search(WebDriver driver) { this.driver = driver; }

    @Step("Поиск")
    void search() throws InterruptedException {
        driver.findElement(By.xpath(".//input[@id = 'search']")).sendKeys("12345TestVideo12345 Ivan Beliy");
    }

    @Step("Нажать поиск")
    void searchButton() throws InterruptedException {
        driver.findElement(By.xpath(".//button[@id = 'search-icon-legacy']")).click();
    }

    @Step("Проверка")
    void check() throws InterruptedException {
        //ожидание появления видео на сайте
        int flag=2;
        while (flag > 1) {
            if (driver.findElements(By.xpath(".//a[@id = 'video-title' and contains(text(), '12345testVideo12345')]")).size() > 0) {
                Assert.assertTrue(driver.findElement(By.xpath(".//a[@id = 'video-title' and contains(text(), '12345testVideo12345')]")).isDisplayed());
                Assert.assertTrue(driver.findElement(By.xpath(".//a[@class = 'yt-simple-endpoint style-scope yt-formatted-string' and contains(text(), 'Ivan Beliy')]")).isDisplayed());
                Assert.assertTrue(driver.findElement(By.xpath(".//yt-formatted-string[@id = 'description-text' and contains(text(), 'Описание видео123')]")).isDisplayed());
                System.out.println("test");
                flag=0;
            }
            Thread.sleep(5000);
            searchButton();
            System.out.println("test1");
        }
        //driver.findElement(By.xpath(".//span[@class = 'style-scope ytd-channel-renderer' and contains(text(), 'Ivan Beliy')]")).click();
        //Thread.sleep(1000);

    }

}
