document.addEventListener('DOMContentLoaded', () => {
    hljs.highlightAll();

    const snippetCards = document.querySelectorAll('.snippet-card');
    snippetCards.forEach((card, index) => {
        card.style.animationDelay = `${index * 0.1}s`;
    });
});