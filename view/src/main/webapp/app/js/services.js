'use strict';

/* Services */

// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', []).factory('MenuService',
	[ '$http', '$rootScope', function($http, $rootScope) {
	    var menus;
	    $http.get("/erp/workspace/listMenus").success(function(data) {
		menus = data;
		$rootScope.$broadcast('app:menuReceived', menus);
	    }).error(function(data) {
		$rootScope.$broadcast('app:error', data);
	    });
	    return {
		getMenus : function() {
		    return menus;
		},
		getChildren : function(parent, index) {
		    return menus[parent].children[index].children;
		},
		isLoaded : function() {
		    return menus !== undefined;
		}
	    };
	} ]).factory('AlertService', [ function() {
    var defaultType = 'danger';
    var alerts = [];
    return {
	addAlert : function(_msg, _type) {
	    if (!_type) {
		_type = defaultType;
	    }
	    alerts.push({
		msg : _msg,
		type : _type
	    });
	},
	closeAlert : function(index) {
	    alerts.splice(index, 1);
	},
	getAlerts : function() {
	    return alerts;
	}
    };
} ]).factory(
	'AccessService',
	[
		'$location',
		'AlertService',
		'$http',
		'authService',
		function($location, AlertService, $http, authService) {
		    var logado = false;
		    var perfis = [];
		    return {
			getPerfis : function() {
			    return perfis;
			},
			login : function(username, password) {
			    $http.post(
				    "/j_spring_security_check?j_username="
					    + username + "&j_password="
					    + password).success(function(data) {
				logado = true;
				perfis = data;
			    }).error(function(data, status, headers, config) {
				AlertService.addAlert(data);
			    });
			},
			logout : function() {
			    $http.post("/j_spring_security_logout").success(
				    function(data) {
					logado = false;
					perfis = [];
					$location.path("/");
					
				    }).error(
				    function(data, status, headers, config) {
					AlertService.addAlert(data);
					$location.path("/");

				    });

			},
			entrar : function(perfilId) {
			    $http.post("/erp/usuario/entrar/" + perfilId).success(
				    function(data) {
					authService.loginConfirmed();
					logado = true;
					$location.path("/");
				    }).error(
				    function(data, status, headers, config) {
					AlertService.addAlert(data);
					$location.path("/");

				    });
			},
			isLogado : function() {
			    return logado;
			}
		    };
		} ]);
