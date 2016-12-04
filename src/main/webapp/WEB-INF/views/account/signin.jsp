<%@ include file="../common/include.jsp" %>

    <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sign in - Welcome to my APP</title>

        <%@ include file="../common/css.jsp"%>
    </head>

    <body OnLoad="document.getElementById('username').focus();">

        <%@ include file="../common/navbar.jsp" %>

            <header id="head" class="secondary"></header>

            <div style="background-image:url(${bodyBGUrl}); opacity:0.95; padding-bottom: 60px">
                <!-- container -->
                <div class="container">

                    <ol class="breadcrumb">
                        <li><a href="${indexUrl }">Home</a>
                        </li>
                        <li class="active">User access</li>
                    </ol>

                    <div class="row">

                        <!-- Article main content -->
                        <article class="col-xs-12 maincontent">
                            <header class="page-header">
                                <h1 class="page-title">Sign in</h1>
                            </header>

                            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                                <div class="panel panel-default" style="background: transparent">
                                    <div class="panel-body">
                                        <h3 class="thin text-center">Sign in to your account</h3>
                                        <p class="text-center text-muted">If you don't have an account, click &quot;<a href="signup">Register</a>&quot; to
                                            register one. </p>
                                        <hr>

                                        <form:form action="${authUrl}" method="post" modelAttribute="loginUser">
                                            <!--
                                            <form:errors path="*"></form:errors>
                                            -->
                                            <div class="top-margin">
                                                <label>Username/Email <span class="text-danger">*</span></label>
                                                <form:input path="username" type="text" class="form-control" autocomplete="off" />
                                                <form:errors path="username" style="color:green"></form:errors><br/>
                                            </div>
                                            <div class="top-margin">
                                                <label>Password <span class="text-danger">*</span></label>
                                                <form:input path="password" type="password" class="form-control" autocomplete="off" />
                                                <form:errors path="password" style="color:green"></form:errors><br/>
                                            </div>
                                             
                                            <div class="top-margin">
                                                <form:checkbox path="rememberMe" />
                                                <label for="rememberMe">Remember Me?</label>
                                            </div>
                                            <!-- 
                                            <input id="rememberMe" name="rememberMe" type="checkbox"/>Remember Me
                                            -->

                                            <hr>

                                            <div class="row">
                                                <div class="col-lg-8">
                                                    <b><a href="password-find"><spring:message code="login.forget.password" /></a></b>
                                                </div>
                                                <div class="col-lg-4 text-right">
                                                    <button class="btn btn-action" type="submit">Sign in</button>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>

                            </div>

                        </article>
                        <!-- /Article -->

                    </div>
                    <div style="height:20px">
                    </div>
                </div>
                <!-- /container -->
            </div>



            <%@ include file="../common/footer.jsp" %>
                <%@ include file="../common/js.jsp" %>
    <!--
    <script type="text/javascript">
    $(function(){
        var validate = $("#loginUser").validate({
            debug: true, 
            focusInvalid: false,
            onkeyup: false,   
            submitHandler: function(form){ 
                alert("abc");   
                form.submit(); 
            },   
            
            rules:{
                username:{
                    required:true
                },
                password:{
                    required:true,
                    rangelength:[3,10]
                }
            },
            messages:{
                username:{
                    required:"required"
                },
                password:{
                    required: "required",
                    //rangelength: $.validator.format("password min:{0}, max:{1}")
                    rangelength: "<spring:message code="password.length.limitation" />"
                }
            }
                      
        });    

    });
    </script>
    -->
    <vali:common modelAttribute="loginUser"/>
    </body>

    </html>
