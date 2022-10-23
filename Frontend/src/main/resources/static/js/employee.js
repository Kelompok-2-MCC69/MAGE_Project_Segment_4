$(document).ready(function () {
    $('#table-employee').DataTable({
        ajax: {
            url: "api/employee",
            dataSrc: ""
        },
        columns: [
            {
                data: null,
                render: (data, type, row, meta) => {
                    return meta.row + 1
                }
            },
            {
                data: 'name'
            }, 
            {
                data: 'email'
            }, 
            {
                data: 'age'
            },
            {
                data: 'phone'
            },
            {
                data: 'salary'
            },
            {
                data: 'manager.name'
            },
        ]
    })
});