<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>

    <style>
        .red-box{
            background-color: red;
            width: 150px;
            height: 150px;
        }
        .green-box{
            background-color: green;
            width: 150px;
            height: 150px;
        }
    </style>
</head>
<body>

<div class="red-box"></div>
<div class="green-box"></div>

<script>
    window.onload = function (){
        anime.timeline ({
            loop: true
        })
            .add({
                targets: '.red-box',
                translateX: 500,
                backgroundColor: "#00ff00",
                duration: 3000
            })
            .add({
                targets: '.green-box',
                translateY: 300,
                backgroundColor: "#ff0000",
                duration: 3000
            }, '-=2500') //start 2500ms before the previous animation ends
    }
</script>

</body>
</html>
