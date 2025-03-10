<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
    <style>
        #countryImage{
            width: 250px;
            height: 150px;
            margin: 15px;
        }
    </style>
</head>
<body>

<h1>COVID-19 Data Dashboard</h1>
<div>
    <button onclick="viewAllCountries()">View all countries</button>
    <select id="selectCountry" onchange="viewSingleCountry()" ><option>Select one country</option></select>
</div>
<img src="#" alt="Country Image" id="countryImage" onclick="changeShape()">

<div id="chart"></div>

<script>
    let countryData = []
    let isCircle = false

    let url = "https://disease.sh/v3/covid-19/countries"
    fetch(url)
    .then(response => response.json())
    .then(function (data) {
        console.log(data)
        countryData = data

        countryData.forEach(country => {
            let option = "<option>"+country.country+"</option>"
            document.getElementById("selectCountry").innerHTML += option
        })

        viewAllCountries()
    })

    function viewAllCountries(){
        let countryNames = countryData.map(country => country.country)
        let totalCases = countryData.map(country => country.cases)
        let recoveredCases = countryData.map(country => country.recovered)
        let deathCases = countryData.map(country => country.deaths)

        var trace1 = {
            x: countryNames,
            y: totalCases,
            name: 'total cases',
            type: 'bar'
        };

        var trace2 = {
            x: countryNames,
            y: recoveredCases,
            name: 'recovered cases',
            type: 'bar'
        };

        var trace3 = {
            x: countryNames,
            y: deathCases,
            name: 'death cases',
            type: 'bar'
        };

        var data = [trace1, trace2, trace3];
        var layout = {barmode: 'group', title: 'COVID-19 Data for all countries'};
        Plotly.newPlot('chart', data, layout);

        hideImage()
    }

    function viewSingleCountry(){
        let countryName = document.getElementById("selectCountry").value
        let countryObj = countryData.find(country => country.country === countryName)
        let totalCases = countryObj.cases
        let recoveredCases = countryObj.recovered
        let deathCases = countryObj.deaths

        var data = [
            {
                x: ['totalCases', 'recoveredCases', 'deathCases'],
                y: [totalCases, recoveredCases, deathCases],
                type: 'bar'
            }
        ];

        var layout = {title: 'COVID-19 Data for ' + countryName};
        Plotly.newPlot('chart', data, layout);

        showImage()
    }

    function showImage(){
        let countryName = document.getElementById("selectCountry").value
        let countryObj = countryData.find(country => country.country === countryName)
        let imgSrc = countryObj.countryInfo.flag
        //console.log(imgSrc)
        document.getElementById("countryImage").setAttribute("src", imgSrc)

        anime({
            targets: "#countryImage",
            translateX: [-100, 0],
            scale: [0, 1],
            opacity: [0, 1],
            duration: 500
        })
    }

    function hideImage(){
        document.getElementById("countryImage").setAttribute("src", "#")
    }

    function changeShape(){
        isCircle = !isCircle

        if (isCircle){
            anime({
                targets: "#countryImage",
                borderRadius: [0, "50%"],
                scale: [0,1],
                duration: 500
            })
        }
        else {
            anime({
                targets: "#countryImage",
                borderRadius: ["50%", 0],
                scale: [0,1],
                duration: 500
            })
        }
    }


</script>
</body>
</html>
