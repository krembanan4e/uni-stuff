<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        .box{
            background-color: red;
            width: 250px;
            height: 250px;
        }
    </style>
</head>
<body>

<div class="box"></div>

<script>

    window.onload = function (){
        const box = document.getElementsByClassName("box")[0];
        let position = 0;

        //prv parametar funkcija, vtor parametar vreme vo ms
        const interval = setInterval(() => {
            position += 2; //move 2px per frame
            box.style.transform = `translateX(${position}px)`;
            if (position >= 300){ //stop at 300px
                clearInterval(interval);
            }
        }, 20) //run every 20ms
    }


</script>

</body>
</html>
