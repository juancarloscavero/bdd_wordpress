Feature: Post
  @valid
  Scenario: add a post
    Given I am logged
    When I press in add button
    And I fill the fields
    Then I see my post

  @valid
  Scenario: delete post
    Given I am in post page
    When I press button delete
    Then Post deleted

  @invalid
  Scenario: add a invalid post
    Given I am logged
    When I press in add button
    And I fill fields with special characters
    Then I see my post


  @valid
  Scenario: delete post
    Given I am in post page
    When I press button delete
    Then Post deleted
