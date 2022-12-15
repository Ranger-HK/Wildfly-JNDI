/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

loadAllUsers();

function loadAllUsers() {

    /*invoked ajax for send a request*/
    $("#userTable").empty();
    $.ajax({
        url: "http://localhost:8080/Simple_Crud_Using_SpringMVC-1.0/user",
        method: "GET",
        //convert to json format
        dataType: "json",
        success: function (res) {
            for (const user of res.data) {

                let row = `<tr><td>${user.userID}</td><td>${user.userName}</td><td>${user.address}</td><td>${user.email}</td><td>${user.contact}</td><td>${user.password}</td></tr>`;
                $("#userTable").append(row);
            }
            $('#table').DataTable();
        }
    });
}


$("#btnUpdate").click(function () {
    updateUser();
    console.log("Giya");
});

function updateUser() {

    /*create json ob*/
    var userOb = {
        userID: $("#txtUserId").val(),
        userName: $("#txtUserName").val(),
        address: $("#txtUserAddress").val(),
        email: $("#txtEmail").val(),
        contact: $("#txtContact").val(),
        password: $("#txtPassword").val()
    };
    console.log(userOb);


    /*implement ajax request for updateUser Function*/
    $.ajax({
        url: "http://localhost:8080/Simple_Crud_Using_SpringMVC-1.0/user",
        method: "PUT",
        contentType: "application/json", //request content type json
        data: JSON.stringify(userOb), //convert valid json String
        //convert valid query String
        success: function (res) {
            /*console.log(res);*/
            if (res.code === 200) {
                swal("Update Completed !", "Successfully Update the User!", "success");
                loadAllUsers();
                clearAll();

            } else if (res.status === 400) {
                swal("Error Updated Unsuccessful!", "Fail to update the user!", "error");


            } else {
                swal("Error Updated Unsuccessful!", "Fail to update the user!", "error");
            }

        },
        error: function (ob, error) {
            console.log(ob);
        }
    });
}


$("#btnDelete").click(function () {
    // console.log("Awa data");
    let userID = $("#txtUserId").val();

    $.ajax({
        url: "http://localhost:8080/Simple_Crud_Using_SpringMVC-1.0/user?userID=" + userID,
        method: "DELETE",
        success: function (resp) {
            if (resp.code === 200) {
                swal("Delete Completed!", "Successfully delete the user!", "success");
                loadAllUsers();
                clearAll();
            } else {
                swal("Error Deleted Unsuccessful!", "Fail to delete the user!", "error");

            }
        }
    });
});


function clearAll() {
    console.log("Clear");
    $("#txtUserId").val("");
    $("#txtUserName").val("");
    $("#txtUserAddress").val("");
    $("#txtEmail").val("");
    $("#txtContact").val("");
    $("#txtPassword").val("");

}

