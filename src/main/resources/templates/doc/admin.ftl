<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理控制台</title>
</head>
<script type="text/javascript" src="../../js/jquery-3.1.1.js"></script>
<body>

    <table border="1" align="center">
        <tr>
            <td>
                <button id="docuid">知识管理</button>
            </td>
            <td rowspan="2">
                <button onclick="location = '/index/creat'">新增知识</button>
                <button onclick="location = '/index/creat'">修改知识</button>
                <button onclick="location = '/index/creat'">修改分类</button>
                <br/>
                <table border="1"  cellspacing="0" id="tab1">
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <button id="cateid">分类管理</button>
            </td>

        </tr>
    </table>
    <script>
        $(function () {
            $.ajax({
                url: "/doc/findAll",
                type: "post",
                success:function (data) {
                    var obj = data.data;
                    for (var i =0 ;i < obj.length ;i++){
                    $("#tab1").append("<tr><td>"+ obj[i].docId
                                        +"</td><td>"+ obj[i].docTitle +"</tr></td>");
                    }
                }
            })
        });
    </script>
</body>
</html>