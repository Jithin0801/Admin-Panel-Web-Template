var id;
function getProducts() {
    var url = "http://localhost:8080/api/products";
    $.ajax({
        type: "GET",
        url: url,
        success: function (data) {
            var product_data = '';
            var sn;
            $.each(data, function (key, value) {
                var id = value.id;
                var serialnumber = [];
                var length = data.length
                for (count = 1; count <= length; count++) {
                    serialnumber.push(count)
                }
                product_data += '<tr>';
                product_data += '<td>' + serialnumber[key] + '</td>';
                product_data += '<td>' + value.productname + '</td>';
                product_data += '<td>' + value.productspecification + '</td>';
                product_data += '<td>' + value.productapplicationarea + '</td>';
                if (value.maindivisionid == "1") {
                    product_data += '<td>' + "BTA-Infra" + '</td>';
                } else if (value.maindivisionid == "2") {
                    product_data += '<td>' + "BTB" + '</td>';
                } else if (value.maindivisionid == "3") {
                    product_data += '<td>' + "BTA" + '</td>';
                } else if (value.maindivisionid == "4") {
                    product_data += '<td>' + "BTL" + '</td>';
                }
                if (value.divisionid == "1") {
                    product_data += '<td>' + "Automobile Division" + '</td>';
                }
                else if (value.divisionid == "2") {
                    product_data += '<td>' + "Infrastructure" + '</td>';
                }
                else if (value.divisionid == "3") {
                    product_data += '<td>' + "Battery" + '</td>';
                }
                else if (value.divisionid == "4") {
                    product_data += '<td>' + "Environmental Division" + '</td>';
                }
                else if (value.divisionid == "5") {
                    product_data += '<td>' + "General Industry" + '</td>';
                }
                else if (value.divisionid == "6") {
                    product_data += '<td>' + "Textile Industry" + '</td>';
                }
                if (value.categoryid == "1") {
                    product_data += '<td>' + "Oil" + '</td>';
                }
                if (value.categoryid == "2") {
                    product_data += '<td>' + "Battery" + '</td>';
                }
                product_data += '<td>' + '<button onClick="viewButton(' + id + ')" type="button" class="mb-2 btn btn-success btn-pill mr-2;"><i class="material-icons mr-1">remove_red_eye</i>View</button>' + " " + '<button onClick="deleteProduct(' + id + ')"type="button" class="mb-2 btn btn-danger btn-pill mr-2;"><i class="material-icons mr-1">delete</i>Delete</button>' + " " + '<button onClick="editButton(' + id + ')" type="button" class="mb-2 btn btn-primary btn-pill mr-2;"><i class="material-icons mr-1">edit</i>Edit</button>' + '</td>';
                product_data += '</tr>';
            }
            )
            $('#producttable').append(product_data);
        },
    });
}
function deleteProduct(id) {
    $.confirm({
        title: 'Do you want to delete?',
        content: false,
        theme: 'Material',
        escapeKey: true,
        buttons: {
            Confirm: function () {
                var url = "http://localhost:8080/api/deleteproduct";
                $.ajax({
                    type: "DELETE",
                    url: url,
                    data: {
                        "id": id
                    },
                    success: function () {
                        showDeleteAlert();
                        $("#producttable1").load(location.href + " #producttable" + "#deleteAlertBox" + getProducts());
                    }
                });
            },
            Cancel: function () {
            }
        }
    });
}
function editButton(proID) {
    var id = proID
    localStorage.setItem('id2', id)
    window.location.href = 'editproduct.html';
}
function viewButton(proID) {
    var id = proID
    localStorage.setItem('id2', id)
    window.location.href = 'viewproduct.html';
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





