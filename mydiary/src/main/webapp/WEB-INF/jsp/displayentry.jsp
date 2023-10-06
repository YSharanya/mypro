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
<h2>VIEW ENTRY</h2><br/>
<Table>
     <tr><td>Date:  </td> 
     <td>${Entries.entrydate}</td></tr>
     
     
     <tr><td>Description:  </td> 
     <td>${Entries.description}</td></tr>
</Table>
<br/><br/><br>

<a href="./authentication"><Button type="Button">Back To Home</Button></a>


</div>
</div>
</body>
</html>