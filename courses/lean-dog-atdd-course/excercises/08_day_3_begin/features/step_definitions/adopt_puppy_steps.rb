Given(/^I am looking for a puppy to adopt$/) do
  visit_page PuppyListPage
end

And(/^I view the details of puppy (\d+)$/) do |puppy_number|
  on(PuppyListPage).view_puppy_details puppy_number.to_i
end

And(/^I adopt the puppy$/) do
  on(PuppyDetailsPage).adopt_button
end

And(/^I complete the adoption$/) do
  on(ShoppingCartPage).complete_adoption_button
end

And(/^I adopt another puppy$/) do
  on(ShoppingCartPage).adopt_another_button
end

Then(/^I should see the message "([^"]*)"$/) do |expected_message|
  expect(on(PuppyListPage).text).to include expected_message
end

And(/^I checkout with:$/) do |checkout_data_table|
  checkout_data = checkout_data_table.hashes.first
  on(OrderDetailsPage).name = checkout_data["name"]
  on(OrderDetailsPage).address = checkout_data["address"]
  on(OrderDetailsPage).email = checkout_data["email"]
  on(OrderDetailsPage).payment_type = checkout_data["payment type"]
  on(OrderDetailsPage).order_button
end

Then(/^I should see "([^"]*)" as the name for line item (\d+)$/) do |expected_name, line_item|
  expect(on(ShoppingCartPage).name_for_line_item(line_item.to_i)).to include expected_name
end

Then(/^I should see "([^"]*)" as the subtotal for line item (\d+)$/) do |expected_subtotal, line_item|
  expect(on(ShoppingCartPage).price_for_line_item(line_item.to_i)).to eql expected_subtotal
end

Then(/^I should see "([^"]*)" as the total for the cart$/) do |expected_total|
  expect(on(ShoppingCartPage).total_element.text).to eql expected_total
end
