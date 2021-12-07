<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
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



                    <div class="">
                        <p>
                            <a class="title"  href="#">CDC signs off on Moderna 
                                and Johnson & Johnson boosters and says people 
                                can get a shot different from their original one</a>

                        </p>
                        <div class="image-view"><p>
                                <img   src="../image/i1.jpg"   />
                                The decision means that those eligible for boosters 
                                can choose any of the three now authorized in the United States</p>
                        </div>



                        <div class="information">
                            By Alan silver | 17-10-2021

                        </div>
                        <br>
                    </div>
                    <h3>____________________________________________________</h3>
                    <div class="">
                        <p>
                            <a class="title"  href="#">CDC signs off on Moderna 
                                and Johnson & Johnson boosters and says people 
                                can get a shot different from their original one</a>

                        </p>
                        <div class="image-view">
                            <img   src="../image/i1.jpg"   />
                            <p>The decision means that those eligible for boosters 
                                can choose any of the three now authorized in the United States</p>
                        </div>



                        <div class="information">
                            By Alan silver | 17-10-2021

                        </div>
                        <br>
                    </div>
                    <h3>____________________________________________________</h3>
                    <div class="">
                        <p>
                            <a class="title"  href="#">CDC signs off on Moderna 
                                and Johnson & Johnson boosters and says people 
                                can get a shot different from their original one</a>

                        </p>
                        <div class="image-view">
                            <img   src="../image/i1.jpg" F  />
                            <p>The decision means that those eligible for boosters 
                                can choose any of the three now authorized in the United States</p>
                        </div>



                        <div class="information">
                            By Alan silver | 17-10-2021

                        </div>
                        <br>
                    </div>
                    <h3>____________________________________________________</h3>
                    <div >
                        <c:forEach var="page" begin="1" end="2">
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
                    </div>
                    <a href="#">Bai so 1<br></a> 
                    <a href="#">Bai so 2<br></a> 
                    <a href="#">Bai so 3<br></a> 
                    <a href="#">Bai so 4<br></a> 
                    <a href="#">Bai so 5<br></a> 
                </div>

            </div>
            <div class="footer">

            </div>
    </body>
</html>

