// create the module and name it scotchApp
var scotchApp = angular.module('scotchApp',
		[ 'multi-select', 'fileAppDir', 'ngAnimate', 'ui.router', 'flow',
				'checklist-model', 'ng.httpLoader', 'PropertySearchServices',
				'ajaxService', 'PropertyServices', 'blockUI','alertsService','ui.bootstrap']);
scotchApp.config(function(blockUIConfigProvider) {

	// Change the default overlay message
	blockUIConfigProvider.message("Loading...");
	// Change the default delay to 100ms before the blocking is visible
	blockUIConfigProvider.delay(5);
	// Disable automatically blocking of the user interface
	blockUIConfigProvider.autoBlock(false);

});

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
			
			// url for reuqirement
			.state('requirement', {
				url : '/requirementForm',
				templateUrl : 'pages/requirementForm.html',
				controller : 'requirementController'
			})
			
			.state('requirement.requirementDetails', {
				url : '/requirementDetails',
				templateUrl : 'pages/requirementDetail.html'
			})
			
			.state('requirement.postRequirement', {
				url : '/postRequirement',
				templateUrl : 'pages/postRequirement.html'
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
			/*.state('requirement', {
				url : '/requirement',
				templateUrl : 'pages/postRequirement.html',
				controller : 'requirementController'
			})*/
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
					$scope.processForm = function() {
						var fd = new FormData();
						$scope.formData.requirementInfo.city = $scope.formData.requirementInfo.city.cityId;
						$scope.formData.registrationInfo.cityId = $scope.formData.registrationInfo.city.cityId;
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
					// process the form
					$scope.processForm = function() {
						 if ($("#loginForm").valid()){
					          // alert("Submitting...");
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
							if(data.jsonMap!= undefined)
							{
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
						if ($("#signupForm").valid()){
					          // alert("Submitting...");
					     }
						
						$scope.formData.registrationInfo.cityId = $scope.formData.registrationInfo.cityId
						$scope.formData.registrationInfo.cityName = $scope.formData.registrationInfo.cityName;
						var fd = new FormData();
						fd.append('jsonData', angular.toJson($scope.formData));
						$http(
								{
									method : 'POST',
									url : 'webservice/Registration.action',
									data : fd, // pass in data as strings
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8'
									}
								}).success(function(data) {
							console.log(data);
							if(data.jsonMap!= undefined)
							{
								if (!data.jsonMap.success) {
									// if not successful, bind errors to error variables
									$scope.errorName = data.jsonMap.errorName;
									$scope.messages = "";
								} else {
									// if successful, bind success message to message
									$scope.messages = data.jsonMap.messages;
									$scope.errorName = "";
								}
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
								$scope.rentBudgets = data.rentBudgets;
								$scope.saleBudgets = data.saleBudgets;
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
		}).directive('rentBudgetCtrl', function() {
			return {
				restrict : 'E',
				scope : {
					rentModelName : '=',
					rentBudgets : '='
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
		});;

scotchApp
		.controller(
				'searchController',
				function($scope, $http, $location, searchService,$modal) {
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
					
					$scope.openModal = function () {

					    var modalInstance = $modal.open({
					        templateUrl: 'pages/advanceSearch.html',
					        controller: 'searchController',
					        windowClass: 'app-modal-window'
					    });

					    modalInstance.result.then(function (productID) {

					    }, function () {
					        // function executed on modal dismissal
					    });
					};
				});

scotchApp.controller('searchResultController', function($scope, $http,
		searchService) {
	$scope.properties = searchService.getSearchResponse();
});

scotchApp.controller('latestSearchCntrl', function($scope, propertyService,alertsService) {
	$scope.initializeController = function() {
		propertyService.findLatest($scope.getLatestPropCompleted,
				$scope.getLatestPropError);
	}
	$scope.getLatestPropCompleted = function(response) {
		$scope.latestProperties = response.latestProperties;
	}

	$scope.getLatestPropError = function(response) {
	    alertsService.RenderErrorMessage("error in reqiuest");
	}
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
						//if ($("#postRequirement").valid()){
					          // alert("Submitting...");
					      // }
						var fd = new FormData();
						$scope.formData.propertyFeatureInfo.propertyMandateInfo.city = $scope.formData.propertyFeatureInfo.propertyMandateInfo.city.cityId;
						$scope.formData.registrationInfo.cityId = $scope.formData.registrationInfo.city.cityId;
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
					
					// Watch the value of property type selected
					$scope.$watch( 'formData.propertyFeatureInfo.propertyMandateInfo.propertyTypeId' , function( selectedVal ) {
						if (selectedVal !== undefined)
						{
							// Variables displaying single fields
							$scope.displayBedroom = false;
							$scope.displayBathroom = false;
							$scope.displayBalcony = false;
							$scope.displayFurnished = false;
							$scope.displayFloorNo = false;
							$scope.displayTotalFloor = false;
							
							if (selectedVal == '5' || selectedVal == '16'
									|| selectedVal == '20' || selectedVal == '21'
										|| selectedVal == '23' || selectedVal == '24')
							{
								$scope.displayFeatures = false;
								$scope.displayBedroom = false;
								$scope.displayBathroom = false;
								$scope.displayBalcony = false;
								$scope.displayFurnished = false;
								$scope.displayFloorNo = false;
								$scope.displayTotalFloor = false;
								// Handling Industrial Shed
								if (selectedVal == '23')
								{
									$scope.displayArea = false;
									return;
								}
								$scope.displayArea = true;
							}
							else
							{
								$scope.displayArea = false;
								$scope.displayFeatures = true;
								$scope.displayBedroom = true;
								$scope.displayBathroom = true;
								$scope.displayBalcony = true;
								$scope.displayFurnished = true;
								$scope.displayFloorNo = true;
								$scope.displayTotalFloor = true;
							}
							// Hiding Balcony
							if (selectedVal == '7')
							{
								$scope.displayBedroom = true;
								$scope.displayBathroom = true;
								$scope.displayBalcony = false;
								$scope.displayFurnished = true;
								$scope.displayFloorNo = true;
								$scope.displayTotalFloor = true;
							}
							// Hiding Floor No
							if (selectedVal == '3' || selectedVal == '4' || selectedVal == '18')
							{
								$scope.displayBedroom = true;
								$scope.displayBathroom = true;
								$scope.displayBalcony = true;
								$scope.displayFurnished = true;
								$scope.displayFloorNo = false;
								$scope.displayTotalFloor = true;
							}
							// Hiding Bedroom/Balcony
							if (selectedVal == '9' || selectedVal == '10' || selectedVal == '12'
								|| selectedVal == '13')
							{
								$scope.displayBedroom = false;
								$scope.displayBathroom = true;
								$scope.displayBalcony = false;
								$scope.displayFurnished = true;
								$scope.displayFloorNo = true;
								$scope.displayTotalFloor = true;
							}
							// Hiding Bedroom/Bathroom/Balcony
							if (selectedVal == '13' || selectedVal == '17')
							{
								$scope.displayBedroom = false;
								$scope.displayBathroom = false;
								$scope.displayBalcony = false;
								$scope.displayFurnished = true;
								$scope.displayFloorNo = true;
								$scope.displayTotalFloor = true;
							}
							// Only Furnished
							if (selectedVal == '14')
							{
								$scope.displayBedroom = false;
								$scope.displayBathroom = false;
								$scope.displayBalcony = false;
								$scope.displayFurnished = true;
								$scope.displayFloorNo = false;
								$scope.displayTotalFloor = false;
							}
							// Only Furnished/Total Floor
							if (selectedVal == '15' || selectedVal == '25')
							{
								$scope.displayBedroom = false;
								$scope.displayBathroom = false;
								$scope.displayBalcony = false;
								$scope.displayFurnished = true;
								$scope.displayFloorNo = false;
								$scope.displayTotalFloor = true;
							}
							// Hiding Balcony/Floor No
							if (selectedVal == '19')
							{
								$scope.displayBedroom = true;
								$scope.displayBathroom = true;
								$scope.displayBalcony = false;
								$scope.displayFurnished = true;
								$scope.displayFloorNo = false;
								$scope.displayTotalFloor = true;
							}
							// Only Total Floor
							if (selectedVal == '22')
							{
								$scope.displayBedroom = false;
								$scope.displayBathroom = false;
								$scope.displayBalcony = false;
								$scope.displayFurnished = false;
								$scope.displayFloorNo = false;
								$scope.displayTotalFloor = true;
							}
						}
							
		            }, true);
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