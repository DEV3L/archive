class OrderDetailsPage
  include PageObject

  text_field(:name, :id => 'order_name')
  text_area(:address, :id => 'order_address')
  text_field(:email, :id => 'order_email')
  select(:payment_type, :id => 'order_pay_type')
  button(:order_button, :value => 'Place Order')

end