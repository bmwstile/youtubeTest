import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.concurrent.TimeUnit;

@Title("Тестовое задание")
public class youtubeTest {

    private WebDriver driver;

    @Step("Открытие ссылок")
    private void openPage(String s) {
        OpenPage openPage = new OpenPage(driver);
        openPage.checkLink(s);
    }

    @Step("Логин")
    private void loginPage(String login, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
    }

    @Step("Нажать на кнопку")
    private void clickOnButton(String s) {
        OpenPage openPage = new OpenPage(driver);
        openPage.button(s);
    }

    @Step("Загрузить видео")
    private void uploadVideo() throws InterruptedException {
        UploadVideo uploadVideo = new UploadVideo(driver);
        uploadVideo.upload();
    }

    @Step("Поиск видео")
    private void searchVideo() throws InterruptedException {
        Search search = new Search(driver);
        search.search();
        search.searchButton();
    }

    @Step("Проверка видео")
    private void checkVideo() throws InterruptedException {
        Search search = new Search(driver);
        search.check();
    }


    @Before
    public void start() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void exit() {
        driver.quit();
    }

    @Test
    @Title("Youtube")
    public void testYoutubeTask() throws InterruptedException {
        OpenPage openPage = new OpenPage(driver);
        driver.get("https://www.youtube.com/");
        openPage.checkLink("ВОЙТИ");
        loginPage("ivanovivanbmw@lenta.ru", "Test1234567890");
        Thread.sleep(1000);
        clickOnButton("Добавить видео");
        openPage.checkLink("Добавить видео");
        Thread.sleep(1000);
        uploadVideo();
        Thread.sleep(1000);
        clickOnButton("Главная страница");
        Thread.sleep(1000);
        searchVideo();
        checkVideo();

    }


}