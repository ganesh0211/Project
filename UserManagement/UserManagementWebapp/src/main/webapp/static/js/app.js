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

function initUserOperations(){


}
