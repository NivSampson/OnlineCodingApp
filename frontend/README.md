# Online Coding App

This project is an online coding application that allows a mentor and students to view and edit code blocks in real-time. The mentor has read-only access to the code, while students can edit it. The changes are displayed in real-time using WebSockets.

## Prerequisites

- Node.js (v16 or later)
- npm (Node Package Manager)

## Getting Started

Follow the steps below to set up and run the project on your local machine.

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <repository-directory>

Navigate to the project directory and install the dependencies.
npm install

Navigate to the frontend directory and install its dependencies.
cd frontend
npm install
cd ..
npm start

This command will:

Kill any processes running on ports 3001, 3002, and 4001.
Start the backend server on port 4001.
Start the mentor client on port 3001.
Start the student client on port 3002.
Open two browser windows: one for the mentor and one for the student.
5. Using the Application
Mentor: The first browser window that opens will be the mentor's view. The mentor can view the code but cannot edit it.
Student: The second browser window that opens will be the student's view. The student can edit the code, and changes will be reflected in real-time in the mentor's view.
Code Blocks
The application contains predefined code blocks that the mentor and students can choose from. The list of code blocks is available on the lobby page.

Code Structure
Backend: Contains the server-side code that manages WebSocket connections and handles real-time code updates.
Frontend: Contains the React application for the mentor and student views.