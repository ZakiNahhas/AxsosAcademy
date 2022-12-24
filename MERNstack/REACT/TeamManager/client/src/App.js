import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Main from './views/Main';
import Detail from './views/Detail';
import Update from './views/Update';
import CreatePlayer from './views/CreatePlayer';



function App() {
    return (
    <div className="App">
         <Routes>
            <Route element={<Main/>} path="/" />
            <Route element={<Detail/>} path="/player/:id" />
            <Route element={<CreatePlayer/>} path="/player/new" />
            <Route element={<Update/>} path="/player/:id/edit"/>
         </Routes>                         
    </div>
    );
}
export default App;

