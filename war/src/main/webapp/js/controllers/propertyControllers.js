"use strict";
var propertyControllers = angular.module('propertyControllers', ['ajaxService','PropertyServices']);

propertyControllers.controller('propertyController', ['$scope', '$rootScope', 'propertyService', 'alertsService', function ($scope, $rootScope, propertyService, alertsService) {

        $rootScope.closeAlert = alertsService.closeAlert;


        $scope.findImages = function () { 
        	 var getCustomer = new Object();
             getCustomer.id = 12;
        	propertyService.findPropertyImages(getCustomer,$scope.findImagesCompleted, $scope.findImagesError);
        }

        $scope.findImagesCompleted = function (response) {
        	$scope.slides = response.images;
        	$scope.myInterval = -2;
        }

        $scope.findImagesError = function (response) {
            alertsService.RenderErrorMessage(response.ReturnMessage);
        }

    }]);
