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
<h2> Welcome <span style="color:SteelBlue">${user.username}</span>
<a href="./signout" style="color:red;float:Right">Signout</a>
<div class="bodypart">
<div class="bodypart1">
<img src="<c:url value="/images/diary.jpg"/>"/>
</div>
<div class="bodypart2">
<h2>ADD ENTRY</h2><br/>
<form action="./saveentry" method="POST">
<label>Date<label><input type="date" name="entrydate" class="formcontrol"/><br/><br/>
<label>Description<label>
<textarea rows="10" cols="40" name="Description"></textarea>
<input type="hidden" name="userid" value="${user.id}">
<button type="submit">Save Entry</button>

</form>
</div>
</div>
</body>
</html>