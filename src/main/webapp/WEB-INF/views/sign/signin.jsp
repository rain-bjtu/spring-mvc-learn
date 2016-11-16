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

    <body style="background-image:url(resources/images/bg_header.jpg); opacity:0.9" OnLoad="document.getElementById('username').focus();">

        <%@ include file="../common/navbar.jsp" %>

            <header id="head" class="secondary"></header>

            <!-- container -->
            <div class="container">

                <ol class="breadcrumb">
                    <li><a href="<c:url value='/index' />">Home</a>
                    </li>
                    <li class="active">User access</li>
                </ol>

                <div class="row" >

                    <!-- Article main content -->
                    <article class="col-xs-12 maincontent">
                        <header class="page-header">
                            <h1 class="page-title">Sign in</h1>
                        </header>

                        <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                            <div class="panel panel-default" style="background: transparent" >
                                <div class="panel-body">
                                    <h3 class="thin text-center">Sign in to your account</h3>
                                    <p class="text-center text-muted">If you don't have an account, click &quot;<a href="signup">Register</a>&quot; to register
                                        one. </p>
                                    <hr>

                                    <form action="j_spring_security_check" method="post">
                                        <div class="top-margin">
                                            <label>Username/Email <span class="text-danger">*</span></label>
                                            <input id="username" name="username" type="text" class="form-control" autocomplete="off" />
                                        </div>
                                        <div class="top-margin">
                                            <label>Password <span class="text-danger">*</span></label>
                                            <input id="password" name="password" type="password" class="form-control" autocomplete="off" />
                                        </div>

                                        <hr>

                                        <div class="row">
                                            <div class="col-lg-8">
                                                <b><a href="password-find">Forgot password?</a></b>
                                            </div>
                                            <div class="col-lg-4 text-right">
                                                <button class="btn btn-action" type="submit">Sign in</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>

                    </article>
                    <!-- /Article -->

                </div>
            </div>
            <!-- /container -->


            <%@ include file="../common/footer.jsp" %>
                <%@ include file="../common/js.jsp" %>
    </body>

    </html>
