'use strict';

/* Services */

var propertySrvices = angular.module('propertyServices', ['ngResource']);

propertySrvices.factory('PropertyHttp', ['$http',
  function($http){
    return $http('http://localhost:8080/webservicesample/openService/search/latest', {}, {
      query: {method:'GET', isArray:true}
    });
  }]);