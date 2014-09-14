 // When the browser is ready...

  $(function() {
  
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
        	userName: "Please enter user name",
            password: {
                required: "Please enter your password",
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
        	displayName: "required",
        	email : {
        		required:true,
        		email:true
        	},
        	password: {
                required: true,
                minlength: 5
            },
            city : "required",
            mobileNo : {
                required : true,
                minlength:10,
                number : true
            },
            landLineNo: {
                required : true,
                minlength:10,
                number : true
            },
            userType : "required"
        },
        
        // Specify the validation error messages
        messages: {
        	displayName: "Please enter your name.",
        	email : {
        		required : "Please enter your email id.",
        		email : "Please enter a valid email address."
        	},
        	 password: {
                 required: "Please provide a password.",
                 minlength: "Your password must be at least 5 characters long."
             },
             city :  "Please select your city.",
             mobileNo : {
            	 required : "Please enter your mobile no.",
            	 minlength : "Please enter valid mobile no.",
            	 number : "Please enter valid mobile no."
             },
             landLineNo: {
            	 required : "Please enter your land line no.",
            	 minLenght : "Please enter valid land line no.",
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
        	bedModelName : "required"
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
        	bedModelName : "Please select no of rooms."
        },
        
        submitHandler: function (form) {
        },
        invalidHandler: function (form) {
        }
    });

  });
