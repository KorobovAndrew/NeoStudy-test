<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Holiday pay calculation</title>
    <style>
        p {
            margin-top: 1em; /* Отступ сверху */
            margin-bottom: 1em; /* Отступ снизу */
        }
    </style>
</head>
<body>
<form method="post" action="/payments/vacation">
    <p><label>Enter average salary for 12 months
            <input name="averageSalary">
        </label><br></p>
    <p><label>Vacation from
            <input name="vacationStart" type="date">
        </label>
        <label> to
            <input name="vacationEnd" type="date">
        </label><br></p>
    <input type="submit" value="Calculate!">
</form>
<#if errors??>
    <h1 style="color: red">${errors}</h1>
</#if>
<hr>
<#if vacationPayAmount?has_content>
    <label>
        Vacation pay amount: ${vacationPayAmount}
    </label>
</#if>
</body>
</html>