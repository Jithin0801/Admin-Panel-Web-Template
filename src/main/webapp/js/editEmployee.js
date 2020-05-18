function editEmployee() {
    var id = localStorage.getItem('id1');
    var url = "http://localhost:8080/api/employeebyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": id
        },
        success: function (data) {
            var employeename = data[0].employeename;
            var employeedobirth = data[0].employeedob;
            var d1 = new Date(employeedobirth);
            var date1 = d1.getDate();
            var month1 = d1.getMonth();
            var year1 = d1.getFullYear();
            if (date1 < 10) {
                date1 = '0' + date1;
            }

            if (month1 < 10) {
                month1 = '0' + month1;
            }
            var employeedob = year1 + "-" + month1 + "-" + date1;
            var employeegender = data[0].employeegenderid;
            var employeecontactnumber = data[0].employeecontactnumber;
            var employeeemail = data[0].employeeemail;
            var employeeaddress1 = data[0].employeeaddress1;
            var employeeaddress2 = data[0].employeeaddress2;
            var employeecityid = data[0].employeecityid;
            var employeestateid = data[0].employeestateid;
            var employeelandmark = data[0].employeelandmark;
            var employeedojoin = data[0].employeedoj;
            var d2 = new Date(employeedojoin);
            var date2 = d2.getDate();
            var month2 = d2.getMonth();
            var year2 = d2.getFullYear();
            if (date2 < 10) {
                date2 = '0' + date2;
            }

            if (month2 < 10) {
                month2 = '0' + month2;
            }
            var employeedoj = year2 + "-" + month2 + "-" + date2;
            var designationid = data[0].designationid;
            var maindivisionid = data[0].maindivisionid;
            var divisionid = data[0].divisionid;
            var createdby = data[0].createdby;
            localStorage.setItem("createdby1", createdby);
            var createddate = data[0].createdat;
            var d3 = new Date(createddate);
            var date3 = d3.getDate();
            var month3 = d3.getMonth();
            var year3 = d3.getFullYear();
            if (date3 < 10) {
                date3 = '0' + date3;
            }

            if (month3 < 10) {
                month3 = '0' + month3;
            }
            var createdat = year3 + "-" + month3 + "-" + date3;
            localStorage.setItem('createdat1', createdat);
            var statusid = data[0].statusid;
            localStorage.setItem("statusid1", statusid);
            $('#p_employeename').val(employeename);
            $('#p_employeedob').val(employeedob);
            if (employeegender == "1") {
                var $radios = $('input:radio[name=gender]');
                if ($radios.is(':checked') === false) {
                    $radios.filter('[value=Male]').prop('checked', true);
                }
            } else if (employeegender == "2") {
                var $radios = $('input:radio[name=gender]');
                if ($radios.is(':checked') === false) {
                    $radios.filter('[value=Female]').prop('checked', true);
                }
            }
            $('#p_employeecontactnumber').val(employeecontactnumber);
            $('#p_employeeemail').val(employeeemail);
            $('#p_employeeaddress1').val(employeeaddress1);
            $('#p_employeeaddress2').val(employeeaddress2);
            if (employeecityid == "1") {
                $('#p_employeecity').val("Chennai");
            }
            if (employeestateid == "1") {
                $('#p_employeestateid').val("Tamil Nadu");
            }
            $('#p_employeelandmark').val(employeelandmark);
            $('#p_employeedoj').val(employeedoj);
            if (designationid == "1") {
                $('#p_designationid').val("Managing Director");
            } else if (designationid == "2") {
                $('#p_designationid').val("General Manager");
            } else if (designationid == "3") {
                $('#p_designationid').val("Team Manager");
            } else if (designationid == "4") {
                $('#p_designationid').val("Marketing Executive");
            }
            if (maindivisionid == "1") {
                $('#p_maindivisionid').val("BTA-Infra");
            } else if (maindivisionid == "2") {
                $('#p_maindivisionid').val("BTB");
            } else if (maindivisionid == "3") {
                $('#p_maindivisionid').val("BTA");
            } else if (maindivisionid == "4") {
                $('#p_maindivisionid').val("BTL");
            }
            if (divisionid == "1") {
                $('#p_divisionid').val("Automobile Division");
            } else if (divisionid == "1") {
                $('#p_divisionid').val("Infrastructure");
            } else if (divisionid == "1") {
                $('#p_divisionid').val("Battery");
            } else if (divisionid == "1") {
                $('#p_divisionid').val("Environmental Division");
            } else if (divisionid == "1") {
                $('#p_divisionid').val("General Industry");
            } else if (divisionid == "1") {
                $('#p_divisionid').val("Textile Industry");
            }
        }
    });
    $("#updatebutton").click(function () {
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
        var employeedoj = $('#p_employeedoj').val()
        var designation = $('#p_designationid').val();
        if (designation == "Managing Director") {
            var designationid = "1";
        } else if (designation == "General Manager") {
            var designationid = "2";
        } else if (designation == "Team Manager") {
            var designationid = "3";
        } else if (designation == "Marketing Executive") {
            var designationid = "4";
        }
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
        var createdby = localStorage.getItem('createdby1');
        var createdat = localStorage.getItem('createdat1')
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0');
        var yyyy = today.getFullYear();
        var modifiedat = yyyy + '-' + mm + '-' + dd;
        var statusid = localStorage.getItem('statusid1');
        var url = "http://localhost:8080/api/modifyemployee"
        $.ajax({
            url: url,
            type: 'PUT',
            data: {
                "id": id,
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
                "modifiedby": createdby,
                "modifiedat": modifiedat,
                "statusid": statusid
            },
            success: function (response) {
                window.location.href = 'http://localhost/employee.html###';
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
                    var url = "http://localhost:8080/api/deleteemployee";
                    $.ajax({
                        type: "DELETE",
                        url: url,
                        data: {
                            "id": id
                        },
                        success: function () {
                            window.location.href = 'http://localhost/employee.html##';
                        }
                    });
                },
                Cancel: function () {

                }
            }
        });
    });
    localStorage.removeItem;
}