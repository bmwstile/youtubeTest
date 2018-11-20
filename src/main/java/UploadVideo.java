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
        driver.findElement(By.xpath(".//input[@type='file']")).sendKeys("C:\\Users\\admin\\IdeaProjects\\youtubeTest\\src\\main\\resources\\testVideo.mp4");
        driver.findElement(By.xpath(".//textarea[@class='yt-uix-form-input-textarea video-settings-description']")).sendKeys("Описание видео");
        driver.findElement(By.xpath(".//input[@class='video-settings-add-tag']")).sendKeys("Тег для видео");
        Thread.sleep(10000);
        driver.findElement(By.xpath(".//button[@class='yt-uix-button yt-uix-button-size-default save-changes-button yt-uix-tooltip yt-uix-button-primary']")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class='item-title upload-cursor-pointer']")).isDisplayed());
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//button[@class='yt-uix-button yt-uix-button-size-default yt-uix-button-default return-to-editing-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='yt-uix-button yt-uix-button-size-default save-changes-button yt-uix-tooltip yt-uix-button-primary']")).click();




    }




//<span class="progress-bar-text-done">Обработка завершена
//</span>

//    <textarea class="yt-uix-form-input-textarea video-settings-description"
//    name="description" placeholder="Описание" data-initial-value="" data-ita-enable="true" rows="6" aria-label="Описание"></textarea>

//    <input class="video-settings-add-tag" spellcheck="false" autocomplete="false" aria-haspopup="true"
//    placeholder="Теги (например: Альберт Эйнштейн, мэшап, рак на горе)" data-ita-enable="true" aria-label="Теги помогают зрителям найти ваши видео и канал. Добавить теги?">

//    <span class="yt-uix-button-content">Опубликовать</span>
}
