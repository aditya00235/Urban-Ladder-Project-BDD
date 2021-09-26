Feature: Search the products

Scenario Outline: As a user I want to search different products
Given User opens the browser
And Navigate to the URL
When user fills the search text box with "<Product>" and click on searchbutton
Then It shows the products related to searched item
And closes browser

Examples:
|Product		|
|Chair			|
|Dining table	|