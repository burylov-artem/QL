package mail.test;

import mail.manager.TestMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by mr.robot on 19.02.2017.
 */
public class Base {

  protected final TestMethods testMethod = new TestMethods();

  @BeforeMethod
  public void setUp() throws Exception {
    testMethod.start();
  }

  @AfterMethod
  public void tearDown() {
    testMethod.stop();
  }

}
