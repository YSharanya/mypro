<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title>welcome to my diary page</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="header">
 <div class="first">
 <img src="<c:url value="/images/diary.jpg"/>" width="30" height="30"/>
 </div>
 <div class="second">
 My Diary App
 </div>
</div>
<br/>
<hr/>
<div class="bodypart">
<div class="bodypart1">
<img src="<c:url value="/images/diary.jpg"/>"/>
</div>
<div class="bodypart2">
<h2>REGISTERATION FORM</h2><br/>
<form action="./saveuser" method="POST">
<label>User Name    <label><input type="text" name="username" class="formcontrol"/><br/><br/>
<label>Password     <label><input type="text" name="password" class="formcontrol"/><br/><br/>
<button type="submit">REGISTER</button>
</form><br/><br/>
Existing user? <a href="./home">Login</a> here
</div>
</div>
</body>
</html>