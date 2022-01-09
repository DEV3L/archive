module AdoptionHelper
  require 'watir-webdriver'

  def goto_puppies_page
    @browser = Watir::Browser.new :firefox
    @browser.goto 'puppies.herokuapp.com'
  end

  def adopt_puppy(puppy_index)
    @browser.button(:value => 'View Details', :index => puppy_index - 1).click
    @browser.button(:value => 'Adopt Me!').click
  end

  def adoption_completion_form(order_name, order_address, order_email, order_pay_type)
    @browser.text_field(:id => 'order_name').set order_name
    @browser.textarea(:id => 'order_address').set order_address
    @browser.text_field(:id => 'order_email').set order_email
    @browser.select_list(:id => 'order_pay_type').select order_pay_type
    @browser.button(:value => 'Place Order').click
  end

  def continue_shopping
    @browser.button(:value => 'Adopt Another Puppy').click
  end

  def proceed_to_checkout
    @browser.button(:value => 'Complete the Adoption').click
  end

  def close_browser
    @browser.close
  end

  def success_message_displays
    fail "Fail to place order" unless @browser.text.include? "Thank you"
  end
end