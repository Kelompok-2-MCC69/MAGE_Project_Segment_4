$(document).ready(function () {
    $('#table-job').DataTable({
        ajax: {
            url: "api/job",
            dataSrc: ""
        },
        columns: [
            {
                data: 'id'
            },
            {
                data: 'code'
            }, 
            {
                data: 'title'
            }, 
        ]
    })
});