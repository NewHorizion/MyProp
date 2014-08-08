	// create the module and name it scotchApp
	var scotchApp = angular.module('scotchApp', ['ngRoute']);

	// configure our routes
	scotchApp.config(function($routeProvider) {
		$routeProvider

			// route for the home page
			.when('/', {
				templateUrl : 'pages/home.html',
				controller  : 'mainController'
			})

			// route for the about page
			.when('/about', {
				templateUrl : 'pages/about.html',
				controller  : 'aboutController'
			})

			// route for the contact page
			.when('/contact', {
				templateUrl : 'pages/contact.html',
				controller  : 'contactController'
			})
			//rout for the login page
			.when('/login', {
			templateUrl : 'pages/login.html',
			controller  : 'loginController'
		});
	});

	// create the controller and inject Angular's $scope
	scotchApp.controller('mainController', function($scope) {
		// create a message to display in our view
		$scope.message = 'Everyone come and see how good I look!';
	});

	scotchApp.controller('aboutController', function($scope) {
		$scope.message = 'Look! I am an about page.';
		CountryCntrl ($scope);
	});

	scotchApp.controller('contactController', function($scope) {
		$scope.message = 'Contact us! JK. This is just a demo.';
	});
	
	scotchApp.controller('loginController', function($scope,$http) {
		$scope.formData = {};

		// process the form
		$scope.processForm = function() {
		$http({
		method : 'POST',
		url : 'webservice/Login.action',
		data : $.param($scope.formData), // pass in data as strings
		headers : { 'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8' }
		})
		.success(function(data) {
		console.log(data);

		if (!data.jsonMap.success) {
		// if not successful, bind errors to error variables
		$scope.errorName = data.jsonMap.errorName;
		$scope.messages = "";
		} else {
		// if successful, bind success message to message
		$scope.messages = data.jsonMap.messages;
		$scope.errorName = "";
		}
		});

		};
	});
	
    function CountryCntrl($scope,$http) {
    	 $http.get('http://localhost:8080/webservicesample/openService/master/location')
    		.success(function(data) {
    		console.log(data);
    		$scope.countries = data;
    		});
    }
   
    function searchControl ($scope,$http)
	    {
	    	$scope.visible = true;
	    	$scope.search = function ()
	    	{
	    	 $http.post('http://localhost:8080/webservicesample/openService/search/properties')
	    		.success(function(data) {
	    		console.log(data);
	    		$scope.properties = data;
	    		});
	    	}
	    }
   