/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 25/6/17
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
function getUserData() {
    var table = $('#userData').DataTable( {
        "processing":false,
        "serverSide": true,
        "sAjaxDataProp":"",
        "ajax": "getAllUsers",
        "columns": [
            { "data": "id"},
            { "data": "name" },
            { "data": "username" },
            { "data": "role.name" }
        ],
        "aaSorting": [[ 1, "desc" ],[ 2, "desc" ]]

    } );


    $('#userData tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        $.ajax({
            type: "POST",
            url: "../ajax/viewUserDetails/"+data.id,
            success : function(text){
                $('#userInfoModalData').html(text);
                initUserOperations();
                $('#modelOpener').click();
            }
        });
    } );
}

function getAccessToken(code,redirect_uri){
    $.ajax({
        url: "../oauth/token",
        method: "POST",
        crossDomain: true,
        data: {
            grant_type:"authorization_code",
            code:code,
            redirect_uri: redirect_uri
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader ("Authorization", "Basic " + btoa("client1" + ":" + "secret1"));
        },
        statusCode: {
            200: function(response) {
               alert(response)   ;
            },
            401: function() {
                alert("The username or password were not correct. Try again.");
            }
        }
    });
}
function getAuthCode(client_id,secret,redirect_uri,username,password,scope){
    $.ajax({
        url: "../oauth/authorize",
        method: "POST",
        crossDomain: true,
        data: {
            client_id : client_id,
            password: secret,
            redirect_uri: redirect_uri,
            response_type:"code",
            scope:scope
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader ("Authorization", "Basic " + btoa(username + ":" +password));
        },
        statusCode: {
            200: function(response) {
                //$('#oathAuthorizeContent').html(response);
                //auth.login(response.accessToken, response.accessTokenExpiration);
            },
            302: function(response) {
                alert("Already authorized");
            },
            401: function() {
                alert("The username or password were not correct. Try again.");
            }
        }
    });
}

function initUserOperations(){


}
