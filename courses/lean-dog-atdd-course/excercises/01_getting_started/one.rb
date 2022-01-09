require 'watir-webdriver'
browser = Watir::Browser.new :firefox
browser.goto 'puppies.herokuapp.com'
sleep 5
browser.close