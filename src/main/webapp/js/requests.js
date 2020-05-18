var customername, empid;

function getCustomersRequests() {
    var url = "http://localhost:8080/api/customerbystatuid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "statusid": 0
        },
        success: function (data) {
            $.each(data, function (key, value) {
                var id = value.id;
                var customerfirstname = value.customerfirstname;
                var customerlastname = value.customerlastname;
                customername = customerfirstname + customerlastname;
                custid = value.id;
                empid = value.employeeid;
                getEmployee(customername, empid, custid)
            })
        },
    });
}

function getEmployee(customername, empid, custid) {
    var url = "http://localhost:8080/api/employeebyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": empid
        },
        success: function (data) {
            $.each(data, function (key, value) {
                employeename = value.employeename;
                populateCustomerRequest(employeename, customername, custid)
            })
        }
    })
}


function populateCustomerRequest(employeename, customername, custid) {
    var requestcard = '<div class="blog-comments__item d-flex p-3"> <div class="blog-comments__content" id="custreq"> <div class="blog-comments__meta text-muted"> <a class="text-secondary" id="customername" href="#">' + customername + ',</a> from <a class="text-secondary" id="employeename" href="#">' + employeename + '</a> </div> <div class="blog-comments__actions"> <div class="btn-group btn-group-sm"> <button onclick = "acceptButton(' + custid + ')" type="button" class="btn btn-white" id="approvebtn"> <span class="text-success"><i class="material-icons">check</i></span> Approve </button> <button type="button" class="btn btn-white" id="rejectbtn"> <span class="text-danger"><i class="material-icons">clear</i></span> Reject </button> <button type="button" class="btn btn-white" id="viewbtn"> <span class="text-light"><i class="material-icons">more_vert</i></span> View </button> </div> </div> </div> </div>';
    $("#customerrequest").append(requestcard);
}

function acceptButton(custid) {
    var url = "http://localhost:8080/api/customerbyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": custid
        },
        success: function (data) {
            var customerfirstname = data[0].customerfirstname;
            var customerlastname = data[0].customerlastname;
            var customercontactnumber = data[0].customercontactnumber;
            var customeremailid = data[0].customeremailid;
            var customeraddress1 = data[0].customeraddress1;
            var customeraddress2 = data[0].customeraddress2;
            var customercityid = data[0].customercityid;
            var customerstateid = data[0].customerstateid;
            var customercountryid = data[0].customercountryid;
            var customerlandmark = data[0].customerlandmark;
            var contactpersonname = data[0].contactpersonname;
            var companyname = data[0].companyname;
            var companyphonenumber = data[0].companyphonenumber;
            var companyaddress1 = data[0].companyaddress1;
            var companyaddress2 = data[0].companyaddress2;
            var companycityid = data[0].companycityid;
            var companystateid = data[0].companystateid;
            var companycountryid = data[0].companycountryid;
            var gstnumber = data[0].gstnumber;
            var website = data[0].website;
            var maindivisionid = data[0].maindivisionid;
            var divisionid = data[0].divisionid;
            var createdby = data[0].createdby;
            var createddate = data[0].createdat;
            var d = new Date(createddate);
            var date = d.getDate();
            var month = d.getMonth();
            var year = d.getFullYear();
            if (date < 10) {
                date = '0' + date;
            }

            if (month < 10) {
                month = '0' + month;
            }
            var createdat = year + "-" + month + "-" + date;
            var modifieddate = data[0].modifiedat;
            var d1 = new Date(modifieddate);
            var date1 = d1.getDate();
            var month1 = d1.getMonth();
            var year1 = d1.getFullYear();
            if (date1 < 10) {
                date1 = '0' + date1;
            }

            if (month1 < 10) {
                month1 = '0' + month1;
            }
            var modifiedat = year1 + "-" + month1 + "-" + date1;
            var url = "http://localhost:8080/api/modifycustomer"
            $.ajax({
                url: url,
                type: 'PUT',
                data: {
                    "id": custid,
                    "customerfirstname": customerfirstname,
                    "customerlastname": customerlastname,
                    "customercontactnumber": customercontactnumber,
                    "customeremailid": customeremailid,
                    "customeraddress1": customeraddress1,
                    "customeraddress2": customeraddress2,
                    "customercityid": customercityid,
                    "customerstateid": customerstateid,
                    "customercountryid": customercountryid,
                    "customerlandmark": customerlandmark,
                    "contactpersonname": contactpersonname,
                    "companyname": companyname,
                    "companyphonenumber": companyphonenumber,
                    "companyaddress1": companyaddress1,
                    "companyaddress2": companyaddress2,
                    "companycityid": companycityid,
                    "companystateid": companystateid,
                    "companycountryid": companycountryid,
                    "gstnumber": gstnumber,
                    "website": website,
                    "gstnumber": gstnumber,
                    "maindivisionid": maindivisionid,
                    "divisionid": divisionid,
                    "createdby": createdby,
                    "createdat": createdat,
                    "modifiedby": createdby,
                    "modifiedat": modifiedat,
                    "statusid": 1
                },
                success: function (response) {
                    showAddAlert();
                    $("#customerrequest").load(location.href + " #customerrequest" + "#addAlertBox" + getCustomersRequests());
                }
            });
        }
    });
}

function deleteButton(id) {
    $.confirm({
        title: 'The request will be deleted from the database!',
        content: 'You might want to ask the employee to send the request again!',
        theme: 'Material',
        escapeKey: true,
        buttons: {
            Reject: function () {
                var url = "http://localhost:8080/api/deletecustomer";
                $.ajax({
                    type: "DELETE",
                    url: url,
                    data: {
                        "id": id
                    },
                    success: function () {
                        showDeleteAlert();
                        $("#customerrequesttable1").load(location.href + " #customerrequesttable" + "#deleteAlertBox" + getCustomersRequests());
                    }
                });
            },
            Cancel: function () {}
        }
    });
}

function showAddAlert() {
    $('#addAlertBox').show('fade');
}

function dismissAddAlert() {
    $('#addAlertBox').hide('fade');
}

function showDeleteAlert() {
    $('#deleteAlertBox').show('fade');
}

function dismissDeleteAlert() {
    $('#deleteAlertBox').hide('fade');
}