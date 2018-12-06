<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<h1>欢迎光临！</h1><br/>
<h1>${user.nickName}</h1>
<ul>
    <@shiro.hasPermission name="add">
        <li>增加</li>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="delete">
        <li>增加</li>
    </@shiro.hasPermission>
</ul>
</body>
</html>