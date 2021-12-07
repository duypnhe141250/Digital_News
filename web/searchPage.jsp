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


                    <c:forEach var="n" items="${listSearch}">
                        <div class="">
                            <div class="title">
                                <a  style="text-decoration: none" href="view?id=${n.id}">
                                    <h3>${n.title}</h3>
                                </a>

                            </div>

                            <div class="image-view">
                                <p>
                                    <img src="image/i1.jpg" /> 
                                    ${n.shortDes}
                                </p>


                            </div>

                            <div class="information">
                                By ${n.author} | ${n.timePost}
                            </div>
                            <br>
                        </div>
                        <h3>____________________________________________________</h3>
                    </c:forEach>

                    <div >
                        <c:forEach var="page" begin="1" end="${maxPage}">
                            <a href="SearchCointroller?index=${page}&txtSearch=${txt}">${page}</a>

                        </c:forEach>
                    </div>

                </div>
                <div class="right">
                    <div class="right-news">
                        Digital News
                    </div>
                    <div class="short-des">

                    </div>
                    <div class="right-news">
                        Search
                    </div>
                    <div class="search">
                        <form method="post" action="SearchCointroller">
                            <input class="txt-input" type="text" name="txtSearch"/>
                            <input class="submit-txt" type="submit" value="Go"/>  
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
    </body>
</html>