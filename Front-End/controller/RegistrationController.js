/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$("#btnSave").click(function () {
    registrationUser();


});

function registrationUser() {
    let userID = $("#txtuserID").val();
    let userName = $("#txtuserName").val();
    let address = $("#txtaddress").val();
    let email = $("#txtemail").val();
    let contact = $("#txtcontact").val();
    let password = $("#txtpassword").val();

    user = {
        userID: userID,
        userName: userName,
        address: address,
        email: email,
        contact: contact,
        password: password
    };


    /*----------------------ajax for saveCustomer function---------------------------*/
    $.ajax({
        url: "http://localhost:8080/Simple_Crud_Using_SpringMVC-1.0/user",
        method: "POST",
        data: "userID=" + user.userID + "&" + "userName=" + user.userName + "&" + "address=" + user.address + "&" + "email=" + user.email + "&" + "contact=" + user.contact + "&" + "password=" + user.password, //if we send data with the request
        success: function (res) {
            if (res.code === 200) {
                swal("New User Registration Success!", "You clicked the button!", "success");
                $("#txtuserID").val("");
                $("#txtuserName").val("");
                $("#txtaddress").val("");
                $("#txtemail").val("");
                $("#txtcontact").val("");
                $("#txtpassword").val("");


            } else {
                swal("New User Registration Failed!", "You clicked the button!", "error");


            }

        },
        error: function (ob, textStatus, error) {
            alert(textStatus);
        }
    });
}
