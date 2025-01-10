<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        #countryFlag{
            width: 250px;
            height: 150px;
            margin: 15px;
        }
    </style>
    <meta charset="UTF-8">
    <title>Petok</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
</head>
<body>
<h1>COVID-19 Data Dashboard</h1>
<div id="container">
    <button onclick="visualizeAllCountries()">View all countries</button>
    <select id="dropdown" onchange="visualizeSingleCountry()">
        <option>Select a country</option>
    </select>
    <div>
        <img src="#" alt="Country flag" id="countryFlag" onclick="transformFlag()">
    </div>
</div>
<div id="chart"></div>
<script>
    // let url = "https://disease.sh/v3/covid-19/countries"; //dadeno api samo copy paste *json niza od objekti
    // // cekori na resavanje 1. zemas podatoci. 2. kako se strukturirani podatoci(niza) kakvi objekti se i nivnite atributi // -> ova zaadaca bar chart i dva filtri.
    //
    // fetch(url)
    // .then(response => response.json())
    // .then(function(data) {
    //
    // })
    let isCircle = false;
    let countryData = []; // ja prevzemas cela niza od function
    async function fetchData() {
        let response = await fetch("https://disease.sh/v3/covid-19/countries");
        let data = await response.json();
        console.log(data);
        countryData = data;
        populateDropdown();
        visualizeAllCountries();
        hideFlag();
    }
    function populateDropdown() {
        let selectElement = document.getElementById("dropdown");
        countryData.forEach((country) => {
           let optionElement = document.createElement("option");
           optionElement.value=country.country;
           optionElement.innerHTML=country.country;
            selectElement.appendChild(optionElement);
        })
    }
    function visualizeAllCountries() {
        let countryNames = countryData.map((country) =>country.country);
        let totalCases = countryData.map((country) => country.cases);
        let recoveredCases= countryData.map((country) => country.recovered);
        let deaths = countryData.map((country) => country.deaths);
        console.log("totalCases", totalCases);
        console.log("recoveredCases", recoveredCases);
        console.log("deaths", deaths);
        var trace1 = {
            x: countryNames,
            y: totalCases,
            name: 'Total Cases',
            type: 'bar'
        };
 
        var trace2 = {
            x: countryNames,
            y: recoveredCases,
            name: 'Recovered Cases',
            type: 'bar'
        };
 
 
        var trace3 = {
            x: countryNames,
            y: deaths,
            name: 'Deaths Cases',
            type: 'bar'
        };
 
        var data = [trace1, trace2,trace3];
 
        var layout = {barmode: 'group',title:'Covid-19 cases for all countries'};
 
        Plotly.newPlot("chart", data, layout); //spored id tuka'
        hideFlag();
    }
    function visualizeSingleCountry(){
        let countryName = document.getElementById("dropdown").value;
        let countryObj = countryData.find((country) => country.country == countryName);
        var data = [
            {
                x: ['Cases', 'Recovered', 'Deaths'],
                y: [countryObj.cases,countryObj.recovered,countryObj.deaths],
                type: 'bar'
            }
        ];
 
        showFlag(countryObj.countryInfo.flag);
 
        Plotly.newPlot("chart", data);
    }
    function showFlag(imgSrc) {
        document.getElementById("countryFlag").setAttribute("src", imgSrc);
        anime({
            targets: "#countryFlag",
            traslateX: [-100,0],
            scale:[0,1],
            opacity:[0,1],
            easing:'easeOutQuad',
            duration:500
        })
    }
    function hideFlag() {
 
        anime({
            targets: "#countryFlag",
            traslateX: [0,-100],
            scale:[1,0],
            opacity:[1,0],
            easing:'easeOutQuad',
            duration:500
        })
    }
    function transformFlag() {
        isCircle = !isCircle;
        anime({
            targets: "#countryFlag",
            easing: 'easeInOutQuad',
            keyframes: [
                { scale:1.2,duration:500 },
                { scale:1,duration:500 },
                { scale:1.2,duration:500 },
                { scale:1,duration:500 },
        ],
            borderRadius: isCircle? ["50%", 0 ] : [0, "50%"],
            duration:500
        })
    }
    fetchData()
</script>
</body>
</html>
