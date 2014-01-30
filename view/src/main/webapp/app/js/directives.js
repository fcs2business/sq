'use strict';

/* Directives */

var myModule = angular.module('myApp.directives', []);
myModule.directive('menu', ['$compile', function($compile) {
    return {
	templateUrl : 'partials/menu.html',
	restrict: 'EA',
	transclude : true,
	replace : true,
	scope : {
	    menu : '='
	}
    };
} ]);
myModule.directive('menuItem', [ function() {
    return {
	templateUrl : 'partials/menu-item.html',
	restrict: 'EA',
	transclude : true,
	replace : true,
	scope : {
	    menu : '='
	}
    };
} ]);