$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/gamification/api/v1/students-team",
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, item) {
                i = i + 1;
                var row = "<tr>" +
                    "<td>" + i + "</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td>" + item.lastName + "</td>" +
                    "<td>" + item.value + "</td>" +
                    +"</tr>";
                $("#studentsTeam > tbody").append(row);
            });
        },
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8090/gamification/api/v1/ranking-students",
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, item) {
                i = i + 1;
                var row = "<tr>" +
                    "<td>" + i + "</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td>" + item.lastName + "</td>" +
                    "<td>" + item.team + "</td>" +
                    "<td>" + item.value + "</td>" +
                    +"</tr>";
                $("#rankinHomeE > tbody").append(row);
            });
        },
    });

    // $('#redeem-home').on('click', function (e) {
    //     e.preventDefault();

    //     var href = $(this).attr('href');
    //     $.get(href, function (data, status) {
    //         console.log(data);
    //         $('#name').text(data.name);
    //         $('#value').text(data.value);
    //         //$('#total').val(data.total);
    //     });

    //     $('#redeemEcoinsModal').modal();
    // });
});
