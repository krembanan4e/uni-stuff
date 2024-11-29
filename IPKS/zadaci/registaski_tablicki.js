<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        h1{
            text-align: center;
        }
        body > div{
            margin: 10px;
        }
        label, #soobr{
            display: inline-block;
            width: 200px;
        }

    </style>
</head>
<body>

<h1>Осигурување на возила</h1>
<div>
    <label for="ime">Име: </label><input type="text" id="ime">
</div>
<div>
    <label for="prezime">Презиме: </label><input type="text" id="prezime">
</div>
<div>
    <label for="tablicka">Регистарска табличка: </label><input type="text" id="tablicka">
</div>
<div>
    <label for="godini">Години на старост: </label><input type="text" id="godini">
</div>
<div>
    <span id="soobr">Сообраќајна незгода:</span>
    <input type="radio" name="soobr" value="da">Да
    <input type="radio" name="soobr" value="ne">Не
</div>
<div>
    <button onclick="generiraj()">Генерирај сметка</button>
</div>

<div>
    <h2>Сметки</h2>
    <p>Вкупно сметки за плаќање: <span id="smetki" style="font-weight: bold">0</span></p>
</div>

<div id="karticki"></div>

<script>
    var vkupnoSmetki = 0
    function generiraj(){
        var ime = document.getElementById("ime")
        ime = ime.value
        var prezime = document.getElementById("prezime")
        prezime = prezime.value
        var tablicka = document.getElementById("tablicka")
        tablicka = tablicka.value
        var godini = document.getElementById("godini")
        godini = godini.value

        // console.log(ime)
        // console.log(prezime)
        // console.log(tablicka)
        // console.log(godini)

        if (ime.length==0 || prezime.length==0 || tablicka.length==0 || godini.length==0){
            alert("Popolni gi site polinja!")
            return;
        }

        var soobrakjajka = document.getElementsByName("soobr")
        var nezgoda
        if (!soobrakjajka[0].checked&&!soobrakjajka[1].checked){
            alert("Selektiraj edna opcija!")
            return
        }
        if (soobrakjajka[0].checked){
            nezgoda = soobrakjajka[0].value
        }
        else if(soobrakjajka[1].checked){
            nezgoda = soobrakjajka[1].value
        }
        //console.log(nezgoda)

        //tablicka = AB-1234-QW
        if (tablicka.length!=10){
            alert("Vnesi tablicka vo format AB-1234-QW")
            return;
        }
        var proverka = tablicka.split("-")
        //proverka = AB,1234,QW
        //proverka za AB
        if ((proverka[0][0]<'A' || proverka[0][0]>'Z') && (proverka[0][1]<'A' || proverka[0][1]>'Z')){
            alert("Vnesi tablicka vo format AB-1234-QW")
            return;
        }
        //proverka za QW
        if ((proverka[2][0]<'A' || proverka[2][0]>'Z') && (proverka[2][1]<'A' || proverka[2][1]>'Z')){
            alert("Vnesi tablicka vo format AB-1234-QW")
            return;
        }
        //proverka za 1234 dali imat nekoja bukva vo brojkive
        var num
        if (!proverka[1].split("").every(num=>(!isNaN(parseInt(num))))){
            alert("Vnesi tablicka vo format AB-1234-QW, da nema bukvi vo sredniot del")
            return;
        }

        var zlatna_flag = false
        var zlatna = 0

        if (proverka[1][0]===proverka[1][1] && proverka[1][1]===proverka[1][2] && proverka[1][2]===proverka[1][3]){
            zlatna_flag = true
            zlatna = 1000;
        }

        var zbor = ""
        if (nezgoda == "da"){
            zbor += "Има"
        }
        else if (nezgoda == "ne"){
            zbor += "Нема"
        }

        var boja
        if (godini > 30){
            boja = "red"
        }
        else{
            boja = "green"
        }

        var cena = 0
        if (zlatna_flag){
            cena = 4000
        }
        else{
            cena = 3000
        }


        var karticka = "<div style='border: 1px solid black; width: 300px; background-color: "+boja+"; display: inline-block; margin: 10px'>" +
            "<p style='text-align: center'>"+ime+" "+prezime+"</p>" +
            "<p style='text-align: center'>"+tablicka+"</p>" +
            "<p style='text-align: center'>Сообраќајки: "+zbor+"</p>" +
            "<p style='text-align: center'>Старост на возилото: "+godini+"</p>" +
            "<p style='text-align: center'>За плаќање: <span id='za_plakjanje'>"+cena+"</span></p>" +
            "<p  style='text-align: center' id='kopcinja'><button onclick='plati()'>Плати</button><button onclick='izbrisi(this)'>Избриши</button></p>" +
            "</div>"


        var mesto = document.getElementById("karticki")
        mesto.innerHTML += karticka
        vkupnoSmetki++
        kolkuSmetki()
    }

    function plati(){
        var nov = "<p><button disabled onclick='plati()'>Плати</button><button disabled onclick='izbrisi(this)'>Избриши</button></p>"
        document.getElementById("kopcinja").innerHTML = nov
    }
    function izbrisi(obj){
        var karticka = obj.parentNode.parentNode
        vkupnoSmetki--
        kolkuSmetki()
        karticka.parentNode.removeChild(karticka)
    }
    function kolkuSmetki(){
        var kolku = document.getElementById("smetki")
        kolku.innerHTML = vkupnoSmetki
    }


</script>

</body>
</html>
