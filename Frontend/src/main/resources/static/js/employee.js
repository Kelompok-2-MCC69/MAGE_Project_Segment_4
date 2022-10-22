$(document).ready(function () {
    $('#table-employee').DataTable({
        ajax: {
            url: "api/employee",
            dataSrc: ""
        },
        columns: [
            {
                data: 'id'
            },
            {
                data: 'name'
            }, 
            {
                data: 'age'
            }, 
            {
                data: 'email'
            }, 
            {
                data: 'phone'
            }, 
            {
                data: 'salary'
            }, 
            {
                data: 'gender'
            }, 
        ]
    })
});