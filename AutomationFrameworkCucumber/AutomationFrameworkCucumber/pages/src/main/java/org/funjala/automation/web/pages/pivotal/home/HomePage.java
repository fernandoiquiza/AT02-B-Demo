package org.funjala.automation.web.pages.pivotal.home;

import org.funjala.automation.web.model.pivotal.home.HomeModel;
import org.funjala.automation.web.pages.pivotal.help.ContactSupportPage;
import org.funjala.automation.web.pages.pivotal.help.FeedBackPage;
import org.funjala.automation.web.pages.pivotal.help.HelpPageMain;
import org.funjala.automation.web.pages.pivotal.help.LearnMorePage;
import org.funjala.automation.web.pages.pivotal.projects.CreateProjectPage;
import org.funjala.automation.web.pages.pivotal.projects.ProjectsWorkSpacesPage;
import org.funjala.automation.web.pages.pivotal.workspaces.CreateWorkspacePage;
import org.funjala.automation.web.pages.pivotal.workspaces.WorkspaceListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Topo on 9/12/2016.
 */
public class HomePage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = HomeModel.createProjectBtn)
  WebElement createProjectBtn;

  @FindBy(xpath = HomeModel.pivotalBtn)
  private WebElement pivotalBtn;

  @FindBy(xpath = HomeModel.workspaceTab)
  WebElement workspaceTab;

  @FindBy(css = HomeModel.createWorkspaceButton)
  WebElement createWorkspace;

  @FindBy(xpath = HomeModel.logOutBtn)
  WebElement logOutBtn;

  @FindBy(xpath = HomeModel.signOutBtn)
  WebElement signOutBtn;

  @FindBy(xpath = HomeModel.helpLink)
  WebElement helpLink;

  @FindBy(css = "span.Dashboard__Tabs__tab.Dashboard__Tabs__tab--active")
  WebElement projectTab;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  public CreateProjectPage clickCreateProject() {
    wait.until(ExpectedConditions.titleIs(driver.getTitle()));
    wait.until(ExpectedConditions.elementToBeClickable(createProjectBtn));
    wait.until(ExpectedConditions.visibilityOf(createProjectBtn));
    createProjectBtn.click();
    return new CreateProjectPage(this.driver);
  }

  public void logOut() {
    logOutBtn.click();
    signOutBtn.click();
  }

  public ProjectsWorkSpacesPage clickProjectsAndWorkSpaces() {
    pivotalBtn.click();
    return new ProjectsWorkSpacesPage(driver);
  }

  public boolean verifyWorkspaceTab(){
    boolean present;
    try {
      driver.findElement(By.cssSelector("span:nth-child(2)"));
      present = true;
    } catch (NoSuchElementException e) {
      present = false;
    }
    return present;
  }

  public boolean verifyCreateWorkspaceButton(){
    boolean present;
    try {
      driver.findElement(By.cssSelector("div.DashboardV2__Tabs__ActionButton > button"));
      present = false;
    } catch (NoSuchElementException e) {
      present = true;
    }
    return present;
  }

  public WorkspaceListPage clickWorkspaceTab() {
    workspaceTab.click();
    return new WorkspaceListPage(driver);
  }

  public HelpPageMain clickHelpPageButton() {
    helpLink.click();
    return new HelpPageMain(driver);
  }

  public CreateWorkspacePage clickCreateWorkspaceLink() {
    createWorkspace.click();
    return new CreateWorkspacePage(driver);
  }

  public LearnMorePage clickLearnMoreButton() {
    helpLink.click();
    return new LearnMorePage(driver);
  }

  public FeedBackPage clickGiveUsFeedBackLink() {
    helpLink.click();
    return new FeedBackPage(driver);
  }

  public ContactSupportPage clickContactSupportLink() {
    helpLink.click();
    return new ContactSupportPage(driver);
  }

  public boolean verifyProjectTab() {
    boolean present;
    try {
      driver.findElement(By.cssSelector("span.Dashboard__Tabs__tab.Dashboard__Tabs__tab--active"));
      present = true;
    } catch (NoSuchElementException e) {
      present = false;
    }
    return present;
  }

    public WorkspaceListPage clickProjectTab() {
      projectTab.click();
      return new WorkspaceListPage(driver);
    }

  public boolean verifyCreateProjectButton() {
    boolean present;
    try {
      driver.findElement(By.cssSelector("button.button.button--action"));
      present = true;
    } catch (NoSuchElementException e) {
      present = false;
    }
    return present;
  }
}
