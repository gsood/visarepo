Narrative:
In order to do web search
As a google user
I want to use google search engine to find search results

Scenario: Gets non zero search results

Given user is on page https://google.co.uk
When user searches for visa europe
Then user gets results
And search result on position 1 is Visa Europe
When user clicks on search result number 1
Then user is taken to http://www.visaeurope.com/en/visa_europe.aspx



Scenario: Gets no search results

Given user is on page https://google.co.uk
When user searches for asdfsdsdg fsddf fdfd fsdjkhgfsdjk sdfsdfsd
Then user gets page with text did not match any documents
