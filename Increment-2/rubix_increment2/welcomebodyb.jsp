<html>
<head>

</head>

<body>
<center>
 
 </center>
<script>
document.write("<center><font color=red size=20> <%=session.getAttribute("user")%>!!!</font></center>");
</script>
<br><center>
<font color=blue size="6"> WELCOME TO FASCIMAIL</font></center><br><br>
    /*font colour is blue*/
<font color=green size="5"><u><I><b>BIRTHDAY'S</b></I></u></font>
<script>
 
 <% Integer x=(Integer)session.getAttribute("k");
 for(int i=0;i<x;i++)
         {%>

document.write("<br><br><font color=orange size=4>Today is <%=session.getAttribute("n1["+i+"]")%>'s birthday<br><br>")
document.write("")
<%}%>
</script>

</body>
</html>
