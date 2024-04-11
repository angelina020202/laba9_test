import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainClass {

    @Test
    public void FirstTest() throws InterruptedException {
        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\Maven1\\drivers\\chromedriver.exe");

        // Инициализируем Chrome драйвер
        WebDriver driver = new ChromeDriver();
        // Переход на сайт
        driver.get("https://mail.ru/");

        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big ejf-iekc__1jdtl7f']")).click();

        // Переключение на iframe
        WebElement iframeElement = driver.findElement(By.cssSelector("iframe.ag-popup__frame__layout__iframe"));
        driver.switchTo().frame(iframeElement);

        // Ввод логина
        driver.findElement(By.xpath("//*[@class='input-0-2-71']")).sendKeys("atazrasheva");
        // Клик по кнопке входа
        driver.findElement(By.xpath("//*[contains(@class, 'inner-0-2-81 innerTextWrapper-0-2-82')]")).click();
        // Клик по кнопке "Войти с паролем"
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        driver.findElement(By.xpath("//*[contains(@class, 'inner-0-2-81 innerTextWrapper-0-2-82')]")).click();
        // Ввод пароля
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        driver.findElement(By.xpath("//*[@class='input-0-2-71 withIcon-0-2-72']")).sendKeys("testformail");
        // Клик по кнопке входа
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        driver.findElement(By.xpath("//*[contains(@class, 'inner-0-2-81 innerTextWrapper-0-2-82')]")).click();

        // Возвращаемся к основной странице
        driver.switchTo().defaultContent();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Клик по аватарке пользователя
        driver.findElement(By.xpath("//*[@class='ph-avatar-img svelte-dfhuqc']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Проверка имени пользователя
        Assert.assertEquals("Test Lab",driver.findElement(By.xpath("//*[@class='ph-name svelte-1popff4']")).getText());

        // Выход из аккаунта
        driver.findElement(By.xpath("//*[@data-testid='whiteline-account-exit']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Проверка наличия кнопки "Создать почту"
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_outlined-themed resplash-btn_mailbox-big ejf-iekc__1jdtl7f']")).isDisplayed());

        // Закрытие браузера
        driver.quit();
    }
    @Test
    public void SecondTest() throws InterruptedException{


        System.setProperty("webdriver.chrome.driver", "D:\\Maven1\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://habr.com/ru/all/");
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search tm-header-user-menu__icon_dark']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        WebElement input = driver.findElement(By.xpath("//input[@name='q']"));
        Assert.assertEquals(input, driver.switchTo().activeElement());

        input.sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        driver.findElement(By.linkText("Что такое Selenium?")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        Assert.assertEquals("28 сен 2012 в 16:14", driver.findElement(By.cssSelector("[title='2012-09-28, 16:14']")).getText());
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        driver.findElement(By.xpath("//a[@href='/ru/articles/' and @class='footer-menu__item-link router-link-active']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        driver.quit();

    }

}
