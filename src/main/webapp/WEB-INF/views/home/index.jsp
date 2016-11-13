<%@ include file="../common/include.jsp"%>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Store - Get your favorite goods</title>

        <%@ include file="../common/css.jsp" %>
    </head>

    <body class="home">
        <%@ include file="../common/navbar.jsp"%>

            <!-- Header -->
            <header id="head">
                <div class="container">
                    <div class="row">
                        <h1 class="lead">AMAZING, INTRESTING, FREE</h1>
                        <p class="tagline">Store: Get your favorite <a href="#">GOODS</a></p>
                        <p><a class="btn btn-default btn-lg" role="button">MORE INFO</a> <a class="btn btn-action btn-lg" role="button">GET NOW</a></p>
                    </div>
                </div>
            </header>
            <!-- /Header -->

            <!-- Intro -->
            <div class="container text-center">
                <br> <br>
                <h2 class="thin">The best place to tell people why they are here</h2>
                <p class="text-muted">
                    Hope you will like it and use it continuously.<br> We will make our best to improve it.
                </p>
            </div>
            <!-- /Intro-->

            <!-- Highlights - jumbotron -->
            <div class="jumbotron top-space">
                <div class="container">

                    <h3 class="text-center thin">Reasons to use this site</h3>

                    <div class="row">
                        <div class="col-md-3 col-sm-6 highlight">
                            <div class="h-caption">
                                <h4><i class="fa fa-cogs fa-5"></i>Variety</h4></div>
                            <div class="h-body text-center">
                                <p>Various goods are here</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 highlight">
                            <div class="h-caption">
                                <h4><i class="fa fa-flash fa-5"></i>Search-based</h4></div>
                            <div class="h-body text-center">
                                <p>You can search your goods
                                </p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 highlight">
                            <div class="h-caption">
                                <h4><i class="fa fa-heart fa-5"></i>Sortable</h4></div>
                            <div class="h-body text-center">
                                <p>You can sort any goods you want</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 highlight">
                            <div class="h-caption">
                                <h4><i class="fa fa-smile-o fa-5"></i>Free</h4></div>
                            <div class="h-body text-center">
                                <p>Some goods are free</p>
                            </div>
                        </div>
                    </div>
                    <!-- /row  -->

                </div>
            </div>
            <!-- /Highlights -->

            <!-- container -->
            <div class="container">

                <h2 class="text-center top-space">Frequently Asked Questions</h2>
                <br>

                <div class="row">
                    <div class="col-sm-6">
                        <h3>How to use it?</h3>
                        <p>123</p>
                    </div>
                    <div class="col-sm-6">
                        <h3>How to use it?</h3>
                        <p>123</p>
                    </div>
                </div>
                <!-- /row -->


                <div class="jumbotron top-space">
                    <h4>ABC</h4>
                    <p class="text-right"><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
                </div>

            </div>
            <!-- /container -->

            <!-- Social links. @TODO: replace by link/instructions in template -->
            <section id="social">
                <div class="container">
                    <div class="wrapper clearfix">
                        <!-- AddThis Button BEGIN -->
                        <div class="addthis_toolbox addthis_default_style">
                            <a class="addthis_button_facebook_like" fb:like:layout="button_count"></a>
                            <a class="addthis_button_tweet"></a>
                            <a class="addthis_button_linkedin_counter"></a>
                            <a class="addthis_button_google_plusone" g:plusone:size="medium"></a>
                        </div>
                        <!-- AddThis Button END -->
                    </div>
                </div>
            </section>
            <!-- /social links -->


            <%@ include file="../common/footer.jsp" %>

                <!-- JavaScript libs are placed at the end of the document so the pages load faster -->
                <%@ include file="../common/js.jsp" %>
    </body>

    </html>
