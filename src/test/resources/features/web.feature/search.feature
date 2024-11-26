@search @smoke
@browserWeb

Feature: Web search Scenario

  Scenario: User should able to search
    Given search "cep telefonu" product
    Then search result should be "cep telefonu"