Feature:Register User with existing email



  Scenario: TC05 register05

  Given Launch browser
  Then Navigate to url 'AutomationExercise'
  And Verify that home page is visible successfully
  And Click on Signup  Login button
  And Verify New User Signup! is visible
  And Enter name and already registered email address
  And Click Signup button
  And Verify error Email Address already exist! is visible