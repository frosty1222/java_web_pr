// wait for the page to load
function hideLoginNotify(){
    document.addEventListener("DOMContentLoaded", function() {
        // Get the notification element by ID
        let notification = document.getElementById("login-success");
        let registerSuccess = document.getElementById("register-success");
        let userIncorrect = document.getElementById("user-incorrect");
        let userLoggedOut = document.getElementById("user-logged-out");
        let registerFail = document.getElementById("register-fail");
        // Function to hide the notification after 3 seconds
        function hideNotification() {
            if(notification){
                notification.style.display = "none";
            }
            if(userIncorrect){
                userIncorrect.style.display ="none";
            }
            if(userLoggedOut){
                userLoggedOut.style.display ="none";
            }
            if(registerFail){
                registerFail.style.display = "none"
            }
            if(registerSuccess){
                registerSuccess.style.display ="none"
            }
        }
        // Set a timeout to hide the notification after 3 seconds
        setTimeout(hideNotification, 5000);
    });
}
hideLoginNotify();