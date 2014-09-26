'use strict';
var ImageServices = angular.module('ImageServices', ['ajaxService']);

ImageServices.service('imageService', ['ajaxService', function propertyService(ajaxService) {
  var self = this;

  
  self.uploadImages = function(formData, successFunction, errorFunction) {
	  if (null!=formData.files)
      {
		  ajaxService.uploadImages(formData, "webservice/UploadImages.action", successFunction, errorFunction);
      }
	  
  };
}]);
