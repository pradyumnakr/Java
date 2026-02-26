<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Spring MVC App</title>
    </head>

    <body>
        <h1>${message}</h1>
        <p>Your Spring MVC project structure is set up successfully.</p>
        <form action="addAlien">
            Enter Number 1 : <input type="text" name="id">
            Enter Number 2 : <input type="text" name="name">
            <input type="submit" value="Add">
        </form>
    </body>

    </html>