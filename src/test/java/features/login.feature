Feature: Login
	Scenario Outline: User should be able to login with valid credential
		Given User is at login page
		When user enters valid username "<username>" and password "<password>"
		Then User should be directed to home page with title "<title>"
	Examples:
	|username|password|title|
	|user| demouser|Deepanshu|	
