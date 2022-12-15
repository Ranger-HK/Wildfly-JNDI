/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$("#table").click(function (e) {
    let userId = $(e.target).closest('tr').find('td').eq(0).html();
    let userName = $(e.target).closest('tr').find('td').eq(1).html();
    let address = $(e.target).closest('tr').find('td').eq(2).html();
    let email = $(e.target).closest('tr').find('td').eq(3).html();
    let contact = $(e.target).closest('tr').find('td').eq(4).html();
    let password = $(e.target).closest('tr').find('td').eq(5).html();

    $("#txtUserId").val(userId);
    $("#txtUserName").val(userName);
    $("#txtUserAddress").val(address);
    $("#txtEmail").val(email);
    $("#txtContact").val(contact);
    $("#txtPassword").val(password);
});


