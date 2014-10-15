"use strict";
var userControllers = angular.module('userControllers', [ 'multi-select',
		'fileAppDir', 'ngAnimate', 'flow', 'checklist-model',
		'ng.httpLoader', 'PropertySearchServices', 'ajaxService',
		'PropertyServices', 'blockUI', 'alertsService', 'ui.bootstrap',
		'propertyControllers', 'LoginServices', 'ImageServices' ]);


userControllers.controller('userController', function($scope, $rootScope) {
	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';
	$('#mainContent').show();
});

userControllers
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

userControllers
		.controller(
				'registrationController', function($scope, $http, loginService, $rootScope, $location) {
					$('#mainContent').hide();
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
userControllers
		.controller(
				'postPropertyController',
				function($scope, $http, propertyService, loginService,imageService) {
					$('#mainContent').hide();
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