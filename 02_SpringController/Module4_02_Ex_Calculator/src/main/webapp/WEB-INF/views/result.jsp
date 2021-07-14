<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="/calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <input type="text" name="firstOperand" value="${firstOperand}">
        <input type="text" name="secondOperand" value="${secondOperand}">
        <br/>
        <input type="submit" name="operator" value="Addition(+)">
        <input type="submit" name="operator" value="Subtraction(-)">
        <input type="submit" name="operator" value="Multiplication(x)">
        <input type="submit" name="operator" value="Division(/)">
    </fieldset>
</form>
Result ${operator}: ${result}

</body>
</html>