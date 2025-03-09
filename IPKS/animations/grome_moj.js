<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sreda</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <style>
        /*
        ova na webhook

        [
        {"id":"1", "dir": "vertical", "width": "87px", "height":"43px", "score": 52, "left":50, "top":180, "color":"red"},
        {"id":"2", "dir": "horizontal", "width": "112px", "height":"48px", "score": 2, "left":140, "top":250, "color":"green"},
        {"id":"3", "dir": "vertical", "width": "47px", "height":"97px", "score": 37, "left":560, "top":380, "color":"blue"},
        {"id":"4", "dir": "vertical", "width": "71px", "height":"71px", "score": 150, "left":450, "top":350, "color":"yellow"},
        {"id":"5", "dir": "horizontal", "width": "76px", "height":"95px", "score": 24, "left":650, "top":15, "color":"purple"},
        {"id":"6", "dir": "vertical", "width": "100px", "height":"132px", "score": 73, "left": 200, "top":70, "color":"pink"}
        ]

         */

        /* display,border,absolute */
        .pravoagolniche{
            display: inline-block;
            position: absolute;
            border: 1px solid black;
        }
        #container{
            width: 800px;
            height: 600px;
            border: 2px solid black;
            position: relative;
            display: inline-block;
        }
        p{
            vertical-align: top;
            display: inline-block;
        }
        .gromchich{
            position: absolute;
            width: 3px;
            height: 600px;
            background: black;
        }
    </style>
</head>
<body>

<div id="container"></div>
<p>Score: <span id="score"></span></p>

<script>
    var rectangle_num = 0
    let url = "https://webhook.site/9645202b-7529-4aa5-8711-e9c2f0c8b678";
    fetch(url)
        .then(response => response.json())
        .then(function (data) {
            rectangle_num = data.length;
            for (let i = 0; i < data.length; i++) {
                //dodaj id i score
                let pr = "<div score='"+data[i].score+"' id='"+data[i].id+"' dir='"+data[i].dir+"' current='"+(i%2)+"' class='pravoagolniche' style='width: "+data[i].width+"; height: "+data[i].height+"; background-color: "+data[i].color+"; left: "+data[i].left+"px; top: "+data[i].top+"px'></div>"
                document.getElementById("container").innerHTML += pr;
            }

            start_moving()
        })

    var counter = 0

    function start_moving(){
        counter ++
        for (let i = 1; i <= rectangle_num; i++) {
            var obj = document.getElementById(i)
            if (obj.getAttribute("dir") == "vertical"){ //0 nagore 1 nadolu
                //var current_top = obj.style.top.replace("px", "")
                var current_top = parseInt(obj.style.top.split("px")[0]) //deka vrakjat pr 52px za da ja zejme samo brojkata bez px
                if (obj.getAttribute("current") == 0){
                    current_top -= 10
                    if (current_top <= 0){
                        obj.setAttribute("current", 1)
                    }
                }
                else{
                    var height = parseInt(obj.style.height.split("px")[0])

                    current_top += 10
                    if (current_top+height >= 600){ //600 visinata od container
                        obj.setAttribute("current", 0)
                    }

                }
                obj.style.top = current_top + "px"
            }

            else{
                var current_left = parseInt(obj.style.left.split("px")[0]) //deka vrakjat pr 52px za da ja zejme samo brojkata bez px
                if (obj.getAttribute("current") == 0){ //nalevo
                    current_left -= 10
                    if (current_left <= 0){
                        obj.setAttribute("current", 1)
                    }
                }
                else{ //nadesno ako current = 1
                    var width = parseInt(obj.style.width.split("px")[0])

                    current_left += 10
                    if (current_left+width >= 800){ //800 shirinata od container
                        obj.setAttribute("current", 0)
                    }
                }
                obj.style.left = current_left + "px"
            }
        }

        if (counter < 50){
            setTimeout(start_moving,30)
        }
        else{
            counter=0
            grome_moj()
        }

    }

    var score = 0
    var grom_counter = 1

    function grome_moj(){
        grom_counter += 1
        var grom_pos = parseInt(Math.random() * 800)
        var gromche = "<div class='gromchich' style='left: "+grom_pos+"px'></div>"
        document.getElementById("container").innerHTML += gromche
        for (var i=1; i<=rectangle_num; i++) {
            var obj = document.getElementById(i)
            var start_obj = parseInt(obj.style.left.split("px")[0]) //deka vrakjat pr 52px za da ja zejme samo brojkata bez px
            var end_obj = parseInt(obj.style.left.split("px")[0]) + parseInt(obj.style.width.split("px")[0])
            if (start_obj <= grom_pos && end_obj >= grom_pos){
                score += parseInt(obj.getAttribute("score"))
                obj.style.display = "none"
                obj.setAttribute("score", 0)
            }
        }

        document.getElementById("score").innerHTML = score
        if (grom_counter <= 3){
            setTimeout(clear_grom, 900)
            setTimeout(start_moving,1000)
        }

    }

    function clear_grom() {
        var groms = document.getElementsByClassName("gromchich")
        for (var i = 0; i < groms.length; i++) {
            groms[i].style.display = "none"
        }
    }

</script>

</body>
</html>
