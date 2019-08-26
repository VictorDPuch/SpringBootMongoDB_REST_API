import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';

class Create extends Component {

  constructor() {
    super();
    this.state = {
      name: '',
      address: '',
      city: '',
      phone: '',
      email: ''
    };
  }
  onChange = (e) => {
    const state = this.state;
    state[e.target.name] = e.target.value;
    this.setState(state);
  }

  onSubmit = (e) => {
    e.preventDefault();

    const {name,first_last_name,second_last_name, address, birthday,phone,email,gender,civil_status,type,baptized} = this.state;

    axios.post('http://localhost:8080/congregants/', 
    {name,first_last_name,second_last_name, address, birthday,phone,email,gender,civil_status,type,baptized})
      .then((result) => {
        this.props.history.push("/");
      });
  }

  render() {
    const {name,first_last_name,second_last_name, address, birthday,phone,email,gender,civil_status,type,baptized} = this.state;
    return (
      <div className="container">
        <div className="panel panel-default">
          <div className="panel-heading">
            <h3 className="panel-title">
              ADD Congregant
            </h3>
          </div>
          <div className="panel-body">
            <h4><Link to="/"><span className="glyphicon glyphicon-th-list" aria-hidden="true"></span> Contacts List</Link></h4>
            <form onSubmit={this.onSubmit}>
              <div className="form-group">
                <label for="isbn">Name:</label>
                <input type="text" className="form-control" name="name" 
                value={name} onChange={this.onChange} placeholder="Name" />
              </div>
              <div className="form-group">
                <label for="isbn">First Last Name:</label>
                <input type="text" className="form-control" name="first_last_name" 
                value={first_last_name} onChange={this.onChange} placeholder="first last name" />
              </div>
              <div className="form-group">
                <label for="isbn">Second Last Name:</label>
                <input type="text" className="form-control" name="second_last_name" 
                value={second_last_name} onChange={this.onChange} placeholder="second last name" />
              </div>
              <div className="form-group">
                <label for="title">Address:</label>
                <input type="text" className="form-control" name="address" 
                value={address} onChange={this.onChange} placeholder="Address" />
              </div>
              <div className="form-group">
                <label for="author">Birthday:</label>
                <input type="text" className="form-control" name="birthday" 
                value={birthday} onChange={this.onChange} placeholder="Birthday" />
              </div>
              <div className="form-group">
                <label for="published_date">Phone:</label>
                <input type="text" className="form-control" name="phone" 
                value={phone} onChange={this.onChange} placeholder="Phone Number" />
              </div>
              <div className="form-group">
                <label for="publisher">Email:</label>
                <input type="email" className="form-control" name="email" 
                value={email} onChange={this.onChange} placeholder="Email Address" />
              </div>
              <div className="form-group">
                <label for="published_date">Gender:</label>
                <input type="text" className="form-control" name="gender" 
                value={gender} onChange={this.onChange} placeholder="Gender" />
              </div>
              <div className="form-group">
                <label for="published_date">Civil Status:</label>
                <input type="text" className="form-control" name="phone" 
                value={civil_status} onChange={this.onChange} placeholder="civil_status" />
              </div>
              <div className="form-group">
                <label for="published_date">Type:</label>
                <input type="text" className="form-control" name="type" 
                value={type} onChange={this.onChange} placeholder="type" />
              </div>
                            <div className="form-group">
                <label for="published_date">Baptized:</label>
                <input type="text" className="form-control" name="baptized" 
                value={baptized} onChange={this.onChange} placeholder="baptized" />
              </div>
              <button type="submit" className="btn btn-default">Submit</button>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default Create;
