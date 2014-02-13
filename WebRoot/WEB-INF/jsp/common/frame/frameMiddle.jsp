<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
  body { }
  .column { width: 190px; float: left; padding-bottom: 100px; }
  .portlet { margin: 0 1em 1em 0; }
  .portlet-header { margin: 0.3em; padding-bottom: 4px; padding-left: 0.2em; }
  .portlet-header .ui-icon { float: right; }
  .portlet-content { padding: 0.4em; }
  .ui-sortable-placeholder { border: 1px dotted black; visibility: visible !important; height: 50px !important; }
  .ui-sortable-placeholder * { visibility: hidden; }
  </style>
  <script>
  
  </script>
<div class="column">
 
  <div class="portlet">
    <div class="portlet-header">今日天气：</div>
    <div class="portlet-content">
		<iframe name="sinaWeatherTool" src="http://weather.news.sina.com.cn/chajian/iframe/weatherStyle31.html?city=%E8%8B%8F%E5%B7%9E" width="166" height="152" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
    </div>
  </div>
 
</div>
 
<div class="column">
 
</div>
 
<div class="column">
 
</div>

<script src="<%=basePath%>js/common/frame/tgks_main.js"></script>