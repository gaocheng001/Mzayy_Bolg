//查看分类并显示默认分类笔记列表
function findFenlei(){
    $("#fenlei").html("");
    $("#add-fenlei").html("");
    
    $.ajax({
        url:baseUrl+"/findFenlei",
        type:"post",
        success:function(result){
            //一个一个添加分类
            for(var key in result.list[0]){
                $("#fenlei").append("<div style='float:left;background:#ECFFFF;text-align:center;width:45px;margin-right:5px' type='button' onclick='findNoteDir(this)' name='"+key+"' value='"+result.list[0][key]+"'>"+result.list[0][key]+"</div>");
                $("#add-fenlei")[0].options.add(new Option(result.list[0][key],key));
                $("#delete-fenlei")[0].options.add(new Option(result.list[0][key],key));
            }

            //删除最后一个默认的笔记列表
            $("#fenlei div:last").remove();
            $("#fenlei").append("<br/>");
            

        $("#add-fenlei option:last").remove();
        $("#delete-fenlei option:last").remove();
    },
        error:function(){
        alert("查找分类失败.");
        }
    });
}
//添加分类
function AddFenlei(btn){
        $(btn).next().remove();
        $(btn).after("<input type='text' value='新建分类..'/>");
        $(btn).next().after("<input type='button' value='添加..'/>");
        $(btn).next().next().click(function(){
            var fenleiName=$(btn).next().val();
            $.ajax({
                url:baseUrl+"/addFenlei",
                type:"post",
                data:{"fenleiName":fenleiName},
                success:function(){
                findFenlei();
                alert("添加分类成功");
                },
                error:function(){
                alert("添加分类失败，通信失败.");
                }
            });
        });
}
//删除分类  
function DeleteFenlei(btn){
    $(btn).next().remove();
  
    var fenleiId=$("#delete-fenlei option:selected").val();
    $.ajax({
        url:baseUrl+"/deleteFenlei",
        type:"post",
        data:{"id":fenleiId},
        success:function(){
        findFenlei();
        alert("删除分类成功成功");
        },
        error:function(){
        alert("删除分类失败，通信失败.");
        }
    });
 
}
//查找笔记
function findNote(btnA){
    var urlId=$(btnA).attr("name");
    var urlP=urlId.split("=");
    var id=urlP[1];

    $.ajax({
            url:baseUrl+"/note?id="+id,
        }
    ).done(function(date){
        $("#blogRight").html(date);
        $("#blogRight").append("<a href='#' onclick='window.location.reload()'>返回</a>")
    });
}
//添加笔记
function AddNote(){
    var title=$("#add-title").val();
    var fenlei=$("#add-fenlei").find("option:selected").val();
    var note=UE.getEditor('editor').getContent();
    if(title=="" || fenlei=="分类" || note=="" ){
        alert("未写标题或未分类或内容为空");
        return;
    }else{
        $.ajax({
            url:baseUrl+"/addNote",
            type:"post",
            data:{"title":title,"fenlei":fenlei,"note":note},
            success:function(){
            findFenlei();
            alert("添加笔记成功");
            },
            error:function(){
            alert("添加笔记失败，通信失败.");
            }
        });
     
    }
    
}
//删除笔记
function deleteNote(a){
    var id=$(a).prev().attr("href").split("id=")[1];
    alert(id);
    alert("确定删除么？ --未完善，尽快修改")
    $.ajax({
        url:baseUrl+"/deleteNote",
        type:"post",
        data:{"id":id},
        success:function(){
        findFenlei();
        alert("删除笔记成功");
        },
        error:function(){
        alert("删除笔记失败，通信失败.");
        }
    });
}
//查找笔记目录
function findNoteDir(btn){
    $("#noteDir").html("");

    var id=$(btn).attr("name");
    $.ajax({
        url:baseUrl+"/findNoteDir",
        type:"post",
        data:{"id":id},
        success:function(result){

            var i=0;
                for(var index in result.list){
                i=1;
                $("#noteDir").append("<div style='width:280px;'><a href='#' name='"+baseUrl+"/note?id="+result.list[index].id+"' onclick='findNote(this)'>"+result.list[index].title+"</a><input type='button' style='float:right' onclick='deleteNote(this);' value='删除'/><br></div>");
            }
            if(i==0){

                $("#noteDir").append("<a>无笔记</a><br>");
            }

        },
        error:function(){
            $("#fenlei").append("查询笔记失败，通信失败.");
        }
    });
}
