 // When the browser is ready...

  $(function() {
	  
	  // Login page validation
	  var login_form = $( "#loginForm" );
	  var login_msg = {
			  userName : "Please enter username!",
			  password : "Please enter password!"
	  };
	  $( "#login_button" ).click(function() {
		  login_form.validate({
	  		messages :login_msg
	  	});
	  });
	  
	  // Registration page validation
	  var signupForm = $("#signupForm");
	  $( "#reg_button" ).click(function() {
		  signupForm.validate({
	  		//messages :login_msg
	  	});
	  });
	  
	  //Post Requirement
	  var postRequirement = $("#postRequirement");
	  $( "#postRequirement_button" ).click(function() {
		  postRequirement.validate({
			  errorElement: "label",
			  errorPlacement: function(error, element) {
					error.appendTo(element.parent("li").next("li"));
					error.css("text-align","left"); 
				},

	  		//messages :login_msg
	  	});
	  });
	  $( "#postRequirement_button2" ).click(function() {
		  postRequirement.validate({
			  //
	  		});
	  });
	  
	  var postpropertyform = $("#post_property_form");
	  $( "#prop_detail_next").click(function() {
		  postpropertyform.validate({
			  errorElement: "label",
			  errorPlacement: function(error, element) {
					error.appendTo(element.parent("li").next("li"));
					error.css("text-align","left"); 
				},

	  		//messages :login_msg
	  	});
	  });
	  $( "#features_next_button").click(function() {
		  postpropertyform.validate({
			  errorElement: "label",
			  errorPlacement: function(error, element) {
					error.appendTo(element.parent("li").next("li"));
					error.css("text-align","left"); 
				},

	  		//messages :login_msg
	  	});
	  });
	  
  /*
    // Setup form validation on the #login-form element
    $("#loginForm").validate({
    
        // Specify the validation rules
        rules: {
        	userName: "required",
            password: {
                required: true,
                minlength: 5
            }
        },
        
        // Specify the validation error messages
        messages: {
        	userName: "Please enter user name.",
            password: {
                required: "Please enter your password.",
                minlength: "Your password must be at least 5 characters long"
            }
        },
        
        submitHandler: function (form) {
        },
        invalidHandler: function (form) {
        }
    });
    $("#signupForm").validate({
    
        // Specify the validation rules
        rules: {
        	userName: "required",
        	emailId : {
        		required:true,
        		email:true
        	},
        	password: {
                required: true,
                minlength: 5
            },
            city : "required",
            mobileNumber : {
                required : true,
                minlength:10,
                number : true
            },
            landlineNumber: {
                minlength:10,
                number : true
            },
            userType : "required"
        },
        
        // Specify the validation error messages
        messages: {
        	userName: "Please enter your name.",
        	emailId : {
        		required : "Please enter your email id.",
        		email : "Please enter a valid email address."
        	},
        	 password: {
                 required: "Please provide a password.",
                 minlength: "Your password must be at least 5 characters long."
             },
             city :  "Please select your city.",
             mobileNumber : {
            	 required : "Please enter your mobile no.",
            	 minlength : "Please enter valid mobile no.",
            	 number : "Please enter valid mobile no."
             },
             landlineNumber: {
            	 minlength : "Please enter valid land line no.",
            	 number : "Please enter valid land line no."
             },
             userType : "Please select user type."
        		
        },
        
        submitHandler: function (form) {
        },
        invalidHandler: function (form) {
        }
    });
    
    
    $("#postRequirement").validate({
        
        // Specify the validation rules
        rules: {
        	purchaseType: "required",
        	city : "required",
        	minCoveredArea : {
        		required : true,
        		digits : true
        	},
        	maxCoveredArea : {
        		required : true,
        		digits : true
        	},
        	coveredAreaUnit : "required",
        	rentBudget : "required",
        	dealingType : "required",
        	bedModelName : "required",
        	userName: "required",
        	emailId : {
        		required:true,
        		email:true
        	},
        	password: {
                required: true,
                minlength: 5
            },
            city : "required",
            mobileNumber : {
                required : true,
                minlength:10,
                number : true
            },
            userType : "required"
        		
        },
        
        // Specify the validation error messages
        messages: {
        	purchaseType: "Please select Purchase Type.",
        	city : "Please select your city.",
        	minCoveredArea : {
        		required : "Enter min covered area.",
        		digits : "Enter valid min covered area."
        	},
        	maxCoveredArea : {
        		required : "Enter max covered area.",
        		digits : "Enter valid max covered area."
        	},
        	coveredAreaUnit : "Please select covered area unit.",
        	rentBudget : "Please select expected price.",
        	dealingType : "Please select dealing type.",
        	bedModelName : "Please select no of rooms.",
        	userName: "Please enter your name.",
        	emailId : {
        		required : "Please enter your email id.",
        		email : "Please enter a valid email address."
        	},
        	 password: {
                 required: "Please provide a password.",
                 minlength: "Your password must be at least 5 characters long."
             },
             city :  "Please select your city.",
             mobileNumber : {
            	 required : "Please enter your mobile no.",
            	 minlength : "Please enter valid mobile no.",
            	 number : "Please enter valid mobile no."
             },
             userType : "Please select user type."
        },
        
        submitHandler: function (form) {
        },
        invalidHandler: function (form) {
        }
    });
*/
  });
