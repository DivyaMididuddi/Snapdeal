@Login
Feature: Login action
Scenario: Successful login
Given Open ChromeBrowser and enter url
Then click on sigin and login
Then enter username
When clicks on continue
Then enter password
When clicks on login
Then homepage should be displayed