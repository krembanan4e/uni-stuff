<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>01</title>
    <style>

    </style>
</head>
<body>

<h1>Forma za registracija</h1>
<div>
<!--    <label for="name">Ime:</label><input type="text" id="name">-->
<!--    NE VO FORM TAG-->
    Ime: <input type="text" id="name">
</div>
<div>
    Prezime: <input type="text" id="prezime">
</div>
<div>
    Email: <input type="text" id="email">
</div>
<div>
    Vorzrast:
    <select id="age">
        <option>18</option>
        <option>19</option>
        <option>20</option>
        <option>21</option>
    </select>

</div>
<button onclick="submit()">Isprati</button>

<script>
    function submit(){
        var name = document.getElementById("name")
        name = name.value
        var surname = document.getElementById("prezime")
        surname = surname.value
        var email= document.getElementById("email")
        email = email.value
        var age = document.getElementById("age")
        age = age.value

        if (name.length==0 || surname.length==0 || email.length==0 || age.length==0){
            alert("Podatocite ne se vneseni")
        }
        else{
            alert("Podatocite se vneseni uspeshno")
        }
    }
</script>
</body>
</html>
