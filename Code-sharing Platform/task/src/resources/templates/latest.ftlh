<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Latest</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.7.0/styles/atom-one-dark.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.7.0/highlight.min.js"></script>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Latest Code Snippets</h1>
    </header>
    <main>
        <#list snippets as snippet>
            <div class="snippet-card">
                <div class="snippet-info">
                    <span class="date">${dateTimeFormatter.format(snippet.lastModified)}</span>
                </div>
                <pre id="code_snippet" class="code-block"><code>${snippet.code}</code></pre>
            </div>
        </#list>
    </main>
</div>
<script src="/latest-script.js"></script>
</body>
</html>