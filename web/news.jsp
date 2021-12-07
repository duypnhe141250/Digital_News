
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <div class="preheader">

            </div>
            <div class="header">
                <h3>My digital new</h3> 
            </div>
            <div class="menu">
                <a href="HomeController">News</a>
            </div>
            <div class="main">
                <div class="left">
                    <div class="title">
                        ${news.title}
                    </div>
                    <div class="image">
                        <img src="image/${news.image}.jpg"/>

                    </div>
                    <div class="description">
                        ${news.description}
                    </div>
                    <div class="information">
                        By ${news.author} | ${lastest.timePost}
                    </div>
                </div>
                <div class="right">
                    <div class="right-news">
                        Digital News
                    </div>
                    <div class="short-des">
                        ${news.shortDes}
                    </div>
                    <div class="right-news">
                        Search
                    </div>
                    <div class="search">
                        <form action="SearchCointroller" method="post">
                            <input class="txt-input" type="text" name="txtSearch"/>
                            <input class="submit-txt" type="submit"   value="Go"/>
                        </form>

                    </div>
                    <div class="right-news">
                        Last Article
                        <div class="list">
                            <c:forEach var="x" items="${listTop5}" >
                            <div>
                                <li><a href="view?id=${x.id}" >${x.title}</a></li>
                            </div>
                        </c:forEach> 
                        </div>
                       
                    </div>



                </div>
            </div>
            <div class="footer">

            </div>
        </div>
    </body>
</html>
