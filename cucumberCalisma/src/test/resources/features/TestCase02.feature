Feature: Login User with correct email and password


  Scenario Outline: Login ol
    Given Launch browser
    And   Navigate to url <url>
    And   Verify that home page is visible successfully
    And   Click on Signup  Login button
    And   Verify Login to your account is visible
    And   Enter correct email address and password
    And   Click login button
    And   Verify that Logged in as username is visible
    And   Click Delete Account button
    And   Kullanici tarayiciyi kapatir
   #And  Verify that ACCOUNT DELETED is visible
    Examples:
      | url |
      |'AutomationExercise'|
      |'AmazonUrl'|
