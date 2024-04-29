import { useState } from 'react'
import './App.css'
import ListComponentTodo from './compoent/ListComponentTodo'
import HeaderComponent from './compoent/HeaderComponent'
import FooterComponent from './compoent/FooterComponent'
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'
import TodoComponent from './compoent/TodoComponent'
import RegisterComponent from './compoent/RegisterComponent'
import LoginComponent from './compoent/LoginComponent'
import { isUserLoggedIn } from './service/AuthService'

function App() {

  function AuthenticatedRoute({children}){
    const isAuth = isUserLoggedIn();

    if(isAuth){
      return children;
    }
    return <Navigate to="/"></Navigate>
  }

  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>

      <Routes>
        <Route path='/' element={<LoginComponent/>}></Route>
        <Route path='/todos' element={
        <AuthenticatedRoute>
        <ListComponentTodo/>
        </AuthenticatedRoute>
        }></Route>
        <Route path='/add-todo' element={
          <AuthenticatedRoute>
        <TodoComponent/>
        </AuthenticatedRoute>
        }></Route>
        <Route path='/edit-todo/:id' element={
          <AuthenticatedRoute>
        <TodoComponent/>
        </AuthenticatedRoute>
        }></Route>
        <Route path='/register' element={<RegisterComponent/>}></Route>
        <Route path='/login' element={<LoginComponent/>}></Route>
      </Routes>
      
    <FooterComponent/>   
    </BrowserRouter>
    
    </>
  )
}

export default App
