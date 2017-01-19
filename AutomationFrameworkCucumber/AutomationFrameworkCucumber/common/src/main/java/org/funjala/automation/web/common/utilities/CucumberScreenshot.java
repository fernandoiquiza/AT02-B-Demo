package org.funjala.automation.web.common.utilities;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.funjala.automation.web.common.drivers.Driver.driver;

/**
 * Created by David on 1/13/2017.
 */
public class CucumberScreenshot {

  public CucumberScreenshot() {
  }
  public void takeScreenshot(Scenario scenario) throws IOException {
    if (scenario.isFailed()) {
      byte[] myScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      FileOutputStream out = new FileOutputStream("../pivotaltracker/reports/cucumber/Screenshots/failure-screenshot-"
              + (scenario.getName()).replace(" ", "-") + ".png");
      out.write(myScreenshot);
      scenario.embed(myScreenshot, "image/png");
      Reporter.log("<a href=../" + myScreenshot + "> " + scenario.getName() + ".png </a>");
      out.close();
    }
  }
}
