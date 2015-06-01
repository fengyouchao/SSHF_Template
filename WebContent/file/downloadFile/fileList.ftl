<#assign s=JspTaglibs["/WEB-INF/tags/struts-tags.tld"]/>
<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<center><h1>文件下载</h1></center>
		<table align="center" width="50%" border="1">
			<#list files as file>
			<tr>
				<td>${file.name}</td>
				<td><a href="download?inputPath=upload/${file.name}" >下载</a></td>
			</tr>
			</#list>
		</table>
	</body>
</thml>