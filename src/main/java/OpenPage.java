import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

class OpenPage {

    private WebDriver driver;

    OpenPage(WebDriver driver) { this.driver = driver; }

    @Step("Открываем страницу \"{0}\"")
    void checkLink(String s) {
        WebElement link =  driver.findElement(By.linkText(s));
        Assert.assertEquals("Error", s, link.getText());
        link.click();
    }

    @Step("Навести мышкой \"{0}\"")
    void moveTo(String s) {
        WebElement link =  driver.findElement(By.linkText(s));
        new Actions(driver).moveToElement(driver.findElement(By.linkText(s))).perform();
        Assert.assertEquals("Error", s, link.getText());
    }

    @Step("Нажать кнопку \"{0}\"")
    void button(String s) {
        if ("Добавить видео".equals(s)) {
            WebElement button = driver.findElement(By.xpath(".//a[@class='yt-simple-endpoint style-scope ytd-topbar-menu-button-renderer']"));
            button.click();
        }
        if ("Главная страница".equals(s)) {
            driver.findElement(By.xpath(".//a[@id='logo-container']/span")).click();
        }

    }

}
