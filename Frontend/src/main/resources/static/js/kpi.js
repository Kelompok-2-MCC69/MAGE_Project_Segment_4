$(document).ready(function () {
    $('#table-kpi').DataTable({
        ajax: {
            url: "api/kpi",
            dataSrc: ""
        },
        columns: [
            {
                data: 'id'
            },
            {
                data: 'created_at'
            }, 
            {
                data: 'first_deadline'
            },
            {
                data: 'second_deadline'
            },
            {
                data: 'year'
            },
            {
                data: 'employee.name'
            },
            {
                data: 'manager.name'
            },
            {
                data: 'final_score'
            },
            {
                data: null,
                render: function (data, type, row, meta) {
                    return `
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" onclick="assessment(${data.id})">
                        Assessment
                        </button>

                        <button type="button" class="btn btn-danger" data-bs-toggle="modal" onclick="deleteKPI(${data.id})">
                        Delete
                        </button>
                        
                        <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateKPI" onclick="beforeUpdate(${data.id})">
                        Edit
                        </button>
                        `
                }
            }  
        ]
    })
});

$('#create-kpi').click((e) => {
    e.preventDefault()

    let employeeVal = $('#employee-id').val()
    let managerVal = $('#manager-id').val()

    $.ajax({
        method: "POST",
        url: "api/kpi",
        dataType: "JSON",
        contentType: "application/json",
        data: JSON.stringify({
            employeeId: employeeVal,
            managerId: managerVal
        }),
        success: (result) => {
            $('#createKPI').modal('hide')
            $('#table-kpi').DataTable().ajax.reload()
            Swal.fire({
                position: 'center',
                icon: 'success',
                title: 'KPI has been created',
                showConfirmButton: false,
                timer: 2000
            })
            $('#employee-id').val("")
            $('#manager-id').val("")
        }
    })
})

function deleteKPI(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "DELETE",
                url: "api/kpi/" + id,
                dataType: "json",
                contentType: "application/json",
                success: (res) => {
                    $('#table-kpi').DataTable().ajax.reload()
                    Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    )
                }
            })
        }
    })
}

function assessment(id){
    $.ajax({
        method: "GET",
        url: "assessment/" + id,
        dataType: "json",
        contentType: "application/json",
        success: (result) => {
            
        }
    })
}