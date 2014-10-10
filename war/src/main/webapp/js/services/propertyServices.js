'use strict';
var PropertySearchServices = angular.module('PropertyServices', ['ajaxService']);

PropertySearchServices.service('propertyService', ['ajaxService', function propertyService(ajaxService) {
    var self = this;

    
    self.findLatest = function(successFunction, errorFunction) {
  	  ajaxService.AjaxGet("openService/search/latest", successFunction, errorFunction);
    };


    self.hotProperties = function(successFunction, errorFunction) {
  	  ajaxService.AjaxGet("openService/search/latest", successFunction, errorFunction);
    };


    self.propertiesAvaiableForRent = function(successFunction, errorFunction) {
  	  ajaxService.AjaxGet("openService/search/latest", successFunction, errorFunction);
  	  
    };


    self.propertiesAvailableForSell = function(successFunction, errorFunction) {
  	  ajaxService.AjaxGet("openService/search/latest", successFunction, errorFunction);
    };
    
    self.findPropertyImages = function(propertyId,successFunction, errorFunction) {
  	  ajaxService.AjaxGetWithData(propertyId,"openService/search/listImages", successFunction, errorFunction);
    };
    
    self.postProperty = function(formData, successFunction, errorFunction) {
  	  ajaxService.AjaxPostContentType(formData, "webservice/UploadPropertyAction.action", successFunction, errorFunction);
    };
    
    self.postRequirement = function(formData, successFunction, errorFunction) {
      ajaxService.AjaxPostContentType(formData, "webservice/UploadRequirementAction.action", successFunction, errorFunction);
    };
    
    self.searchProperties = function (formData, successFunction, errorFunction)
    {
    	ajaxService.AjaxPost(formData, "http://localhost:8080/webservicesample/openService/search/properties", successFunction, errorFunction);
    }
    
}]);
