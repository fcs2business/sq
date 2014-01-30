'use strict';

/* jasmine specs for services go here */

describe('service', function() {
    var $httpBackend, $rootScope, createController;
    beforeEach(module('myApp.services'));
    beforeEach(inject(function($injector) {
	// Set up the mock http service responses
	$httpBackend = $injector.get('$httpBackend');
	// backend definition common for all tests
	$httpBackend.when('GET', '/erp/workspace/listMenus').respond(403,'');
    }));
    describe('login controller tests', function() {
	it('should return 403 status error', inject(function($http) {
	    var success = function(data, status) {

	    };
	    var fail = function(data, status) {
		expect(status).toEqual(403);
	    };
	    $http.query("/erp/workspace/listMenus", success, fail);
	}));
    });
});
