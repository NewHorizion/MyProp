'use strict';

/* Services */


var PropertySearchServices = angular.module('PropertySearchServices', []);

PropertySearchServices.factory('PropertyService', ['$http',
  function($http){
    return $http('http://localhost:8080/webservicesample/openService/search/latest', {}, {
      query: {method:'GET', isArray:true}
    });
  }]);



PropertySearchServices.factory('searchService', function () {
    var searchResponse = {};

    return {
        saveSearchResponse:function (data) {
            searchResponse = data;
            console.log(data);
        },
        getSearchResponse:function () {
            return searchResponse;
        }
    };
});

PropertySearchServices.factory('imageService', function () {
    var imageResponse = {};

    return {
        saveImageResponse:function (data) {
        	imageResponse = data;
            console.log(data);
        },
        getImageResponse:function () {
            return imageResponse;
        }
    };
});