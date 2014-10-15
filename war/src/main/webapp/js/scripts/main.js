// create the module and name it scotchApp
var scotchApp = angular.module('scotchApp',
		[ 'userModule', 'anonymousModule','ui.router', 'flow', 'LoginServices', 'PropertySearchServices']);

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function($scope, $rootScope, loginService, $location) {
	// create a message to display in our view
	$rootScope.userType = '';
	$scope.logoutSuccess = function(response) {
		$rootScope.userType = '';
		$location.path('home', false);
	}
	$scope.logoutError = function(response) {
	    
	}
	$scope.logout = function($http)
	{
		loginService.logout($scope.logoutSuccess,
				$scope.logoutError);
	}
	$scope.message = 'Everyone come and see how good I look!';
	
});

scotchApp
		.controller(
				'CountryCntrl',
				function($scope, $http, $location,searchDataService) {
					$http
							.get(
									'http://localhost:8080/webservicesample/openService/master/location')
							.success(function(data) {
								$scope.propertyTypes = data.propertyTypes;
								$scope.locations = data.locations;
								$scope.rentBudgets = data.rentBudgets;
								$scope.saleBudgets = data.saleBudgets;
							});
					$scope.visible = true;
					$scope.properties = [];
					$scope.propertyTypesMaster = [];
					$scope.propertyTypesMaster = $scope.propertyTypes;
					//searchDataService.saveSearchData($scope.propertyTypesMaster);
				}).directive('cityCtrl', function() {
			return {
				restrict : 'E',
				scope : {
					cityModelName : '=',
					locations : '='
				},
				templateUrl : 'pages/city-ctrl.html'

			};
		}).directive('locationCtrl', function() {
			return {
				restrict : 'E',
				templateUrl : 'pages/location-ctrl.html'
			};
		}).directive('propertyCtrl', function() {
			return {
				restrict : 'E',
				scope : {
					propertyModelName : '=',
					propertyTypes : '='
				},
				templateUrl : 'pages/property-ctrl.html'
			};
		}).directive('rentBudgetCtrl', function() {
			return {
				restrict : 'E',
				scope : {
					rentModelName : '=',
					rentBudgets : '=',
				},
				
				templateUrl : 'pages/rent-budget-ctrl.html'
			};
		}).directive('saleBudgetCtrl', function() {
			return {
				restrict : 'E',
				scope : {
					saleModelName : '=',
					saleBudgets : '='
				},
				templateUrl : 'pages/sale-budget-ctrl.html'
			};
		});