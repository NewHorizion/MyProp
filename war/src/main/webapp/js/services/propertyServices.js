'use strict';
var PropertySearchServices = angular.module('PropertyServices', ['ajaxService']);

PropertySearchServices.service('propertyService', ['ajaxService', function propertyService(ajaxService) {
  var self = this;

  
  self.findLatest = function(successFunction, errorFunction) {
	  ajaxService.AjaxGet("openService/search/latest", successFunction, errorFunction);
  };


  self.hotProperties = function(successFunction, errorFunction) {
	  ajaxService.AjaxGet("openService/search/latest", successFunction, errorFunction);
  }


  self.propertiesAvaiableForRent = function(successFunction, errorFunction) {
	  ajaxService.AjaxGet("openService/search/latest", successFunction, errorFunction);
	  
  };


  self.propertiesAvailableForSell = function(successFunction, errorFunction) {
	  ajaxService.AjaxGet("openService/search/latest", successFunction, errorFunction);
  }

}]);
