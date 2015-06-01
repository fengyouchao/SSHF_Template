<#include "common/struts2Tags.ftl">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome</title>
	</head>
	<body>
		<@s.url id="basePath" value="%{#request.getContextPath()}" />
		<a href="${basePath}register">注册</a><br />
		<a href="${basePath}prepareUpload">上传文件</a><br />
		<a href="${basePath}downloadList">下载文件</a><br />
	</body>
</html>