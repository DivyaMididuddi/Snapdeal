@BuyGiftCard
Feature: Gift card
Scenario: Buy Gift card
Given open ChromeBrowser and enter url
Then clicks on Signin and clicks on Login
Then enter Email
And Click on continue
Then Enter Password 
When clicks on log in button
Then Homepage should be displayed
When clicks on Gift Cards
Then Digital Entertainment page is displayed
And select a gift card and click on it
Then click on Buy Now
And enter data and click on save and continue
Then click on proceed to payment
Then  click on pay


