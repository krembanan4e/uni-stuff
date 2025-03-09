<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        h1{
            display: flex;
            justify-content: center;
        }
        th, td{
            border: 1px solid black;
        }
        table{
            border-collapse: collapse;
        }
        .green{
            background-color: mediumseagreen;
        }
        .blue{
            background-color: cornflowerblue;
        }
        .grey{
            background-color: lightgray;
        }
        body div{
            margin: 10px;
        }
        label{
            display: inline-block;
            margin-right: 20px;
            width: 200px;
        }
        input, select{
            width: 300px;
        }
        span{
            font-weight: bold;
        }
    </style>
</head>
<body>

<h1>Online classes</h1>

<div>
    <label for="name">Name and surname</label><input type="text" id="name">
</div>
<div>
    <label for="email">Email</label><input type="text" id="email">
</div>
<div>
    <label for="age">Age</label><input type="text" id="age">
</div>
<div>
    <label for="username">Username</label><input type="text" id="username">
</div>
<div>
    <label for="password">Password</label><input type="text" id="password">
</div>
<div>
    <label for="role">Role</label><select id="role"><option>teacher</option><option>student</option></select>
</div>

<button onclick="add()">Add</button>
<div>Available teachers: <span id="available">0</span></div>

<h2>Users</h2>
<table id="tabela">
    <tr><th>Name</th><th>Username</th><th>Email</th><th>Age</th><th>Role</th><th>Actions</th></tr>
</table>


<script>
    var available = 0;
    function add(){
        var name = document.getElementById("name")
        name = name.value
        var email = document.getElementById("email")
        email = email.value
        var age = document.getElementById("age")
        age = age.value
        var username = document.getElementById("username")
        username = username.value
        var password = document.getElementById("password")
        password = password.value

        var daliBukva = false
        var daliBrojka = false
        if (password.length < 10){
            alert("Vnesete podolg password!")
        }
        //plus proverka za bukva i brojka
        for (var i = 0; i<password.length; i++){
            if (parseInt(password[i])>=0 && parseInt(password[i])<=9){
                daliBrojka = true
            }
            if (password[i] >= 'A' && password[i] <= 'Z'){
                daliBukva = true
            }
        }
        
        if (daliBrojka==false && daliBukva==false){
            alert("Vnesete barem edna brojka i barem edna golema bukva vo password-ot!")
            return;
        }
        if (daliBrojka == false){
            alert("Vnesete barem edna brojka vo password-ot")
            return;
        }
        if (daliBukva == false){
            alert("Vnesete barem edna golema bukva vo password-ot!")
            return;
        }


        var role = document.getElementById("role")
        role = role.value

        if (age<18 && role=="teacher"){
            alert("Ne mozhe da se dodade ovoj role na korisnik pomlad od 18 godini!")
            return;
        }

        if (name.length==0 || email.length==0 || age.length==0 || username.length==0 || password.length==0 || role.length==0){
            alert("Ne se vneseni site polinja!")
            return
        }

        var proverka = document.getElementById(username)
        if (proverka != null){
            alert("Ova korisnichko ime e vekje iskoristeno")
            return;
        }

        var mesto = document.getElementById("tabela")

        var boja = "green"
        if (role == "student"){
            boja = "blue"
        }

        if (role == "teacher"){
            var redica = "<tr class='"+boja+"'><td>"+name+"</td><td>"+username+"</td><td>"+email+"</td><td>"+age+"</td><td>"+role+"</td><td><button onclick='hire(this)'>Hire</button></td></tr>"
            available += 1
        }
        else{
            var redica = "<tr class='"+boja+"'><td>"+name+"</td><td>"+username+"</td><td>"+email+"</td><td>"+age+"</td><td>"+role+"</td><td></td></tr>"
        }

        mesto.innerHTML += redica
        show_available()

    }

    function hire(obj){
        var redica = obj.parentNode.parentNode
        redica.className = "grey"
        var kopce = obj
        kopce.parentNode.removeChild(kopce)
        available -= 1
        show_available()
    }

    function show_available(){
        var available_na_ekran = document.getElementById("available")
        available_na_ekran.innerHTML = available
    }

</script>

</body>
</html>
