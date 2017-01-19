Feature: Dashboard
  This test will verify if Dashboard elements are being loaded.

Background: Login
    Given I am at the Pivotal Tracker page
    And I put fernando.iquiza@fundacion-jala.org as username and press Next button
    And I put MTat676435019 as password and press Submit button


  Scenario: Verify that workspace button is clickable
    Given Workspace button is displayed.
    And I click Workspace button
    Then I should see CreateWorkspace button displayed

  Scenario: Verify that project button is clickable
    Given Project button is displayed.
    And I click Project button
    Then I should see CreateProject button displayed