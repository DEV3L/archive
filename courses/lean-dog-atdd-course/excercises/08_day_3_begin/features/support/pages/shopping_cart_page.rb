class ShoppingCartPage
  include PageObject

  button(:complete_adoption_button, :value => 'Complete the Adoption')
  button(:adopt_another_button, :value => 'Adopt Another Puppy')
  table(:shopping_cart, :index => 0)
  td(:total, :class => "total_cell")

  def name_for_line_item(line_item)
    line_item_first_row_index = (line_item - 1) * 6
    shopping_cart_element[line_item_first_row_index][1].text
  end

  def price_for_line_item(line_item)
    line_item_first_row_index = (line_item.to_i - 1) * 6
    shopping_cart_element[line_item_first_row_index][3].text
  end
end