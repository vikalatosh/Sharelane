import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    @Test
    public void zipCodeShouldAccept5Digits() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        // Убедиться, что мы на странице Sign Up
        boolean isOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isOpened, "страница регистрации не открылась");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept6Digits() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 6 цифр (например 123456)
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "сообщение об ошибке (zip code) некорректное");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotAccept4Digits() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 4 цифр (например 1234)
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "сообщение об ошибке (zip code) некорректное");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void successfulSignUp() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Убедиться, что мы на странице Sign Up, Account is created!
        boolean Created = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        Assert.assertTrue(Created, "регистрация пройдена не успешно");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void firstNameShouldNotAcceptInvalidData() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("вика");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Убедиться, что на странице сообщение "Oops, error on page. Some of your fields have invalid data or email
        // was previously used"
        String error2 = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error2, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "сообщение об ошибке (first name) некорректное");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void emailShouldNotAcceptInvalidChars() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("tes,t@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Убедиться, что на странице сообщение "Oops, error on page. Some of your fields have invalid data or email
        // was previously used"
        String error2 = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error2, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "сообщение об ошибке (first name) некорректное");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void emailShouldNotAcceptInvalidData() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmailcom");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Убедиться, что на странице сообщение "Oops, error on page. Some of your fields have invalid data or email
        // was previously used"
        String error2 = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error2, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "сообщение об ошибке (first name) некорректное");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void passwordShouldNotAcceptInvalidData() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1");
        driver.findElement(By.name("password2")).sendKeys("1");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Убедиться, что на странице сообщение "Oops, error on page. Some of your fields have invalid data or email
        // was previously used"
        String error2 = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error2, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "сообщение об ошибке (password) некорректное");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void passwordShouldUseTypePassword() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String type = driver.findElement(By.cssSelector("type")).getAttribute("type");
        Assert.assertEquals(type, "password", "Неверный тип данных Password");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void confirmPasswordShouldBeEqualPassword() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Убедиться, что на странице сообщение об ошибке
        String error2 = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error2, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "нет проверки на совпадение Password и Confirm Password");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void successfulLogin() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Убедиться, что мы на странице Sign Up, Account is created!
        boolean Created = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        Assert.assertTrue(Created, "регистрация пройдена не успешно");
        // Сохранить Email
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        // Убедиться, что мы на главной странице (Login)
        boolean Login = driver.findElement(By.cssSelector("[value=Login]")).isDisplayed();
        Assert.assertTrue(Login, "не перешли на главную страницу");
        // Ввести Email и Password
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        // Убедиться, что авторизация пройдена успешно
        boolean Logout = driver.findElement(By.linkText("Logout")).isDisplayed();
        Assert.assertTrue(Logout, "Авторизация не пройдена");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void successfulAddBookToCart() {
        // Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открыть страницу https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Ввести любые 5 цифр (например 12345)
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Нажать Continue
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        // Убедиться, что мы на странице Sign Up, Account is created!
        boolean Created = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        Assert.assertTrue(Created, "регистрация пройдена не успешно");
        // Сохранить Email
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        // Убедиться, что мы на главной странице (Login)
        boolean Login = driver.findElement(By.cssSelector("[value=Login]")).isDisplayed();
        Assert.assertTrue(Login, "не перешли на главную страницу");
        // Ввести Email и Password
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        // Убедиться, что авторизация пройдена успешно
        boolean Logout = driver.findElement(By.linkText("Logout")).isDisplayed();
        Assert.assertTrue(Logout, "Авторизация не пройдена");
        // Выбрать книгу
        driver. findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        // Добавить в корзину
        String author = driver.findElement(By.xpath("(//b)[1]")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        // Убедиться, что книга выбранного автора добавлена в корзину
        boolean message = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        Assert.assertTrue(message, "Сообщение о добавлении книги отсутствует");
        driver.findElement(By.xpath("//a[contains(@href, 'shopping_cart')]")).click();
        String author1 = driver.findElement(By.xpath("//tr[5]//tr[2]/td[1]")).getText();
        Assert.assertEquals(author1, author,"Книга выбранного автора не добавлена в Shopping Cart");
        // Закрыть браузер
        driver.quit();
    }
}


