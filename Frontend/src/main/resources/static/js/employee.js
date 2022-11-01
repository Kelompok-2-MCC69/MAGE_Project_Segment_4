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
                data: 'phone'
            },
            {
                data: 'salary'
            },
            {
                defaultContent: ' ',
                data: 'manager.name'
            },
            {
                data: null,
                render: function (data, type, row, meta) {
                    return ` 

                    <button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#detailEmployee" onclick="findById(${data.id})">
                    Detail
                    </button>
                
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" onclick="deleteEmployee(${data.id})">
                    Delete
                    </button>

                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateEmployee" onclick="beforeUpdate(${data.id})">
                    Edit
                    </button>
                    `
                }
            }
        ]
    })
});

function findById(id) {
    $.ajax({
        method: "GET",
        url: "api/employee/" + id,
        dataType: "json",
        contentType: "application/json",
        success: (result) => {
            $('#employeeId').text(`${result.id}`)
            $('#employeeName').text(`${result.name}`)
            $('#employeeAge').text(`${result.age}`)
            $('#employeeEmail').text(`${result.email}`)
            $('#employeePhone').text(`${result.phone}`)
            $('#employeeGender').text(`${result.gender}`)
            $('#employeeSalary').text(`${result.salary}`)
            $('#employeeUsername').text(`${result.user.username}`)
            $('#employeePassword').text(`${result.user.password}`)
        }
    })
}

$('#create-employee').click((e) => {
    e.preventDefault()

    let nameValue = $('#employee-name').val();
    let ageValue = $('#employee-age').val();
    let emailValue = $('#employee-email').val();
    let phoneValue = $('#employee-phone').val();
    let genderValue = $('#employee-gender').val();
    let salaryValue = $('#employee-salary').val();
    let usernameValue = $('#employee-username').val();
    let passwordValue = $('#employee-password').val();

    
    //Validasi 
    if (nameValue === "" || nameValue === null) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Please fill all field',
            showConfirmButton: false,
            timer: 1000
        })
    } else {
        $.ajax({
            method: "POST",
            url: "api/employee",
            dataType: "json",
            contentType: "application/json",
            beforeSend: addCsrfToken(),
            data: JSON.stringify({
                name: nameValue,
                age : ageValue,
                email: emailValue,
                phone: phoneValue,
                gender: genderValue,
                salary: salaryValue,
                username: usernameValue,
                password: passwordValue
            }),
            success: (result) => {
                $('#createEmployee').modal('hide')
                $('#table-employee').DataTable().ajax.reload()
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Employee has been created',
                    showConfirmButton: false,
                    timer: 2000
                });
                $('#employee-name').val("")
            },
            error: (result) => {
                Swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: 'Employee name already exists',
                    showConfirmButton: false,
                    timer: 1000
                })
            } 
        });
    }
       
});
