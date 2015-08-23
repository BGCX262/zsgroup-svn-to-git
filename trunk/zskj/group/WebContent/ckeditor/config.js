/*
 Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
 For licensing, see LICENSE.html or http://ckeditor.com/license
 */
CKEDITOR.editorConfig = function(config){
    // Define changes to default configuration here. For example:
    // config.language = 'fr';
    // config.uiColor = '#AADC6E';
    
   	config.toolbar = 'MyToolbar';
 
	
  config.toolbar_MyToolbar =
    [
        ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
		    ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
		    ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
		    ['Link','Unlink','Anchor'],
		    ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
		    ['Styles','Format','Font','FontSize','Source'],
    ];   
    config.language = 'zh-cn';
    config.uiColor = '#DDEDFC';
    
    config.font_names = '宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;' + config.font_names;
    
  //  config.filebrowserImageBrowseUrl = '/inc/browseUserImg.jsp';
  //  config.filebrowserImageUploadUrl = '/group/inc/uploadImgUrl.jsp?type=img';
  //  config.filebrowserFlashUploadUrl = './upload.php?type=flash';
	
	 config.filebrowserUploadUrl ='/group/CKEditorUploadServlet?Type=File';
	 config.filebrowserImageUploadUrl ='/group/CKEditorUploadServlet?Type=Image'; 
	 config.filebrowserFlashUploadUrl = '/group/CKEditorUploadServlet?Type=Flash';
	 config.dialog_backgroundCoverColor = 'rgb(255, 254, 253)'; //可设置参考
};
