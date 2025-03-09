<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        h1{
            display: flex;
            justify-content: center;
        }
        body div{
            margin: 10px;
        }
        label, input, select{
            display: inline-block;
            width: 200px;
        }
        .green{
            background-color: mediumseagreen;
        }
    </style>
</head>
<body>

<h1>Регистрирај лет</h1>
<div>
    <label for="ime">Име и презиме</label><input type="text" id="ime">
</div>
<div>
    <label for="oznaka">Ознака на летало</label><input type="text" id="oznaka">
</div>
<div>
    <label for="koordinati">Координати на лет</label><input type="text" id="koordinati">
</div>
<div>
    <label for="radius">Радиус на лет</label><input type="text" id="radius">
</div>
<div>
    <label for="visina">Висина на лет</label><input type="text" id="visina">
</div>
<div>
    <label for="tip">Тип на летало</label><select id="tip"><option>Едрилица</option><option>Дрон</option></select>
</div>

<button onclick="najavi()">Најави</button>
<div>Вкупно најавени летови: <span id="najaveni">0</span></div>
<ul id="letovi"></ul>

<script>
    var najaveni_letovi = 0
    function najavi(){
        var ime = document.getElementById("ime")
        ime = ime.value
        var oznaka = document.getElementById("oznaka")
        oznaka = oznaka.value

        if (!oznaka.startsWith("Z3-UNR-") || oznaka.length > 11){
            alert("Vnesete oznaka vo format Z3-UNR-xxxx")
            return;
        }
        for (var i = 7; i<oznaka.length; i++){
            if (!(oznaka[i]>=0 && oznaka[i]<=9)){
                alert("Vnesete oznaka vo format Z3-UNR-xxxx (kade xxxx se 4 brojki!)")
                return;
            }
        }

        var koordinati = document.getElementById("koordinati")
        koordinati = koordinati.value
        var radius = document.getElementById("radius")
        radius = radius.value

        var brojcinja = oznaka.substring(7, 11)
        console.log(brojcinja)

        if (!(brojcinja=="1111" || brojcinja=="2222" || brojcinja=="3333" || brojcinja=="4444" || brojcinja=="5555" || brojcinja=="6666" || brojcinja=="7777" || brojcinja=="8888" || brojcinja=="9999")){
            if (radius > 500){
                alert("Ne mozhe da se najavi, bidejki radiusot e pogolem od 500 metri!")
                return;
            }
        }

        var visina = document.getElementById("visina")
        visina = visina.value

        if (!(brojcinja=="1111" || brojcinja=="2222" || brojcinja=="3333" || brojcinja=="4444" || brojcinja=="5555" || brojcinja=="6666" || brojcinja=="7777" || brojcinja=="8888" || brojcinja=="9999")) {
            if (visina > 150) {
                alert("Ne mozhe da se najavi, bidejki visinata e pogolema od 150 metri!")
                return;
            }
        }

        var tip = document.getElementById("tip")
        tip = tip.value

        if (ime.length==0 || oznaka.length==0 || koordinati.length==0 || radius.length==0 || visina.length==0 || tip.length==0){
            alert("Ne se vneseni site polinja")
            return
        }


        var mesto = document.getElementById("letovi")

        //stavi border aku e edrilica, ili aku e dron (ama visinata da e ista so radiusot)
        if (tip=="Едрилица" || (tip=="Дрон" && visina==radius)){
            var karticka = "<li><div style='display: inline-block; width: 300px; border: 1px solid black'><p>"+ime+","+oznaka+"</p><p>Радиус: "+radius+","+"Висина: "+visina+"</p><p>"+tip+"</p><p><button onclick='potvrdi(this)'>Потврди</button><button onclick='otkazi(this)'>Откажи</button></p></div></li>"
        }
        //inaku kartickata da e bez border
        else{
            var karticka = "<li><div style='display: inline-block; width: 300px;'><p>"+ime+","+oznaka+"</p><p>Радиус: "+radius+","+"Висина: "+visina+"</p><p>"+tip+"</p><p><button onclick='potvrdi(this)'>Потврди</button><button onclick='otkazi(this)'>Откажи</button></p></div></li>"
        }

        mesto.innerHTML += karticka
        najaveni_letovi += 1
        prikazi_najaveni_letovi()

    }

    function potvrdi(obj){
        var karticka = obj.parentNode.parentNode
        karticka.className = "green"
    }

    function otkazi(obj){
        var karticka = obj.parentNode.parentNode.parentNode
        karticka.parentNode.removeChild(karticka)
        najaveni_letovi -= 1
        prikazi_najaveni_letovi()
    }

    function prikazi_najaveni_letovi(){
        var letovi_na_ekran = document.getElementById("najaveni")
        letovi_na_ekran.innerHTML = najaveni_letovi
    }


</script>

</body>
</html>
