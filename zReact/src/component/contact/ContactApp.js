import React from 'react';
import {
    BrowserRouter as Router,
    Route,
    Switch
} from "react-router-dom";
import AddContactComponent from'./AddContactComponent'
import ListContactsComponent from './ListContactsComponent'

function ContactApp(){
  
      return (
         
            <Router>
                  <Switch>
                     <Route path="/add">
                        <AddContactComponent/>
                     </Route>
                     <Route path="/list">
                        <ListContactsComponent/>
                     </Route>
                  </Switch>
            </Router>
        
      );
   }

   export default ContactApp;
