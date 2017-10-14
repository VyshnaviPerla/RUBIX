
<html>
<body bgcolor=#f7f6f9 text=657693>

<table border="0" class="box" cellpadding="1" cellspacing="0" width="90%"  align=center>
                           <tr>
                           <td>
	        <table border="0"  width="100%" cellpadding="3" cellspacing="0" align="center">
		<tr>
			<th colspan=2><h1>Employee registration form</h1></td>
		</tr>
		<tr>
                                    <td >
<h4>Emp no</h4>
			</td>
			<td >
		<%= session.getAttribute("uname")%>
	
			</td>
		</tr>
		<tr>
			<td >
			
<h4>Emp Name</h4>

			</td>
			<td >
			<%=request.getAttribute("fid")%>
			</td>
		</tr>
		<tr>
			<td width="40%"> 

<h4>Date of Birth</h4>

			</td>
			<td >
			
                        
<%=request.getAttribute("sub")%>
			</td>
		</tr>
		<tr>
			<td width="40%">

<h4>Designation</h4>
			</td>
			<td >
			<%=request.getAttribute("dat")%>
			</td>
		</tr>
                  <td width="40%"> 

	<tr>
			<td width="40%">
                      
		
<h4>Address</h4>

		</td>
			<td><%=request.getAttribute("msg")%>
			</td>
		</tr>

	
		<tr>
			<td width="40%">
				
			
<h4>Mobile Number</h4>

			</td>
			<td >
			<%=request.getAttribute("mid")%>
			</td>
		</tr>
		
</table>
</form>


</table>

<!-- End of regpatient FORM -->
</body>
</html>
