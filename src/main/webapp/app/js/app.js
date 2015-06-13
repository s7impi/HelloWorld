'use strict';

/* App Module */

var boardgameApp = angular.module('boardgameApp', [
  'ngRoute',
  'boardgameAnimations',
  'boardgameControllers',
  'boardgameServices',
]);

boardgameApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/boardgames', {
        templateUrl: 'app/partials/boardgame-list.html',
        controller: 'BoardgameListCtrl'
      }).
      when('/boardgames/:boardgameId', {
        templateUrl: 'app/partials/boardgame-detail.html',
        controller: 'BoardgameDetailCtrl'
      }).
      when('/sell-game', {
        templateUrl: 'app/partials/sell-game.html',
        controller: 'SellGameCtrl'
      }).

      otherwise({
        redirectTo: '/boardgames'
      });
  }]);

