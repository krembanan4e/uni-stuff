<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
    <style>
        /*
        ova na webhook
        
        [{"background-color":"red", "width":"100px", "height":"100px"}, 
        {"background-color":"green", "width":"50px", "height":"100px"}, 
        {"background-color":"blue", "width":"100px", "height":"50px"}]
         */
    </style>
</head>
<body>

<div>
    <button onclick="nalevo()"><</button><button onclick="nadesno()">></button>
</div>
<div id="container"></div>

<script>
    let podatoci = []
    let url = "https://webhook.site/bc5dd310-74c6-448c-bde5-db5edfef60b7"
    fetch(url)
    .then(response => response.json())
    .then(function (data) {
        console.log(data)
        podatoci = data
        kreirajKocki()
    })

    let kockaID = -1

    function kreirajKocki(){
        podatoci.forEach(podatok => {
            kockaID++
            let kocka = "<div id='"+kockaID+"' style='display: inline-block; position:absolute; top: 50px; left: -200px; width: "+podatok.width+"; height: "+podatok.height+"; background-color: "+podatok["background-color"]+"'></div>"
            document.getElementById("container").innerHTML += kocka
            console.log(kocka)
        })

    }

    let targetKocka = 0

    function nadesno(){
        let kocka = document.getElementById(targetKocka)
        console.log(kocka)

        if (targetKocka === 2){
            targetKocka = -1
        }

        let kocka2 = document.getElementById(targetKocka+1)
        console.log(kocka2)

        anime({
            targets: kocka,
            translateX: [200, 2200],
            duration: 4000,
            easing: 'easeOutQuad'
        })

        anime({
            targets: kocka2,
            translateX: [0, 200],
            duration: 6000,
            easing: 'easeOutQuad'
        })

        targetKocka++
    }

    function nalevo(){
        let kocka = document.getElementById(targetKocka)
        console.log(kocka)

        if (targetKocka === 0){
            targetKocka = 3
        }

        let kocka2 = document.getElementById(targetKocka-1)
        console.log(kocka2)

        anime({
            targets: kocka2,
            translateX: [2200, 200],
            duration: 4000,
            easing: 'easeOutQuad'
        })

        anime({
            targets: kocka,
            translateX: [200, 0],
            duration: 6000,
            easing: 'easeOutQuad'
        })

        targetKocka--
    }

</script>
</body>
</html>
