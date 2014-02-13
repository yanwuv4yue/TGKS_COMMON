$(function()
{
	var tabTitle = $( "#tab_title" ),
    tabContent = $( "#tab_content" ),
    tabTemplate = "<li><a id='\#{id}' name='\#{name}' title='\#{title}' href='\#{href}'>\#{label}</a> <span class='ui-icon ui-icon-close'>Remove Tab</span></li>",
    tabCounter = 2;
	var tabs = $( "#tabs" ).tabs();
	
	// 一级菜单
	$( "#accordion" ).accordion({
        collapsible: true, // 可折叠的
        heightStyle: "content" // 按内容长度展示
    });
    
	var menuOneArr = document.getElementsByName("menuOne");
	
	// 先选择所有name为menu的菜单组件，然后再取出每一条的id，组合#来调用jqueryUI
	for (var i = 0; i < menuOneArr.length; i++)
	{
		// 调用jquery的方法需要在id前加#，页面组件id前不加此符号
		$("#" + menuOneArr[i].id).menu();
	}
	
	// 二级菜单
	var menuTwoArr = document.getElementsByName("menuTwo");
	
	for (var i = 0; i < menuTwoArr.length; i++)
	{
		$("#" + menuTwoArr[i].id).click(function() {
			newTab(this.title, this.type);
		});
	}
	
	//新增标签
	function newTab(label, url)
	{
		// 看是否已经打开了该菜单，如果是，则直接跳到该菜单页
		if (tabExist(label))
		{
			return;
		}
		
		// label这个值是标题，tabContentHtml这个是正文内容
	    var id = "tabs-" + tabCounter,
	    	up = "up" + tabCounter, // 上门的标签页的ID,用于后面自动跳到刚点开的菜单
	        li = $( tabTemplate.replace( /#\{id}/g, up).replace( /#\{name\}/g, "ups").replace( /#\{title\}/g, label).replace( /#\{href\}/g, "#"+id).replace( /#\{label\}/g, label ) );
        tabs.find( ".ui-tabs-nav" ).append( li );
        tabs.append( "<div id='" + id + "'></div>" );
        tabs.tabs( "refresh" );
        
        tabCounter++;
        // 跳转到刚点开的菜单
        $("#" + up).click();
        //$("#" + id).load(url);
        var html=$.ajax({url:url,async:false});
        $("#" + id).html(html.responseText);
	}
	
	function tabExist(label)
	{
		var ups = document.getElementsByName("ups");
		
		for (var i=0; i<ups.length; i++)
		{
			if (label == ups[i].title)
			{
				$("#" + ups[i].id).click();
				tabs.tabs( "refresh" );
				return true;
			}
		}
		
		return false;
	}
});
