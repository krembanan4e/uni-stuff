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
        .circle{
            background-color: red;
            width: 100px;
            height: 100px;
            border-radius: 50%;
            top: 100px;
            position: absolute;
        }
        .circle:nth-child(2){  /*deka se spoeni site edno nad drugo*/
            top: 300px;
        }
        .circle:nth-child(3){
            top: 500px;
        }
    </style>
</head>
<body>

<div id="container">
    <div class="circle"></div>
    <div class="circle"></div>
    <div class="circle"></div>
</div>

<script>
    function moveAndScaleCircles(){
        let circles = document.getElementsByClassName("circle")
        for (let i=0; i<circles.length; i++){
            let leftPosition = 0
            let scale = 1

            let interval = setInterval(() => {
                leftPosition += 5
                scale += 0.01

                circles[i].style.left = `${leftPosition}px`
                circles[i].style.transform = `scale(${scale})`

                if (leftPosition >= 400){
                    clearInterval(interval)
                }
            }, 30) //na 50ms
        }
    }
    function moveAndScaleCirclesWithAnimeJS(){
        anime({
            targets: '.circle',
            translateX: 400,
            scale: 1.5,
            durarion: 3000,
            easing: 'easeInOutQuad',
            delay: anime.stagger(500)
        })
    }
    window.onload = function (){
        moveAndScaleCircles()
        //moveAndScaleCirclesWithAnimeJS()
    }
</script>
</body>
</html>
