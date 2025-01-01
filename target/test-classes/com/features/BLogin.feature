Feature: Login Page Feature

Scenario: Login Page Title
Given User is on login page
When user gets the title of the login page
Then login page title should be "Customer Login"

Scenario: Login in application with valid credentials
Given User is on login page
When user input the valid credentials
And user click on signin button
Then user gets the title of the login page
And login page title should be "Home Page"
