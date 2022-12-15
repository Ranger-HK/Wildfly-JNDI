/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$("#btnLog").click(function () {

    var userName = $("#userID").val();
    var password = $("#password").val();

    obj = {
        userName: userName,
        password: password
    };

//invoked ajax
    $.ajax({
        url: 'http://localhost:8080/Simple_Crud_Using_SpringMVC-1.0/login?userName=' + obj.userName + '&password=' + obj.password,
        method: 'POST',
        success: function (res) {
            console.log(res);
            if (res.code === 200) {
                swal("Login success!", "You clicked the button!", "success");
                window.location = "Home.html";

            } else {
                swal("User name or password incorrect!", "You clicked the button!", "error");

            }
        }
    });
});


