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
                defaultContent: ' ',
                data: 'employee.name'
            },
            // {   
            //     defaultContent: ' ',
            //     data: 'manager.name'
            // },
            {
                defaultContent: '0',
                data: 'final_score'
            },
            {
                data: null,
                render: function (data, type, row, meta) {
                    return `
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" onclick="location.href='http://localhost:8090/assessment/' + (${data.id})">
                        Assessment
                        </button>

                        <button type="button" class="btn btn-danger" data-bs-toggle="modal" onclick="deleteKPI(${data.id})">
                        Delete
                        </button>
                        
                        <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updatekpi" onclick="beforeUpdate(${data.id})">
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
        beforeSend: addCsrfToken(),
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
                beforeSend: addCsrfToken(),
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

function beforeUpdate(id) {
    $.ajax({
        method: "GET",
        url: "api/kpi/" + id,
        dataType: "JSON",
        success: (res) => {
            $('#update-kpi-id').val(`${res.id}`);
            $('#update-kpi-create').val(`${res.created_at}`);
            $('#update-kpi-deadline1').val(`${res.first_deadline}`);
            $('#update-kpi-deadline2').val(`${res.second_deadline }`);
            $('#update-kpi-year').val(`${res.year }`);
            $('#update-kpi-score').val(`${res.final_score}`);
            $('#update-kpi-manager-id').val(`${res.manager.id }`);
            $('#update-kpi-employee-id').val(`${res.employee.id }`);
        }
    })
}

$("#update-kpi").click((e) => {
    e.preventDefault();

    let id = $('#update-kpi-id').val();
    let create = $('#update-kpi-create').val();
    let deadline1 = $('#update-kpi-deadline1').val();
    let deadline2 = $('#update-kpi-deadline2').val();  
    let year = $('#update-kpi-year').val();  
    let score = $('#update-kpi-score').val();  
    let managerId = $('#update-kpi-manager-id').val();
    let employeeId = $('#update-kpi-employee-id').val();
    
    $.ajax({
        method: "PUT",
        url: "api/kpi/" + id,
        dataType: "json",
        contentType: "application/json",
        beforeSend: addCsrfToken(),
        data: JSON.stringify({
            created_at: create,
            first_deadline: deadline1,
            second_deadline: deadline2,
            year: year,
            final_score: score,
            managerId: managerId,
            employeeId: employeeId
        }),
        success: (result) => {
            $("#updatekpi").modal("hide");
            $("#table-kpi").DataTable().ajax.reload();
            Swal.fire({
                position: "center",
                icon: "success",
                title: "KPI has been updated",
                showConfirmButton: false,
                timer: 2000,
            });
            $("#update-kpi-create").val("");
            $("#update-kpi-deadline1").val("");
            $("#update-kpi-deadline2").val("");
            $("#update-kpi-year").val("");
            $("#update-kpi-score").val("");
            $("#update-kpi-manager-id").val("");
            $("#update-kpi-employee-id").val("");
        },
    });
});
