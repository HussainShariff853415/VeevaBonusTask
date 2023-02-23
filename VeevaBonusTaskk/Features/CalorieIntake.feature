Feature: To calculate the calorie intake per day

Scenario Outline: Calculation of calorie intake per day for male
    Given Launch the application in a browser 
    When user enters the age <age>
    And clicks male radio button for geneder selection
    And Enters Height <height> weight <weight> in respective text fields
    And selects activity <activity> from the dropdown box and clicks calcutlate button
    Then user should see calorie intake per day under results

    Examples: 
      | age  | height  | weight  |activity|
      | 24	 |     157 | 65			 |Moderate:|
      
      
