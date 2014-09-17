'use strict';
var LoginServices = angular.module('LoginServices', ['ajaxService']);

LoginServices.service('loginService', ['ajaxService', function propertyService(ajaxService) {
  var self = this;

  
  self.login = function(formData, successFunction, errorFunction) {
	  ajaxService.AjaxPostContentType(formData, "webservice/Login.action", successFunction, errorFunction);
  };
  
  self.registration = function(formData, successFunction, errorFunction) {
	  ajaxService.AjaxPostContentType(formData, "webservice/Registration.action", successFunction, errorFunction);
  };

}]);
