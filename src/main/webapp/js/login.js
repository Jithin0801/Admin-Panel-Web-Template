function getCredentials() {
    $('#loginbutton').click(function () {
        var usernameinput = $('#username').val();
        var passwordinput = $('#password').val();
        var url = 'http://localhost:8080/api/checkcredentials'
        $.ajax({
            type: "GET",
            url: url,
            data: {
                "email": usernameinput,
                "password": passwordinput
            },
            success: function (data) {
                if (data == "") {
                    $('#deleteAlertBox').show('fade');
                } else {
                    var id = data[0].id;
                    var emailid = data[0].adminmailid;
                    var sessionkey = data[0].sessionid
                    createSession(id, emailid, sessionkey)
                    window.location.href = 'home.html';
                }
            }
        })
    });
}

function createSession(id, emailid, sessionkey) {
    $.cookie("emailid", emailid);
    $.cookie("sessionkey", sessionkey)
}

function dismissDeleteAlert() {
    $('#deleteAlertBox').hide('fade');
}