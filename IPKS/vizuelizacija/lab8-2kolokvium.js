<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <style>
        table{
            border-collapse: collapse;
        }
        th, td{
            border: 1px solid black;
        }
    </style>
</head>
<body>

<div>City: <input type="text" id="city"></div>
<div>Temperature: <input type="text" id="temp"></div>
<div>Day of Month: <input type="text" id="day"></div>
<button onclick="add()">Add Record</button>
 
<table id="tabela">
    <tr><th>City</th><th>Temp</th><th>Day</th></tr>
</table>
<button onclick="showChart()">Show Line Chart</button>
<div id="chart"></div>

<script>
    let podatoci = []
    let gradovi = []
    function add(){
        let city = document.getElementById("city").value
        let temp = document.getElementById("temp").value
        let day = document.getElementById("day").value

        let redica = "<tr><td>"+city+"</td><td>"+temp+"</td><td>"+day+"</td></tr>"
        document.getElementById("tabela").innerHTML += redica

        let merenje = {
            city: city,
            temp: temp,
            day: day
        }

        podatoci.push(merenje)
        console.log(merenje)
    }

    let traces = []
    function showChart(){
        gradovi = new Set(podatoci.map(merenje => merenje.city))
        console.log(gradovi)

        gradovi.forEach(grad => {
            console.log(grad)
            let days = podatoci.filter(podatok => podatok.city === grad).map(podatok => podatok.day)
            let temp = podatoci.filter(podatok => podatok.city === grad).map(podatok => podatok.temp)
            console.log(temp)

            let trace = {
                x: days,
                y: temp,
                type: 'scatter',
                name: grad
            }
            traces.push(trace)
        })
        Plotly.newPlot('chart', traces);

    }

</script>
</body>
</html>
