var data1 = [];  
  
    $(function() {  
        $.ajax({  
            type : "post",  
            url : baseurl+"/menu/getAllPermissions.action",  
            success : function(data, status) {  
                if (data.code == 200) {  
                    data1 = data.data;  
                }   
            },  
            error : function() {  
                toastr.error('Error');  
            },  
        });  
    });  
  
    function buildDomTree() {  
        var data = [];  
        var root = "所有分类";  
        function walk(nodes, data) {  
            if (!nodes) {  
                return;  
            }  
            $.each(nodes, function(id, node) {  
                var obj = {  
                    id : id,  
                    text : node.name != null ? node.name : root  
                };  
                if (node.isLeaf = true) {  
                    obj.nodes = [];  
                    walk(node.children, obj.nodes);  
                }  
                data.push(obj);  
            });  
        }  
  
        walk(data1, data);  
        return data;  
    }  
  
    $("#txt_departmentname").click(function() {  
    	alert("!");
        var options = {  
            bootstrap2 : false,  
            showTags : true,  
            levels : 5,  
            showCheckbox : true,  
            checkedIcon : "glyphicon glyphicon-check",  
            data : buildDomTree(),  
            onNodeSelected : function(event, data) {  
                $("#txt_departmentname").val(data.text);  
                $("#treeview").hide();  
            }  
        };  
  
        $('#treeview').treeview(options);  
    });  