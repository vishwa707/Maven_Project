Feature: Testing Login
Scenario Outline: Validate Successful Login
Given user is on the login page
When user enters valid <username> and valid <password>
And Click on Login button 
Then User should be in dashboard 
And close the browser
Examples:
|username|password|
|Admin|admin123|
Scenario Outline: Validate Unsuccessful Login
Given user is on the login page
When user enters invalid <username> and invalid <password>
And Click on Login button 
Then Show error msg "Invalid Credentials" 
And close the browser
Examples:
|username|password|
|Admin|admin|
Scenario: Validate empty credentials
Given user is on the login page
When Click on Login button 
Then Show error msg "Required username and password" 
And close the browser