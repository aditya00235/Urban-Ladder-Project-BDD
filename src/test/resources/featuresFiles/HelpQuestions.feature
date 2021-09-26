Feature: Ask some FAQ 

Scenario Outline: As a user I want to ask some FAQ from application
Given Users opens the browser
And Navigate to the Url
When user click on help icon
And ask help question "<Questions>"
Then It should show the FAQ related to that question
And close browser

Examples:
|Questions									|
|What is the estimated delivery time		|
|Do you ship to my city and location		|