function postAllCustomerDetails() {
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
    var companycity = $('#p_companycityid').val();
    if (companycity == "Chennai") {
        var companycityid = "1";
    }
    var companystate = $('#p_companystateid').val();
    if (companystate == "Tamil Nadu") {
        var companystateid = "1";
    }
    var companycountry = $('#p_companycountryid').val();
    if (companycountry == "India") {
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
    var createdby = $('#p_createdby').val();
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();
    createdat = yyyy + '-' + mm + '-' + dd;
    localStorage.setItem('createdby', createdby);
    localStorage.setItem('createdat', createdat);
    var statusid = $('#p_statusid').val();
    var url = "http://localhost:8080/api/addcustomer"
    $.post(url, {
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
            "modifiedat": createdat,
            "modifiedby": createdby,
            "statusid": 1,
            "employeeid": 0
        },
        function () {
            window.location.href = "http://localhost/Customer.html#";
        });
}