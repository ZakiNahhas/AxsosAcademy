import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Main from './views/Main';
import Detail from './views/Detail';
import Update from './views/Update';
import CreateAuthor from './views/CreateAuthor';

function App() {
    return (
    <div className="App">
         <Routes>
            <Route element={<Main/>} path="/" />
            <Route element={<Detail/>} path="/author/:id" />
            <Route element={<CreateAuthor/>} path="/author/new" />
            <Route element={<Update/>} path="/author/:id/edit"/>
         </Routes>                         
    </div>
    );
}
export default App;

