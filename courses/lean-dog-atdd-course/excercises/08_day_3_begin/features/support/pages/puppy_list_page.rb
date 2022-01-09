class PuppyListPage
  include PageObject

  page_url "http://puppies.herokuapp.com"

  def view_puppy_details(puppy_number)
    index = puppy_number - 1
    @browser.button(:value => 'View Details', :index => index).click
  end
end