<!DOCTYPE html>
<html lang="en-gb" dir="ltr">
<head>
    <title></title>
    <meta charset="utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link id="data-uikit-theme" rel="stylesheet" href="uikit-2.17.0/css/uikit.min.css">
    <link rel="stylesheet" href="uikit-2.17.0/highlight/highlight.css">
    <link rel="stylesheet" href="uikit-2.17.0/css/uikit.min.css" />
    <script src="javascript/jquery-1.7.1.min.js"></script>
    <script src="uikit-2.17.0/js/uikit.min.js"></script>
    <script src="ace-builds-master/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css" media="screen">
        body {
            overflow: hidden;
        }
        #editor {
            margin: 0;
            position: absolute;
            top: 3.2cm;
            bottom:1.8cm;
            left: 0;
            right: 14.8cm;
        }
    </style>
</head>
<body class="tm-background">
<nav class="tm-navbar uk-navbar uk-navbar-attached" style="background:#000000" >
    <div class="uk-container uk-container-center uk-margin-top">

        <a class="uk-navbar-brand uk-hidden-small " href="#"><img class="uk-linkx" src="piture/seu.png" width="50px" height="50px" title="JAVA" alt="JAVA"></a>
        <ul class="uk-navbar-nav uk-hidden-small">
            <li><a href="#">学习区</a></li>
            <li  class="uk-active"><a href="#">编辑区</a></li>
            <li><a href="http://b">作业区</a></li>
            <li><a href="#">讨论区</a></li>
            <li><a href="#" target="_blank">关于我们</a></li>
        </ul >
        <ul class="uk-navbar-nav uk-hidden-small uk-align-right">
            <a href="#" class="uk-button-success uk-button-large uk-margin-small-right " >注册</a>
            <a href="#" class="uk-button-primary uk-button-large">登陆</a>
        </ul>

        <a href="#tm-offcanvas" class="uk-navbar-toggle uk-visible-small" data-uk-offcanvas></a>

    </div>
</nav>
<div class="class="tm-middle>
    <div class="uk-grid" data-uk-margin>
        <div class="tm-sidebar uk-width-medium-3-5" >
            <nav class="tm-navbar uk-navbar uk-navbar-attached" style="background:#232323">
                <div style="margin-left:30px">
                    <ul class="uk-navbar-nav" >
                        <li >
                            <a>Main.java</a>
                        </li>
                    </ul >
                </div>
                <div class="uk-align-right" style="background:#232323">
                    <ul class="uk-navbar-nav">
                        <li >
                            <a>设置</a>
                        </li>
                    </ul >
                </div>
            </nav>
            <pre id="editor"></pre>
            <nav class="tm-navbar uk-navbar uk-navbar-attached" style="background:#232323;margin-top:12.5cm">
                <div class="uk-align-right uk-margin-top" style="background:#232323">
                    <button id = "run" class="uk-button-success uk-button-large uk-margin-small-right uk-icon-send">运行</button>
                    <button id = "rewrite" class="uk-button-primary uk-button-large uk-margin-small-right uk-icon- refresh">重写</button>
                </div>
            </nav>
            <script charset="utf-8">
                var editor = ace.edit("editor");
                editor.setTheme("ace/theme/twilight");
                editor.getSession().setMode("ace/mode/java");
                $(document).ready(function(){
                    $("#rewrite").click(function(){
                        editor.setValue("");
                    });

                    $("#run").click(function(){
                        var code = editor.getValue();
                        var codeType = "java";
                        if(code == ""){
                            alert("程序为空");
                        }
                        else{
                            $.ajax(
                                    {
                                        url:"runCode.action",
                                        dataType:"text",
                                        data:{code:code,
                                            codeType:codeType},
                                        contentType:"application/x-www-form-urlencoded; charset=utf-8",
                                        success:function(strValue) {
                                            alert(strValue);
                                        }

                            });

                        }

                    });
                });
            </script>
        </div>
        <div class="tm-main uk-width-medium-2-5" style="background:#132323">
            <div class="uk-text-center">
                dsfjdshkjfhjdfsdfsdfs
            </div>
        </div>
    </div>

</div>
</body>
</html>