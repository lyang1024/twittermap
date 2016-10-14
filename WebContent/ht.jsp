<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ht</title>
</head>
<body>
<form id="form2" action="getlocations.getlocas" method="post">
 	  <input  type="hidden" id="002" name="hashtag" value="">
 	  <%--<input type="hidden" name="top5" value="<%=request.getAttribute("top5")>">--%>
	<%--<div id="subblock"></div> --%>
	</form>	
   <div id="subblock">
    <button onclick="submit('<%=request.getAttribute("top1")%>')">1.<%=request.getAttribute("top1")%></button>
     <button onclick="submit('<%=request.getAttribute("top2")%>')">2.<%=request.getAttribute("top2")%></button>
      <button onclick="submit('<%=request.getAttribute("top3")%>')">3.<%=request.getAttribute("top3")%></button>
       <button onclick="submit('<%=request.getAttribute("top4")%>')">4.<%=request.getAttribute("top4")%></button>
        <button onclick="submit('<%=request.getAttribute("top5")%>')">5.<%=request.getAttribute("top5")%></button>
   </div>
</body>
<script>
<%--function hts(hashtags){
	print("yes");
	var temp=[];
	var hash=hashtags.split('_');
	int i;
        for ( i=0;i<5;i++){
            temp=temp+"<br><button onclick='submitform(&quot"+hash[i]+"&quot)'>"+(i+1).toString()+"."+hash[i]+"</button>";
        }
        document.getElementById("subblock").innerHTML=temp;

}--%>
function submit(hashtag){
	document.getElementById("002").value=hashtag;
	document.getElementById("form2").submit();
}
</script>
</html>
