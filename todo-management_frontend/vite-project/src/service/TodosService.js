import axios from "axios";
import { getToken } from "./AuthService";

const BASE_URL = 'http://localhost:8080/todos';

axios.interceptors.request.use(function (config) {
    
    config.headers['Authorization'] = getToken();

    return config;
  }, function (error) {
    // Do something with request error
    return Promise.reject(error);
  });

export const getlAllTodos = () =>  axios.get(BASE_URL);

export const createTodo = (todo) =>  axios.post(BASE_URL, todo);

export const getTodoById =(todoId) => axios.get(BASE_URL +'/todo/'+ todoId);

export const updateTodo = (todoId, todo) => axios.put(BASE_URL +'/todo/'+ todoId, todo);

export const deleteTodo = (todoId) => axios.delete(BASE_URL +'/todo/'+ todoId);

export const completeTodo = (todoId) => axios.patch(BASE_URL +'/todo/'+ todoId +'/complete');

export const InCompleteTodo = (todoId) => axios.patch(BASE_URL +'/todo/'+ todoId +'/incomplete');

