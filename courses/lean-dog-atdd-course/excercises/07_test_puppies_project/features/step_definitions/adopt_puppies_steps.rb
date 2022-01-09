Given(/^I am looking for a puppy$/) do
  @browser.goto 'puppies.herokuapp.com'
end

When(/^I view the details puppy (\d+)$/) do |puppy_number|
  index = puppy_number.to_i - 1
  @browser.button(:value => 'View Details', :index => index).click
end

Then(/^I should see details for "([^"]*)"$/) do |puppy_name|
  fail "Puppy name not found" unless @browser.text.include? puppy_name
  fail "Not on details page" unless @browser.text.include? "Return to List"
end

And(/^I adopt the puppy$/) do
  @browser.button(:value => 'Adopt Me!').click
end

And(/^I complete the adoption$/) do
  @browser.button(:value => 'Complete the Adoption').click
end

And(/^I enter "([^"]*)" as the name$/) do |order_name|
  @browser.text_field(:id => 'order_name').set order_name
end

And(/^I enter "([^"]*)" as the address$/) do |order_address|
  @browser.textarea(:id => 'order_address').set order_address
end

And(/^I enter "([^"]*)" as the email$/) do |order_email|
  @browser.text_field(:id => 'order_email').set order_email

end

And(/^I select "([^"]*)" as the payment type$/) do |order_pay_type|
  @browser.select_list(:id => 'order_pay_type').select order_pay_type
end

And(/^I complete the order$/) do
  @browser.button(:value => 'Place Order').click
end

Then(/^I should see the message "([^"]*)"$/) do |success_message|
  expect(@browser.text).to include success_message
end


And(/^I fill out the details form$/) do |details_data_table|
  details_data = details_data_table.hashes.first
  @browser.text_field(:id => 'order_name').set details_data["name"]
  @browser.textarea(:id => 'order_address').set details_data["address"]
  @browser.text_field(:id => 'order_email').set details_data["email"]
  @browser.select_list(:id => 'order_pay_type').select details_data["payment"]
end

And(/^I want to adopt another puppy$/) do
  @browser.button(:value => 'Adopt Another Puppy').click
end