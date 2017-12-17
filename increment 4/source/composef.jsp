<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>Inbox</TITLE>
<META http-equiv=Content-Type content="text/html; charset=windows-1252">
<META content="Microsoft FrontPage 4.0" name=GENERATOR>
<META content=FrontPage.Editor.Document name=ProgId></HEAD>
<head>
<script>
function fun()
{
  
   for(i=0;i<f.elements.length;i++)
    {
        if(f.elements[i].value.length==0)
        {
            alert('Enter value of '+f.elements[i].name)
            f.elements[i].focus();
            return false
        }
 }
  return true
 }
</script>
</head>
<BODY bgColor=white style="BACKGROUND-IMAGE: url(file://E:\Tomcat\webapps\WebBasedMail\images\tile_ragged_edge_bubbles.gif)">
>
<DIV align=center>
<TABLE height=247 width="905" border=0 style="position:absolute;top=0;left=0;">
        <TBODY>
        
  <TR>
    <FORM name=f action=./sendf method="post" onsubmit="return fun()">
    <TD 
    style="background-image: url('file:///E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif')" 
    width=897 height=517>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      </P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      &nbsp;To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT type="text"
      style="WIDTH: 540px; HEIGHT: 22px" size=62 name="toaddress" >&nbsp;@ 
      fascimail.com</P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Subject&nbsp; 
      &nbsp;<INPUT type="text" style="WIDTH: 540px; HEIGHT: 22px" size=66 
      name="subject" value=<%=session.getAttribute("sub")%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P>
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: serif; FONT-VARIANT: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;<TEXTAREA id=TEXTAREA1 style="FONT-WEIGHT: bold; FONT-SIZE: small; WIDTH: 546px; HEIGHT: 213px" name="message" rows=10 cols=57><%=session.getAttribute("message")%></TEXTAREA></P>
      <P><B><FONT face=garamond color=darkblue 
      size=4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      Date Of Delivery</FONT></B> <FONT face=garamond color=darkblue 
      size=4><SELECT size=1 name="D1"> <option value="<%=session.getAttribute("dd")%> 
" selected><%=session.getAttribute("dd")%> 
 <OPTION value=1>1</OPTION> 
        <OPTION value=2>2</OPTION> <OPTION value=3>3</OPTION> <OPTION 
        value=4>4</OPTION> <OPTION value=5>5</OPTION> <OPTION value=6>6</OPTION> 
        <OPTION value=7>7</OPTION> <OPTION value=8>8</OPTION> <OPTION 
        value=9>9</OPTION> <OPTION value=10>10</OPTION> <OPTION 
        value=11>11</OPTION> <OPTION value=12>12</OPTION> <OPTION 
        value=13>13</OPTION> <OPTION value=14>14</OPTION> <OPTION 
        value=15>15</OPTION> <OPTION value=16>16</OPTION> <OPTION 
        value=17>17</OPTION> <OPTION value=18>18</OPTION> <OPTION 
        value=19>19</OPTION> <OPTION value=20>20</OPTION> <OPTION 
        value=21>21</OPTION> <OPTION value=22>22</OPTION> <OPTION 
        value=23>23</OPTION> <OPTION value=24>24</OPTION> <OPTION 
        value=25>25</OPTION> <OPTION value=26>26</OPTION> <OPTION 
        value=26>26</OPTION> <OPTION value=27>27</OPTION> <OPTION 
        value=28>28</OPTION> <OPTION value=29>29</OPTION> <OPTION 
        value=30>30</OPTION> <OPTION value=31>31</OPTION></SELECT>&nbsp; <SELECT 
        size=1 name="D2"> <option value="<%=session.getAttribute("m")%> 
" selected><%=session.getAttribute("m")%> 
      <OPTION value=Jan>Jan</OPTION> <OPTION 
        value=Feb>Feb</OPTION> <OPTION value=Mar>Mar</OPTION> <OPTION 
        value=Apr>Apr</OPTION> <OPTION value=May>May</OPTION> <OPTION 
        value=Jun>Jun</OPTION> <OPTION value=Jul>July</OPTION> <OPTION 
        value=Aug>Aug</OPTION> <OPTION value=sep>Sep</OPTION> <OPTION 
        value=Oct>Oct</OPTION> <OPTION value=Nov>Nov</OPTION> <OPTION 
        value=Dec>Dec</OPTION></SELECT>&nbsp; <SELECT size=1 name="D3">  
        <option value="<%=session.getAttribute("yy")%> 
" selected><%=session.getAttribute("yy")%> 
         <OPTION value=2010>2010</OPTION> 
        <OPTION value=2009>2009</OPTION> <OPTION value=2008>2008</OPTION> 
        <OPTION value=2007>2007</OPTION> </SELECT></FONT> 
      <P 
      style="FONT-WEIGHT: bold; FONT-SIZE: small; FONT-STYLE: normal; FONT-FAMILY: Bradley Hand ITC; FONT-VARIANT: small-caps">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<input type=image src="file://E:\Tomcat\webapps\WebBasedMail\images\send.jpg" width=100 height=25>
</TD></FORM></TR>
  </TBODY>
<CENTER></CENTER>
</table>
</BODY>