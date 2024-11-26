
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vlatko chestitkiiii</title>
    <style>
        td,th{
            border: 1px solid black;
        }
        table{
            border-collapse: collapse;
        }
    </style>
</head>
<body>

<h1>Forma za registracija na proekti</h1>
<div>
    <!--    <label for="name">Ime:</label><input type="text" id="name">-->
    <!--    NE VO FORM TAG-->
    Avtor: <input type="text" id="name">
</div>
<div>
    Shirina: <input type="number" id="shirina"> px
</div>
<div>
    Visina: <input type="number" id="visina"> px
</div>
<div>
    Boja: <select id="boicka"><option>red</option><option>pink</option></select>
</div>

<button onclick="submit()">Isprati</button>
<p>Total cost: <span id="total">0</span></p>
<div id="kontejner"></div>


<script>
    var total_cost = 0
    function submit(){
        var name = document.getElementById("name")
        name = name.value
        name = name.replaceAll("!", "")
        for (var i =0; i<10; i++){
            name = name.replaceAll(i, "")
        }
        var shirina= document.getElementById("shirina")
        shirina = shirina.value
        var visina= document.getElementById("visina")
        visina = visina.value
        var boicka= document.getElementById("boicka")
        boicka = boicka.value

        console.log(name)
        console.log(shirina)
        console.log(visina)
        console.log(boicka)


        if (name.length==0 || shirina.length==0 || visina.length==0){
            alert("Podatocite ne se vneseni")
            return
        }

        // ako pomine dodavanjeto

        var karticka = document.getElementById(name)
        if (karticka != null){
            karticka.style.width = shirina
            karticka.style.height = visina
            return;
        }
        // total_cost += parseInt(cena)
        // prikazi_cena()

        var mesto = document.getElementById("kontejner")
        var kartichka = "<div id='"+name+"' style='display: inline-block; width: "+shirina+"px ;height: "+visina+"px; background-color: "+boicka+"' ></div>"
        mesto.innerHTML += kartichka
    }

    // function prikazi_cena(){
    //     var cena_ekran = document.getElementById("total")
    //     cena_ekran.innerHTML = total_cost
    // }
    //
    // function brisi(obj){
    //     // prvoto td vtoroto tr
    //     var redica = obj.parentNode.parentNode
    //     var cena_redica = redica.classList.value
    //     total_cost -= cena_redica
    //     prikazi_cena()
    //     redica.parentNode.removeChild(redica)
    //
    // }

</script>
</body>
</html>
