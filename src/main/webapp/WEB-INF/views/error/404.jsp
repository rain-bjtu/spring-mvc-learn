<%@ include file="../common/include.jsp"%>
<%@ page isErrorPage="true" %>

    <!DOCTYPE html>
    <html>

    <head>
        <title>404</title>
        <%@ include file="../common/css.jsp" %>

    </head>

    <body>
        <div class="container">
            <div class="row" style="padding: 80px 0px 160px; color: #999999;">
                <div class="col-md-3">
                    <img alt="" height="196" width="297" src="${e404Url }">
                </div>
                <div class="col-md-7">
                    <h2>Sorry, the page you are looking for does not exist.</h2>
                </div>
            </div>
        </div>
    </body>

    </html>
