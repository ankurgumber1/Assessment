Feature: Registration Page Feature

Scenario: Registration Page Title
Given User is on registration page
When user gets the title of the page
Then page title should be "Create New Customer Account"

Scenario: Fill the registration form
Given User is on registration page
When user fill the registration form from random generation data
And user click on submit button
Then user gets the title of the page
And page title should be "My Account"
And user should get success message "Thank you for registering with Main Website Store."