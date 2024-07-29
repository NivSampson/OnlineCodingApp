import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { io } from 'socket.io-client';
import hljs from 'highlight.js';
import 'highlight.js/styles/github.css';

const socket = io('http://localhost:4001');

const CodeBlockPage = () => {
    const { id } = useParams(); // Extracting the code block ID from the URL
    const [code, setCode] = useState(''); // State to hold the code
    const [isMentor, setIsMentor] = useState(false); // State to determine if the user is a mentor

    useEffect(() => {
        // Join the code block room
        socket.emit('join-code-block', parseInt(id));

        // Listen for mentor role assignment
        socket.on('set-mentor', (block) => {
            setIsMentor(true);
            setCode(block.code); // Set the code block for the mentor
        });

        // Listen for student role assignment
        socket.on('set-student', (block) => {
            setIsMentor(false);
            setCode(block.code); // Set the code block for the student
        });

        // Listen for code updates from the server
        socket.on('update-code', (block) => {
            setCode(block.code);
        });

        // Clean up event listeners on component unmount
        return () => {
            socket.off('set-mentor');
            socket.off('set-student');
            socket.off('update-code');
        };
    }, [id]);

    // Handle changes to the code textarea
    const handleCodeChange = (e) => {
        const newCode = e.target.value;
        setCode(newCode);
        if (!isMentor) {
            // Emit code change event if the user is a student
            socket.emit('code-change', { id: parseInt(id), code: newCode });
        }
    };

    // Highlight the code using highlight.js whenever the code changes
    useEffect(() => {
        document.querySelectorAll('pre code').forEach((block) => {
            hljs.highlightBlock(block);
        });
    }, [code]);

    return (
        <div>
            <h1>Code Block</h1>
            {isMentor ? (
                // Display code in read-only mode for the mentor
                <pre><code className="javascript">{code}</code></pre>
            ) : (
                // Display editable textarea for the student
                <textarea
                    value={code}
                    onChange={handleCodeChange}
                    style={{ width: '80%', height: '500px' }} // Adjusted height
                ></textarea>
            )}
        </div>
    );
};

export default CodeBlockPage;
