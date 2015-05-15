<!DOCTYPE html>
<html lang="en-gb" dir="ltr">
    <head>
        <title></title>
        <meta charset="utf-8" >
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link id="data-uikit-theme" rel="stylesheet" href="uikit-2.17.0/css/uikit.docs.min.css">
        <link rel="stylesheet" href="uikit-2.17.0/highlight/highlight.css">
        <link rel="stylesheet" href="uikit-2.17.0/css/uikit.min.css" />
        <link rel="stylesheet" href="css/docs.css">

        <script src="js/uikit.min.js"></script>
        <script src="uikit-2.17.0/js/docs.js"></script>
        <script src="jquery-1.7.1.min.js"></script>
        <script src="uikit-2.17.0/js/uikit.min.js"></script>
        <script src="ace-builds-master/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
    </head>
    <body class="tm-background">
        <nav class="tm-navbar uk-navbar uk-navbar-attached" style="background:#000000" >
            <div class="uk-container uk-container-center uk-margin-top">

                <a class="uk-navbar-brand uk-hidden-small " href="#"><img class="uk-linkx" src="seu.png" width="50px" height="50px" title="JAVA" alt="JAVA"></a>
                <ul class="uk-navbar-nav uk-hidden-small">
                    <li><a href="#">学习区</a></li>
                    <li ><a href="#">编辑区</a></li>
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
        <div>
        <div class="uk-panel uk-navbar-center">
            <div class="b35"></div>
                <h1>
                    <a href="register.jsp" class="b list_cat"><i class="uk-icon-user mb-a"></i> 注册</a>
                </h1>
                <iframe src="" name="send" id="send" style="display:none;"></iframe>
               <form action="login.action" method="post" id="user-login" accept-charset="UTF-8" onsubmit="return checkinput()">
                   <div>
                       <div class="form-item form-type-textfield form-item-name uk-margin-large-top">
                           <label for="edit-user-stu">
                               <input type="radio" id="edit-user-stu" name="usertype" value="student" size="60" maxlength="60" class="form-text required" checked />学生
                           </label>

                           <label for="edit-user-tea">
                               <input type="radio" id="edit-user-tea" name="usertype" value="teacher" size="60" maxlength="60" class="form-text required uk-margin-large-left" />教师
                           </label>
                       </div>
                       <div class="form-item form-type-textfield form-item-name uk-margin-top">
                           <label for="edit-name">账号<span class="form-required" title="">*</span></label>
                           <input type="text" id="edit-name" name="username" value="" size="60" maxlength="60" class="form-text required" />
                           <div class="description"></div>
                       </div>
                       <div class="form-item form-type-password form-item-pass uk-margin-top">
                           <label for="edit-pass">密码<span class="form-required">*</span></label>
                           <input type="password" id="edit-pass" name="password" size="60" maxlength="128" class="form-text required" />
                       </div>
                       <div class="form-actions uk-form-row uk-margin-top" id="edit-actions">
                            <input type="submit" id="edit-submit" name="op" value="确认" class="uk-button form-submit uk-button-primary uk-icon-send" />
                        </div>
                    </div>
                </form>

            </div>
        </div>

        <script type="text/javascript">
            function checkinput(){
                var name = document.getElementById("edit-name").value;
                if(name ==  null || name == ''){
                    alert("用户名不能为空");
                    return false;
                }
                var password = document.getElementById("edit-pass").value;
                var passAgain = document.getElementById("edit-pass-again").value;
                if (password == null || password =='') {
                    alert("密码不能为空");
                    return false;
                }
                if (password.length < 6) {
                    alert("密码长度必须6以上");
                    return false;
                }
                return true;
            }
        </script>

    </body>

</html>