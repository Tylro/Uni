function showLeftMenu() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            xmlDoc = xhttp.responseXML;

            htmlOptions = "";
            menuoptions = xmlDoc.getElementsByTagName("Name");
            for (i = 0; i < menuoptions.length; i++) {
                htmlOptions += "<li><a href='"
                        + xmlDoc.getElementsByTagName("Link")[i].firstChild.nodeValue + "'>"
                        + xmlDoc.getElementsByTagName("Name")[i].firstChild.nodeValue + "</a></li>";
            }

            document.getElementById("ulLeftMenu").innerHTML = htmlOptions;
        }
    };

    xhttp.open("GET", "data/leftmenu.xml", true);
    xhttp.send();
}




