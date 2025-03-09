<!DOCTYPE html>
        <html lang="en">
        <head>
        <meta charset="UTF-8">
        <title>Title</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>

    <style>
        #container{
            position: relative;
        }
        .card{
            width: 150px;
            height: 200px;
            position: absolute;
        }
    </style>
</head>
<body>

<div id="container"></div>

<script>
    let colors = ["green", "yellow", "red", "blue", "purple", "pink", "gray"]

    function startAnimation(){
        let animeObj = anime.timeline({ //vo toj timeline praj sho ke prajsh
            loop: "false" //ednas samo da se izvrsit
        })

        for (let i=0; i<colors.length; i++){
            animeObj
                .add({
                    targets: `.${colors[i]}-card`,
                    translateX: 180*i,
                    translateY: 300 + i*10,
                    duration: 2000
                })
        }

        for (let i=0; i<colors.length; i++){
            animeObj
                .add({
                    targets: `.${colors[i]}-card`,
                    rotate: 720,
                    borderRadius: "50%",
                    height: "150px",
                    duration: 2000,
                })
        }
    }

    window.onload = function (){
        for (let i=0; i<colors.length; i++){
            let card = document.createElement("div")
            card.className = `card ${colors[i]}-card` //prvata klasa card za gore vo style, drugata klasa so bojata za targets, klasite se oddeleni so space
            card.style.top = `${2*i}px`
            card.style.left = `${2*i}px`
            card.style.backgroundColor = colors[i]
            document.getElementById("container").appendChild(card)
        }
        setTimeout(startAnimation, 3000)
    }
</script>
</body>
</html>
