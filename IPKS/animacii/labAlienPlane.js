<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #plane{
            position: absolute;
        }
        #alien{
            position: absolute;
            display: none;
        }
    </style>
</head>
<body>

<button onclick="up()">Up</button>
<button onclick="down()">Down</button>
<button onclick="shoot()">Shoot</button>

<div id="plane">
    <img src="plane.png" height="70" width="100"/>
</div>
<div id="alien">
    <img src="alien.png" height="90" width="70"/>
</div>

<script>
    let plane = document.getElementById("plane")
    let planePozY = 0;

    let alien = document.getElementById("alien")
    let alienPozX = Math.random()*300
    let alienPozY = Math.random()*300
    alien.style.top = `${alienPozX}px`
    alien.style.left = `${alienPozY}px`
    alien.style.display = "block"
    function up(){
        let plane = document.getElementById("plane")
        planePozY -= 40
        plane.style.top = `${planePozY}px`
    }
    function down(){
        let plane = document.getElementById("plane")
        planePozY += 40
        plane.style.top = `${planePozY}px`
    }
    function shoot(){
        let bullet = document.createElement("div")
        bullet.style.width = "30px"
        bullet.style.height = "3px"
        bullet.style.backgroundColor = "red"
        bullet.style.position = "absolute"
        bullet.style.left = `100px`
        bullet.style.top = `30px`
        plane.appendChild(bullet)

        let bulletPozX = 0;

        let bulletInterval = setInterval(() => {
            bulletPozX += 2
            bullet.style.transform = `translateX(${bulletPozX}px)`

            // ova so +90 e visinata na slikata so alien i +70 e visinata na slikata so plane
             if (planePozY < alienPozY + 90 && planePozY + 70 > alienPozY){
                alien.style.display = "none"
                document.removeChild(bullet)
                clearInterval(bulletInterval)
            }

            if (bulletPozX >= 1920){
                plane.removeChild(bullet)
                clearInterval(bulletInterval)
            }
        })
    }
</script>

</body>
</html>
