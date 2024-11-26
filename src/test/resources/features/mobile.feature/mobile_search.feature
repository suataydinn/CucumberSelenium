@search @smoke
@browserMobile

Feature: Mobile search Scenario

  Scenario: Mobile user should able to search
    Given mobile search "cep telefonu" product
    Then search result should be "cep telefonu"