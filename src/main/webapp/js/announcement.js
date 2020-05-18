function postAnnouncements() {
    $('#savedraft').click(function () {
        var announcementtitle = $('#p_announcementtitle').val();
        console.log(announcementtitle);
        var announcementbody = $('#p_announcementbody').val();
        console.log(announcementbody);

        var today = new Date();
        var day = today.getDate();
        var month = (today.getMonth() + 1);
        var year = today.getFullYear();
        if (day < 10) {
            day = '0' + day;
        }

        if (month < 10) {
            month = '0' + month;
        }
        var createdat = year + "-" + month + "-" + day;
        var createdby = "Jithin";
        var Draft = "Draft";
        var url = "http://localhost:8080/api/addnewannouncement"
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                "announcementtitle": announcementtitle,
                "announcementbody": announcementbody,
                "createdby": createdby,
                "createdat": createdat,
                "announcementstatus": Draft

            },
            success: function (response) {
                getDraft()
                $("#draftDiv").load(location.href + " #draftDiv");
                $("#p_announcementtitle").load(location.href + " #p_announcementtitle");
                $("#p_announcementbody").load(location.href + " #p_announcementbody");
            }
        });
    });
    $('#publish').click(function () {
        var announcementtitle = $('#p_announcementtitle').val();
        console.log(announcementtitle);
        var announcementbody = $('#p_announcementbody').val();
        console.log(announcementbody);

        var today = new Date();
        var day = today.getDate();
        var month = (today.getMonth() + 1);
        var year = today.getFullYear();
        if (day < 10) {
            day = '0' + day;
        }

        if (month < 10) {
            month = '0' + month;
        }
        var createdat = year + "-" + month + "-" + day;
        var createdby = "Jithin";
        var Post = "Post";
        var url = "http://localhost:8080/api/addnewannouncement"
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                "announcementtitle": announcementtitle,
                "announcementbody": announcementbody,
                "createdby": createdby,
                "createdat": createdat,
                "announcementstatus": Post

            },
            success: function (response) {
                getAnnouncement();
                $("#draftDiv").load(location.href + " #draftDiv");
                $("#p_announcementtitle").load(location.href + " #p_announcementtitle");
                $("#p_announcementbody").load(location.href + " #p_announcementbody");
            }
        });
    });

}

function getDraft() {
    var url = "http://localhost:8080/api/announcementbystatus"
    $.ajax({
        url: url,
        type: 'GET',
        data: {
            "announcementstatus": "Draft"
        },
        success: function (data) {
            $.each(data, function (key, value) {
                var announcementtitle = value.announcementtitle;
                var announcementbody = value.announcementbody;
                var createdby = value.createdby;
                var createdatdate = value.createdat;
                populateDraftDiv(announcementtitle, announcementbody, createdby, createdatdate)
            })
        }
    });
}

function getAnnouncements() {
    var url = "http://localhost:8080/api/announcementbystatus"
    $.ajax({
        url: url,
        type: 'GET',
        data: {
            "announcementstatus": "Post"
        },
        success: function (data) {
            $.each(data, function (key, value) {
                var announcementtitle = value.announcementtitle;
                var announcementbody = value.announcementbody;
                var createdby = value.createdby;
                var createdatdate = value.createdat;
                populateAnnouncementDiv(announcementtitle, announcementbody, createdby, createdatdate)
            })
        }
    });
}

function populateAnnouncementDiv(announcementtitle, announcementbody, createdby, createdatdate) {
    var d = new Date(createdatdate);
    var day = d.getDay();
    var month = d.getMonth();
    var year = d.getFullYear();
    if (day < 10) {
        day = '0' + day;
    }

    if (month < 10) {
        month = '0' + month;
    }
    var createdat = day + "-" + month + "-" + year;
    var announcementcard = '<div class="card card-small mb-3"> <div class="card-body border-accent"><h6><strong class="border-bottom">Title: ' + announcementtitle + '</strong></h6> <div class="row"><span class="ml-3 mt-0"><strong>' + createdat + ',' + createdby + '</strong></span></div> <div class="row mt-1"> <h4 class="ml-3">' + announcementtitle + '</h4> </div> <div class="row"> <h6 class="ml-3">' + announcementbody + '<span class="justify-content-end"><strong></strong></span></h6> </div> </div> </div>'
    $("#announcementhistory1").append(announcementcard);
}

function populateDraftDiv(announcementtitle, announcementbody, createdby, createdatdate) {
    var d = new Date(createdatdate);
    var day = d.getDay();
    var month = d.getMonth();
    var year = d.getFullYear();
    if (day < 10) {
        day = '0' + day;
    }

    if (month < 10) {
        month = '0' + month;
    }
    var createdat = day + "-" + month + "-" + year;
    var draftcard = '<div class="card card-small mb-3"><div class="card-body><div class="blog-comments__item d-flex p-2"><div class="blog-comments__content p-2"> <div class="blog-comments__meta text-muted ml-2"> <a class="text-secondary" href="#">' + announcementtitle + '</a><span class="ml-1">Created on: ' + createdat + '</span></div> <p class="m-0 my-1 ml-2 mb-2 text-muted">' + announcementbody + ',<span class="ml-1">Author: <strong>' + createdby + '</strong></span></p> <div class="blog-comments__actions"> <div class="btn-group btn-group-sm ml-2"> <button type="button" class="btn btn-white"> <span class="text-success"><i class="material-icons">edit</i></span> Edit </button> <button type="button" class="btn btn-white"> <span class="text-danger"><i class="material-icons">clear</i></span> Delete</button> <button type="button" class="btn btn-white"> <span class="text-warning"><i class="material-icons">remove_red_eye </i></span> View</button> </div> </div> </div> </div> </div> </div>'
    $("#draftDiv").append(draftcard);
}