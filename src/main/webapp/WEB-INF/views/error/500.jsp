<%@ include file="../common/include.jsp"%>
<%@ page isErrorPage="true" %>

    <!DOCTYPE html>
    <html>

    <head>
        <title>500</title>
        <%@ include file="../common/css.jsp" %>

    </head>

    <body>
        <div class="container">
            <div class="row" style="padding: 80px 0px 160px; color: #999999;">
                <div class="col-md-3">
                    <img alt="" height="196" width="297" src="${error500pngUrl }">
                </div>
                <div class="col-md-7">
                    <h2>Sorry, there is something wrong with the server.</h2>
                </div>
            </div>
        </div>
    </body>

    </html>
