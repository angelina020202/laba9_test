import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big mfflmpk__b85yax']")).click();

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
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_outlined-themed resplash-btn_mailbox-big mfflmpk__b85yax']")).isDisplayed());

        // Закрытие браузера
        driver.quit();
    }

}
