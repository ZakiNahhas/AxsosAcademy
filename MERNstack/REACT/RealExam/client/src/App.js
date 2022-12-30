import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Main from './views/Main';
import Detail from './views/Detail';
import Update from './views/Update';
import CreateCompetition from './views/CreateCompetition';
import Header from './components/Header';
import VoteDetails from './views/VoteDetails';



function App() {
    return (
    <div className="App">
        <Header/>
         <Routes>
            <Route element={<Main/>} path="/" />
            <Route element={<Detail/>} path="/competition/:id" />
            <Route element={<CreateCompetition/>} path="/competition/new" />
            <Route element={<Update/>} path="/competition/:id/edit"/>
            <Route element={<VoteDetails/>} path="/votes/:id" />
         </Routes>                         
    </div>
    );
}
export default App;

