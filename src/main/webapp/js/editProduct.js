function editProduct() {
    var id = localStorage.getItem('id2');
    var url = "http://localhost:8080/api/productbyid";
    $.ajax({
        type: "GET",
        url: url,
        data: {
            "id": id
        },
        success: function (data) {
            var productname = data[0].productname;
            var productcode = data[0].productcode;
            var productapplicationarea = data[0].productapplicationarea;
            var productspecification = data[0].productspecification;
            var productvideourl = data[0].productvideourl;
            var productfileurl = data[0].productfileurl;
            var maindivision = data[0].maindivisionid;
            var division = data[0].divisionid;
            var category = data[0].categoryid;
            var createdby = data[0].createdby;
            localStorage.setItem("createdby2", createdby);
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
            localStorage.setItem('createdat2', createdat);
            var statusid = data[0].statusid;
            localStorage.setItem("statusid2", statusid);
            $('#p_productname').val(productname);
            $('#p_productcode').val(productcode);
            $('#p_productapplicationarea').val(productapplicationarea);
            $('#p_productspecification').val(productspecification);
            $('#p_productvideourl').val(productvideourl);
            $('#p_productfileurl').val(productfileurl);
            if (maindivision == "1") {
                $('#p_maindivisionid').val("BTA-Infra");
            }
            else if (maindivision == "2") {
                $('#p_maindivisionid').val("BTB");
            }
            else if (maindivision == "3") {
                $('#p_maindivisionid').val("BTA");
            }
            else if (maindivision == "4") {
                $('#p_maindivisionid').val("BTL");
            }
            if (division == "1") {
                $('#p_divisionid').val("Automobile Division");
            }
            else if (division == "2") {
                $('#p_divisionid').val("Infrastructure");
            }
            else if (division == "3") {
                $('#p_divisionid').val("Battery");
            }
            else if (division == "4") {
                $('#p_divisionid').val("Environmental Division");
            }
            else if (division == "5") {
                $('#p_divisionid').val("General Industry");
            }
            else if (division == "6") {
                $('#p_divisionid').val("Textile Industry");
            }
            if (category == "1") {
                $('#p_categoryid').val("Oil")
            } else if (category == "2") {
                $('#p_categoryid').val("Battery")
            }
        }
    });
    $("#updatebutton").click(function () {
        var productname = $('#p_productname').val();
        var productcode = $('#p_productcode').val();
        var productapplicationarea = $('#p_productapplicationarea').val();
        var productspecification = $('#p_productspecification').val();
        var productvideourl = $('#p_productvideourl').val();
        var productfileurl = $('#p_productfileurl').val();
        var maindivision = $('#p_maindivisionid').val();
        if (maindivision == "BTA-Infra") {
            var maindivisionid = "1";
        } else if (maindivision == "BTB") {
            var maindivisionid = "2";
        }
        else if (maindivision == "BTA") {
            var maindivisionid = "3";
        }
        else if (maindivision == "BTL") {
            var maindivisionid = "4";
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
        var category = $('#p_categoryid').val();
        if (category == "Oil") {
            var categoryid = "1";
        }
        else if (category == "Battery") {
            var categoryid = "2";
        }
        var createdby = localStorage.getItem('createdby2');
        var createdat = localStorage.getItem('createdat2')
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0');
        var yyyy = today.getFullYear();
        var modifiedat = yyyy + '-' + mm + '-' + dd;
        var statusid = localStorage.getItem('statusid1');
        var url = "http://localhost:8080/api/modifyproduct"
        $.ajax({
            url: url,
            type: 'PUT',
            data: {
                "id": id,
                "productname": productname,
                "productcode": productcode,
                "productapplicationarea": productapplicationarea,
                "productspecification": productspecification,
                "productvideourl": productvideourl,
                "productfileurl": productfileurl,
                "maindivisionid": maindivisionid,
                "divisionid": divisionid,
                "categoryid": categoryid,
                "createdby": createdby,
                "createdat": createdat,
                "modifiedby": createdby,
                "modifiedat": modifiedat,
                "statusid": statusid
            },
            success: function (response) {
                window.location.href = 'http://localhost/products.html###';
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
                    var url = "http://localhost:8080/api/deleteproduct";
                    $.ajax({
                        type: "DELETE",
                        url: url,
                        data: {
                            "id": id
                        },
                        success: function () {
                            window.location.href = 'http://localhost/products.html##';
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
