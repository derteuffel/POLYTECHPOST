/**
 * enzo kenza
 */

$(document).ready( function () {
    var table = $('#userTable').DataTable({
        "sAjaxSource": "/user",
        "order": [[ 0, "asc" ]],
        "sAjaxDataProp": "",
        language: {
            url: '//cdn.datatables.net/plug-ins/1.10.19/i18n/French.json'
        },
        "columns": [
            { "data": "nom"},
            { "data": "matricule"},
            { "data": "telephone"},
            { "data": "email"},
            { "data": "idUser",
                mRender: function (data, type, row) {
                    var str = '';
                    str += '<a href="user/detail/'+data+' " class="btn btn-primary"><i class="fa fa-eye"> Detail</i></a> &#160; ';
                    str += '<a href="user/update/'+data+' " class="btn btn-warning"><i class="fa fa-edit"> Modifier</i></a>';
                    return str;
                }
            }
        ],
    });
});