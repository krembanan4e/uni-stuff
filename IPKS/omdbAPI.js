<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div>
    Movie title:<input type="text" id="movie_title"> <button onclick="getData()">Get movie data</button>
</div>
<h2 id="title"></h2>
<p id="actors"></p>
<p id="plot"></p>
<img src="" id="poster">

<script>
    function getData() {
        let movie_title = document.getElementById("movie_title")
        movie_title = movie_title.value

        //http://www.omdbapi.com/?apikey=[yourkey]&      ----> [yourkey]
        //                                                         ^                                                         
        let url = "https://www.omdbapi.com/?i=tt3896198&apikey=3c03cfbd&t="+movie_title
        fetch(url)
            .then(response => response.json())
            .then(function (data) {
                document.getElementById("title").innerHTML = data.Title
                document.getElementById("actors").innerHTML = data.Actors
                document.getElementById("plot").innerHTML = data.Plot
                document.getElementById("poster").setAttribute("src", data.Poster)
            })
    }

</script>

</body>
</html>
