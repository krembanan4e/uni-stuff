<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
    <style>

        /*
        ova na webhook
         */
        /*[{"color":"red","dir":"vertical", "width":"70px", "height":"90px", "top":"400", "left":"260"},*/
        /*{"color":"green", "dir":"horizontal", "width":"120px", "height":"140px", "top":"180", "left":"190"},*/
        /*{"color":"blue", "dir":"vertical", "width":"200px", "height":"60px", "top":"710", "left":"210"},*/
        /*{"color":"yellow", "dir":"vertical", "width":"80px", "height":"100px", "top":"140", "left":"400"},*/
        /*{"color":"pink","dir":"horizontal", "width":"100px", "height":"400px", "top":"540", "left":"800"},*/
        /*{"color":"purple","dir":"vertical", "width":"200px", "height":"100px", "top":"640", "left":"400"}]*/
        /*
        Дадени се податоци во форма на JSON стринг за кој се претпоставува дека секогаш го има истиот формат. 
        Податоците се низа од објекти кои ги претставуваат правоаголниците/квадратите кои се движат вертикално 
        и хоризонтално низ правоаголна форма со големина од 800x600 пиксели. 
        Секој објект содржи висина и ширина на правоаголникот, поени кои ги добива корисникот, 
        информации дали правоаголникот се движи вертикално или хоризонтално и негова почетна позиција. 
        Играта се одвива на следниот начин: Според JSON објектот, правоаголниците се креираат, 
        се обојуваат во боја по случаен избор и се прикажуваат во полето за игра(20). 
        Потоа, почнуваат да се движат хоризонтално или вертикално зависно од карактеристиката за насока ("dir")(20). 
        После одредено време на движење, на екранот се појавува вертикална линија која има за цел да ги уништи правоаголниците(10). 
        Сите правоаголници кои ќе се најдат на патот на линијата се уништуваат, а корисникот добива онолку поени колку што носи уништениот правоаголник. 
        Поените се прикажуваат во горниот десен агол (20). Оваа постапка се повторува 3 пати, односно линијата се појавува 3 пати на позиција по случаен избор, 
        од одреден временски интервал. Играта завршува по 3-тото појавување на линијата (10).
        */
        
        #container{
            width: 1000px;
            height: 1000px;
            border: 1px solid black;
            position: relative;
        }
        #container div{
            border: 1px solid black;
            position: absolute;
            display: inline-block;
        }
        
    </style>
</head>
<body>

<div id="container"></div>

<script>
    function func() {
        let url = "https://webhook.site/9645202b-7529-4aa5-8711-e9c2f0c8b678"
        fetch(url)
            .then(response => response.json())
            .then(function (data) {

                const containerWidth = 1000
                const containerHeight = 1000

                for (let i=0; i<data.length; i++){
                    let card = document.createElement("div")
                    card.style.width = data[i].width
                    card.style.height = data[i].height
                    card.style.top = data[i].top + "px"
                    card.style.left = data[i].left + "px"
                    card.style.backgroundColor = data[i].color
                    card.className = 'card-'+i

                    document.getElementById("container").appendChild(card)

                    const cardWidth = parseInt(data[i].width.replace('px', ''))
                    const cardHeight = parseInt(data[i].height.replace('px', ''))

                    const delay = Math.random() * 1000

                    if (data[i].dir === "horizontal"){
                        anime({
                            targets: `.card-${i}`,
                            translateX: [
                                {value: -(data[i].left), duration: 3000},
                                {value: containerWidth - data[i].left - cardWidth, duration: 3000}
                            ],
                            easing: 'easeInOutQuad',
                            direction: 'alternate',
                            loop: true,
                            delay: delay
                        })
                    }

                    else if (data[i].dir === "vertical"){
                        anime({
                            targets: `.card-${i}`,
                            translateY: [
                                {value: -(data[i].top), duration: 3000},
                                {value: containerHeight - data[i].top - cardHeight, duration: 3000}
                            ],
                            easing: 'easeInOutQuad',
                            direction: 'alternate',
                            loop: true,
                            delay: delay
                        })
                    }

                }
            })
    }

    func()
</script>

</body>
</html>
