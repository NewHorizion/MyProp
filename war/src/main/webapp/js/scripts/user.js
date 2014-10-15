// create the module and name it scotchApp
var userModule = angular.module('userModule',
		[ 'userControllers','ui.router', 'flow',]);
userModule.config(function(blockUIConfigProvider) {

	// Change the default overlay message
	blockUIConfigProvider.message("Loading...");
	// Change the default delay to 100ms before the blocking is visible
	blockUIConfigProvider.delay(5);
	// Disable automatically blocking of the user interface
	blockUIConfigProvider.autoBlock(false);

});

// configure our routes
userModule
		.config(function($stateProvider, $urlRouterProvider) {

			$stateProvider
			
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
				templateUrl: 'pages/propertyForm.html',
				controller : 'postPropertyController'
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
			})
			
			.state('user.registration', {
				url : '/registration',
				templateUrl : 'pages/registration.html',
				controller : 'registrationController'
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