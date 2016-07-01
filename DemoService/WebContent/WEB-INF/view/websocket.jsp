<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSocket Client</title>
<script type="text/javascript">
	var wsocket;
	function connect() {
		wsocket = new WebSocket("ws://localhost:8080/DemoService/serveristek");
		wsocket.onmessage = onMessage;
	}
	function onMessage(evt) {
		document.getElementById("rate").innerHTML = evt.data;
	}
	window.addEventListener("load", connect, false);
</script>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td><label id="rateLbl">Current Rate:</label></td>
			<td><label id="rate">0</label></td>
		</tr>
	</table>
</body>
</html>