<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        #formm{
            display: flex;
        }
        h1{
            display: flex;
            justify-content: center;
        }
        label, input{
            display: inline-block;
            width: 200px;
        }
        body div{
            margin: 10px;
        }
        #kopce {
            display: flex;
            width: 400px;
            justify-content: center;

        }
        #brojcinja div{
            display: inline-block;
            border: 1px solid black;
            border-radius: 50%;
            margin: 0px;
            padding: 10px;
            height: 10px;
            width: 10px;
        }
        .yellow{
            background-color: greenyellow;
        }
        .green{
            background-color: lightgreen;
        }
        .blue{
            background-color: lightblue;
        }
    </style>
</head>
<body>

<h1>National Lottery Game</h1>

<div id="formm">

<div>
    <h2>Assign form</h2>
    <div>
        <label for="name">Name and surname</label><input type="text" id="name">
    </div>
    <div>
        <label for="suma">Ticket amount</label><input type="text" id="suma">
    </div>
    <div>
        <label for="code">Code</label><input type="text" id="code">
    </div>
    <div>
        <label for="combination">Combination</label><input type="text" id="combination">
    </div>
    <div>
        <label for="bonus">Bonus</label><select id="bonus"><option>yes</option><option>no</option></select>
    </div>

    <div id="kopce"> <button onclick="add()">Add</button></div>

</div>

<div>
    <h2>Lucky numbers</h2>
    <div id="brojcinja">
        <div class="lucky" style="background-color: yellow" id="prv">1</div>
        <div class="lucky" style="background-color: hotpink" id="vtor">2</div>
        <div class="lucky" style="background-color: lightblue" id="tret">3</div>
        <div class="lucky" style="background-color: lightgreen" id="cetvrt">4</div>
        <div class="lucky" style="background-color: cornflowerblue" id="petti">5</div>
        <div class="lucky" style="background-color: lightgray;" id="sesti">6</div>
        <div class="lucky" style="background-color: lightyellow;" id="sedmi">7</div>
    </div>
    <button onclick="get_weekly_combination()">Get weekly combination</button>
    <p>Total win: <span id="total"></span></p>
</div>

</div>

<div id="karticki"></div>

<script>
    var total = 0
    function add() {
        var name = document.getElementById("name")
        name = name.value
        var suma = document.getElementById("suma")
        suma = suma.value
        var code = document.getElementById("code")
        code = code.value

        //proverka za kodot dali e sostaven samo od bukvi i samo od znacite ! i %
        for (var i=0; i<code.length; i++){
            if (code[i]>=0 && code[i]<=9){
                alert("Vo kodot ne smee da ima cifra!")
                return;
            }
            if (!(code[i]>='a' && code[i]<='z') && !(code[i]>='A' && code[i]<='Z')) {
                if (!(code[i] == '!' || code[i] == '%')) {
                    alert("Vo kodot ne smee da ima drugi znaci osven znacite ! ili %")
                    return;
                }
            }
        }

        //proverka dali shifrata e slobodna, a dolu kaj kartickata shifrata se redit ko id
        var proverka = document.getElementById(code)
        console.log(proverka)
        if (proverka != null){
            alert("Ne moze da se dodade, kodot vekje postoi!")
            return;
        }

        var combination = document.getElementById("combination")
        combination = combination.value
        // for (var i=0; i<combination.length; i++){
        //     if (combination[1] != ',' || combination[3] != ',' || combination[5] != ',' || combination[7] != ',' || combination[9] != ',' || combination[11] !=','){
        //         alert("Vnesete ja kombinacijata vo format x,x,x,x,x,x,x ")
        //         return;
        //     }
        // }
        var kombinacija = combination.split(",")
        kombinacija = kombinacija.join(" ")
        console.log(kombinacija)

        var bonus = document.getElementById("bonus")
        bonus = bonus.value

        if (name.length==0 || suma.length==0 || code.length==0 || combination.length==0 || bonus.length==0){
            alert("Ne se vneseni site polinja!")
            return
        }

        var mesto = document.getElementById("karticki")
        var karticka = "<div id='"+code+"' style='display:inline-block; border: 1px solid black; width: 300px' ><p>Name: "+name+"</p>" +
            "<p>Code: "+code+"</p><p>Combination: <span class='combination'>" +kombinacija+"</span></p><p>Initial amount: "+suma+"</p>" +
            "<p>Total win: <span class='total_win'>0</span></p><p class='getpaid'></p></div>"
        mesto.innerHTML += karticka
    }

    var counter = 0;
    function get_weekly_combination(){
        var prv = document.getElementById("prv")
        prv.innerHTML = Math.floor(Math.random() * 31) + 1;
        var vtor = document.getElementById("vtor")
        vtor.innerHTML = Math.floor(Math.random() * 31) + 1;
        var tret = document.getElementById("tret")
        tret.innerHTML = Math.floor(Math.random() * 31) + 1;
        var cetvrt = document.getElementById("cetvrt")
        cetvrt.innerHTML = Math.floor(Math.random() * 31) + 1;
        var petti = document.getElementById("petti")
        petti.innerHTML = Math.floor(Math.random() * 31) + 1;
        var sesti = document.getElementById("sesti")
        sesti.innerHTML = Math.floor(Math.random() * 31) + 1;
        var sedmi = document.getElementById("sedmi")
        sedmi.innerHTML = Math.floor(Math.random() * 31) + 1;

        //let randomNumber = Math.floor(Math.random() * 31) + 1;
        //console.log(randomNumber)


        var lucky_numbers = document.getElementsByClassName("lucky")
        for (var i=0; i<lucky_numbers.length; i++){
            console.log(lucky_numbers[i].innerHTML)
        }


        var kombinacii = document.getElementsByClassName("combination")
        for (var i=0; i<kombinacii.length; i++){
            counter = 0;
            var kombinacija = kombinacii[i].innerHTML.split(" ")
            console.log(kombinacija)

            for (var j=0; j<7; j++){
                for (var z=0; z<7; z++){
                    if (kombinacija[j] == lucky_numbers[z].innerHTML){
                        counter++
                    }
                }
            }

            console.log(counter)
            if (counter <= 3){
                kombinacii[i].parentNode.parentNode.className = "yellow"
            }
            if (counter >=4 && counter <= 5){
                kombinacii[i].parentNode.parentNode.className = "blue"
            }
            if (counter >= 6 && counter <= 7){
                kombinacii[i].parentNode.parentNode.className = "green"
            }
            console.log(kombinacii[i].innerHTML)
        }


        var kartickii = document.getElementsByClassName("getpaid")
        for (var i=0; i<kartickii.length; i++){
            kartickii[i].innerHTML = "<button onclick='brisi(this)'>Get paid</button>"
        }

        var total_win = document.getElementsByClassName("total_win")
        for (var i=0; i<total_win.length; i++){
            var suma = document.getElementById("suma").value
            var bonus = document.getElementById("bonus").value
            if (bonus == "yes"){
                total_win[i].innerHTML = (parseInt(suma) + counter*30 + 500)
            }
            else{
                total_win[i].innerHTML = (parseInt(suma) + counter*30)
            }
            total = total_win[i].innerHTML
            prikazi()
        }


    }

    function brisi(obj){
        var karticka = obj.parentNode.parentNode
        karticka.parentNode.removeChild(karticka)
    }

    function prikazi(){
        var ekran = document.getElementById("total")
        ekran.innerHTML = total
    }

</script>

</body>
</html>
