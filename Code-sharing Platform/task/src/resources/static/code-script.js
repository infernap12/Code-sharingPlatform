document.addEventListener('DOMContentLoaded', () => {
    hljs.highlightAll();

    const timeRestriction = document.getElementById('time_restriction');
    if (timeRestriction) {
        // Extract all numbers, ignoring commas and other characters
        const numberMatch = timeRestriction.textContent.match(/\d+(?:,\d+)*/);
        if (numberMatch) {
            // Remove commas and parse as integer
            let timeLeft = parseInt(numberMatch[0].replace(/,/g, ''), 10);
            const updateTimer = () => {
                if (timeLeft > 0) {
                    const hours = Math.floor(timeLeft / 3600);
                    const minutes = Math.floor((timeLeft % 3600) / 60);
                    const seconds = timeLeft % 60;

                    let timeString = '';
                    if (hours > 0) timeString += `${hours}h `;
                    if (minutes > 0 || hours > 0) timeString += `${minutes}m `;
                    timeString += `${seconds}s`;

                    timeRestriction.textContent = `Available for ${timeString}`;
                    timeLeft--;
                    setTimeout(updateTimer, 1000);
                } else {
                    timeRestriction.textContent = 'Time expired';
                    document.getElementById('code_snippet').textContent = 'This code snippet has expired.';
                }
            };

            updateTimer();
        }
    }
});