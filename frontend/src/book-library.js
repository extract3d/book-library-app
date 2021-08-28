import './book-library.css';
import React from 'react';
import { TextField } from '@fluentui/react/lib/TextField';
import { DefaultButton } from '@fluentui/react/lib/Button';

const axios = require('axios').default;

class BookLibrary extends React.Component{
  constructor(props){
      super(props);
      this.state = {
          name: 'test'
      };
      this.changeTest = this.changeTest.bind(this);
      this.getBooks = this.getBooks.bind(this);
  }

render() {
  return (
    <div className="App">
      <header className="App-header">
        <TextField label="Standard" onChange = {this.changeTest} />
        <DefaultButton text="Standard" onClick = {this.getBooks}/>
        <p>{this.state.name}</p>
      </header>
    </div>
  );
};

changeTest(){
  this.setState({name: 'NEW'});
};

getBooks(){
  axios.get('/books', {
  })
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
};

}

export default BookLibrary;


