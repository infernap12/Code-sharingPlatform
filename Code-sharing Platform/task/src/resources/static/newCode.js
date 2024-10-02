document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('codeForm');

    form.addEventListener('submit', function (e) {
        e.preventDefault();

        const code = document.getElementById('code_snippet').value;
        const time = document.getElementById('time_restriction').value;
        const views = document.getElementById('views_restriction').value;

        const data = {
            code: code,
            time: time ? parseInt(time) : 0,
            views: views ? parseInt(views) : 0
        };

        fetch('/api/code/new', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(result => {
                alert('Success! New code snippet ID: ' + result.id);
                form.reset();
            })
            .catch(error => {
                console.error('Error:', error);
                alert('An error occurred while submitting the code.');
            });
    });
});