<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #forma, #lucky_numbers{
            display: inline-block;
            width: 300px;
            vertical-align: top;
        }
        #cards > div{
            display: inline-block;
            border: 1px solid black;
            width: 300px;
        }
        .krug{
            display: inline-block;
            border: 1px solid black;
            border-radius: 100%;
            padding: 5px;
            margin-right: 5px;
        }
    </style>
</head>
<body>

<h1>Lottery game</h1>
<div id="forma">
    <h2>Form:</h2>
    <div>
        Name: <input type="text" id="name">
    </div>
    <div>
        Amount: <input type="text" id="amount">
    </div>
    <div>
        Code: <input type="text" id="code">
    </div>
    <div>
        Combination: <input type="text" id="combination">
    </div>
    <div>
        Bonus: <select id="bonus"><option>yes</option><option>no</option></select>
    </div>
    <button onclick="submit()">Add</button>
</div>
<div id="lucky_numbers">
    <h2>Weekly combination</h2>
    <div id="win_com"></div>
    <button onclick="get_comb()">Get weekly combination</button>
    <p>Total: <span id="total_win"></span></p>
</div>
<div id="cards">

</div>


<script>
    var number_cards = 0
    function submit() {
        var name = document.getElementById("name")
        name = name.value
        var amount = document.getElementById("amount")
        amount = amount.value
        var code = document.getElementById("code")
        code = code.value
        var comb = document.getElementById("combination")
        comb = comb.value
        var bonus = document.getElementById("bonus")
        bonus = bonus.value

        if (name.length==0 || amount.length==0 || code.length==0 || comb.length==0){
            alert("NE se vneseni site polinja")
            return
        }

        var card = document.getElementById(code)
        if (card != null){
            alert("Kodot vekje postoi!")
            return;
        }

        for (var i=0; i<10; i++){
            if (code.indexOf(i)!=-1){ //najde brojka na nekoja pozicija
                alert("Nevalidne kod")
                return;
            }
        }

        if (code.indexOf("!")!=-1 || code.indexOf("%")!=-1){
            alert("Nevaliden kod")
            return;
        }

        comb = comb.split(",")
        var combination_str = ""
        for (var i=0; i<7; i++){
            combination_str += "<p class='krug'>"+comb[i]+"</p>"
        }
        var new_card = "<div class='karticka' title='"+bonus+"' id='"+code+"'><p>Name: "+name+"</p><p>Code: "+code+"</p><div>Combination: "+combination_str+"</div><p class='amount'>Amount: "+amount+"</p><p>Total win: <span class='win'></span></p></div>"
        var cards = document.getElementById("cards")
        cards.innerHTML += new_card
        number_cards += 1

    }

    function get_comb() {
        if (number_cards < 5){
            return
        }

        var combination_str = ""
        for (var i=0; i<7; i++){
            var broj = parseInt(Math.random()*31+1)
            combination_str += "<p class='krug'>"+broj+"</p>"
        }
        var win_comb = document.getElementById("win_com")
        win_comb.innerHTML += combination_str

        check_combinations()
    }
    
    function check_combinations() {
        var win_comb = document.getElementById("win_com")
        win_comb = win_comb.getElementsByClassName("krug")

        var cards = document.getElementById("cards")
        cards = cards.getElementsByClassName("karticka")

        for (var i=0; i<5; i++){
            var card_comb = cards[i].getElementsByClassName("krug")
            var dobitni =0
            for (var j=0; j<7; j++){
                for (var k=0; k<7; k++){
                    if (win_comb[j].innerHTML == card_comb[k].innerHTML){
                        dobitni+=1
                    }
                }
            }
            if (dobitni<=3){
                cards[i].style.background = "yellow"
            }
            else if(dobitni<=5){
                cards[i].style.background = "blue"
            }
            else{
                cards[i].style.background = "green"
            }
            var bonus = cards[i].getAttribute("title")
            var card_total_win = dobitni*30
            if (bonus == "yes"){
                card_total_win += 500
            }
            var uplata = cards[i].getElementsByClassName("amount")[0].innerHTML.split(":")[1]
            card_total_win += parseInt(uplata)
            cards[i].getElementsByClassName("win")[0].innerHTML = card_total_win
            cards[i].innerHTML += "<button onclick='remove(this)'>Sold</button>"

        }
    }

    function remove(obj){
        var element = obj.parentNode
        element.remove()
    }
    
</script>

</body>
</html>
