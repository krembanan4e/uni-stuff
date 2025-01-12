<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
    <style>
        /*

        na webhook:

        [
        {
            "team": "Lakers",
            "players": [
                {"name": "LeBron James", "position": "Forward", "ppg": 27.1, "rpg": 7.4},
                {"name": "Anthony Davis", "position": "Forward", "ppg": 24.0, "rpg": 9.1},
                {"name": "Russell Westbrook", "position": "Guard", "ppg": 19.5, "rpg": 7.4},
                {"name": "Dennis Schroder", "position": "Guard", "ppg": 12.4, "rpg": 3.1},
                {"name": "Dwight Howard", "position": "Center", "ppg": 7.4, "rpg": 8.3}
            ]
        },

        {
            "team": "Warriors",
            "players": [
                {"name": "Stephen Curry", "position": "Guard", "ppg": 29.3, "rpg": 5.4},
                {"name": "Klay Thompson", "position": "Guard", "ppg": 20.4, "rpg": 3.6},
                {"name": "Draymond Green", "position": "Forward", "ppg": 8.4, "rpg": 7.3},
                {"name": "Andrew Wiggins", "position": "Forward", "ppg": 17.2, "rpg": 4.5},
                {"name": "Kevon Looney", "position": "Center", "ppg": 6.1, "rpg": 7.5}
            ]
        }
    ]
         */

        #chart{
            width: 1500px;
            height: 800px;
        }
    </style>
</head>
<body>

<select id="selection" onchange="prikaziEden()">
    <option>All positions</option>
    <option>Guard</option>
    <option>Forward</option>
    <option>Center</option>
</select>
<div id="chart"></div>

<script>
    let podatoci = []
    let url = "https://webhook.site/40c40604-e75f-4ff1-93cf-9ba7c967925a"
    fetch(url)
        .then(response => response.json())
        .then(function (data) {
            console.log(data)
            podatoci = data
            prikaziGiSite()
        })

    let lakers = []
    let warriors = []

    let lakersPlayers = []
    let warriorsPlayers = []

    let lakersPPG = []
    let warriorsPPG = []

    function prikaziGiSite() {
        lakers = podatoci.filter(podatok => podatok.team === "Lakers")
        warriors = podatoci.filter(podatok => podatok.team === "Warriors")
        //console.log(lakers[0])

        lakersPlayers = lakers[0].players.map(player => player.name)
        warriorsPlayers = warriors[0].players.map(player => player.name)
        //console.log(lakersPlayers)

        lakersPPG = lakers[0].players.map(player => player.ppg)
        warriorsPPG = warriors[0].players.map(player => player.ppg)
        //console.log(lakersPPG)

        var dataL =
            {
                x: lakersPPG,
                y: lakersPlayers,
                type: 'bar',
                name: "Lakers",
                orientation: 'h',
                marker:{color: "purple"}
            }


        var dataW =
            {
                x: warriorsPPG,
                y: warriorsPlayers,
                type: 'bar',
                name: "Warriors",
                orientation: 'h',
                marker:{color: "yellow"}
            }


        let traces = [dataL, dataW]
        let layout = {title: "All positions"}
        Plotly.newPlot('chart', traces, layout);
    }

    function prikaziEden(){
        let opcija = document.getElementById("selection").value

        if (opcija === "All positions"){
            prikaziGiSite()
            return
        }

        let lakersPosition = lakers[0].players.filter(player => player.position === opcija).map(player => player.name)
        let warriorsPosition = warriors[0].players.filter(player => player.position === opcija).map(player => player.name)
        console.log(lakersPosition)

        var dataL =
            {
                x: lakersPPG,
                y: lakersPosition,
                type: 'bar',
                name: "Lakers",
                orientation: 'h',
                marker:{color: "purple"}
            }


        var dataW =
            {
                x: warriorsPPG,
                y: warriorsPosition,
                type: 'bar',
                name: "Warriors",
                orientation: 'h',
                marker:{color: "yellow"}
            }


        let traces = [dataL, dataW]
        let layout = {title: opcija+"s"}
        Plotly.newPlot('chart', traces, layout);

    }

</script>

</body>
</html>
