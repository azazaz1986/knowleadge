<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>创建知识</title>
</head>
<script type="text/javascript" src="../../js/jquery-3.1.1.js"></script>
<body>
<div align="center">
    <div id="text" name="text"></div>
    <form   onsubmit="return sub()" action="/index/creatDocument" method="post">
        知识标题 : <input type="text" id="doc_name" name="docTitle"/><br/>
        文档内容:<br/>
        <textarea id="doc_text" name="docContent"></textarea>
      <br/>
        tag:<input type="text" id="doc_tag" name="tagName"/>
        小组审核:<select id="doc_group" name="groupId">
        <option value="1">否</option>
        <option value="2">OA小组</option>
    </select>
        文档分类:<select id="doc_type" name="category">
                     <option value="">    </option>
                  </select>
        <br/>
        <input type="submit" value="确定"/>

    </form>

</div>
<script>
    $(function(){
        $.ajax({
            url:"/index/docType",
            type: "post",
            success : function (data) {
                // alert(data.key.length);
                for (var i = 0 ; i <data.key.length ;i++){
                    $("#doc_type").append("<option value="+data.key[i].categoryId+">"+data.key[i].categoryText+"</option>");
                }
            }
        })
    })
    function sub() {
        var temp = true;
        var doc_name  = document.getElementById("doc_name");
        var doc_text  = document.getElementById("doc_text");
        var doc_tag   = document.getElementById("doc_tag");
        var doc_group = document.getElementById("doc_group");
        var doc_type  = document.getElementById("doc_type");
        // alert(doc_name.value)
        if (doc_name.value == "") {
            $("#text").html("知识标题不能为空").css("color","red" );
            return false;
        }
        if (doc_text.value == "") {
            $("#text").html("知识内容不能为空").css("color","red" );
            return false;
        }
        if (doc_tag.value == "") {
            $("#text").html("tag不能为空").css("color","red" );
            return false;
        }
        if (doc_type.value == "") {
            $("#text").html("文档分类不能为空").css("color","red" );
            return false;
        }
    }


</script>
</body>
</html>