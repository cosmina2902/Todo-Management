import { useState } from 'react'
import './App.css'
import ListComponentTodo from './compoent/ListComponentTodo'
import HeaderComponent from './compoent/HeaderComponent'
import FooterComponent from './compoent/FooterComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import TodoComponent from './compoent/TodoComponent'

function App() {

  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>

      <Routes>
        <Route path='/' element={<ListComponentTodo/>}></Route>
        <Route path='/todos' element={<ListComponentTodo/>}></Route>
        <Route path='/add-todo' element={<TodoComponent/>}></Route>
        <Route path='/edit-todo/:id' element={<TodoComponent/>}></Route>
      </Routes>
      
    <FooterComponent/>   
    </BrowserRouter>
    
    </>
  )
}

export default App
