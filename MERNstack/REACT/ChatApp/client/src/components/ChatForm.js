import React, { useState } from 'react';

function ChatForm(props) {
  const [username, setUsername] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    // Send the username to the server
    props.Name(username);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Choose a username:
        <input
          type="text"
          value={username}
          onChange={(event) => setUsername(event.target.value)}
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
}

export default ChatForm