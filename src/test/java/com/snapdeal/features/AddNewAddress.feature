@AddNewAddress
Feature: AddNewAddress
Scenario: Adding new address
Given Open chromeBrowser and enter url
When clicks on sign in and login
Then enter username and click on continue
When enters password and click on Login button
Then Homepage is displayed
Then click on account
Then cick on orders
When clicks on saved addresses
Then Saved address page is displayed
Then click on Add New Address
Then enter data and click on save.
