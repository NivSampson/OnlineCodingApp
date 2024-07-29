const express = require('express');
const http = require('http');
const socketIO = require('socket.io');
const cors = require('cors');

const app = express();
const server = http.createServer(app);
const io = socketIO(server, {
    cors: {
        origin: "*", // Allowing all origins for simplicity, should be restricted in production
        methods: ["GET", "POST"]
    }
});

app.use(cors());
app.use(express.json());

// Define the code blocks with their titles and code snippets
const codeBlocks = [
    { id: 1, title: 'Async case', code: `
      async function asyncExample() {
        console.log('Calling asynchronous function...');

        const asyncFunction = () => {
          return new Promise((resolve, reject) => {
            setTimeout(() => {
              resolve("Completed Async Operation");
            }, 1000);
          });
        };

        try {
          const result = await asyncFunction();
          console.log(result);  // Expected output: "Completed Async Operation"
        } catch (error) {
          console.error('Error:', error);
        }

        // Additional async function to show chaining
        const anotherAsyncFunction = async () => {
          const data = await asyncFunction();
          console.log("Another async call:", data);
        };

        anotherAsyncFunction();
      }

      asyncExample();
    ` },
    { id: 2, title: "Promise example", code: `
      function getData() {
        return new Promise((resolve, reject) => {
          setTimeout(() => {
            resolve("Data received");
          }, 2000);
        });
      }

      async function fetchData() {
        console.log("Fetching data...");
        try {
          const data = await getData();
          console.log(data);
        } catch (error) {
          console.error("Error:", error);
        }
      }

      fetchData();
    ` },
    { id: 3, title: 'Promise example', code:  `
      function getData() {
        return new Promise((resolve, reject) => {
          setTimeout(() => {
            resolve("Data received");
          }, 2000);
        });
      }

      async function fetchData() {
        console.log("Fetching data...");
        try {
          const data = await getData();
          console.log(data);
        } catch (error) {
          console.error("Error:", error);
        }
      }

      fetchData();
    ` },
    { id: 4, title: "Closure", code: `
      function outerFunction(outerVariable) {
        return function innerFunction(innerVariable) {
          console.log("Outer Variable:", outerVariable);
          console.log("Inner Variable:", innerVariable);
        };
      }

      const newFunction = outerFunction("outside");
      newFunction("inside");
    ` }
];

let mentorSocketId = null; // Store the mentor's socket ID

// Listen for client connections
io.on('connection', (socket) => {
    console.log('a user connected:', socket.id);

    // Listen for a user joining a code block
    socket.on('join-code-block', (codeBlockId) => {
        if (!mentorSocketId) {
            mentorSocketId = socket.id; // Assign the first user as the mentor
            socket.emit('set-mentor', codeBlocks.find(block => block.id === codeBlockId));
        } else {
            socket.emit('set-student', codeBlocks.find(block => block.id === codeBlockId)); // All other users are students
        }
    });

    // Listen for code changes
    socket.on('code-change', (codeBlock) => {
        if (socket.id !== mentorSocketId) {
            io.to(mentorSocketId).emit('update-code', codeBlock); // Update mentor's view
        } else {
            socket.broadcast.emit('update-code', codeBlock); // Update all students' view
        }
    });

    // Handle user disconnections
    socket.on('disconnect', () => {
        if (socket.id === mentorSocketId) {
            mentorSocketId = null; // Clear mentor if they disconnect
        }
        console.log('user disconnected:', socket.id);
    });
});

// Start the server
server.listen(4001, () => {
    console.log('Server is running on port 4001');
});
