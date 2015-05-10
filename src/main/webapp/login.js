
var app = angular.module('login', ['ngResource', 'ngRoute']);

app.factory('loginService', ['$resource', function ($resource) {
    return $resource('api/login/', {}, {
        login: {method:'POST'}
    });
}]);

app.controller('loginFormController', ['$scope', 'loginService', function ($scope, loginService) {
    $scope.login = function (user) {
        loginService.login(user);
    };
}]);