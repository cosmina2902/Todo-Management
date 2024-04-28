import React, { useEffect, useState } from 'react'
import { createTodo, getTodoById, updateTodo } from '../service/TodosService'
import { useNavigate, useParams } from 'react-router-dom'

const TodoComponent = () => {

    const [title, setTitle] = useState('')

    const [description, setDescription] = useState('')

    const [completed, setCompleted] = useState(false)

    const navigator = useNavigate();

    const {id} = useParams();

    useEffect(()=>{
        if(id){
            getTodoById(id).then((response)=>{
                setTitle(response.data.title)
                setDescription(response.data.description)
                setCompleted(response.data.completed)
            }).catch(error=>{
                console.error(error)
            })
        }

    },[id])

    function saveOrUpdateTodo(e){
        e.preventDefault();

        const todo = {title, description, completed}

        if(id){
            updateTodo(id, todo).then((response)=>{
                navigator('/todos')
            }).catch(error=>{
                console.error(error)
            })
        }
        else{
            createTodo(todo).then((response)=>{
                console.log(response.data)
                navigator('/todos')
           }).catch(error=>{
                console.error(error)
           })
        }

       
      
    }

    function pageTitle(){
        if(id){
            return <h2 className='text-center'>Update Todo</h2>
        }
        else{
           return  <h2 className='text-center'>Add Todo</h2>
        }
    }

  return (
    <div className='container'>
        <div className='row'>
            <div className='crad col-md-6 offset-md-3 offset-md-3'>
                {
                    pageTitle()
                }
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Todo Title:</label>
                            <input type='text'
                            placeholder='Enter Todo Title'
                            name='title'
                            value={title}
                            className='form-control'
                            onChange={(e) => setTitle(e.target.value)}
                            >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Todo Description:</label>
                            <input type='text'
                            placeholder='Enter Todo Description'
                            name='description'
                            value={description}
                            className='form-control'
                            onChange={(e) => setDescription(e.target.value)}
                            >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Todo Completed:</label>
                            <select 
                                className='form-control'
                                value={completed}
                                onChange={(e)=> setCompleted(e.target.value)}
                            >
                                <option value={"false"}>No</option>
                                <option value={"true"}>Yes</option>
                            </select>
                        </div>
                        <button className='btn btn-success' onClick={(e)=> saveOrUpdateTodo(e)}>Submit</button>
                    </form>
                </div>
                
            </div>
        </div>

    </div>
  )
}

export default TodoComponent