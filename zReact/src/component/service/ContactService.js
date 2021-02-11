import React, { useState, useEffect } from 'react'
import Axios from 'axios'
var axios = require('axios');


function ContactService() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [randomUserDataJSON, setRandomUserDataJson] = useState([]);
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('')
  const [deletedId, deleteId] = useState('')
  useEffect(() => {
    setTimeout(() => {
      Axios
      .get('http://localhost:8080/contact/getAll')
      .then(data => data.data)
      .then(
        (data) => {
          setIsLoaded(true);
          setRandomUserDataJson(data);
          console.log(data)
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
          console.log(error)
        }
      )
    }, 500);
   

  }, [isLoaded])

  const article1 = {
    "firstName": firstName,
    "lastName": lastName,
    "phoneNumber": phoneNumber
  }
  //"asa se pune 
  let ceva;
  let unLink=`http://localhost:8080/contact/add/${ceva}`;
  //ES6 feature

  const handleSubmit = (e) => {
    e.preventDefault();
    Axios.post("http://localhost:8080/contact/add", article1)

      .then(function (response) {
        console.log(response)
      })
      .catch(function (error) {
        console.log(error)
      })
      setIsLoaded(false);
  }

  const handleDelete = (e) => {
    e.preventDefault();

    axios.delete('http://localhost:8080/contact/delete/'.concat(deletedId))
      .then(function (response) {
        console.log(response)
      })
      .catch(function (error) {
        console.log(error, deletedId)
      })
    deleteId("");
    setIsLoaded(false);
    
    
  }


  function topDataCase() {
    var topDataInfo = <div>aici scriu</div>
    if (error) {
      topDataInfo= <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
      topDataInfo= <div>Loading...</div>;
    } else {
      topDataInfo=
        <div>
          <ol>
            {randomUserDataJSON.map(item => (
              <li key={item.id}>
                {item.id} {item.firstName} {item.lastName}
              </li>
            ))}
          </ol>
        </div>
    }
    return topDataInfo
  }


  return (
    <div>
      
      {topDataCase()}
      <form className='form'  >
        <div className='form-control'>
          <label>First Name</label>
          <input type="text" id="firstName" name="firstName"
            value={firstName} onChange={(e) => setFirstName(e.target.value)} />
        </div>

        <div className='form-control'>
          <label>Last Name</label>
          <input type="text" id="lastName" name="lastName"
            value={lastName} onChange={(e) => setLastName(e.target.value)} />
        </div>

        <div className='form-control'>
          <label>Phone number</label>
          <input type="text" id="phoneNumber" name="phoneNumber"
            value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)} />
        </div>

        <button id="saveContact" type="submit" onClick={handleSubmit}>Save</button>
      </form>


      <form className='formDelete' >
        <div className='form-control'>
          <label>ID</label>
          <input type="text" id="firstName" name="firstName"
            value={deletedId} onChange={(e) => deleteId(e.target.value)} />
          <button id="deleteContact" type="submit" onClick={handleDelete} >Delete</button>
        </div>
      </form>
      <p>Scriu ceva aici</p>
      
    </div>
  );
  
}

export default ContactService