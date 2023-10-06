<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h2>UPDATE ENTRY</h2><br/>
<form action="./processentryupdate" method="POST">
<label>Date  <label><input type="text" name="entrydate" class="formcontrol" value="<fmt:formatDate value="${entry.entrydate}" pattern="yyyy-MM-dd"/>" readonly>
<br/><br/>
<label>Description  <label>
<textarea rows="7" cols="40" name="Description">
${entry.description}
</textarea>
<input type="hidden" name="userid" value="${user.id}">
<input type="hidden" name="id" value="${entry.id}">
<br/><br/><br/>

<button type="submit">Update Entry</button>

</form>
</div>
</div>
</body>
</html>