const open = require('open');

// Immediately Invoked Function Expression to run the async code
(async () => {
    // Open the mentor page on port 3001
    await open('http://localhost:3001');
    // Open the student page on port 3002
    await open('http://localhost:3002');
})();
