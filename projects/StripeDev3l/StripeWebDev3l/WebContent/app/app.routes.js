applicationModule

  .config([ '$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/accepted', {
        templateUrl : 'app/components/accepted/accepted.html',
        controller : 'creditCardController'
      })
      .otherwise({
        redirectTo : '/',
        templateUrl : 'app/components/credit_card/credit_card.html',
        controller : 'creditCardController'
      });
  } ]);
