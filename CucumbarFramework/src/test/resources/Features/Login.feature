Feature: login functionility

Scenario: vaild login
Given user should on login page
When user enter vaild crediential
Then user should be on home page   
And user can see logout link

Scenario: Invaild login
Given user should on login page
When user enter Invaild crediential
Then user should be on login page   
And user can see error message