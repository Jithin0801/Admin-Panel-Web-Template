function postAllEmployeeDetails() {
    var employeename = $('#p_employeename').val();
    var employeedob = $('#p_employeedob').val();
    var employeegender = $('input[name=gender]:checked', '#employeeform').val()
    if (employeegender == "Male") {
        employeegenderid = "1";
    } else if (employeegender == "Female") {
        employeegenderid = "2";
    }
    var employeecontactnumber = $('#p_employeecontactnumber').val();
    var employeeemail = $('#p_employeeemail').val();
    var employeeaddress1 = $('#p_employeeaddress1').val();
    var employeeaddress2 = $('#p_employeeaddress2').val();
    var employeecity = $('#p_employeecityid').val();
    if (employeecity == "Chennai") {
        var employeecityid = "1";
    }
    var employeestate = $('#p_employeestateid').val();
    if (employeestate == "Tamil Nadu") {
        var employeestateid = "1";
    }
    var employeelandmark = $('#p_employeelandmark').val();
    var employeedoj = $('#p_employeedoj').val();
    var designation = $('#p_designationid').val();
    if (designation == "Managing Director") {
        var designationid = "1";
    }
    else if (designation == "General Manager") {
        var designationid = "2";
    }
    else if (designation == "Team Manager") {
        var designationid = "3";
    }
    else if (designation == "Marketing Executive") {
        var designationid = "4";
    }
    var maindivision = $('#p_maindivisionid').val();
    if (maindivision == "BTA-Infra") {
        var maindivisionid = "1";
    }
    else if (maindivision == "BTB") {
        var maindivisionid = "2"
    }
    else if (maindivision == "BTA") {
        var maindivisionid = "3"
    }
    else if (maindivision == "BTL") {
        var maindivisionid = "4"
    }
    var division = $('#p_divisionid').val();
    if (division == "Automobile Division") {
        var divisionid = "1";
    }
    if (division == "Infrastructure") {
        var divisionid = "2";
    }
    else if (division == "Battery") {
        var divisionid = "3";
    }
    else if (division == "Environmental Division") {
        var divisionid = "4";
    }
    else if (division == "General Industry") {
        var divisionid = "5";
    }
    else if (division == "Textile Industry") {
        var divisionid = "6";
    }
    var createdby = $('#p_createdby').val();
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();
    createdat = yyyy + '-' + mm + '-' + dd;
    localStorage.setItem('createdby1', createdby);
    localStorage.setItem('createdat1', createdat);
    var statusid = $('#p_statusid').val();
    var url = "http://localhost:8080/api/addemployee"
    $.post(url, {
        "employeename": employeename,
        "employeedob": employeedob,
        "employeegenderid": employeegenderid,
        "employeecontactnumber": employeecontactnumber,
        "employeeemail": employeeemail,
        "employeeaddress1": employeeaddress1,
        "employeeaddress2": employeeaddress2,
        "employeecityid": employeecityid,
        "employeestateid": employeestateid,
        "employeelandmark": employeelandmark,
        "employeedoj": employeedoj,
        "designationid": designationid,
        "maindivisionid": maindivisionid,
        "divisionid": divisionid,
        "createdby": createdby,
        "createdat": createdat,
        "modifiedat": createdat,
        "modifiedby": createdby,
        "statusid": statusid
    },
        function () {
            window.location.href = "http://localhost/employee.html#";
        });
}
