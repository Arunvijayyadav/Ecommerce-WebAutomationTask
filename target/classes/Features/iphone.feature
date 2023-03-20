Feature: Price Comparison
 
Scenario: Validating Price of iphone13 from two websites
    Given User Opens the Browser
    And  User Enter the first URL"amazon.in"
    When User enter "iphone 13" in first website search box
    When User gets the product details from amazon
    And  User Opens second URL"flipkart.com"
    And  User enter "iphone 13" in second website search box
    When User gets the product details from flipkart
    And  User Validate the price on Amazon and Flipkart and prints in ascending order