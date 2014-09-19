var ajaxServices = angular.module('ajaxService', []);

ajaxServices.service('ajaxService', ['$http', 'blockUI', function ($http, blockUI) {

        // setting timeout of 1 second to simulate a busy server.

        this.AjaxPost = function (data, route, successFunction, errorFunction) {
            blockUI.start();
            setTimeout(function () {
                $http.post(route, data).success(function (response, status, headers, config) {
                    blockUI.stop();
                    successFunction(response, status);
                }).error(function (response) {
                    blockUI.stop();                   
                    if (response.IsAuthenicated == false) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 1000);

        }
        
        this.AjaxPostContentType = function (data, route, successFunction, errorFunction) {
            blockUI.start();
            setTimeout(function () {
            	var fd = new FormData(); 
				fd.append('jsonData', angular.toJson(data));
				$http(
						{
							method : 'POST',
							url : route,
							headers : {
								'Content-Type' : undefined
							},
							transformRequest : angular.identity,
							async : false,
							data : fd
						}).success(function (response, status, headers, config) {
		                    blockUI.stop();
		                    successFunction(response);
		                }).error(function (response) {
		                    blockUI.stop();                   
		                    if (response.IsAuthenicated == false) { window.location = "/index.html"; }
		                    errorFunction(response);
		                });
            }, 1000);

        }
        
        /*this.AjaxPostContentWithoutResponse = function (data, route) {
            blockUI.start();
            setTimeout(function () {
            	var fd = new FormData(); 
				fd.append('jsonData', angular.toJson(data));
				$http(
						{
							method : 'POST',
							url : route,
							headers : {
								'Content-Type' : undefined
							},
							transformRequest : angular.identity,
							async : false,
							data : fd
						}).success(function (response, status, headers, config) {
							blockUI.stop();
		                    return "success";
		                }).error(function (response) {
		                    return "error";
		                });
            }, 1000);

        }*/

        this.AjaxPostWithNoAuthenication = function (data, route, successFunction, errorFunction) {
            blockUI.start();
            setTimeout(function () {
                $http.post(route, data).success(function (response, status, headers, config) {
                    blockUI.stop();
                    successFunction(response, status);
                }).error(function (response) {
                    blockUI.stop();                 
                    errorFunction(response);
                });
            }, 1000);

        }

        this.AjaxGet = function (route, successFunction, errorFunction) {
            blockUI.start();
            setTimeout(function () {
                $http({ method: 'GET', url: route }).success(function (response, status, headers, config) {
                    blockUI.stop();
                    successFunction(response, status);
                }).error(function (response) {
                    blockUI.stop();
                    if (response.IsAuthenicated == false) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 1000);

        }

        this.AjaxGetWithData = function (data, route, successFunction, errorFunction) {
            blockUI.start();
            setTimeout(function () {
                $http({ method: 'GET', url: route, params: data }).success(function (response, status, headers, config) {
                    blockUI.stop();
                    successFunction(response, status);
                }).error(function (response) {
                    blockUI.stop();
                    if (response.IsAuthenicated == false) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 1000);

        }


        this.AjaxGetWithNoBlock = function (data, route, successFunction, errorFunction) {            
            setTimeout(function () {
                $http({ method: 'GET', url: route, params: data }).success(function (response, status, headers, config) {                 
                    successFunction(response, status);
                }).error(function (response) {                  ;
                    if (response.IsAuthenicated == false) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 0);

        }


    }]);


