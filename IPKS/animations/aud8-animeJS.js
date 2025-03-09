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
            scale: [1, 1.5], //scale up to 1.5 times the original size
            translateX: 300,
            translateY: 400,
            backgroundColor: '#000000',
            duration: 8000,
            easing: 'easeInOutSine'
        })

    }
</script>

</body>
</html>
