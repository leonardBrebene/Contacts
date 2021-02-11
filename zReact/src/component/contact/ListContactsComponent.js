import React from 'react'
import ContactService from '../service/ContactService'
import Experiment from '../service/Experiment'
import AddContactComponent from './AddContactComponent'


class ListContactsComponent extends React.Component {
    render() {
      return (
        <div className="listOfPeople">
          altceva
          <ContactService/>
          <Experiment/>
          <AddContactComponent/>
        </div>
      );
    }
  }

export default ListContactsComponent;