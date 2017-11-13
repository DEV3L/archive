var applicationModule = angular.module("helwoho", ['ngRoute', 'ngResource', 'helwoho.services']);

applicationModule

  .controller("usersController", function($rootScope, $scope, $location, User) {
    var users = User.query(function() {
      $scope.count_end = users.length;
      $scope.count_start = users.length > 0 ? 1 : 0;
    });
    
    $scope.predicate = '';
    $scope.users = users;
    $scope.token = localStorage.helwoho_tokenId;
    
    // we will store all of our form data in this object
    $scope.formData = {};
    
    $scope.clickAdd = function() {
      displayLogo = true;
      $location.path('/users/create');
    };
    
    $scope.returnUsers = function() {
      displayLogo = true;
      $location.path('/users');
    };
    
    // function to process the form
    $scope.submitForm = function() {
      $location.path('/');
    };
    
  })
  
  .controller('loginController', function($rootScope, $scope, $http, $location) {
    $rootScope.display_logo = false;
    $scope.login_invalid = false;
    
    // function to process the form
    $scope.submitForm = function() {
      $http.post('/HelwohoWebServices-r2/user/action/login', { userName: $scope.user_name, password: $scope.user_password } )
        .success(
            function(authenticationToken, status, headers, config) {
              localStorage.helwoho_tokenId = authenticationToken.token;
              $rootScope.display_logo = true;
              $scope.login_invalid = false;
              $location.path('/users');
            })
        .error(
            function(data, status, headers, config) {
              if (status == 401) {
                
                $scope.login_invalid = true;
                $rootScope.display_logo = false;
              } else {
                alert("An unexpected ERROR occurred while trying to sign in.")
              }
            });
    };
    
    $scope.clickCreate = function() {
      displayLogo = false;
      $location.path('/users/create');
    };
    
    $scope.fieldValid = fieldValid;
  });

// shared functions
var fieldValid = function(input) {
  return input.$valid || input.$pristine;
}