  @test
  Feature: Purchase data from e-comm website
  
  Background:
  Given I landed on Ecommerece page
  
  
  @test1
  Scenario Outline: Add an employee
   Given I login with username <name> and password <password>
   Then I add employee with firstname <empfname> name and <emplname> last name
   Then I edit employee details
   
   
    Examples: 
      | name  | password | | empfname | | emplname |
      | Admin | admin123 | | Shailja  | | Gautam   |
      
      
     
      