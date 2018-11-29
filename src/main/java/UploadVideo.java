import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class UploadVideo {

    private WebDriver driver;
    public UploadVideo(WebDriver driver) { this.driver = driver; }

    @Step("Загружаем видео")
    void upload() throws InterruptedException {
        driver.findElement(By.xpath(".//input[@type='file']")).sendKeys("C:\\Users\\admin\\IdeaProjects\\youtubeTest1\\src\\main\\resources\\12345testVideo12345.mp4");
        driver.findElement(By.xpath(".//textarea[@class='yt-uix-form-input-textarea video-settings-description']")).sendKeys("Описание видео123");
        driver.findElement(By.xpath(".//input[@class='video-settings-add-tag']")).sendKeys("Тег для видео");

        Thread.sleep(1000);
        driver.findElement(By.xpath(".//button[@class='yt-uix-button yt-uix-button-size-default save-changes-button yt-uix-tooltip yt-uix-button-primary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//button[@class='yt-uix-button yt-uix-button-size-default yt-uix-button-default return-to-editing-button']")).click();
        Thread.sleep(1000);

        Thread.sleep(2000);
        //цикл ожидания загрузки видео
        while (driver.findElement(By.xpath(".//div[@class='upload-status-text' and contains(text(), 'Идет обработка')]")).isDisplayed())
        {
            Thread.sleep(2000);
            if(driver.findElements(By.xpath(".//div[@class='upload-status-text' and contains(text(), 'Загрузка завершена')]")).size() > 0)
                break;
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='yt-uix-button yt-uix-button-size-default save-changes-button yt-uix-tooltip yt-uix-button-primary']")).click();

    }
}
