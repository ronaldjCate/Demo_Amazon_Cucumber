@SETPRUEBA
Feature: buscar producto en amazon
  @prueba1
  Scenario Outline: buscar producto de libros en amazon
    Given ingreso a la pagina de amazon "<url>"
    When ingreso el producto a buscar "<texto>"
    And selecciono buscar
    Then debe mostrar el valor "<Resultado>"
    Examples:
      | url                          | texto             | Resultado  |
      | https://www.amazon.com/-/es/ | Libro de cucumber | Resultados |


