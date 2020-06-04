Narative:
This story covers basics test of main page

Scenario: Check amount books on page
Given I open main page
When I open book's catalog
Then I check that page have 20 books

Scenario: Check that book with title present on page
Given I open main page
When I open book's catalog
When I sout text
Then I check that book with "<bookTitle>" title book present on page
Examples:
|bookTitle               |
|Hacking Exposed Wireless|
|Silence On The Wire     |
|Hackers                 |
|fUCKERS                 |