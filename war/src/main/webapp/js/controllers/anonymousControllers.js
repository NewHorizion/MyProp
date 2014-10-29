"use strict";
var anonymousControllers = angular.module('anonymousControllers',
		[ 'multi-select', 'fileAppDir', 'ngAnimate', 'flow',
				'checklist-model', 'ng.httpLoader', 'PropertySearchServices',
				'ajaxService', 'PropertyServices', 'blockUI', 'alertsService',
				'ui.bootstrap', 'propertyControllers', 'LoginServices',
				'ImageServices' ]);

anonymousControllers.controller('aboutController', function($scope) {
	$scope.message = 'Look! I am an about page.';
	CountryCntrl($scope);
});

anonymousControllers.controller('contactController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});

anonymousControllers
		.controller(
				'requirementController',
				function($scope, $http, loginService, propertyService) {
					$('#mainContent').hide();
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
						if ($scope.formData.registrationInfo.newUser == 'true') {
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
						if ($scope.formData.registrationInfo.newUser == 'false') {
							loginService.login($scope.formData,
									$scope.postRequirement,
									$scope.getErrorLogin);
						} else {
							loginService.registration($scope.formData,
									$scope.postRequirement,
									$scope.getErrorRegister);
						}

					};

					/*
					 * $scope.$watch( 'formData.requirementInfo.propertyTypes' ,
					 * function( selectedVal ) { if (selectedVal !== undefined) {
					 * if (selectedVal == '5' || selectedVal == '16' ||
					 * selectedVal == '20' || selectedVal == '21' || selectedVal ==
					 * '23' || selectedVal == '24' || selectedVal == '9' ||
					 * selectedVal == '10' || selectedVal == '12' || selectedVal ==
					 * '13' || selectedVal == '17' || selectedVal == '14' ||
					 * selectedVal == '15' || selectedVal == '25' || selectedVal ==
					 * '22') { $scope.displayFeatures = false;
					 *  } else { $scope.displayBedroom = true; } }
					 *  }, true);
					 */
				});

anonymousControllers
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
							 if (response.jsonMap.userType == undefined || response.jsonMap.userType == '')
							 {
								 return;
							 }
							 $rootScope.userType = response.jsonMap.userType;
							 $location.path('user', false);
						 }
						 $scope.getErrorLogin = function(response) {
						    alert('Error');
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

anonymousControllers
		.controller(
				'registrationController', function($scope, $http, loginService, $rootScope, $location) {
					$('#mainContent').hide();
					$scope.formData = {};
					//$injector.invoke(GenericController, this, {$scope: $scope});

					// process the form
					$scope.signup = function() {
						/*if ($("#signupForm").valid()==false){
					          return false;
					     }*/
						$scope.formData.registrationInfo.cityId = $scope.formData.registrationInfo.city.cityId
						$scope.formData.registrationInfo.cityName = $scope.formData.registrationInfo.city.cityName;
						// Register & Logged-IN
						$scope.getSuccessRegister = function(response) {
							if (response.jsonMap.userType == undefined || response.jsonMap.userType == '')
							 {
								 return;
							 }
							 $rootScope.userType = response.jsonMap.userType;
							 $location.path('user', false);
						}
						$scope.getErrorRegister = function(response) {
							alertsService.RenderErrorMessage("error in reqiuest");
						}
						loginService.registration($scope.formData, $scope.getSuccessRegister,
								$scope.getErrorRegister);
					};
					
					$scope.successUpdate = function(){
						alert('Updated');
					}
					
					$scope.errorUpdate = function(){
						alert('error');
					}
					
					$scope.updateProfile = function(){
						loginService.updateProfile($scope.formData, $scope.successUpdate,
								$scope.errorUpdate);
					};
				});

anonymousControllers
.controller(
		'searchController',
		function($scope, $http, $location, searchService,searchDataService,$modal) {
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


anonymousControllers
.controller(
		'searchResultController',
		function($scope, propertyService, $http, searchService,
				searchDataService) {
			$scope.formData = searchDataService.getSearchData();
			$scope.selectedPropertyTypes = $scope.formData.propertyTypes;
			$scope.selectedBudget = $scope.formData.budget;
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
			
			// function to process the form
			$scope.openChatWindow = function() {
				
		          var box = null;
		          $("#chat").click(function(event, ui) {
		              if(box) {
		                  box.chatbox("option", "boxManager").toggleBox();
		              }
		              else {
		                  box = $("#chat_div").chatbox({id:"chat_div", 
		                                                user:{key : "value"},
		                                                title : "test chat",
		                                                messageSent : function(id, user, msg) {
		                                                    $("#log").append(id + " said: " + msg + "<br/>");
		                                                    $("#chat_div").chatbox("option", "boxManager").addMsg(id, msg);
		                                                }});
		              }
		      });
			};

			$scope.findPropsCompleted = function(response) {
				counter = 0;
				$scope.displaySearchProps = [];
				$scope.properties = response.searchProperties;
				$scope.loadMore();
			}

			$scope.findpropsError = function(response) {
				alertsService.RenderErrorMessage("error in request");
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

anonymousControllers.controller('latestSearchCntrl', function($scope, propertyService,GalleryImageService,alertsService,$modal) {
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

anonymousControllers
.controller(
		'postPropertyController',
		function($scope, $http, $rootScope, propertyService, loginService,imageService) {
			$('#mainContent').hide();
			
			if ($rootScope.userType != null && $rootScope.userType != undefined
					&& $rootScope.userType != "")
			{
				$('#rootDiv').removeClass('col-sm-8');
				$('#rootDiv').removeClass('col-sm-offset-2');
			}
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
			
			$scope.processUserSubmit = function() {
				//if ($("#postRequirement").valid()){
			          // alert("Submitting...");
			      // }
				var fd = new FormData();
				//$scope.formData.propertyFeatureInfo.propertyMandateInfo.city = $scope.formData.propertyFeatureInfo.propertyMandateInfo.city.cityId;
				$scope.formData.propertyFeatureInfo.propertyMandateInfo.city = '1';
				
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
				propertyService.postProperty($scope.formData, $scope.postProperty,
						$scope.error);
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

anonymousControllers.controller('TabsCtrl', [ '$scope', function($scope) {
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