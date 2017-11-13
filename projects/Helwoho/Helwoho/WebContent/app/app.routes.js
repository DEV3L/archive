applicationModule

  .config([ '$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/users', {
        templateUrl : 'app/components/users/users.html',
        controller : 'usersController'
      })
      .when('/users/create', {
        templateUrl : 'app/components/users/user.html',
        controller : 'usersController'
      })
      .otherwise({
        redirectTo : '/',
        templateUrl : 'app/components/login/login.html',
        controller : 'loginController'
      });
  } ]);
