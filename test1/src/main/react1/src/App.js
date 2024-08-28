import logo from './logo.svg';
import './App.css';
import { useEffect } from 'react';
import axios from 'axios';


function App() {

  useEffect(() => {
    axios.get('/main')
         .then(result => {
            console.log(result);
            console.log(result.data)
            setHello(result.data);
         })
  })

  return (
    <div className="App">

    </div>
  );
}

export default App;
