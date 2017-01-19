package org.funjala.automation.web.pivotal.steps.dashboard;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.funjala.automation.web.common.api.ApiProjects;
import org.funjala.automation.web.common.api.Workspace;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.CucumberScreenshot;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.model.pivotal.home.HomeModel;
import org.funjala.automation.web.model.pivotal.workspaces.WorkspaceModel;
import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.funjala.automation.web.pages.pivotal.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 1/18/2017.
 */
public class dashboardSteps {

  HomePage home;
  Log log = Log.getInstance();
  WebDriver driver;
  LoginPage login;
  Workspace workspace;
  WebDriverWait wait;


  @Given("^I am at the Pivotal Tracker page$")
  public void onPivotalTrackerPage() throws IOException {
    log.info("Step", "I am on Pivotal Tracker page", "Going to pivotal tracker page");
    driver = Driver.getDriver().openBrowser();
    login = new LoginPage(driver);
  }

  @And("^I put ([^\"]*) as username and press Next button$")
  public void putNameAndPressNextButton(String userName) {
    log.info("Step", "I put a " + userName + " and press Next button", "Inserting username");
    login.setUserName(userName);
    login.clickContinue();
  }

  @And("^I put ([^\"]*) as password and press Submit button$")
  public void putPasswordAndPressSubmitButton(String password) {
    log.info("Step", "I put a " + password + " and press Submit button", "Inserting password and pressing submit button");
    login.setPassword(password);
    home = login.clickSubmit();
  }

//  @Then("^I should be in Dashboard page$")
//  public void dashboardPageShouldBeDisplayed() {
//    driver.getTitle();
//    Assert.assertEquals(driver.getTitle(), "Dashboard - Pivotal Tracker");
//  }

  @Given("^Workspace button is displayed.$")
  public void workspaceSButtonIsDisplayed()  {
  home.verifyWorkspaceTab();
  }

  @And("^I click Workspace button$")
  public void iClickWorkspaceButton()  {
    home.clickWorkspaceTab();
  }

  @Then("^I should see CreateWorkspace button displayed$")
  public void iShouldSeeCreateWorkspaceButtonDisplayed(){
     assertTrue(home.verifyCreateWorkspaceButton());
  }


  @Given("^Project button is displayed.$")
  public void projectButtonIsDisplayed() {
    home.verifyProjectTab();

  }

  @And("^I click Project button$")
  public void iClickProjectButton()  {
    home.clickProjectTab();

  }

  @Then("^I should see CreateProject button displayed$")
  public void iShouldSeeCreateProjectButtonDisplayed()  {
    assertTrue(home.verifyCreateProjectButton());
  }

  @After()
  public void logout(Scenario scenario) throws IOException {
    CucumberScreenshot screenshot = new CucumberScreenshot();
    screenshot.takeScreenshot(scenario);
    log.info("Step", "Logout of the account", "Quiting of the account");
    home.logOut();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    log.info("Step", "Go to the login page", "Going to the login page");
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
  }

}


