function postAllProductDetails() {
    var productname = $('#p_productname').val();
    var productcode = $('#p_productcode').val();
    var productapplicationarea = $('#p_productapplicationarea').val();
    var productspecification = $('#p_productspecification').val();
    var productvideourl = $('#p_productvideourl').val();
    var productfileurl = $('#p_productfileurl').val();
    var maindivision = $('#p_maindivisionid').val();
    if (maindivision == "BTA-Infra") {
        var maindivisionid = "1";
    }
    else if (maindivision == "BTB") {
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
    var createdby = $('#p_createdby').val();
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();
    createdat = yyyy + '-' + mm + '-' + dd;
    localStorage.setItem('createdby2', createdby);
    localStorage.setItem('createdat2', createdat);
    var statusid = $('#p_statusid').val();
    var url = "http://localhost:8080/api/addproduct"
    $.post(url, {
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
        "modifiedat": createdat,
        "statusid": statusid
    },
        function () {
            window.location.href = "http://localhost/products.html#";
        });
}
