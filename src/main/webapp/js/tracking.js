var id;

function getAttendance() {
    var url = "http://localhost:8080/api/attendance";
    $.ajax({
        type: "GET",
        url: url,
        data: {},
        success: function (data) {
            $.each(data, function (key, value) {
                var employeeid = value.employeeid;
                var id = value.id;
                var date1 = value.date;
                var d = new Date(date1);
                var date = d.getDate();
                var month = d.getMonth();
                var year = d.getFullYear();
                if (date < 10) {
                    date = '0' + date;
                }

                if (month < 10) {
                    month = '0' + month;
                }
                var date2 = date + "-" + month + "-" + year;
                var length = data.length;
                populateloctable(employeeid, id, date2, length, key);
            })
        },
    });
}

var map;
var marker, i;
var markers = [];

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 17
    });
    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                map.setCenter(pos);
                infoWindow = new google.maps.InfoWindow({
                    content: "You are here!"
                });
                var marker = new google.maps.Marker({
                    position: pos,
                    map: map,
                    icon: 'mylocation.png'
                });
                google.maps.event.addListener(marker, 'mouseover', function () {
                    infoWindow.open(map, marker);
                });
            },
            function () {
                handleLocationError(true, infoWindow, map.getCenter());
            });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
    infoWindow.open(map);
}

function setMapOnAll(map) {
    if (markers != undefined)
        if (markers.length > 0) {
            for (var i = 0; i < markers.length; i++) {
                markers[i].setMap(map);
            }
        }
}


function addmarker(lat, lng, empname) {
    setMapOnAll(null);
    var infowindow = new google.maps.InfoWindow;
    var locations = [
        [empname + " " + "Marked attendance!", lat, lng]
    ];
    for (i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            map: map,
            icon: 'markattendance.png'
        });
        markers.push(marker);
        google.maps.event.addListener(marker, 'mouseover', (function (marker, i) {
            return function () {
                infowindow.setContent(locations[i][0]);
                infowindow.open(map, marker);
            }
        })(marker, i));
        map.setCenter(new google.maps.LatLng(locations[i][1], locations[i][2]));
        map.setZoom(17);
    }
    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                var marker = new google.maps.Marker({
                    position: pos,
                    map: map,
                    icon: 'mylocation.png'
                });
                google.maps.event.addListener(marker, 'mouseover', function () {
                    infoWindow.open(map, marker);
                });
            },
            function () {
                handleLocationError(true, infoWindow, map.getCenter());
            });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
    infoWindow.open(map);
}

function populateloctable(employeeid, id, date2, length, key1) {
    var url = "http://localhost:8080/api/employeebyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": employeeid
        },
        success: function (data) {
            var attendance_data = '';
            var sn;
            $.each(data, function (key, value) {
                var serialnumber = [];
                for (count = 1; count <= length; count++) {
                    serialnumber.push(count)
                }
                attendance_data += '<tr>';
                attendance_data += '<td>' + serialnumber[key1] + '</td>';
                attendance_data += '<td>' + value.employeename + '</td>';
                attendance_data += '<td>' + date2 + '</td>';
                attendance_data += '<td>' + '<button onClick="viewButton(' + id + ',' + employeeid + ')" type="button" class="mb-2 btn btn-success btn-pill mr-2;"><i class="material-icons mr-1">remove_red_eye</i>View</button>' + '</td>';
                attendance_data += '</tr>';
            })
            $('#employeeloctable').append(attendance_data);
        }
    });
}

function viewButton(id, employeeid) {
    var lat, lng, empname, checkin, name, phno, status, designation, maindivision;
    var url = "http://localhost:8080/api/attendancebyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": id
        },
        success: function (data) {
            $.each(data, function (key, value) {
                lat = value.lat;
                lng = value.lng;
                addmarker(lat, lng, empname)
                checkin = value.checkintime;
                status = value.attendancestatus;
                viewfullattendance(data, checkin, status, name, phno, designation, maindivision)

            })
        },
    });
    var url = "http://localhost:8080/api/employeebyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": employeeid
        },
        success: function (data) {
            $.each(data, function (key, value) {
                empname = value.employeename;
                $("#empname").text(empname);
                addmarker(lat, lng, empname)
                name = value.employeename;
                phno = value.employeecontactnumber;
                designation = value.designationid;
                maindivision = value.maindivisionid;
                viewfullattendance(data, checkin, status, name, phno, designation, maindivision)
            })
        }
    });

}

function viewfullattendance(data, checkin, status, name, phno, designation, maindivision) {
    $("#p_employeename").text(name);
    $("#p_employeecontactnumber").text(phno);
    $("#checkintime").text(checkin);
    if (designation == "1") {
        $('#p_designationid').text("Managing Director");
    } else if (designation == "2") {
        $('#p_designationid').text("General Manager");
    } else if (designation == "3") {
        $('#p_designationid').text("Team Manager");
    } else if (designation == "4") {
        $('#p_designationid').text("Marketing Executive");
    }
    if (maindivision == "1") {
        $('#p_maindivisionid').text("BTA-Infra");
    } else if (maindivision == "2") {
        $('#p_maindivisionid').text("BTB");
    } else if (maindivision == "3") {
        $('#p_maindivisionid').text("BTA");
    } else if (maindivision == "4") {
        $('#p_maindivisionid').text("BTL");
    }
    if (status == "PRESENT") {
        $('#present').show();
        $('#verylate').hide();
        $('#late').hide();
        $('#absent').hide();

    } else if (status == "LATE") {
        $('#present').hide();
        $('#verylate').hide();
        $('#late').show();
        $('#absent').hide();

    } else if (status == "TOO LATE") {
        $('#present').hide();
        $('#verylate').show();
        $('#late').hide();
        $('#absent').hide();

    } else if (status == "ABSENT") {
        $('#present').hide();
        $('#verylate').hide();
        $('#late').hide();
        $('#absent').show();
    }
}