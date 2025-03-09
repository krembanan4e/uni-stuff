<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>

    <style>
        .box{
            background-color: red;
            width: 150px;
            height: 150px;
        }
    </style>
</head>
<body>

<div class="box"></div>

<script>
    window.onload = function (){
        anime({
            targets: '.box',
            keyframes: [
                { translateX: 500, backgroundColor: "#d3ce6d", duration: 1000 },
                { translateY: 500, backgroundColor: "#6d91d3", duration: 1000 },
                { translateX: 0, translateY: 0, backgroundColor: "#red", duration: 1000 },
            ],
            //easing: 'easeInOutQuad', //smooth transitions
            loop: true //repeat the animation indefinitely
        })

    }
</script>

</body>
</html>
