Feature: Login User with incorrect email and password

  Scenario: Login User with email and password

  And Launch browser
  And Navigate to url 'AutomationExercise'
  And Verify that home page is visible successfully
  And Click on Signup  Login button
  And Verify Login to your account is visible
  And Enter incorrect email address and password
  And Click login button
  And Verify error Your email or password is incorrect! is visible