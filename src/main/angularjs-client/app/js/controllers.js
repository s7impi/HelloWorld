'use strict';

/* Controllers */

var boardgameControllers = angular.module('boardgameControllers', []);

boardgameControllers.controller('BoardgameListCtrl', ['$scope', 'Boardgame',
  function($scope, Boardgame) {
    $scope.boardgames = Boardgame.query();
  }]);

boardgameControllers.controller('BoardgameDetailCtrl', ['$scope', '$routeParams', 'Boardgame',
  function($scope, $routeParams, Boardgame) {
    $scope.boardgame = Boardgame.get({boardgameId: $routeParams.boardgameId}, function(boardgame) {
    });
  }]);

boardgameControllers.controller('SendCommentCtrl', ['$scope', 
  function($scope) {
    $scope.sendComment = function(comment, id){
      alert("Add comment: "+comment+" for game "+id);
    };//TODO service
  }]);


