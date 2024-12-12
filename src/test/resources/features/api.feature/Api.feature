@smokeApi
@Api

Feature: Api Scenarios

  Background:
    Given send get request and save response

  Scenario Outline: check user & post count
    Then user <user> should have <numPosts> posts
    Examples:
      | user | numPosts |
      | 1    | 10      |
      | 2    | 10      |
      | 5    | 10      |
      | 7    | 10      |
      | 9    | 10      |


  Scenario: Unique ID per post
    Then each blog post should have a unique ID
