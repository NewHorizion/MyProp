	// create the module and name it scotchApp
	var scotchApp = angular.module('scotchApp', ['multi-select','ngAnimate', 'ui.router']);

	// configure our routes
	scotchApp.config(function($stateProvider,$urlRouterProvider) {
		
		$stateProvider
	    
        // route to show our basic form (/form)
        .state('form', {
            url: '/propertyForm',
            templateUrl: 'pages/propertyForm.html',
            controller: 'postPropertyController'
        })
        
        // nested states 
        // each of these sections will have their own view
        // url will be nested (/form/propertyDetails)
        .state('form.propertyDetails', {
            url: '/propertyDetails',
            templateUrl: 'pages/propertyDetail.html'
        })
        
        // url will be /form/upload
        .state('form.upload', {
            url: '/upload',
            templateUrl: 'pages/uploadPropertyImages.html'
        })
        
        // url will be /form/post property
        .state('form.postProperty', {
            url: '/postProperty',
            templateUrl: 'pages/postProperty.html'
        })
		
			// route for the home page
		.state('home', {
				url:'/home',
				templateUrl : 'pages/home.html',
				controller  : 'mainController'
			})

			// route for the about page
		.state('about', {
				url:'/about',
				templateUrl : 'pages/about.html',
				controller  : 'aboutController'
			})

			// route for the contact page
		.state('contact', {
				url:'/contact',
				templateUrl : 'pages/contact.html',
				controller  : 'contactController'
			})
			// route for the portfolio page
		.state('portfolio', {
				url:'/portfolio',
				templateUrl : 'pages/portfolio.html',
				controller  : 'contactController'
			})

				// route for the portfolio page
		.state('blog', {
				url:'/blog',
				templateUrl : 'pages/blog.html',
				controller  : 'contactController'
			})
			// rout for the login page
		.state('login', {	
			url:'/login',
			templateUrl : 'pages/login.html',
			controller  : 'loginController'
		})
		// route for the registration page
		.state('registration', {
		url:'/registration',
		templateUrl : 'pages/registration.html',
		controller  : 'registrationController'
		})

		// route for the search result page
		.state('search', {
		url:'/search',
		templateUrl : 'pages/searchResult.html',
		controller  : 'registrationController'
		});
		
		$urlRouterProvider.otherwise('/home');
		
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

	scotchApp.controller('registrationController', function($scope,$http) {
		$scope.formData = {};

		// process the form
		$scope.signup = function() {
		$scope.formData.propCityId = $scope.formData.propCity.cityId
		$scope.formData.propCity = $scope.formData.propCity.cityName;	
		$http({
		method : 'POST',
		url : 'webservice/Registration.action',
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

	 scotchApp.controller('CountryCntrl', function($scope,$http,$location) {
    	 $http.get('http://localhost:8080/webservicesample/openService/master/location')
    		.success(function(data) {
    		console.log(data);
    		$scope.propertyTypes = data.propertyTypes;
    		$scope.locations = data.locations;
    		});
	    	$scope.visible = true;
	    	$scope.properties = [];

	    	$scope.search = function ()
	    	{
	    		$http({
	    			method : 'post',
	    			url : 'http://localhost:8080/webservicesample/openService/search/properties',
	    			data : JSON.stringify($scope.formData), // pass in data as strings
	    			headers: {'Content-Type': 'application/json'}
	    			})
	    		.success(function(data) {
	    		console.log(data);
	    		if ($location.path().indexOf('/search') < 0)
	    		      $location.path('search');
	    		$scope.properties = data;
	    		});
	    	}
	    });




	 scotchApp.controller('latestSearchCntrl', function($scope,$http) {
    	 $http.get('http://localhost:8080/webservicesample/openService/search/latest')
    		.success(function(data) {
    		console.log(data);
    		$scope.latestProperties = data.latestProperties;
    		});
	    });

	 scotchApp.controller('postPropertyController', function($scope) {
		    
		    // we will store all of our form data in this object
		    $scope.formData = {};
		    
		    // function to process the form
		    $scope.processForm = function() {
		        alert('awesome!');  
		    };
		    
		});