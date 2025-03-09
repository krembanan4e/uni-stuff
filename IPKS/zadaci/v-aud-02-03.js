<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>02</title>
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
    Proekt: <input type="text" id="proekt">
</div>
<div>
    Cena: <input type="number" id="cena">
</div>

<button onclick="submit()">Isprati</button>
<p>Total cost: <span id="total">0</span></p>

<table id="tabela">
    <tr>
        <th>Avtor</th>
        <th>Proekt</th>
        <th>Cena</th>
        <th>Akcii</th>
    </tr>
</table>

<script>
    var total_cost = 0
    function submit(){
        var name = document.getElementById("name")
        name = name.value
        var proekt= document.getElementById("proekt")
        proekt = proekt.value
        var cena= document.getElementById("cena")
        cena = cena.value

        // console.log(name)
        // console.log(proekt)
        // console.log(cena)

        if (name.length==0 || proekt.length==0 || cena.length==0){
            alert("Podatocite ne se vneseni")
            return
        }

        // ako pomine dodavanjeto
        total_cost += parseInt(cena)
        prikazi_cena()

        var tabela = document.getElementById("tabela")
        var redica = "<tr class='"+cena+"'><td>"+name+"</td><td>"+proekt+"</td><td>"+cena+"</td><td><button onclick='brisi(this)'>Remove</button></td></tr>"
        tabela.innerHTML += redica
    }

    function prikazi_cena(){
        var cena_ekran = document.getElementById("total")
        cena_ekran.innerHTML = total_cost
    }

    function brisi(obj){
        // prvoto td vtoroto tr
        var redica = obj.parentNode.parentNode
        var cena_redica = redica.classList.value
        //var cena_redica = redica.getAttribute("class")
        total_cost -= cena_redica
        prikazi_cena()
        redica.parentNode.removeChild(redica)

    }

</script>
</body>
</html>
