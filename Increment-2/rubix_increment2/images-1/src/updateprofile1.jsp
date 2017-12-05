<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta name="GENERATOR" content="Microsoft FrontPage 4.0">
<meta name="ProgId" content="FrontPage.Editor.Document">

 <title>
  Inbox</title>
<script language="javascript">
function fun()
{
    for(i=0;i<f.elements.length;i++)
    {
        
    if((f.password.value)!=(f.rpassword.value))
    {
     alert('The two password entries must be same') 
    f.password.focus()
      return false  
     }
if((f.password.value.length)<6)
    {
     alert('Password length must be minimum of  6  characters') 
    f.password.focus()
      return false  
     }
}
return true
}
</script>
</head>
<body bgcolor=white style="BACKGROUND-IMAGE: url(file://E:\Tomcat\webapps\WebBasedMail\images\tile_ragged_edge_bubbles.gif)">
  

 <table>
  <tr><form name='f' method="post" onSubmit="return fun()" action="./profile">
      <td width="1316" height="324" colspan="2">
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" ><br>
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      Retype Password
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input type="password" name="rpassword" 
      style="WIDTH: 154px; HEIGHT: 22px" size=18><br>
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      Secret 
      Question&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      &nbsp;&nbsp;&nbsp;<SELECT name="Question" id="Question" >
<option value="" selected><%=request.getAttribute("ques")%> 

<OPTION value="What is your fathers middle name?">What is your father's middle 
        name?
 <OPTION value="What was the name of your first school?">What was 
        the name of your first school?
 <OPTION 
        value="Who was your childhood hero?">Who was your childhood hero?<OPTION 
        value="What is your favorite pastime?">What is your favorite 
        pastime?
<OPTION value="What is your all-time favorite sports team?">What 
        is your all-time favorite sports team?<OPTION 
        value="What was your high school mascot?">What was your high school 
        mascot?
<OPTION value="What make was your first car or bike?">What make 
        was your first car or bike?<OPTION 
        value="Where did you first meet your spouse?">Where did you first meet 
        your spouse?
<OPTION value="What is your pets name?">What is your pet's 
        name?

</SELECT>
&nbsp; 
      <BR><BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      Your 
      Answer&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      &nbsp;&nbsp;&nbsp;<INPUT type="text" name="Answer" value=<%=request.getAttribute("ans")%>></P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;F 
      irst 
      Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      &nbsp;&nbsp;&nbsp; <INPUT type="text"
      name="Name" value=<%=request.getAttribute("name")%>><BR><BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  LastName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      &nbsp;&nbsp;&nbsp;<INPUT type="text" name="LName" value=<%=request.getAttribute("lname")%>></P>
      
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br> 
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Profession&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<select name="proffession" id="proffession"><option value="" selected><%=request.getAttribute("pro")%>
<option value="student" >
			Student
<option value="professional" >
			Professional
<option value="technical" >
			Technical
<option value="officer" >
			Officer
<option value="business" >
			Business</option>
			


</select><br>
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
     <br>
 <br>
Address
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <TEXTAREA rows=5 cols=50 name="Address"><%=request.getAttribute("add")%></TEXTAREA>&nbsp;&nbsp;</P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      City&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      &nbsp; &nbsp;<INPUT type="text" name="City" value=<%=request.getAttribute("city")%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal"><BR>
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
ZIP/Postal 
      Code &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Zipcode" value=<%=request.getAttribute("z")%>> </P>





      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Contry&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<SELECT 
      id=intl style="WIDTH: 153px" name="country"> <option value="" selected><%=request.getAttribute("cou")%>


<OPTION value=us 
        >U.S.
<OPTION value=U.S. in Spanish>U.S. in Spanish
<OPTION value=U.S. in Chinese>U.S. in Chinese 
       
<OPTION value=U.S. in Russian >U.S. in Russian
<OPTION value=China>China
<OPTIO value=United Kingdom >United Kingdom
     <OPTION value=Argentina>Argentina
<OPTION value=Asia >Asia
    <OPTION value=Australia >Australia
     <OPTION value=Brazil>Brazil
<OPTION value=Canada in English >Canada in English
    <OPTION value=Canada in French >Canada in French
<OPTION value=Denmark>! Denmark
<OPTION value=France>France
<OPTION value=Germany>Germany
<OPTION value=Greece>Greece
   <OPTION value=Hong Kong>! Hong Kong
   <OPTION value=India>India
<OPTION value=Indonesia>Indonesia
<OPTION value=Ireland >Ireland
<OPTION value=Italy>Italy
<OPTION value=Korea >Korea
<OPTION value=Malaysia>Malaysia
<OPTION value=Mexico>Mexico
<OPTION value=New Zealand>New Zealand
<OPTION value=Norway>Norway
<OPTION value=Philippines>Philippines
<OPTION value=Poland>Poland
<OPTION value=Singapore>Singapore
<OPTION value=Spain>Spain
<OPTION value=Sweden>Sweden
<OPTION value=Taiwan>Taiwan
<OPTION value=Thailand>Thailand
<OPTION value=Turkey>Turkey
<OPTION value=Vietnam>Vietnam
</OPTION></SELECT>&nbsp;&nbsp;</P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      <input type=image img src="file://E:\Tomcat\webapps\WebBasedMail\images\submitbutton.gif"></P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;</P></td>
  </tr>
    </form>
   </table>
<CENTER></CENTER>
</div>

</body>
</html>
