package mail.Suite;

import mail.test.Base;
import mail.test.DateAuthorization;
import mail.test.DateLetter;
import org.testng.annotations.Test;

public class TestSuite extends Base {

    @Test
    public void TestSuite() throws InterruptedException {
        testMethod.authorization(new DateAuthorization("testuserforql", "pas042389234word"));
        testMethod.writeLetter(new DateLetter("burylov.artem@quality-lab.ru", "Тестовое задание от Quality-lab", "Hello Quality-lab"));
        testMethod.send();

    }

}
