Feature: Complete order adding two products and deleting one of them
  Get id and amount from confirmation popup
  Scenario Outline: Complete purchasing flow
    Given Open Online shop
    When Navigate to category "<category>" and product "<product-1>" and click on add to cart
    Then Accept confirmation pop up when first product is added
    When Navigate again to category "<category>" and product "<product-2>" and click on add to cart
    Then Accept confirmation alert when second product is added
    When Go to shopping cart
    Then Delete product "<product-2>" from shopping cart
    And Click on place order button
    When Fill form fields->Name:"<name>", Country:"<country>", City:"<city>", Credit card:"<creditcard>", Month:"<month>", Year:"<year>"
    Then Capture order "<form-data-1>" and "<form-data-2>"
    And  Assert purchase "<field>" equals "<amount>"


    Examples:
    | category  | product-1    |  product-2   | name    | country | city    | creditcard | month    | year | form-data-1 | form-data-2 | field  |amount   |
    | Laptops   | Sony vaio i5 |  Dell i7 8gb | Miguel  | Spain   | Cadrete | 12345678   | February | 2021 | Id         | Amount      | Amount |790 USD  |