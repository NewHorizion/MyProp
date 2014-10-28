'use strict';
var LoginServices = angular.module('LoginServices', ['ajaxService']);

LoginServices.service('loginService', ['ajaxService', function loginService(ajaxService) {
  var self = this;

  
  self.login = function(formData, successFunction, errorFunction) {
	  ajaxService.AjaxPostContentType(formData, "webservice/Login.action", successFunction, errorFunction);
  };
  
  self.registration = function(formData, successFunction, errorFunction) {
	  ajaxService.AjaxPostContentType(formData, "webservice/Registration.action", successFunction, errorFunction);
  };
  
  self.logout = function(successFunction, errorFunction) {
	  ajaxService.AjaxWithUrl("webservice/LogoutAction.action", successFunction, errorFunction);
  };
  
  self.updateProfile = function(formData, successFunction, errorFunction) {
	  ajaxService.AjaxPostContentType(formData, "webservice/UpdateProfile.action", successFunction, errorFunction);
  };
  
  /*self.register = function(formData) {
	  return ajaxService.AjaxPostContentWithoutResponse(formData, "webservice/Registration.action");
  };
  
  self.loggedin = function(formData) {
	  return ajaxService.AjaxPostContentWithoutResponse(formData, "webservice/Login.action");
  };*/

}]);
