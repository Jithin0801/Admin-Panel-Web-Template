function editCustomer() {
    var id = localStorage.getItem('id');
    var url = "http://localhost:8080/api/customerbyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": id
        },
        success: function (data) {
            var customerfirstname = data[0].customerfirstname;
            var customerlastname = data[0].customerlastname;
            var customercontactnumber = data[0].customercontactnumber;
            var customeremailid = data[0].customeremailid;
            var customeraddress1 = data[0].customeraddress1;
            var customeraddress2 = data[0].customeraddress2;
            var customercity = data[0].customercityid;
            var customerstate = data[0].customerstateid;
            var customercountry = data[0].customercountryid;
            var customerlandmark = data[0].customerlandmark;
            var contactpersonname = data[0].contactpersonname;
            var companyname = data[0].companyname;
            var companyphonenumber = data[0].companyphonenumber;
            var companyaddress1 = data[0].companyaddress1;
            var companyaddress2 = data[0].companyaddress2;
            var companycity = data[0].companycityid;
            var companystate = data[0].companystateid;
            var companycountry = data[0].companycountryid;
            var gstnumber = data[0].gstnumber;
            var website = data[0].website;
            var maindivision = data[0].maindivisionid;
            var division = data[0].divisionid;
            var createdby = data[0].createdby;
            localStorage.setItem("createdby", createdby);
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
            localStorage.setItem('createdat', createdat);
            var statusid = data[0].statusid;
            localStorage.setItem("statusid", statusid);
            $('#p_customerfirstname').val(customerfirstname);
            $('#p_customerlastname').val(customerlastname);
            $('#p_customercontactnumber').val(customercontactnumber);
            $('#p_customeremailid').val(customeremailid);
            $('#p_customeraddress1').val(customeraddress1);
            $('#p_customeraddress2').val(customeraddress2);
            if (customercity == "1") {
                $('#p_customercityid').val("Chennai");
            }
            if (customerstate == "1") {
                $('#p_customerstateid').val("Tamil Nadu");
            }
            if (customercountry == "1") {
                $('#p_customercountryid').val("India");
            }
            $('#p_customerlandmark').val(customerlandmark);
            $('#p_contactpersonname').val(contactpersonname);
            $('#p_companyname').val(companyname);
            $('#p_companyphonenumber').val(companyphonenumber);
            $('#p_companyaddress1').val(companyaddress1);
            $('#p_companyaddress2').val(companyaddress2);
            if (companycity == "1") {
                $('#p_companycityid').val("Chennai");
            }
            if (companystate == "1") {
                $('#p_companystateid').val("Tamil Nadu");
            }
            if (companycountry == "1") {
                $('#p_companycountryid').val("India");
            }
            $('#p_gstnumber').val(gstnumber);
            $('#p_website').val(website);
            if (maindivision == "1") {
                $('#p_maindivisionid').val("BTA-Infra");
            } else if (maindivision == "2") {
                $('#p_maindivisionid').val("BTB");
            } else if (maindivision == "3") {
                $('#p_maindivisionid').val("BTA");
            } else if (maindivision == "4") {
                $('#p_maindivisionid').val("BTL");
            }
            if (division == "1") {
                $('#p_divisionid').val("Automobile Division");
            } else if (division == "2") {
                $('#p_divisionid').val("Infrastructure");
            } else if (division == "3") {
                $('#p_divisionid').val("Battery");
            } else if (division == "4") {
                $('#p_divisionid').val("Environmental Division");
            } else if (division == "5") {
                $('#p_divisionid').val("General Industry");
            } else if (division == "6") {
                $('#p_divisionid').val("Textile Industry");
            }
        }
    });
    $("#updatebutton").click(function () {
        var customerfirstname = $('#p_customerfirstname').val();
        var customerlastname = $('#p_customerlastname').val();
        var customercontactnumber = $('#p_customercontactnumber').val();
        var customeremailid = $('#p_customeremailid').val();
        var customeraddress1 = $('#p_customeraddress1').val();
        var customeraddress2 = $('#p_customeraddress2').val();
        var customercity = $('#p_customercityid').val();
        if (customercity == "Chennai") {
            var customercityid = "1";
        }
        var customerstate = $('#p_customerstateid').val();
        if (customerstate == "Tamil Nadu") {
            var customerstateid = "1";
        }
        var customercountry = $('#p_customercountryid').val();
        if (customercountry == "India") {
            var customercountryid = "1";
        }
        var customerlandmark = $('#p_customerlandmark').val();
        var contactpersonname = $('#p_contactpersonname').val();
        var companyname = $('#p_companyname').val();
        var companyphonenumber = $('#p_companyphonenumber').val();
        var companyaddress1 = $('#p_companyaddress1').val();
        var companyaddress2 = $('#p_companyaddress2').val();
        var companycityname = $('#p_companycityid').val();
        if (companycityname == "Chennai") {
            var companycityid = "1";
        }
        var companystatename = $('#p_companystateid').val();
        if (companystatename == "Tamil Nadu") {
            var companystateid = "1";
        }
        var companycountryname = $('#p_companycountryid').val();
        if (companycountryname == "India") {
            var companycountryid = "1";
        }
        var gstnumber = $('#p_gstnumber').val();
        var website = $('#p_website').val();
        var maindivision = $('#p_maindivisionid').val();
        if (maindivision == "BTA-Infra") {
            var maindivisionid = "1";
        } else if (maindivision == "BTB") {
            var maindivisionid = "2";
        } else if (maindivision == "BTA") {
            var maindivisionid = "3";
        } else if (maindivision == "BTL") {
            var maindivisionid = "4";
        }
        var division = $('#p_divisionid').val();
        if (division == "Automobile Division") {
            var divisionid = "1";
        }
        if (division == "Infrastructure") {
            var divisionid = "2";
        } else if (division == "Battery") {
            var divisionid = "3";
        } else if (division == "Environmental Division") {
            var divisionid = "4";
        } else if (division == "General Industry") {
            var divisionid = "5";
        } else if (division == "Textile Industry") {
            var divisionid = "6";
        }
        var createdby = localStorage.getItem('createdby');
        var createdat = localStorage.getItem('createdat')
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0');
        var yyyy = today.getFullYear();
        var modifiedat = yyyy + '-' + mm + '-' + dd;
        var statusid = localStorage.getItem('statusid');
        var url = "http://localhost:8080/api/modifycustomer"
        $.ajax({
            url: url,
            type: 'PUT',
            data: {
                "id": id,
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
                "statusid": 1,
                "employeeid": 0
            },
            success: function (response) {
                window.location.href = 'http://localhost/customer.html###';
            }
        });
    });
    $("#deletebutton").click(function () {
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
                            window.location.href = 'http://localhost/customer.html##';
                        }
                    });
                },
                Cancel: function () {

                }
            }
        });
    });
}