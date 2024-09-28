<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/code.css"/>
    <title>Latest</title>
</head>
<body>
<#list snippets as snippet>
    <span id="load_date">${snippet.getTimeString()}</span>
    <pre id="code_snippet">${snippet.code}</pre>
</#list>
</body>
</html>