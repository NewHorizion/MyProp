var anonymousModule = angular.module('anonymousModule',
		[ 'anonymousControllers']);

anonymousModule.config(function(blockUIConfigProvider) {

	// Change the default overlay message
	blockUIConfigProvider.message("Loading...");
	// Change the default delay to 100ms before the blocking is visible
	blockUIConfigProvider.delay(5);
	// Disable automatically blocking of the user interface
	blockUIConfigProvider.autoBlock(false);

});

// configure our routes
anonymousModule
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