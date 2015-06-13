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
      $scope.comments.push(comment);
      $scope.commentText = "";
    };//TODO service
    $scope.comments = [];
    $scope.commentText = "";
  }]);

boardgameControllers.controller('SellGameCtrl', ['$scope', 
  function($scope) {
    $scope.submitted = false;
    $scope.sell = function(){
        $scope.submitted = true;
        //TODO service
    };
    $scope.name = "";
    $scope.description = "";
    $scope.price = 0;
    $scope.post = false;
    $scope.inPerson = false;
  }]);

