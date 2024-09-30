<html lang="en">
<head>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <link rel="stylesheet" type="text/css" href="/code.css"/>
    <title>Code</title>
</head>
<body>
<span id="load_date">${snippet.getTimeString()}</span>
<#if snippet.viewsRestricted>
    <div><span id="views_restriction">${snippet.views} more views allowed</span></div>
</#if>
<#if snippet.timeRestricted>
    <div><span id="time_restriction">The code will be available for ${snippet.time} seconds</span></div>
</#if>
<pre id="code_snippet"><code>${snippet.code}</code></pre>
</body>
</html>