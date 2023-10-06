<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Registered Successfully</title>
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
<div class="userhome">
<h3> Welcome <span style="color:SteelBlue">${user.username}</span>
<a href="./signout" style="color:red;float:Right">Signout</a>
</h3><br/><br/>
<span class="heading">List of past Entries</span>
<a href="./addentry"><button type="button" class="addbtn"><b>ADD ENTRY</b></button></a>



<table border="1">
<tr>
<th>Date</th>
<th colspan="3">Actions</th>
</tr>
<c:if test="${entrieslist.size()==0}">
<tr><td style="font-size:30px;color:white;text-align:center" colspan="4">User not added any Diary entry till now.</td></tr>
</c:if>
<c:forEach items="${entrieslist}" var="e">
<tr>
<td> 
<fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/>
 </td>
<td><a href="./viewentry?id=${e.id}">View</a></td>
<td><a href="./updateentry?id=${e.id}">Update</a></td>
<td><a href="./deleteentry?id=${e.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>