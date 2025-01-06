<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>
<body>

<h1>NBA Player Stats Comparison</h1>
<select id="positionSelect" onchange="updateVisualization()">
    <option value="All">All positions</option>
    <option value="Guard">Guards</option>
    <option value="Center">Centers</option>
    <option value="Forward">Forwards</option>
</select>
<div id="container" style="width: 1000px; height: 700px"></div>

<script>
    const nbaData = [
        // Team 1
        {
            team: "Lakers",
            players: [
                {name: "LeBron James", position: "Forward", ppg: 27.1, rpg: 7.4},
                {name: "Anthony Davis", position: "Forward", ppg: 24.0, rpg: 9.1},
                {name: "Russell Westbrook", position: "Guard", ppg: 19.5, rpg: 7.4},
                {name: "Dennis Schroder", position: "Guard", ppg: 12.4, rpg: 3.1},
                {name: "Dwight Howard", position: "Center", ppg: 7.4, rpg: 8.3}
            ]
        },
        // Team 2
        {
            team: "Warriors",
            players: [
                {name: "Stephen Curry", position: "Guard", ppg: 29.3, rpg: 5.4},
                {name: "Klay Thompson", position: "Guard", ppg: 20.4, rpg: 3.6},
                {name: "Draymond Green", position: "Forward", ppg: 8.4, rpg: 7.3},
                {name: "Andrew Wiggins", position: "Forward", ppg: 17.2, rpg: 4.5},
                {name: "Kevon Looney", position: "Center", ppg: 6.1, rpg: 7.5}
            ]
        }
    ];

    function updateVisualization(){
        let position = document.getElementById("positionSelect").value

        let filteredData = nbaData.map(team => ({
            team: team.team,
            players: team.players.filter(player => position === "All" || player.position === position)
        }))

        const lakersPlayers = filteredData.find(team => team.team === "Lakers").players
        const warriorsPlayers = filteredData.find(team => team.team === "Warriors").players

        const lakersTrace = {
            x: lakersPlayers.map(player => player.ppg),
            y: lakersPlayers.map(player => player.name),
            name: "Lakers",
            type: "bar",
            orientation: "h",
            marker: {color: "purple"}
        }

        const warriorsTrace = {
            x: warriorsPlayers.map(player => player.ppg),
            y: warriorsPlayers.map(player => player.name),
            name: "Warriors",
            type: "bar",
            orientation: "h",
            marker: {color: "gold"}
        }

        const layout = {
            title: "NBA Player Stats Comparison",
            barmode: "stack",
            xaxis: { title: "Points Per Game (PPG)" },
            yaxis: { title: "Players", automargin: true },
            height: 700,
            legend: { orientation: "h" }
        }

        Plotly.newPlot("container", [lakersTrace, warriorsTrace], layout)
    }

    updateVisualization();

</script>

</body>
</html>
