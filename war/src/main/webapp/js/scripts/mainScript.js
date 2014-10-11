// create the module and name it scotchApp
var scotchApp = angular.module('scotchApp',
		[ 'multi-select', 'fileAppDir', 'ngAnimate', 'ui.router', 'flow',
				'checklist-model', 'ng.httpLoader', 'PropertySearchServices',
				'ajaxService', 'PropertyServices', 'blockUI','alertsService','ui.bootstrap','propertyControllers',
				'LoginServices','ImageServices']);
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
			})
			
			.state('user', {
				url : '/user',
				templateUrl: 'pages/userHomePage.html',
				controller: 'userController'
			})
			
			.state('user.propertyForm.upload', {
				url : '/upload',
				templateUrl: "pages/propertyFeatures.html"
					
			})
			
			.state('user.propertyForm', {
				url : '/propertyForm',
				templateUrl: 'pages/propertyForm.html' 
			})
			
			.state('user.propertyForm.propertyDetails', {
				url : '/propertyDetails',
				templateUrl: "pages/propertyDetail.html"
			})
			
			.state('user.requirement', {
				url : '/requirementForm',
				templateUrl : 'pages/requirementForm.html',
				controller : 'requirementController'
			})
			
			.state('user.requirement.requirementDetails', {
				url : '/requirementDetails',
				templateUrl : 'pages/requirementDetail.html'
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
scotchApp.controller('mainController', function($scope, $rootScope, loginService) {
	// create a message to display in our view
	$rootScope.userType = '';
	$scope.logout = function($http)
	{
		loginService.logout();
	}
	$scope.message = 'Everyone come and see how good I look!';
	
});

scotchApp.controller('userController', function($scope, $rootScope) {
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
				function($scope, $http, loginService, propertyService) {
					// we will store all of our form data in this object
					$scope.formData = {};
					$scope.reqData = {};
					$scope.files = [];

					// listen for the file selected event
					$scope.$on("fileSelected", function(event, args) {
						$scope.$apply(function() {
							// add the file object to the scope's files
							// collection
							$scope.formData.files.push(args.file);
						});
					});
					// function to process the form
					$scope.processForm = function() {
						var fd = new FormData();
						$scope.formData.requirementInfo.city = $scope.formData.requirementInfo.city.cityId;
						if ($scope.formData.registrationInfo.newUser == 'true')
						{
							$scope.formData.registrationInfo.cityId = $scope.formData.registrationInfo.city.cityId;
						} 
						
						// remove comment to append a file to the request
						var oBlob = new Blob([ 'test' ], {
							type : "text/plain"
						});
						fd.append("files", oBlob, $scope.files);
						
						$scope.postRequirement = function(response) {
							alert('loogedin');
						 }
						 $scope.getErrorLogin = function(response) {
						    
						 }
						if ($scope.formData.registrationInfo.newUser == 'false')
						{
							loginService.login($scope.formData, $scope.postRequirement,
									$scope.getErrorLogin);
						}
						else
						{
							loginService.registration($scope.formData, $scope.postRequirement,
									$scope.getErrorRegister);
						}
					
					};
					
					/*$scope.$watch( 'formData.requirementInfo.propertyTypes' , function( selectedVal ) {
						if (selectedVal !== undefined)
						{
							if (selectedVal == '5' || selectedVal == '16'
									|| selectedVal == '20' || selectedVal == '21' || selectedVal == '23' 
									|| selectedVal == '24' || selectedVal == '9' || selectedVal == '10' 
									|| selectedVal == '12' || selectedVal == '13' || selectedVal == '17'
									|| selectedVal == '14' || selectedVal == '15' || selectedVal == '25'
									|| selectedVal == '22')
							{
								$scope.displayFeatures = false;
								
							}
							else
							{
								$scope.displayBedroom = true;
							}
						}
							
		            }, true);*/
				});

scotchApp
		.controller(
				'loginController',
				function($scope, $http, loginService, $location, $rootScope) {
					$scope.formData = {};
					// process the form
					$scope.processForm = function() {
//						 if ($("#loginForm").valid()==false){
//					          return false;
//					     }
						 $scope.getSuccessLogin = function(response) {
							 $rootScope.userType = response.jsonMap.userType;
							 $location.path('user', false);
						 }
						 $scope.getErrorLogin = function(response) {
						    
						 }
						 loginService.login($scope.formData, $scope.getSuccessLogin,
									$scope.getErrorLogin);
						
					};
				});

/*function GenericController($scope, loginService){
	$scope.getSuccessLogin = function(response) {
		return "success";
	}
	$scope.getErrorLogin = function(response) {
		alertsService.RenderErrorMessage("error in reqiuest");
	}
	$scope.getSuccessRegister = function(response) {
		loginService.login($scope.formData, $scope.getSuccessLogin,
			$scope.getErrorLogin);
	}
	$scope.getErrorRegister = function(response) {
		alertsService.RenderErrorMessage("error in reqiuest");
	}
	$scope.register = function()
	{
		loginService.registration($scope.formData, $scope.getSuccessRegister,
			$scope.getErrorRegister);
	}
};
*/
scotchApp
		.controller(
				'registrationController', function($scope, $http, loginService) {
					$scope.formData = {};
					//$injector.invoke(GenericController, this, {$scope: $scope});

					// process the form
					$scope.signup = function() {
						if ($("#signupForm").valid()==false){
					          return false;
					     }
						$scope.formData.registrationInfo.cityId = $scope.formData.registrationInfo.city.cityId
						$scope.formData.registrationInfo.cityName = $scope.formData.registrationInfo.city.cityName;
						// Register & Logged-IN
						$scope.getSuccessRegister = function(response) {
							alert('success');
						}
						$scope.getErrorRegister = function(response) {
							alertsService.RenderErrorMessage("error in reqiuest");
						}
						loginService.registration($scope.formData, $scope.getSuccessRegister,
								$scope.getErrorRegister);
					};
				});

scotchApp
		.controller(
				'CountryCntrl',
				function($scope, $http, $location,searchDataService) {
					$scope.$watch('formData', function(newValue, oldValue) { 
						searchDataService.saveSearchData($scope.formData);
					});
					
					$scope.$watch( 'formData.bedroom' , function( selectedVal ) {
						if (selectedVal !== undefined && selectedVal.length !== 0)
						{
							if ($scope.formData.bedroom.length == 2)
							{
								angular.forEach($scope.roomNos, function (da) {
					      				if (($scope.formData.bedroom != null || $scope.formData.bedroom != undefined)
					      					&& !(angular.equals($scope.formData.bedroom[0].label, da.label)
					      					|| angular.equals($scope.formData.bedroom[1].label, da.label))) {
					      					da.disabled = true;
					    		  		}
					    		  	});
							}
							
							if ($scope.formData.bedroom.length < 2)
							{
								angular.forEach($scope.roomNos, function (da) {
					      				{
					      					da.disabled = false;
					    		  		}
					    		  	});
							}
						}
						else
						{
							angular.forEach($scope.roomNos, function (da) {
									{
										da.disabled = false;
						  		}
						  	});
						}
						
					}, true);
					$scope.$watch( 'formData.budget' , function( selectedVal ) {
						var budgetArray = [];
						if (selectedVal != undefined && selectedVal.length !== 0)
						{
							if (angular.equals(selectedVal[0].budgetType, 'Sale'))
							{
								budgetArray = $scope.saleBudgets;
							}
							else
							{
								budgetArray = $scope.rentBudgets;
							}
						}
						if (selectedVal !== undefined && selectedVal.length !== 0)
						{
							if ($scope.formData.budget.length == 2)
							{
								angular.forEach(budgetArray, function (da) {
			              				if (($scope.formData.budget != null || $scope.formData.budget != undefined)
			              					&& !(angular.equals($scope.formData.budget[0].label, da.label)
			              					|| angular.equals($scope.formData.budget[1].label, da.label))) {
			              					da.disabled = true;
			            		  		}
			            		  	});
							}
							
							if ($scope.formData.budget.length < 2)
							{
								angular.forEach(budgetArray, function (da) {
			              				{
			              					da.disabled = false;
			            		  		}
			            		  	});
							}
						}
						else
						{
							budgetArray = $scope.saleBudgets;
							angular.forEach(budgetArray, function (da) {
	              				{
	              					da.disabled = false;
	            		  		}
	            		  	});
							budgetArray = $scope.rentBudgets;
							angular.forEach(budgetArray, function (da) {
	              				{
	              					da.disabled = false;
	            		  		}
	            		  	});
						}
							
		            }, true);

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
		});;

scotchApp
		.controller(
				'searchController',
				function($scope, $http, $location, searchService,searchDataService,$modal) {
					$scope.$watch('formData', function(newValue, oldValue) { 
						searchDataService.saveSearchData($scope.formData);
					});
					
					$scope.search = function() {
						searchDataService.saveSearchData($scope.formData);
						if ($scope.formData.city != null || $scope.formData.city != undefined)
							$scope.formData.cityId = $scope.formData.city.cityId;
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
							$scope.properties = data.searchProperties;
							searchService.saveSearchResponse(data.searchProperties);
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


scotchApp
		.controller(
				'searchResultController',
				function($scope, propertyService, $http, searchService,
						searchDataService) {
					$scope.formData = searchDataService.getSearchData();
					$scope.collapsed = true;
					$scope.bedRoomCollapsed = true;
					$scope.localityCollapsed = true;
					$scope.properties = searchService.getSearchResponse();
					$scope.displaySearchProps = [];
					var counter = 0;
					$scope.loadMore = function() {
						if ($scope.properties) {
							for ( var i = 0; i < $scope.properties.length; i++) {

								$scope.displaySearchProps
										.push($scope.properties[counter]);
								counter++;
								if (i>0 && i % 5 == 0) {
									break;
								}
							}
						}
					};

					$scope.findPropsCompleted = function(response) {
						counter = 0;
						$scope.displaySearchProps = [];
						$scope.properties = response.searchProperties;
						$scope.loadMore();
					}

					$scope.findpropsError = function(response) {
						alertsService.RenderErrorMessage("error in reqiuest");
					}

					$scope.filterResults = function() {
						if ($scope.formData) {
							$scope.formData.locations = $scope.formData.city.localities;
							propertyService.searchProperties($scope.formData,
									$scope.findPropsCompleted,
									$scope.findpropsError);
						}
					};

					$scope.loadMore();
				}).directive('whenScrolled', function() {
			return function(scope, elm, attr) {
				var raw = elm[0];

				elm.bind('scroll', function() {
					if (raw.scrollTop + raw.offsetHeight >= raw.scrollHeight) {
						scope.$apply(attr.whenScrolled);
					}
				});
			};
		});

scotchApp.controller('latestSearchCntrl', function($scope, propertyService,GalleryImageService,alertsService,$modal) {
	$scope.initializeController = function() {
		propertyService.findLatest($scope.getLatestPropCompleted,
				$scope.getLatestPropError);
	}
	
	 $scope.findImagesCompleted = function (response) {
     	$scope.images = response.images;
     	GalleryImageService.saveImageResponse (response);
     	$scope.myInterval = -2;
	    var modalInstance = $modal.open({
	        templateUrl: 'pages/gallery.html',
	        controller: 'propertyController',
	        windowClass: 'app-modal-window-Gallery'
	    });

	    modalInstance.result.then(function (productID) {

	    }, function () {
	        // function executed on modal dismissal
	    });
     }

     $scope.findImagesError = function (response) {
         alertsService.RenderErrorMessage(response.ReturnMessage);
     }
		
	$scope.openModal = function (propertyId) {
          var property = new Object();
          property.id = propertyId;
        propertyService.findPropertyImages(property,$scope.findImagesCompleted, $scope.findImagesError);
    
       

	};
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
				function($scope, $http, propertyService, loginService,imageService) {

					// we will store all of our form data in this object
					$scope.formData = {};
					$scope.files = [];
					$scope.formData.files=[];

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
						if ($scope.formData.registrationInfo.newUser == 'true')
						{
							$scope.formData.registrationInfo.cityId = $scope.formData.registrationInfo.city.cityId;
						}
                        $scope.imageUploadSuccessFull = function (response)
                        {
                        	alert ("post property Successfull");
                        }
						$scope.postProperty = function(response) {
						     $scope.formData.propertyId = response.jsonMap.propertyId;
						     if (null!=$scope.files)
						    	 {
						    	    $scope.formData.files = $scope.files;
						    	 	imageService.uploadImages($scope.formData,$scope.imageUploadSuccessFull,$scope.error)
						    	 }
						}
						
						$scope.error = function(response) {
						    alertsService.RenderErrorMessage("error in reqiuest");
						}
						if ($scope.formData.registrationInfo.newUser == 'false')
						{
							loginService.login($scope.formData, $scope.postProperty,
									$scope.error);
						}
						else
						{
							loginService.registration($scope.formData, $scope.postProperty,
									$scope.error);
						}
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
		url : 'pages/propertyListing.html'
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