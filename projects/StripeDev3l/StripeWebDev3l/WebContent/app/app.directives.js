applicationModule

  .directive("topMenu", function() {
    return {
      restrict : 'E',
      templateUrl : "app/shared/top_menu/top_menu.html"
    };
  })

  .directive("pageFooter", function() {
    return {
      restrict : 'E',
      templateUrl : "app/shared/footer/footer.html"
    };
  });