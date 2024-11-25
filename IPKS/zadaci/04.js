<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>04</title>
</head>
<body>

<h1>Generiranje buttons</h1>
<div>
    <!--    <label for="name">Ime:</label><input type="text" id="name">-->
    <!--    NE VO FORM TAG-->
    Kolku: <input type="number" id="broj">
</div>
<div>
    Kakvi: <select id="tip"><option>Radio</option><option>Checkbox</option></select>
</div>

<button onclick="generiraj()">Generiraj</button>
<div id="kontejner">

</div>

<script>
    function generiraj(){
        var mesto = document.getElementById("kontejner")
        mesto.innerHTML =""
        var broj = document.getElementById("broj")
        broj = parseInt(broj.value)
        var tip = document.getElementById("tip")
        tip = tip.value
        for (var i=1; i<=broj; i++){
            mesto.innerHTML += "<input type='" + tip + "'><span></span>"
        }
    }
</script>
</body>
</html>
