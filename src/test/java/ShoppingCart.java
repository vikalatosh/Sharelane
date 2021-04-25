import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShoppingCart {

    @Test
    public void checkingCalculationTotalPrice() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'shopping_cart')]")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("25");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String totalPrice = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(totalPrice, "245.00", "Incorrect calculation Total,$");
        driver.quit();
    }

    @Test
    public void checkingCalculationDiscount2For20dash49Books() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'shopping_cart')]")).click();
        // Checking discount for 19 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount19 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice19 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice19 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount19, discountPrice19, totalPrice19}, new String[]{"0", "0", "190.00"},
                "Incorrect calculation discount");
        // Checking discount for 20 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount20 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice20 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice20 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount20, discountPrice20, totalPrice20}, new String[]{"2", "4.0", "196.00"},
                "Incorrect calculation discount");
        // Checking discount for 49 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("49");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount49 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice49 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice49 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount49, discountPrice49, totalPrice49}, new String[]{"2", "9.8", "480.20"},
                "Incorrect calculation discount");
        // Checking discount for 50 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("50");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount50 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice50 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice50 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount50, discountPrice50, totalPrice50},
                new String[]{"3", "15.0", "485.00"}, "Incorrect calculation discount");
        driver.quit();
    }

    @Test
    public void checkingCalculationDiscount3For50dash99Books() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'shopping_cart')]")).click();
        // Checking discount for 49 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("49");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount49 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice49 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice49 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount49, discountPrice49, totalPrice49}, new String[]{"2", "9.8", "480.20"},
                "Incorrect calculation discount");
        // Checking discount for 50 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("50");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount50 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice50 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice50 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount50, discountPrice50, totalPrice50},
                new String[]{"3", "15.0", "485.00"}, "Incorrect calculation discount");
        // Checking discount for 99 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("99");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount99 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice99 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice99 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount99, discountPrice99, totalPrice99},
                new String[]{"3", "29.3", "960.3"}, "Incorrect calculation discount");
        // Checking discount for 100 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("100");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount100 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice100 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice100 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount100, discountPrice100, totalPrice100},
                new String[]{"4", "40.0", "960.00"}, "Incorrect calculation discount");
        driver.quit();
    }

    @Test
    public void checkingCalculationDiscount4For100dash499Books() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'shopping_cart')]")).click();
        // Checking discount for 99 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("99");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount99 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice99 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice99 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount99, discountPrice99, totalPrice99},
                new String[]{"3", "29.3", "960.3"}, "Incorrect calculation discount");
        // Checking discount for 100 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("100");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount100 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice100 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice100 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount100, discountPrice100, totalPrice100},
                new String[]{"4", "40.0", "960.00"}, "Incorrect calculation discount");
        // Checking discount for 499 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("499");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount499 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice499 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice499 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount499, discountPrice499, totalPrice499},
                new String[]{"4", "199.6", "4790.40"}, "Incorrect calculation discount");
        // Checking discount for 500 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("500");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount500 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice500 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice500 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount500, discountPrice500, totalPrice500},
                new String[]{"5", "250.0", "4750.00"}, "Incorrect calculation discount");
        driver.quit();
    }

    @Test
    public void checkingCalculationDiscount6For1000dash4999Books() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("vika");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'shopping_cart')]")).click();
        // Checking discount for 999 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("999");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount999 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice999 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice999 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount999, discountPrice999, totalPrice999},
                new String[]{"5", "499.5", "9490.5"}, "Incorrect calculation discount");
        // Checking discount for 1000 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("1000");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount1000 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice1000 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice1000 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount1000, discountPrice1000, totalPrice1000},
                new String[]{"6", "600.0", "9400.00"}, "Incorrect calculation discount");
        // Checking discount for 4999 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("4999");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount4999 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice4999 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice4999 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount4999, discountPrice4999, totalPrice4999},
                new String[]{"6", "2999.4", "46990.60"}, "Incorrect calculation discount");
        // Checking discount for 5000 books
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("5000");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discount5000 = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        String discountPrice5000 = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        String totalPrice5000 = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(new String[]{discount5000, discountPrice5000, totalPrice5000},
                new String[]{"7", "3500.0", "46500.00"}, "Incorrect calculation discount");
        driver.quit();
    }
}
