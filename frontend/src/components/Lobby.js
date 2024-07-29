import React from 'react';
import { Link } from 'react-router-dom';

const Lobby = () => {
    // Define the available code blocks with their IDs and titles
    const codeBlocks = [
        { id: 1, title: 'Async case' },
        { id: 2, title: 'Callback example' },
        { id: 3, title: 'Promise example' },
        { id: 4, title: 'Async/Await example' }
    ];

    return (
        <div>
            <h1>Choose code block</h1>
            <ul>
                {codeBlocks.map((block) => (
                    <li key={block.id}>
                        <Link to={`/codeblock/${block.id}`}>{block.title}</Link>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Lobby;
