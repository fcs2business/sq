'use strict';

// Declare app level module which depends on filters, and services
var myApp = angular.module('myApp', [ 'ngRoute', 'http-auth-interceptor',
	'ui.bootstrap', 'myApp.filters', 'myApp.services', 'myApp.directives',
	'myApp.controllers' ])
.config(['$routeProvider',function($routeProvider){
    $routeProvider
    .when('/',{
	tempateUrl:"partials/partial1.html"
    })
    .when('/select/:parentIdx/:index',{
	controller: 'SelectionCtrl',
	templateUrl: "partials/selection.html"
    }).otherwise("/");
}])
.run([ '$rootScope', '$modal', '$http','MenuService','AlertService','AccessService',
	function($rootScope, $modal, $http, MenuService, AlertService, AccessService) {
	    $rootScope.$on('event:auth-loginRequired', function() {
		$rootScope.needsLogin();
	    });
	    $rootScope.$on('event:auth-loginConfirmed', function() {
		$rootScope.modalInstance.close("logado com sucesso");
	    });
	    $rootScope.$on('app:menuReceived', function(event, menus){
		$rootScope.menus = menus;
	    });
	    $rootScope.$on('app:error', function(event, error){
		AlertService.addAlert(error);
	    });
	    
	    $rootScope.isLogado = function(){
		return AccessService.isLogado();
	    };
	    var opened = false;
	    $rootScope.needsLogin = function() {
		if (opened)
		    return;

		$rootScope.modalInstance = $modal.open({
		    templateUrl : 'partials/login.html',
		    controller : 'LoginModalCtrl',
		    backdrop : false,
		    backdropFade: true,
		    dialogFade:true,
		    keyboard: false,
		    scope : $rootScope
		});
		opened = true;
		$rootScope.modalInstance.result.then(function(selectedItem) {
		    opened = false;
		}, function() {
		    opened = false;
		});
	    };
	} ]);