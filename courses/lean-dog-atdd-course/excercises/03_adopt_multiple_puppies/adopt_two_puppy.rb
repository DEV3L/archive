require 'watir-webdriver'
browser = Watir::Browser.new
browser.goto 'puppies.herokuapp.com'

# adopt first puppy
browser.button(:value => 'View Details', :index => 0).click
browser.button(:value => 'Adopt Me!').click

# back to list
browser.button(:value => 'Adopt Another Puppy').click

# adopt second puppy
browser.button(:value => 'View Details', :index => 1).click
browser.button(:value => 'Adopt Me!').click

# complete
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