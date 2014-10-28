'use strict';
var userServices = angular.module('userServices', ['ajaxService']);

userServices.service('userService', ['ajaxService', function userService(ajaxService) {
  var self = this;

  self.profile = function(successFunction, errorFunction) {
	  ajaxService.AjaxGet("webservice/Profile.action", successFunction, errorFunction);
  };
  
  self.updateProfile = function(formData, successFunction, errorFunction) {
	  ajaxService.AjaxPostContentType(formData, "webservice/UpdateProfile.action", successFunction, errorFunction);
  };
  
}]);
