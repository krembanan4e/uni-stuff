<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        h1 {
            text-align: center;
        }
        #lotteryGame {
            display: flex;
        }
        #lotteryGame > div {
            margin-right: 50px;
        }
        #lotteryGame > div > div {
            margin: 10px;
        }
        label, input {
            display: inline-block;
            width: 200px;
        }
        .card {
            display: inline-block;
            border: 1px solid black;
            margin: 10px;
            padding: 10px;
        }
        ul {
            list-style-type: none;
            display: flex;
            flex-direction: row;
        }
        li {
            border: 1px solid black;
            border-radius: 50%;
            padding: 6px 5px 5px 9px;
            margin-right: 3px;
            display: inline-block;
            width: 17px;
        }
    </style>
</head>
<body>

<h1>National Lottery Game</h1>
<div id="lotteryGame">

    <div>
        <h2>Assign form</h2>
        <div>
            <label for="name">Name and surname: </label><input type="text" id="name">
        </div>
        <div>
            <label for="amount">Ticket amount: </label><input type="text" id="amount">
        </div>
        <div>
            <label for="code">Code: </label><input type="text" id="code">
        </div>
        <div>
            <label for="combination">Combination: (7 numbers)</label><input type="text" id="combination"
                                                                            placeholder="for example: 1,2,3,4,5,6,7">
        </div>
        <div>
            <label for="bonus">Bonus: </label><select id="bonus">
            <option>yes</option>
            <option>no</option>
        </select>
        </div>
        <button onclick="add()">Add</button>
    </div>

    <div>
        <h2>Lucky numbers</h2>
        <p id="luckyNumbers">Weekly numbers: Not Generated</p>
        <button id="weeklyCombination" disabled onclick="getWeeklyCombination()">Get weekly combination</button>
        <p>Total win: <span id="total">0</span></p>
    </div>
</div>
<div id="mestoZaKarticki"></div>

<script>
    var kartickiCounter = 0
    var weeklyCombination = []
    var vkupnoPogodoci = 0
    var totalWin = 0
    var uplatena_suma = 0

    function add() {
        var name = document.getElementById("name").value
        var amount = document.getElementById("amount").value
        uplatena_suma = amount
        var code = document.getElementById("code").value
        var combination = document.getElementById("combination").value.split(",").map(Number)
        var bonus = document.getElementById("bonus").value
        var unclickableButton = document.getElementById("weeklyCombination")

        //proverka za kodot dali e sostaven samo od bukvi i samo od znacite ! i %
        for (var i = 0; i < code.length; i++) {
            if (code[i] >= 0 && code[i] <= 9) {
                alert("Vo kodot ne smee da ima cifra!")
                return;
            }
            if (!(code[i] >= 'a' && code[i] <= 'z') && !(code[i] >= 'A' && code[i] <= 'Z')) {
                if (!(code[i] == '!' || code[i] == '%')) {
                    alert("Vo kodot ne smee da ima drugi znaci osven znacite ! ili %")
                    return;
                }
            }
        }

        //proverka za dali shifrata e slobodna ili e vekje zafatena
        var proverka = document.getElementById(code)
        if (proverka != null) {
            alert("Ne mozhe da se dodade bidejki ovoj kod vekje postoi!")
            return;
        }

        //proverka za dali se vneseni site polinja
        if (name.length == 0 || amount.length == 0 || code.length == 0 || combination.length == 0 || bonus.length == 0) {
            alert("Ne se vneseni site polinja!")
            return
        }

        //napraj ja kombinacijata vo ul lista za da ja dodajs na kartickata posle
        var ul = document.createElement("ul")
        for (var i = 0; i < combination.length; i++) {
            var li = document.createElement("li")
            li.innerHTML = combination[i]
            ul.appendChild(li)
        }

        //napraj karticka, dodaj ja i zgolemi go counter-ot za karticki
        var karticka = "<div id='" + code + "' class='card'><p>Name: " + name + "</p><p>Code: " + code + "</p>" +
            "<p>Combination: " + ul.outerHTML + "</p><p>Initial amount: "+amount+"</p>" +
            "</p><button id='kartickaButton' onclick='getPaid(this)'>Get paid</button></div>"

        var mesto = document.getElementById("mestoZaKarticki")
        mesto.innerHTML += karticka
        kartickiCounter++

        //ako se vneseni 5 karticki, otlkuci go button-ot za weekly combination
        if (kartickiCounter === 5) {
            unclickableButton.disabled = false
        }
    }

    //funkcija za brisenje karticka i update na totalWin rezultatot, vo zavisnost od brojot na pogodoci na kartickata
    function getPaid(obj) {
        var rezultat = uplatena_suma * vkupnoPogodoci * 30
        var bonus = document.getElementById("bonus").value
        if (bonus == "yes") {
            rezultat += 500
        }
        totalWin += rezultat
        var karticka = obj.parentNode
        karticka.parentNode.removeChild(karticka)
        prikaziTotalWin()
    }

    //funkcija za generiranje na 7-te random brojki
    function getWeeklyCombination() {
        weeklyCombination = []
        while (weeklyCombination.length < 7) {
            var num = Math.floor(Math.random() * 31) + 1
            if (!weeklyCombination.includes(num)) { //za da nemat duplikati vo weekly kombinacijata
                weeklyCombination.push(num)
            }
        }
        weeklyCombination.sort((a, b) => (a - b))

        //napraj ul lista so weekly combination brojcinjata
        var ul = document.createElement("ul")
        for (var i = 0; i < weeklyCombination.length; i++) {
            var li = document.createElement("li")
            li.innerHTML = weeklyCombination[i]
            //za random boja na pozadina na luckyu numbers
            li.style.backgroundColor = `rgb(${Math.floor(Math.random() * 256)}, ${Math.floor(Math.random() * 256)}, ${Math.floor(Math.random() * 256)})`
            ul.appendChild(li)
        }

        //dodaj gi weekly combination brojcinjata pod Lucky numbers:
        var mestoZaLuckyNumbers = document.getElementById("luckyNumbers")
        mestoZaLuckyNumbers.innerHTML = ul.outerHTML

        updateTickets()
    }

    //funkcija za menvenje pozadina na kartickite vo zavisnost od brojot na pogodoci
    function updateTickets() {
        var karticki = document.getElementsByClassName("card")
        for (var karticka of karticki) {
            var pogodoci = 0
            var kombinacija = karticka.getElementsByTagName("li")
            for (var brojce of kombinacija) {
                if (weeklyCombination.includes(parseInt(brojce.innerHTML))) {
                    pogodoci++
                }
            }
            if (pogodoci <= 3) {
                karticka.style.backgroundColor = "lightyellow"
            } else if (pogodoci >= 4 && pogodoci <= 5) {
                karticka.style.backgroundColor = "lightblue"
            } else if (pogodoci >= 6 && pogodoci <= 7) {
                karticka.style.backgroundColor = "lightgreen"
            }
            vkupnoPogodoci += pogodoci
        }
    }

    function prikaziTotalWin() {
        document.getElementById("total").innerHTML = totalWin
    }

</script>
</body>
</html>
