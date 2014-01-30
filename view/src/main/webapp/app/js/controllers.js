'use strict';

/* Controllers */

var myControllers = angular.module('myApp.controllers', [])

.controller(
	'SelectionCtrl',
	[
		'$scope',
		'MenuService',
		'$routeParams',
		function($scope, MenuService, $routeParams) {
		    var parentIdx = $routeParams.parentIdx;
		    var index = $routeParams.index;

		    if (MenuService.isLoaded()) {
			$scope.subMenus = MenuService.getChildren(parentIdx,
				index);
		    }
		} ])
.controller('AlertsCtrl', ['$scope','AlertService', function($scope, AlertService) {
    $scope.alerts = function(){
	return AlertService.getAlerts();
    };

    $scope.closeAlert = function(index) {
	AlertService.closeAlert(index);
    };

} ]).controller(
	'LoginModalCtrl',
	[
		'$scope',
		'$http',
		'authService',
		'AccessService',
		function($scope, $http, authService, AccessService) {
		    $scope.credenciais = {
			username : "",
			password : ""
		    };
		    $scope.openModal = function() {
			$scope.theModal = true;
		    };
		    $scope.closeModal = function() {
			$scope.theModal = false;
		    };
		    $scope.login = function() {
			AccessService.login( $scope.credenciais.username,$scope.credenciais.password);
		    };
		    
		    $scope.entrar = function() {
			console.log($scope.perfil);
			AccessService.entrar($scope.perfil.perfilId);
		    };
		    $scope.cancelarLogin = function() {
			AccessService.logout();
		    };
		    
		    $scope.getPerfis = function(){
			var perfis = AccessService.getPerfis();
			$scope.perfil = perfis[0];
			return perfis;
		    };
		    
		} ]);
