"use strict";
var chat = angular.module('chatModule', [  ]);




chat.controller(
				'chatController',
				function($scope) {

					// function to process the form
					$scope.openChatWindow = function() {
						
				          var box = null;
				          $("input[type='button']").click(function(event, ui) {
				              if(box) {
				                  box.chatbox("option", "boxManager").toggleBox();
				              }
				              else {
				                  box = $("#chat_div").chatbox({id:"chat_div", 
				                                                user:{key : "value"},
				                                                title : "test chat",
				                                                messageSent : function(id, user, msg) {
				                                                    $("#log").append(id + " said: " + msg + "<br/>");
				                                                    $("#chat_div").chatbox("option", "boxManager").addMsg(id, msg);
				                                                }});
				              }
				      });
					};
				});