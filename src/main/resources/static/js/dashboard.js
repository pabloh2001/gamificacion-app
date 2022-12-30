$(document).ready(function () {
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
                $("#rankingE > tbody").append(row);
            });
        },
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8090/gamification/api/v1/ranking-teams",
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, item) {
                i = i + 1;
                var row = "<tr>" +
                    "<td>" + i + "</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td>" + item.value + "</td>"+
                    +"</tr>";
                $("#rankingT > tbody").append(row);
            });
        },
    });
});
