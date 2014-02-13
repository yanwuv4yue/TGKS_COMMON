$(function()
{
	var tabs = $( "#tabs" ).tabs();
	
    // close icon: removing the tab on click
    $( "#tabs span.ui-icon-close" ).live( "click", function() {
        var panelId = $( this ).closest( "li" ).remove().attr( "aria-controls" );
        $( "#" + panelId ).remove();
        tabs.tabs( "refresh" );
    });
    
    // tab使用ajax方式访问url
    $( "#tabs" ).tabs({
        beforeLoad: function( event, ui ) {
            ui.jqXHR.error(function() {
                ui.panel.html(
                    "该页面暂时无法访问，请联系管理员处理......" );
            });
        }
    });
    
    // 可以切换tab顺序的代码
    tabs.find( ".ui-tabs-nav" ).sortable({
        axis: "x",
        stop: function() {
            tabs.tabs( "refresh" );
        }
    });
    
    // 框架布局初始化
    $('body').layout({ applyDemoStyles: true });
});