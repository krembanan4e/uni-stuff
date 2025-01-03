<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #container {
            border: 1px solid black;
            width: 1000px;
            height: 1000px;
        }
        #container div{
            border: 1px solid black;
            display: inline-block;
            position: absolute;
        }
    </style>
</head>
<body>

<div id="container"></div>

<script>
    
    /*
    Ova vo webhook tamu vo Edit gore, kaj Content type: application/json, i selektiraj Add CORS headers
    [{"color":"red", "width":"70px", "height":"90px", "top":"400", "left":"260"}, 
    {"color":"green", "width":"120px", "height":"140px", "top":"180", "left":"190"},
    {"color":"blue", "width":"200px", "height":"60px", "top":"710", "left":"210"}, 
    {"color":"yellow", "width":"80px", "height":"100px", "top":"140", "left":"400"},
    {"color":"pink", "width":"100px", "height":"400px", "top":"540", "left":"800"},
    {"color":"purple", "width":"200px", "height":"100px", "top":"640", "left":"400"}]
     */

    fetch("https://webhook.site/dabf6af4-8bd1-42c4-8b07-439fa6e33515")
        .then(response => response.json())
        .then(function (data) {
            for (let i=0; i<data.length; i++){
                let karticka = "<div style='background-color: "+data[i].color+"; width: "+data[i].width+"; height: "+data[i].height+"; top: "+data[i].top+"px; left: "+data[i].left+"px'></div>"
                let container = document.getElementById("container")
                container.innerHTML += karticka
            }
        })


</script>

</body>
</html>
