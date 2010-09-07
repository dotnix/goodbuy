<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Olá, mundo!</title>
</head>
<body>
	Mensagem vinda da lógica: 
	${stringList}
	<br />
	<c:forEach items="${stringList}" var="pais">
		${pais} <br />
	</c:forEach>
</body>
</html>