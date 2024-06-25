function validateEmail(email) {
    var email = document.getElementById("email").value;
    var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (emailRegex.test(email)) {
        return true;
    } else {
        return false;
    }
}
function validatePassword(password) {
    const minLength = 6;
    const uppercasePattern = /[A-Z]/;
    const lowercasePattern = /[a-z]/;
    const specialCharPattern = /[!@#$%^&*(),.?":{}|<>]/;

    if (password.length < minLength || !uppercasePattern.test(password) || !lowercasePattern.test(password) || !specialCharPattern.test(password)) {
        return false;
    }

    return true;
}
function passwordCheck() {
    var pass1 = document.getElementById("pass1").value;
    var pass2 = document.getElementById("pass2").value;
    

    if (!validatePassword(pass1)) {
        alert("Password must be at least 6 characters long and contain at least one uppercase letter, one lowercase letter, and one special character.");
        return false;
    }

    if (pass1 !== pass2) {
        alert("Passwords do not match.");
        document.getElementById("pass1").style.borderColor = "#E34234";
        document.getElementById("pass2").style.borderColor = "#E34234";
        return false;
    }

    return true;
}

function validateForm() {
    var form = document.getElementById("registration-form");
    var inputs = form.querySelectorAll("input[required]");
    var email = document.getElementById("email").value;
    var isValid = true;
    
    if(!validateEmail(email)){
    	alert("Invalid email address format");
    	return false;
    }

    inputs.forEach(function(input) {
        if (!input.value) {
            input.style.borderColor = "#E34234";
            isValid = false;
        } else {
            input.style.borderColor = "#00FFFF";
        }
    });

    if (!isValid) {
        alert("Please fill out all required fields.");
        return false;
    }

    return passwordCheck();
}