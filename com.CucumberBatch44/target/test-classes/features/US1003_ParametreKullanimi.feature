@parametreliTest
Feature: US1003 parametre ile stepdefinition olusturma

  @paralel1
  Scenario: TC05_parametre kullanimi

    Given kullanici amazon sayfasina gider
    And "Java" icin arama yapar
    Then sonuclarin "Nutella" icerdigini test eder
    And sayfayi kapatir

