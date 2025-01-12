<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
    <style>
        #container{
            width: 500px;
            height: 500px;
            border: 1px solid gray;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .krug{
            position: absolute;
            width: 100px;
            height: 100px;
            display: inline-block;
        }
        #zaKrugceto{
            width: 250px;
            height: 250px;
        }
    </style>
</head>
<body>

<h1>Color Shape Animations</h1>
<div>
    Choose a color:
    <select id="selection" onchange="animiraj()">
        <option>Select color</option>
        <option>Red</option>
        <option>Yellow</option>
        <option>Blue</option>
    </select>
</div>
<div>
    <button onclick="animation.pause()">Stop animation</button>
    <button onclick="animation.restart()">Reset</button>
</div>
<div id="container">
    <div id="zaKrugceto"></div>
</div>

<script>
let animation
    function animiraj(){
        let opcija = document.getElementById("selection").value
        document.getElementById("zaKrugceto").innerHTML = ""

        if (opcija === "Red"){
            let krug = "<div class='krug' id='crveno' style='border-radius: 50%; background: red'></div>"
            document.getElementById("zaKrugceto").innerHTML += krug
            animation = anime({
                targets: '#crveno',
                keyframes: [
                    {scale: [1, 1.5], duration: 1000},
                    {scale: [1.5, 1], duration: 1000}
                ],
                loop: true,
                easing: 'easeOutQuad'
            })
        }
        else if (opcija === "Yellow"){
            let krug = "<div class='krug' id='zolto' style='border-radius: 50%; background: yellow'></div>"
            document.getElementById("zaKrugceto").innerHTML += krug
             animation = anime({
                targets: '#zolto',
                keyframes: [
                    {opacity: [1, 0], duration: 1000},
                    {opacity: [0, 1], duration: 1000}
                ],
                loop: true
            })
        }
        else{
            let krug = "<div class='krug' id='sino' style='border-radius: 50%; background: blue'></div>"
            document.getElementById("zaKrugceto").innerHTML += krug
             animation = anime({
                targets: '#sino',
                keyframes: [
                    //{translateY: -100, duration: 1000},
                    {translateY: [-100, 250], duration: 1000},
                    {translateY: [250, -100], duration: 1000},
                ],
                loop: true,
                easing: 'easeOutQuad'
            })
        }
    }
</script>

</body>
</html>
