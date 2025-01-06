<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>
<body>

<div id="pieChart" style="display: inline-block; width: 500px"></div>
<div id="bubbleChart" style="display: inline-block; width: 500px"></div>

<script>
    const demographisData = [
        {
            ageRange: "18-25",
            incomeData: [
                {occupation: "Engineer", avgIncome: 50000, people: 3000},
                {occupation: "Teacher", avgIncome: 40000, people: 2000},
                {occupation: "Student", avgIncome: 10000, people: 7000}

            ]
        },
        {


            ageRange: "26-35",
            incomeData: [
                {occupation: "Engineer", avgIncome: 70000, people: 5000},
                {occupation: "Teacher", avgIncome: 50000, people: 4000},
                {occupation: "Doctor", avgIncome: 90000, people: 3000},
                {occupation: "Other", avgIncome: 30000, people: 6000}
            ]
        },
        {
            ageRange: "36-45",
            incomeData: [
                {occupation: "Engineer", avgIncome: 80000, people: 4000},
                {occupation: "Teacher", avgIncome: 55000, people: 3000},
                {occupation: "Doctor", avgIncome: 95000, people: 2000},
                {occupation: "Other", avgIncome: 40000, people: 6000}
            ]
        },
        {
            ageRange: "46-60",
            incomeData: [
                {occupation: "Engineer", avgIncome: 85000, people: 2000},
                {occupation: "Teacher", avgIncome: 60000, people: 3000},
                {occupation: "Doctor", avgIncome: 100000, people: 1000},
                {occupation: "Other", avgIncome: 35000, people: 4000}
            ]
        }
    ]

    function getPopulation(incomeData){
        let population = 0;
        incomeData.forEach((data) => {
            population += data.people;
        })
        return population;
    }

    function visualizeData(){
        demographisData.forEach((data) => {
            data.population = getPopulation(data.incomeData)
        })

        let pieData = {
            type: "pie",
            labels: demographisData.map((data) => data.ageRange),
            values: demographisData.map((data) => data.population)
        }
        let layout = {
            title: "Population distribution by age group"
        }

        Plotly.newPlot("pieChart", [pieData], layout)

        const bubbleTraces = demographisData.flatMap(group =>
        group.incomeData.map(income => ({
            x: [income.occupation],
            y: [income.avgIncome],
            mode: 'markers',
            marker: {
                size: [income.people],
                sizemode: 'area',
                sizeref: 30,
                color: income.avgIncome
            },
            name: `${income.occupation} (${group.ageRange})`
        }))
        )

        layout = {
            title: "Income Distribution by Occupation",
            xaxis: { title: "Occupation" },
            yaxis: { title: "Average Income (USD)" },
            showlegend: true
        };

        Plotly.newPlot("bubbleChart", bubbleTraces, layout);
    }

    visualizeData()

</script>

</body>
</html>
