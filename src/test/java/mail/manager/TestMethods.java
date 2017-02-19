package mail.manager;

import mail.test.DateAuthorization;
import mail.test.DateLetter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mr.robot on 19.02.2017.
 */
public class TestMethods {
  ChromeDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void start() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.manage().window().maximize();
  }

  public void send() {
    String keysPressed = Keys.chord(Keys.CONTROL, Keys.RETURN);
    wd.findElement(By.name("Subject")).sendKeys(keysPressed);
  }

  public void writeLetter(DateLetter DateLetter) throws InterruptedException {
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.findElement(By.linkText("Написать письмо")).click();
    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    type(By.cssSelector("textarea.js-input.compose__labels__input"), DateLetter.getRecipient());
    type(By.name("Subject"), DateLetter.getSubject());

    wd.findElement(By.name("Subject")).sendKeys(Keys.TAB);
    moveOnFrame();
    writeInFrame(DateLetter);
    outOfTheFrame();
  }

  public void writeInFrame(DateLetter DateLetter) {
    wd.getKeyboard().sendKeys(DateLetter.getText());
  }

  public void outOfTheFrame() {
    wd.switchTo().defaultContent();
  }

  public void moveOnFrame() {
    wd.switchTo().frame(1);
  }

  public void authorization(DateAuthorization dateAuthorization) {
    wd.get("https://mail.ru/");

    type(By.id("mailbox__login"), dateAuthorization.getUsername());
    type(By.id("mailbox__password"), dateAuthorization.getUserpassword());

    wd.findElement(By.id("mailbox__auth__button")).click();
  }

  public void type( By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void stop() {
    wd.quit();
  }

}
