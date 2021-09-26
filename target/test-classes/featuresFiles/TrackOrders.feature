Feature: Track the placed orders

Scenario Outline: As a user I want to track the details of my placed orders
Given Opens the browser
And Go to URL
When user click on track order icon
And fills the details "<OrderNumber>" and "<PhoneNumber>" on track order page
Then It shows the tracking details
And closes browsers

Examples:
|OrderNumber	|PhoneNumber	|
|123456			|7464012345		|
|234567			|7464023456		|