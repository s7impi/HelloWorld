'use strict';

/* Services */

var boardgameServices = angular.module('boardgameServices', ['ngResource']);

boardgameServices.factory('Boardgame', ['$resource',
  function($resource){
    return $resource('../api/games/:boardgameId', {}, {
      query: {method:'GET', params:{boardgameId:'boardgames'}, isArray:true}
    });
  }]);
