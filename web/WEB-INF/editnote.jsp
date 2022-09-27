<%-- 
    Document   : editnote
    Created on : Sep. 19, 2022, 1:15:53 p.m.
    Author     : dom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <p><strong>Title:</strong></p> <input type="text" id="title" name="title" placeholder="This is the title"> 
        <p><strong>Contents:</strong><br> </p> <textarea id="contents" name="contents" placeholder="contents go here"></textarea>
        <br>
        <button type="submit" id="save">Save</button>
        </form>
        <br>
        <a href="note?view">View</a>
    </body>
</html>
