// var tableUsers = $('#tableUsers').DataTable({
//     "ajax": "http://localhost:8090/gamification/api/v1/users/",
//     "language": {
//         "sProcessing": "Procesando...",
//         "sLengthMenu": "Mostrar _MENU_ registros",
//         "sZeroRecords": "No se encontraron resultados",
//         "sEmptyTable": "Ningún dato disponible en esta tabla",
//         "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
//         "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0",
//         "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
//         "sInfoPostFix": "",
//         "sSearch": "Buscar:",
//         "sUrl": "",
//         "sInfoThousands": ",",
//         "sLoadingRecords": "Cargando...",
//         "oPaginate": {
//             "sFirst": "Primero",
//             "sLast": "Último",
//             "sNext": "Siguiente",
//             "sPrevious": "Anterior"
//         },
//         "oAria": {
//             "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
//             "sSortDescending": ": Activar para ordenar la columna de manera descendente"
//         }
//     }
// });


$(document).ready(function () {
    // var table = $('#tableUsers').DataTable({
    // 			"sAjaxSource": "http://localhost:8090/gamification/api/v1/users/",
    // 			"sAjaxDataProp": "",
    // 			"order": [[ 0, "asc" ]],
    // 			"aoColumns": [
    // 			    { "mData": "name"},
    // 		        { "mData": "lastName" },
    // 				{ "mData": "email" },
    // 				{ "mData": "team" },
    // 			]
    // 	 })
    // $.ajax({
    //     type: "GET",
    //     url: "http://localhost:8090/gamification/api/v1/users/",
    //     dataType: "json",
    //     success: function (data) {
    //         console.log(data);
    //         $.each(data, function (i, item) {
    //             var row = "<tr>" +
    //                 "<td>" + item.name + "</td>" +
    //                 "<td>" + item.lastName + "</td>" +
    //                 "<td>" + item.email + "</td>" +
    //                 "<td>" + item.team + "</td>" +
    //                 +"</tr>";
    //             $("#tableUsers > tbody").append(row);
    //         });
    //     },
    // });

    $('#dataTable tbody').on('click', '.edit', function () {
        var id = $(this).parent().find('#id').val();
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8090/gamification/api/v1/users/' + id,
            dataType: 'json',
            success: function (user) {
                //console.log(user);
                $('#id').val(user.id);
                $('#name').val(user.name);
                $('#lastNameEdit').val(user.lastName);
                $('#email').val(user.email);
            }
        });
    });
});