@WebLuxoftTraining
Feature: This feature used to check correctness of visited pages
@Ex2
  Scenario: Checking that schedule webpage contains required buttons and visual elements
    Given 'home page' is opened
    When user clicks on 'Schedule'
    Then this buttons displayed on 'Schedule' webpage
      | Schedule          |
      | Free seminars |
      | Online-courses        |
@Ex3
  Scenario: Checking that contact webpage contains required buttons and visual elements
    Given 'home page' is opened
    When user clicks on 'Contacts'
    Then this buttons displayed on 'Contacts' webpage
      | Moscow          |
      | Saint-Petersburg |
      | Omsk            |
    And this buttons not displayed on 'Contacts' webpage
      | Екатеринбург |
@Ex4
  Scenario Outline: when user moves to "Каталог" webpage, he can find SQA-050 and SQA-051 courses.
  Course is found when link with it's name displayed
    Given '<First page>' is opened
    When user clicks on '<Clicked>'
    And clicks 'Complex Programs' and types '<Search>'
    Then this links displayed on '<Clicked>' webpage
    |'<Search>'|
    Examples:
      | First page | Clicked | Search  |
      | home page  | Catalog | автомат |
      | home page  | Catalog | SQA-050 |

