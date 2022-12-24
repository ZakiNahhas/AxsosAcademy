import React, { useState } from 'react';

function Navbar() {
  const [menuOpen, setMenuOpen] = useState(false);

  return (
    <nav style={{
      display: 'flex',
      justifyContent: 'space-between',
      alignItems: 'center',
      backgroundColor: '#333',
      color: '#fff',
      padding: '0.5rem 1rem'
    }}>
      <div style={{ fontSize: '1.5rem' }}>Logo</div>
      <div style={{ display: 'flex' }}>
        <button onClick={() => setMenuOpen(!menuOpen)} style={{
          background: 'none',
          border: 'none',
          color: '#fff',
          fontSize: '1.2rem',
          cursor: 'pointer'
        }}>Menu</button>
        <ul style={{
          display: menuOpen ? 'block' : 'none',
          listStyle: 'none',
          margin: 0,
          padding: 0,
          backgroundColor: '#333'
        }}>
          <li style={{ display: 'block', padding: '0.5rem 1rem' }}>Home</li>
          <li style={{ display: 'block', padding: '0.5rem 1rem' }}>About</li>
          <li style={{ display: 'block', padding: '0.5rem 1rem' }}>Contact</li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;

