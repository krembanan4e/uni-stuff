<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        p, h1{
            display: flex;
            justify-content: center;
        }
        label, input, select{
            display: inline-block;
            width: 200px;
        }
        body div{
            margin: 10px;
        }
    </style>
</head>
<body>

<h1>User cards</h1>
<div>
    <label for="name">Username: </label><input type="text" id="name">
</div>
<div>
    <label for="width">Width: </label><input type="text" id="width"> px
</div>
<div>
    <label for="height">Height: </label><input type="text" id="height"> px
</div>
<div>
    <label for="cardID">Card ID: </label><input type="text" id="cardID">
</div>
<div>
    <label for="color">Color: </label><select id="color"><option>red</option><option>green</option><option>blue</option><option>yellow</option></select>
</div>

<button onclick="kreiraj()">Create</button>
<div>Total value of sold cards: <span id="total" style="font-weight: bold">0</span></div>
<div id="kontejner"></div>


<script>
    var total_cost = 0

    function kreiraj(){
        var name = document.getElementById("name")
        name = name.value
        var width = document.getElementById("width")
        width = width.value

        if (width < 0)
        {
            alert("Vnesete pozitiven broj za shirina, i ne pogolem od 350px!")
            return;
        }
        if (width > 350)
        {
            alert("Shirinata ne smee da bide pogolema od 350px!")
            return;
        }

        var height = document.getElementById("height")
        height = height.value

        if (height < 0)
        {
            alert("Vnesete pozitiven broj za visina, i ne pogolem od 350px!")
            return;
        }
        if (height > 350)
        {
            alert("Visinata ne smee da bide pogolema od 350px!")
            return;
        }

        var cardID = document.getElementById("cardID")
        cardID = cardID.value

        var golemaBukva = false;
        var brojka = false;
        for (var  i=0; i<cardID.length; i++){
            if (cardID[i] > 'A' && cardID[i] < 'Z'){
                golemaBukva = true;
            }
            if (cardID[i] >= 0 && cardID[i] <= 9){
                brojka = true;
            }
        }
        if (golemaBukva){
            alert("Ne smee da ima golema bukva vo card ID!")
            return;
        }
        if (brojka){
            alert("Vo card ID ne smee da ima brojki!")
        }

        var color = document.getElementById("color")
        color = color.value

        if (name.length==0 || width.length==0 || height.length==0 || cardID.length==0 || color.length==0){
            alert("Ne se vneseni site polinja!")
            return
        }

        var prethodna_karticka = document.getElementById(name)
        if (prethodna_karticka != null){
            prethodna_karticka.style.height = height
            prethodna_karticka.style.width = width
            return;
        }

        var value = Math.floor(parseFloat(height) * parseFloat(width) * 0.5)
        if (color == "green"){
            value += 1000
        }
        total_cost += parseInt(value)
        prikazi()

        var mesto = document.getElementById("kontejner")

        //cenata na kartickata ja redime vo class za posle ko ke trebit da se izbrisit cenata od vkupnata cena da mojt da se zemit preku classList.value

        var karticka = "<div class='"+value+"' style='height: "+height+"px; width: "+width+"px; background-color: "+color+"; display: inline-block; margin-right: 10px'>" +
            "<p>ID: "+cardID+"</p><p>Width: "+width+"</p><p>Height: "+height+"</p><p>Value: "+value+"</p><p><button onclick='prodaj(this)'>Sell</button></p></div>"

        mesto.innerHTML += karticka


    }

    function prodaj(obj){
        var karticka = obj.parentNode.parentNode
        var cena_karticka = karticka.classList.value
        total_cost -= cena_karticka
        prikazi()
        karticka.parentNode.removeChild(karticka)
    }

    function prikazi(){
        var cena_ekran = document.getElementById("total")
        cena_ekran.innerHTML = total_cost
    }

</script>

</body>
</html>
