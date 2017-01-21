<%@ include file="../common/include.jsp" %>

    <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sign up - Welcome to my APP</title>

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
                        <li class="active">Register</li>
                    </ol>

                    <div class="row">

                        <!-- Article main content -->
                        <article class="col-xs-12 maincontent">
                            <header class="page-header">
                                <h1 class="page-title">Register</h1>
                            </header>

                            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                                <div class="panel panel-default" style="background: transparent">
                                    <div class="panel-body">
                                        <h3 class="thin text-center">Register an account</h3>
                                        <hr>

                                        <form action="${signupUrl}" method="post" id="registerUser">
                                            <div class="top-margin">
                                                <label>Username <span class="text-danger">*</span></label>
                                                <input id="username" name="username" type="text" class="form-control" autocomplete="off" />
                                            </div>
                                            <div class="top-margin">
                                                <label>Email address <span class="text-danger">*</span></label>
                                                <input id="email" name="email" type="text" class="form-control" autocomplete="off" />
                                            </div>
                                            <div class="top-margin">
                                                <label>Password <span class="text-danger">*</span></label>
                                                <input id="password" name="password" type="password" class="form-control" autocomplete="off" />
                                            </div>
                                            <div class="top-margin">
                                                <label>Verification Code <span class="text-danger">*</span></label>
                                                <input id="verification" name="verification" type="text" class="form-control" autocomplete="off" />
                                            </div>
                                            <hr>
                                            <div>
                                                <label>
                                                    <input id="agree" name="agree" type="checkbox" checked="checked" >
                                                </label>
                                                <label>
                                                I agree to Rain's <a href="#">Privacy Policy</a> and <a href="#">Terms of Use</a>.
                                                </label>
                                            </div>
                                            <br />

                                            <div align="center">
                                                    <button class="btn btn-action" type="submit" >Submit</button>
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
    $(function() {
    });
    </script>

    </body>

    </html>
