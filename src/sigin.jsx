import './App.css'
import React, { useState} from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


function Cadastro(){
    const navigate = useNavigate()
    const [novoUsuario, setNovousuario] = useState({
    username: '',
    password: '',
    });
    
  
  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNovousuario((prevUsuario) => ({
      ...prevUsuario,
      [name]: value,
    }));
  };  
  //POST
  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await axios.post('http://localhost:8090/api', novoUsuario);
      setNovousuario({
        username: '',
        password: '',
        });
    navigate("/")    
    } catch (error) {
      console.error('Erro ao criar usuario:', error);
    }
  };

  return (
    <div>
     
      <h1>Casdastro de Usuarios</h1>
  
     
      <form onSubmit={handleSubmit}>
       
        <input
          type="text"
          name="username"
          placeholder="Usuario"
          value={novoUsuario.username}
          onChange={handleInputChange}
        />
       
        <input
          type="text"
          name="password"
          placeholder="Password"
          value={novoUsuario.password}
          onChange={handleInputChange}
        />
       
        <button type="submit">Cadastrar Usuario</button>
      </form>
    </div>
    );
  }

export  {Cadastro};