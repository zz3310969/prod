var ue = UE.getEditor('container');

var sourceDom = '<li class="tab"><div class="tab-title">'
          +'<span>数据源:</span><input class="s-key" type="text" value="" placeholder="输入键值名称" />'
          +'<span class="btn btn-red" name="del-source">删除</span>'
          +'</div><div class="tab-content"><textarea class="data"></textarea> </div></li>'

// var testTemplateHtml = '<ul>'
//                 +'{{#each dataList}}<li>姓名：{{name}} 年龄:{{age}}</li>{{/each}}'
//                 +'{{#each userList}}<li>姓名22：{{name}} 年龄:{{age}}</li>{{/each}}'
//                 +'{{#each userList2}}<li>姓名3333：{{name}} 年龄:{{age}}</li>{{/each}}'
//                 +'</ul>'


$(function(){

    var dataList = [{name:"张三",age:15},{name:"Job",age:12},{name:"Jack",age:15}];

    //删除数据源配置
    $("#sourceList").on("click","li span[name='del-source']",function(event){
      var $this = $(this)
      $this.parents("li").remove()
    });

    //增加数据源配置
    $("#addDataSource").on("click",function(){
      $("#sourceList").find("ul").append(sourceDom)
    });
    
    
    $("#createBtn").on("click",function(){
    	var submitDataList = [];
    	$("#sourceList").find("li.tab").each(function(){
    		var $this = $(this);
    		submitDataList.push({
    			"key":$this.find("input.s-key").val()||"",
    			"value":$this.find("textarea").val()
    		})
    	});
    	var templateHtml = ue.getContentTxt();
    	params = {
    		"templateHtml":templateHtml,
    		"dataList":submitDataList
    	}
	    $.ajax({
	      type: 'POST',
	      dataType: 'json',
	      data:JSON.stringify(params),
        url:"/templateController/submit",
        contentType: "application/json",
	      success:function(resp){
	      	if(resp.success){
	      		$("#htmlContent")[0].innerHTML = resp.data.replace("\n\r","");
	      	}
	      },
	      error:function(resp){
	      	
	      }
	  });
	
    });
    
    
});