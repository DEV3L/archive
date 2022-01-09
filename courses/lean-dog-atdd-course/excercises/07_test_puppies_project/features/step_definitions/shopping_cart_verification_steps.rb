Then(/^I should see "([^"]*)" as the name of the puppy in my cart$/) do |name|
  table = @browser.table(:index => 0)
  expect(table[0][1].text).to include name
end

Then(/^I should see "(.*)" as the price of the puppy in my cart$/) do |price|
  table = @browser.table(:index => 0)
  expect(table[0][3].text).to eql price
end

Then(/^I should see "([^"]*)" as the type of the puppy in my cart$/) do |type|
  table = @browser.table(:index => 0)
  expect(table[0][2].text).to eql type
end

#

Then(/^I should see "([^"]*)" as the total price of my cart$/) do |total|
  total_cell = @browser.td(:class => "total_cell")
  expect(total_cell.text).to eql total
end