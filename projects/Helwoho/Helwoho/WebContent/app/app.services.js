applicationServices = angular.module('helwoho.services', []);

applicationServices

  .factory('User', function($resource) {
    return $resource('/HelwohoWebServices-r2/user/:id');
  });
