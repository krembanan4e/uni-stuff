<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        .box{
            background-color: red;
            width: 250px;
            height: 250px;
        }
    </style>
</head>
<body>

<div class="box"></div>
<div id="message"></div>

<script>

    window.onload = function (){
        //function to display a message after 3 seconds
        function showMessage(){
            const msgElement = document.getElementById("message");
            msgElement.textContent = "This message appeared after a 3-second delay!";
        }

        //schedule the message to appear
        setTimeout(showMessage, 3000); //3000ms = 3s
    }


</script>

</body>
</html>
