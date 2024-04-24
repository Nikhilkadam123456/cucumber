Feature: login functionility

Background:
Given user should be on login page

@test1
Scenario: valid login
When user enter valid credentials and click on login button
Then user should navigate to home page
And user click on logout link

@test2
Scenario Outline: Invalid login
When user enter Invalid userid "<userid>" and password "<password>" credentials and click on login button
Then user should navigate to login page
And user can see error message
Examples:
|userid|password|
|admin1|pwd1    |
|admin2|pwd2    |
|admin3|pwd3    |
