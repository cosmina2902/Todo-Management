import React, { useState } from 'react'
import { registerAPICall } from '../service/AuthService';

const RegisterComponent = () => {

    const [name, setName] = useState('');

    const [username, setUserName] = useState('');

    const [email, setEmail] = useState('');

    const [password, setPassword] = useState('');

    function registerUser(e){

        e.preventDefault();

        const register = {name, username, email, password}

        console.log(register)

        registerAPICall(register).then((response)=>{
            console.log(response.data)
        }).catch(error=>{
            console.error(error)
        })

    }

  return (
    <div className='container'>
        <br/> <br/>
    <div className='row'>
        <div className='col-md-6 offset-md-3'>
            <div className='card'>
                <div className='card-header'>
                <h2 className='text-center'>User Registration Form</h2>
                </div>
                <div className='card-body'>
                <form>
                    <div className='row mb-3'>
                        <label className='col-md-3 control-label'>Name:</label>
                        <div className='col-md-9'>
                            <input type='text'
                            placeholder='Enter your name'
                            name='name'
                            value={name}
                            className='form-control'
                            onChange={(e) => setName(e.target.value)}
                            >
                            </input>
                        </div>
                        
                    </div>

                    <div className='row mb-3'>
                        <label className='col-md-3 control-label'>Username:</label>
                        <div className='col-md-9'>
                            <input type='text'
                            placeholder='Enter username'
                            name='username'
                            value={username}
                            className='form-control'
                            onChange={(e) => setUserName(e.target.value)}
                            >
                            </input>
                        </div>
                    </div>

                    <div className='row mb-3'>
                    <label className='col-md-3 control-label'>Email:</label>
                        <div className='col-md-9'>
                            
                            <input type='text'
                            placeholder='Enter email'
                            name='email'
                            value={email}
                            className='form-control'
                            onChange={(e) => setEmail(e.target.value)}
                            >
                            </input>
                        </div>
                    </div>

                    <div className='row mb-3'>
                    <label className='col-md-3 control-label'>Password:</label>
                        <div className='col-md-9'>
                            
                            <input type='password'
                            placeholder='Enter password'
                            name='password'
                            value={password}
                            className='form-control'
                            onChange={(e) => setPassword(e.target.value)}
                            >
                            </input>
                        </div>
                    </div>
                    <button className='btn btn-primary' onClick={(e)=> registerUser(e)}>Register</button>
                </form>
            </div>
            </div>
           
            
            
        </div>
    </div>

</div>
  )
}

export default RegisterComponent