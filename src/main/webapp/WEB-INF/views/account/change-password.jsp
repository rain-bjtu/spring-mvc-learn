<%@ include file="../common/include.jsp"%>

    <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Change Password</title>

        <%@ include file="../common/css.jsp"%>
    </head>

    <body>
        <%@ include file="../common/navbar.jsp" %>

            <header id="head" class="secondary"></header>

            <div style="background-image:url(${bodyBGUrl}); opacity:0.95; padding-bottom: 60px">
                <!-- container -->
                <div class="container">

                    <ol class="breadcrumb">
                        <li><a href="${indexUrl }">Home</a>
                        </li>
                        <li class="active">Change password</li>
                    </ol>

                    <div class="row">

                        <!-- Article main content -->
                        <article class="col-xs-12 maincontent">
                            <header class="page-header">
                                <h1 class="page-title">Change password</h1>
                            </header>

                            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                                <div class="panel panel-default" style="background: transparent">
                                    <div class="panel-body">
                                        <h3 class="thin text-center">Change your password</h3>
                                        <hr>

                                        <form id="changePassword" action="${changePasswordUrl}" method="post">
                                            <div class="top-margin">
                                                <label>Old Password <span class="text-danger">*</span></label>
                                                <input id="oldPassword" name="oldPassword" type="password" class="form-control" autocomplete="off" />
                                            </div>
                                            <div class="top-margin">
                                                <label>New Password <span class="text-danger">*</span></label>
                                                <input id="newPassword" name="newPassword" type="password" class="form-control" autocomplete="off" />
                                            </div>
                                            <!-- -->
                                            <div class="top-margin">
                                                <label>Confirm Password <span class="text-danger">*</span></label>
                                                <input id="confirmPassword" name="confirmPassword" type="password" class="form-control" autocomplete="off" />
                                            </div>
                                            <!-- -->
                                            <hr>
                                            <div class="row">
                                                <div class="col-lg-8">
                                                </div>
                                                <div class="col-lg-4 text-right">
                                                    <button class="btn btn-action" type="submit">Change</button>
                                                </div>
                                            </div>
                                        </form>
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
    <script type="text/javascript">
    $(function(){
        var validate = $("#changePassword").validate({
            onkeyup: true,   
            rules:{
            	oldPassword:{
                    required:true,
                    rangelength:[1,10],
                    remote: {
                        url: "${checkPasswordUrl}",
                        type: "post",
                        dataType: "json", 
                        data: {
                            password: function() {
                                return $("#oldPassword").val();
                            }
                        }
                    }
                },
                newPassword:{
                    required:true,
                    rangelength:[1,10]
                },
                confirmPassword:{
                	equalTo:"#newPassword"
                }
            },
            messages:{
            	oldPassword:{
            		required: "<spring:message code="password.not.empty" />",
                    rangelength: "<spring:message code="password.length.limitation" />",
                    remote: "<spring:message code="password.not.correct" />"
                },
                newPassword:{
                    required: "<spring:message code="password.not.empty" />",
                    rangelength: "<spring:message code="password.length.limitation" />"
                },
                confirmPassword:{
                	equalTo: "<spring:message code="password.confirm.equal" />"
                }
            }
        });    
    });
    </script>
    </body>

    </html>
