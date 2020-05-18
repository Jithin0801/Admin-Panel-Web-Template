var employeename, empphno, employeecityid, attendancestatus, maindivision, checkintime, serialnumber;

function getEmployeeId() {
    var url = "http://localhost:8080/api/attendance";
    $.ajax({
        type: "GET",
        url: url,
        success: function (data) {
            $.each(data, function (key, value) {
                var id = value.employeeid;
                var serialnumber = [];
                var length = data.length
                for (count = 1; count <= length; count++) {
                    serialnumber.push(count)
                }
                serialnumber = serialnumber[key]
                attendancestatus = value.attendancestatus;
                checkintime = value.checkintime;
                getEmployee(id, attendancestatus, checkintime, serialnumber)
            })
        }
    })
}


function getEmployee(id, attendancestatus, checkintime, serialnumber) {
    var url = "http://localhost:8080/api/employeebyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": id
        },
        success: function (data) {
            $.each(data, function (key, value) {
                employeename = value.employeename;
                empphno = value.employeecontactnumber;
                if (value.employeecityid == "1") {
                    employeecityid = "Chennai"
                }
                maindivision = value.maindivisionid;
                if (value.maindivisionid == "1") {
                    maindivision = "BTA-Infra";
                } else if (value.maindivisionid == "2") {
                    maindivision = "BTB";
                } else if (value.maindivisionid == "3") {
                    maindivision = "BTA";
                } else if (value.maindivisionid == "4") {
                    maindivision = "BTL";
                }
                populateattendancetable(employeename, empphno, employeecityid, maindivision, attendancestatus, checkintime, serialnumber)
            })
        }
    })
}

function populateattendancetable(employeename, empphno, employeecityid, maindivision, attendancestatus, checkintime, serialnumber) {
    var attendance_data = '';
    attendance_data += '<tr>';
    attendance_data += '<td>' + serialnumber + '</td>';
    attendance_data += '<td>' + employeename + '</td>';
    attendance_data += '<td>' + empphno + '</td>';
    attendance_data += '<td>' + employeecityid + '</td>';
    attendance_data += '<td>' + maindivision + '</td>';
    attendance_data += '<td>' + checkintime + '</td>';
    attendance_data += '<td>' + attendancestatus + '</td>';
    attendance_data += '/<tr>';
    $('#attendancetable').append(attendance_data);
}