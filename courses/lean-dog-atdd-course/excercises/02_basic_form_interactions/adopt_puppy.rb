require 'watir-webdriver'
browser = Watir::Browser.new
browser.goto 'puppies.herokuapp.com'

browser.button(:value => 'View Details').click
browser.button(:value => 'Adopt Me!').click
browser.button(:value => 'Complete the Adoption').click

# adoption form
browser.text_field(:id => 'order_name').set "Justin Beall"
browser.textarea(:id => 'order_address').set "4070 Stonehaven Rd.\nSouth Euclid, OH 44121"
browser.text_field(:id => 'order_email').set "jus.beall@gmail.com"
browser.select_list(:id => 'order_pay_type').select "Credit card"
browser.button(:value => 'Place Order').click

# success message
fail "Fail to place order" unless browser.text.include? "Thank you"

browser.close