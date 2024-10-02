<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Submit New Code Snippet</h1>
    </header>
    <main>
        <form id="codeForm">
            <div class="form-group">
                <label for="code_snippet">Code to upload:</label>
                <textarea id="code_snippet" name="code" rows="10" required></textarea>
            </div>
            <div class="snippet-info">
                <div class="form-group">
                    <label for="time_restriction">Time restriction (seconds):</label>
                    <input type="number" id="time_restriction" name="time" min="0">
                </div>
                <div class="form-group">
                    <label for="views_restriction">Views restriction:</label>
                    <input type="number" id="views_restriction" name="views" min="0">
                </div>
            </div>
            <button id="send_snippet" type="submit">Submit</button>
        </form>
    </main>
</div>
<script src="/newCode.js"></script>
</body>
</html>