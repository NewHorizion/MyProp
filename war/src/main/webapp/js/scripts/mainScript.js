// create the module and name it scotchApp
var scotchApp = angular.module('scotchApp', [ 'multi-select', 'fileAppDir',
		'ngAnimate', 'ui.router', 'flow', 'checklist-model', 'ng.httpLoader',
		'PropertySearchServices' ]);

// configure our routes
scotchApp
		.config(function($stateProvider, $urlRouterProvider) {

			$stateProvider

			// route to show our basic form (/form)
			.state('form', {
				url : '/propertyForm',
				templateUrl : 'pages/propertyForm.html',
				controller : 'postPropertyController'
			})

			// nested states
			// each of these sections will have their own view
			// url will be nested (/form/propertyDetails)
			.state('form.propertyDetails', {
				url : '/propertyDetails',
				templateUrl : 'pages/propertyDetail.html'
			})

			// url will be /form/upload
			.state('form.upload', {
				url : '/upload',
				templateUrl : 'pages/propertyFeatures.html'
			})

			// url will be /form/post property
			.state('form.postProperty', {
				url : '/postProperty',
				templateUrl : 'pages/postProperty.html'
			})

			// route for the home page
			.state('home', {
				url : '/home',
				templateUrl : 'pages/home.html',
				controller : 'mainController'
			})

			// route for the about page
			.state('about', {
				url : '/about',
				templateUrl : 'pages/about.html',
				controller : 'aboutController'
			})

			// route for the contact page
			.state('contact', {
				url : '/contact',
				templateUrl : 'pages/contact.html',
				controller : 'contactController'
			})
			// route for the portfolio page
			.state('portfolio', {
				url : '/portfolio',
				templateUrl : 'pages/portfolio.html',
				controller : 'contactController'
			})

			// route for the portfolio page
			.state('blog', {
				url : '/blog',
				templateUrl : 'pages/blog.html',
				controller : 'contactController'
			})
			// rout for the login page
			.state('login', {
				url : '/login',
				templateUrl : 'pages/login.html',
				controller : 'loginController'
			})
			// route for the registration page
			.state('registration', {
				url : '/registration',
				templateUrl : 'pages/registration.html',
				controller : 'registrationController'
			})

			// route for post requirement
			.state('requirement', {
				url : '/requirement',
				templateUrl : 'pages/postRequirement.html',
				controller : 'requirementController'
			})
			// route for the registration page
			.state('viewDetails', {
				url : '/viewDetails',
				templateUrl : 'pages/SinglePropertyDetails.html',
				controller : 'registrationController'
			})

			// route for the search result page
			.state('search', {
				url : '/search',
				templateUrl : 'pages/searchResult.html',
				controller : 'searchResultController'
			});

			$urlRouterProvider.otherwise('/home');
		})

		.config([ 'flowFactoryProvider', function(flowFactoryProvider) {

			flowFactoryProvider.defaults = {
				target : 'upload.php',
				permanentErrors : [ 404, 500, 501 ],
				maxChunkRetries : 1,
				chunkRetryInterval : 5000,
				simultaneousUploads : 4,
				singleFile : true
			}

			flowFactoryProvider.on('catchAll', function(event) {
				console.log('catchAll', arguments);
			});

		} ])
		.config(
				[
						'httpMethodInterceptorProvider',
						function(httpMethodInterceptorProvider) {
							httpMethodInterceptorProvider
									.whitelistDomain('http://localhost:8080/webservicesample');
						} ]);

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function($scope) {
	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';
});

scotchApp.controller('aboutController', function($scope) {
	$scope.message = 'Look! I am an about page.';
	CountryCntrl($scope);
});

scotchApp.controller('contactController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});

scotchApp
		.controller(
				'requirementController',
				function($scope, $http) {
					// we will store all of our form data in this object
					$scope.formData = {};
					$scope.files = [];

					// listen for the file selected event
					$scope.$on("fileSelected", function(event, args) {
						$scope.$apply(function() {
							// add the file object to the scope's files
							// collection
							$scope.files.push(args.file);
						});
					});
					// function to process the form
					$scope.submitForm = function() {
						var fd = new FormData();
						$scope.formData.propertyFeatureInfo.propertyMandateInfo.city = $scope.formData.propertyFeatureInfo.propertyMandateInfo.city.cityId;
						fd.append('jsonData', angular.toJson($scope.formData));

						// remove comment to append a file to the request
						var oBlob = new Blob([ 'test' ], {
							type : "text/plain"
						});
						fd.append("files", oBlob, $scope.files);

						$http({
							method : 'POST',
							url : "webservice/UploadRequirementAction.action",
							headers : {
								'Content-Type' : undefined
							},
							transformRequest : angular.identity,
							data : fd
						})

						.success(function(data, status, headers, config) {
							alert("success!");
						}).error(function(data, status, headers, config) {
							alert("failed!");
						});
					};
				});

scotchApp
		.controller(
				'loginController',
				function($scope, $http) {
					$scope.formData = {};
                    
					$scope.validateLogin = function() {
							  
							    // Setup form validation on the #register-form element
							    $("#loginForm").validate({
							    
							        // Specify the validation rules
							        rules: {
							            firstname: "required",
							            lastname: "required",
							            email: {
							                required: true,
							                email: true
							            },
							            password: {
							                required: true,
							                minlength: 5
							            },
							            agree: "required"
							        },
							        
							        // Specify the validation error messages
							        messages: {
							            firstname: "Please enter your first name",
							            lastname: "Please enter your last name",
							            password: {
							                required: "Please provide a password",
							                minlength: "Your password must be at least 5 characters long"
							            },
							            email: "Please enter a valid email address",
							            agree: "Please accept our policy"
							        },
							        
							        submitHandler: function(form) {
							            form.submit();
							        }
							    });

							  };
					// process the form
					$scope.processForm = function() {
						 if ($("#loginForm").valid()){
					           alert("Submitting...");
					       }
						$http(
								{
									method : 'POST',
									url : 'webservice/Login.action',
									data : $.param($scope.formData), // pass in data as strings
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8'
									}
								}).success(function(data) {
							console.log(data);

							if (!data.jsonMap.success) {
								// if not successful, bind errors to error
								// variables
								$scope.errorName = data.jsonMap.errorName;
								$scope.messages = "";
							} else {
								// if successful, bind success message to
								// message
								$scope.messages = data.jsonMap.messages;
								$scope.errorName = "";
							}
						});

					};
				});

scotchApp
		.controller(
				'registrationController',
				function($scope, $http) {
					$scope.formData = {};

					// process the form
					$scope.signup = function() {
						$scope.formData.propCityId = $scope.formData.propCity.cityId
						$scope.formData.propCity = $scope.formData.propCity.cityName;
						$http(
								{
									method : 'POST',
									url : 'webservice/Registration.action',
									data : $.param($scope.formData), // pass in data as strings
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8'
									}
								}).success(function(data) {
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

scotchApp
		.controller(
				'CountryCntrl',
				function($scope, $http, $location) {
					$http
							.get(
									'http://localhost:8080/webservicesample/openService/master/location')
							.success(function(data) {
								$scope.propertyTypes = data.propertyTypes;
								$scope.locations = data.locations;
							});
					$scope.visible = true;
					$scope.properties = [];

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
		});

scotchApp
		.controller(
				'searchController',
				function($scope, $http, $location, searchService) {
					$scope.search = function() {
						$http(
								{
									method : 'post',
									url : 'http://localhost:8080/webservicesample/openService/search/properties',
									data : JSON
											.stringify($scope.$parent.formData), // pass
									headers : {
										'Content-Type' : 'application/json'
									}
								}).success(function(data) {
							$scope.properties = data;
							searchService.saveSearchResponse(data);
							if ($location.path().indexOf('/search') < 0)
								$location.path('search', false);
						});
					}
				});

scotchApp.controller('searchResultController', function($scope, $http,
		searchService) {
	$scope.properties = searchService.getSearchResponse();
});

scotchApp.controller('latestSearchCntrl', function($scope, $http) {
	$http.get(
			'http://localhost:8080/webservicesample/openService/search/latest')
			.success(function(data) {
				console.log(data);
				$scope.latestProperties = data.latestProperties;
			});
});

scotchApp
		.controller(
				'postPropertyController',
				function($scope, $http) {

					// we will store all of our form data in this object
					$scope.formData = {};
					$scope.files = [];

					//listen for the file selected event
					$scope.$on("fileSelected", function(event, args) {
						$scope.$apply(function() {
							//add the file object to the scope's files collection
							$scope.files.push(args.file);
						});
					});
					// function to process the form
					$scope.processForm = function() {
						var fd = new FormData();
						$scope.formData.propertyFeatureInfo.propertyMandateInfo.city = $scope.formData.propertyFeatureInfo.propertyMandateInfo.city.cityId;
						fd.append('jsonData', angular.toJson($scope.formData));

						//remove comment to append a file to the request
						var oBlob = new Blob([ 'test' ], {
							type : "text/plain"
						});
						fd.append("files", oBlob, $scope.files);

						$http({
							method : 'POST',
							url : "webservice/UploadPropertyAction.action",
							headers : {
								'Content-Type' : undefined
							},
							transformRequest : angular.identity,
							data : fd
						})

						.success(function(data, status, headers, config) {
							alert("success!");
						}).error(function(data, status, headers, config) {
							alert("failed!");
						});
					};
				});

scotchApp.controller('TabsCtrl', [ '$scope', function($scope) {
	$scope.tabs = [ {
		title : 'Rent',
		url : 'pages/homePageContent.html'
	}, {
		title : 'Buy',
		url : 'pages/ajax.html'
	}, {
		title : 'Recent',
		url : 'pages/about.html'
	} ];

	$scope.currentTab = 'pages/homePageContent.html';

	$scope.onClickTab = function(tab) {
		$scope.currentTab = tab.url;
	}

	$scope.isActiveTab = function(tabUrl) {
		return tabUrl == $scope.currentTab;
	}
} ]);