var id;

function getCustomers() {
    var url = "http://localhost:8080/api/customerbystatuid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "statusid": 1
        },
        success: function (data) {
            var customer_data = '';
            var sn;
            $.each(data, function (key, value) {
                var id = value.id;
                var serialnumber = [];
                var length = data.length
                for (count = 1; count <= length; count++) {
                    serialnumber.push(count)
                }
                customer_data += '<tr>';
                customer_data += '<td>' + serialnumber[key] + '</td>';
                customer_data += '<td>' + value.customerfirstname + " " + value.customerlastname + '</td>';
                customer_data += '<td>' + value.customercontactnumber + '</td>';
                if (value.customercityid == "1") {
                    customer_data += '<td>' + "Chennai" + '</td>';
                }
                if (value.maindivisionid == "1") {
                    customer_data += '<td>' + "BTA-Infra" + '</td>';
                } else if (value.maindivisionid == "2") {
                    customer_data += '<td>' + "BTB" + '</td>';
                } else if (value.maindivisionid == "3") {
                    customer_data += '<td>' + "BTA" + '</td>';
                } else if (value.maindivisionid == "4") {
                    customer_data += '<td>' + "BTL" + '</td>';
                }
                if (value.divisionid == "1") {
                    customer_data += '<td>' + "Automobile Division" + '</td>';
                } else if (value.divisionid == "2") {
                    customer_data += '<td>' + "Infrastructure" + '</td>';
                } else if (value.divisionid == "3") {
                    customer_data += '<td>' + "Battery" + '</td>';
                } else if (value.divisionid == "4") {
                    customer_data += '<td>' + "Environmental Division" + '</td>';
                } else if (value.divisionid == "5") {
                    customer_data += '<td>' + "General Industry" + '</td>';
                } else if (value.divisionid == "6") {
                    customer_data += '<td>' + "Textile Industry" + '</td>';
                }
                customer_data += '<td>' + value.companyname + '</td>';
                customer_data += '<td>' + value.contactpersonname + '</td>';
                customer_data += '<td>' + value.companyphonenumber + '</td>';
                customer_data += '<td>' + '<button onClick="viewButton(' + id + ')" type="button" class="mb-2 btn btn-success btn-pill mr-2;"><i class="material-icons mr-1">remove_red_eye</i>View</button>' + " " + '<button onClick="deleteCustomer(' + id + ')"type="button" class="mb-2 btn btn-danger btn-pill mr-2; onclick="deleteCustomer()""><i class="material-icons mr-1">delete</i>Delete</button>' + " " + '<button onClick="editButton(' + id + ')" type="button" class="mb-2 btn btn-primary btn-pill mr-2;"><i class="material-icons mr-1">edit</i>Edit</button>' + '</td>';
                customer_data += '</tr>';
            })
            $('#customertable').append(customer_data);
        },
    });
}

function deleteCustomer(id) {
    $.confirm({
        title: 'Do you want to delete?',
        content: false,
        theme: 'Material',
        escapeKey: true,
        buttons: {
            Confirm: function () {
                var url = "http://localhost:8080/api/deletecustomer";
                $.ajax({
                    type: "DELETE",
                    url: url,
                    data: {
                        "id": id
                    },
                    success: function () {
                        showDeleteAlert();
                        $("#customertable1").load(location.href + " #customertable" + "#deleteAlertBox" + getCustomers());
                    }
                });
            },
            Cancel: function () {}
        }
    });
}

function editButton(custId) {
    var id = custId
    localStorage.setItem('id', id)
    window.location.href = 'editcustomer.html';
}

function viewButton(custId) {
    var id = custId
    localStorage.setItem('id', id)
    window.location.href = 'viewcustomer.html';
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
    if (window.location.href == 'http://localhost/customer.html##') {
        showDeleteAlert();
    }
    if (window.location.href == 'http://localhost/customer.html#') {
        showAddAlert();
    }
    if (window.location.href == 'http://localhost/customer.html###') {
        showUpdateAlert();
    }
}

function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("customersearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("customertable");
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