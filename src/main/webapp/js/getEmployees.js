var id;
function getEmployees() {
    var url = "http://localhost:8080/api/employees";
    $.ajax({
        type: "GET",
        url: url,
        success: function (data) {
            var employee_data = '';
            var sn;
            $.each(data, function (key, value) {
                var id = value.id;
                var serialnumber = [];
                var length = data.length
                for (count = 1; count <= length; count++) {
                    serialnumber.push(count)
                }
                employee_data += '<tr>';
                employee_data += '<td>' + serialnumber[key] + '</td>';
                employee_data += '<td>' + value.employeename + '</td>';
                employee_data += '<td>' + value.employeecontactnumber + '</td>';
                employee_data += '<td>' + value.employeeemail + '</td>';
                if (value.maindivisionid == "1") {
                    employee_data += '<td>' + "BTA-Infra" + '</td>';
                } else if (value.maindivisionid == "2") {
                    employee_data += '<td>' + "BTB" + '</td>';
                } else if (value.maindivisionid == "3") {
                    employee_data += '<td>' + "BTA" + '</td>';
                } else if (value.maindivisionid == "4") {
                    employee_data += '<td>' + "BTL" + '</td>';
                }
                if (value.divisionid == "1") {
                    employee_data += '<td>' + "Automobile Division" + '</td>';
                }
                else if (value.divisionid == "2") {
                    employee_data += '<td>' + "Infrastructure" + '</td>';
                }
                else if (value.divisionid == "3") {
                    employee_data += '<td>' + "Battery" + '</td>';
                }
                else if (value.divisionid == "4") {
                    employee_data += '<td>' + "Environmental Division" + '</td>';
                }
                else if (value.divisionid == "5") {
                    employee_data += '<td>' + "General Industry" + '</td>';
                }
                else if (value.divisionid == "6") {
                    employee_data += '<td>' + "Textile Industry" + '</td>';
                }
                if (value.designationid == "1") {
                    employee_data += '<td>' + "Managing Director" + '</td>';
                }
                else if (value.designationid == "2") {
                    employee_data += '<td>' + "General Manager" + '</td>';
                }
                else if (value.designationid == "3") {
                    employee_data += '<td>' + "Team Manager" + '</td>';
                }
                else if (value.designationid == "4") {
                    employee_data += '<td>' + "Marketing Executive" + '</td>';
                }
                employee_data += '<td>' + '<button onClick="viewButton(' + id + ')" type="button" class="mb-2 btn btn-success btn-pill mr-2;"><i class="material-icons mr-1">remove_red_eye</i>View</button>' + " " + '<button onClick="deleteEmployee(' + id + ')"type="button" class="mb-2 btn btn-danger btn-pill mr-2;"><i class="material-icons mr-1">delete</i>Delete</button>' + " " + '<button onClick="editButton(' + id + ')" type="button" class="mb-2 btn btn-primary btn-pill mr-2;"><i class="material-icons mr-1">edit</i>Edit</button>' + '</td>';
                employee_data += '</tr>';
            }
            )
            $('#employeetable').append(employee_data);
        },
    });
}
function deleteEmployee(id) {
    $.confirm({
        title: 'Do you want to delete?',
        content: false,
        theme: 'Material',
        escapeKey: true,
        buttons: {
            Confirm: function () {
                var url = "http://localhost:8080/api/deleteemployee";
                $.ajax({
                    type: "DELETE",
                    url: url,
                    data: {
                        "id": id
                    },
                    success: function () {
                        showDeleteAlert();
                        $("#employeetable1").load(location.href + " #employeetable" + "#deleteAlertBox" + getEmployees());
                    }
                });
            },
            Cancel: function () {
            }
        }
    });
}
function editButton(empID) {
    var id = empID
    localStorage.setItem('id1', id)
    window.location.href = 'editemployee.html';
}
function viewButton(empID) {
    var id = empID
    localStorage.setItem('id1', id)
    window.location.href = 'viewemployee.html';
}
// alert box functions
function showDeleteAlert() {
    $('#deleteAlertBox').show('fade');
}
function dismissDeleteAlert() {
    $('#deleteAlertBox').hide('fade');
}
function showAddAlert() {
    $('#addAlertBox').show('fade');
}
function dismissAddAlert() {
    $('#addAlertBox').hide('fade');
}
function showUpdateAlert() {
    $('#updateAlertBox').show('fade');
}
function dismissUpdateAlert() {
    $('#updateAlertBox').hide('fade');
}
function triggerAlertBoxes() {
    if (window.location.href == 'http://localhost/employee.html##') {
        showDeleteAlert();
    }
    if (window.location.href == 'http://localhost/employee.html#') {
        showAddAlert();
    }
    if (window.location.href == 'http://localhost/employee.html###') {
        showUpdateAlert();
    }
}
function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("employeesearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("employeetable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}





