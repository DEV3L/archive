var paymentEndpoint = "/StripeRESTWebServiceDev3l/payment/charge";

var applicationModule = angular.module("credit_card", ['ngRoute']);

applicationModule

  .controller('creditCardController', function($scope, $location) {
    
    // we will store all of our form data in this object
    $scope.formData = {};
    
    $scope.returnCreditCard = function() {
      $location.path('/');
    };
    
    // function to process the form
    $scope.submitForm = function() {
      if (!$scope.validateFields()) {
        return false;
      }
      
      if (confirm("Are you sure you want to charge the card $" + $scope.amount + ".00?")) {
        $("#submitButton").attr('disabled', 'disabled');
        
        var submitData = 
          '{' +
            '"number":"' + $scope.number + '",' +
            '"expMonth":"' + $scope.expMonth + '",' +
            '"expYear":"' + $scope.expYear + '",' +
            '"cvc":"' + $scope.cvc + '",' + 
            '"name":"' + $scope.name + '",' +
            '"currency":"usd",' +
            '"amount":"' + $scope.amount + '00"' + 
          '}';
        
        $.ajax ({
          url: paymentEndpoint,
          type: "POST",
          data: submitData,
          dataType: "json",
          contentType: "application/json",
          success: function(data){
            $.bootstrapGrowl("Payment accepted!", { type: 'info'} );
          }
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
          if (errorThrown == "Unauthorized") {
            $.bootstrapGrowl("Card payment denied.", { type: 'danger'} );
          }
          else {
            $.bootstrapGrowl("Error processing payment.", { type: 'danger'} );
          }
          
          console.log(jqXHR);
          console.log(textStatus);
          console.log(errorThrown);
        });
        
        $location.path('/accepted');
      }
    };
    
    $scope.validateFields = function() {
      var isValid = true;
      isValid = isValid && $scope.validateField($scope.name, "Name");
      isValid = isValid && $scope.validateField($scope.amount, "Amount");
      isValid = isValid && $scope.validateField($scope.number, "Card Number");
      isValid = isValid && $scope.validateField($scope.expMonth, "Expire Month");
      isValid = isValid && $scope.validateField($scope.expYear, "Expire Year");
      isValid = isValid && $scope.validateField($scope.cvc, "CVC");
      return isValid;
    };
    
    $scope.validateField = function(inputField, inputName) {
      if (typeof inputField == "undefined") {
        $.bootstrapGrowl(inputName + " is required.", { type: 'danger'} );
        return false;
      }
      
      return true;
    };
  });
