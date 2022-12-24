import React, { useState } from 'react';

function ChatApp() {
  const [username, setUsername] = useState('');

  function handleUsernameChange(event) {
    setUsername(event.target.value);
  }

  return (
    <form>
      <label>
        Choose your username:
        <input type="text" value={username} onChange={handleUsernameChange} />
      </label>
      <input type="submit" value="Submit" />
    </form>
  );
}

export default ChatApp;
