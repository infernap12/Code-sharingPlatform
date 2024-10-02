<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Code</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.7.0/styles/atom-one-dark.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.7.0/highlight.min.js"></script>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Code Snippet</h1>
    </header>
    <main>
        <div class="snippet-info">
            <span class="date" id="load_date">${dateTimeFormatter.format(snippet.lastModified)}</span>
            <#if snippet.viewsRestricted>
                <span class="views" id="views_restriction">${snippet.views} more views allowed</span>
            </#if>
            <#if snippet.timeRestricted>
                <span class="time" id="time_restriction">Available for ${snippet.time} seconds</span>
            </#if>
        </div>
        <pre id="code_snippet" class="code-block"><code>${snippet.code}</code></pre>
    </main>
</div>
<script src="/code-script.js"></script>
</body>
</html>